package org.challenge;

import java.util.Arrays;
import java.util.List;
import org.challenge.data.mapper.AgeLineMapper;
import org.challenge.data.mapper.DepartmentLineMapper;
import org.challenge.data.mapper.EmployeeLineMapper;
import org.challenge.data.model.Employee;
import org.challenge.data.reader.CsvDataReader;
import org.challenge.data.reader.DataReader;
import org.challenge.data.reader.MergedEmployeeDataReader;
import org.challenge.data.writer.ConsoleDataWriter;
import org.challenge.data.writer.CsvDataWriter;
import org.challenge.data.writer.DataWriter;
import org.challenge.report.AvgIncomeByAgeRangesReport;
import org.challenge.report.MedianEmployeeAgeByDepartment;
import org.challenge.report.MedianIncomeByDepartmentReport;
import org.challenge.report.PercentileIncomeByDepartmentReport;
import org.challenge.report.Report;

public class Application {

  public static void main(String[] args) {
    try {

      String delimiter = ",";
      String inputDir = args.length > 0 ? args[0] : "data";
      boolean useConsoleWriter = args.length > 1 ? Boolean.valueOf(args[1]) : false;
      String outputDir = args.length > 2 ? args[2] : "reports";

      DataReader<Employee> mergedEmployeeDataReader =
          new MergedEmployeeDataReader(
              new CsvDataReader<>(inputDir, "employees.csv", new EmployeeLineMapper(delimiter)),
              new CsvDataReader<>(inputDir, "ages.csv", new AgeLineMapper(delimiter)),
              new CsvDataReader<>(inputDir, "departments.csv", new DepartmentLineMapper()));

      List<Employee> employees = mergedEmployeeDataReader.read();

      List<Report> reports = Arrays.asList(
          new MedianIncomeByDepartmentReport(employees, "income-by-department.csv"),
          new PercentileIncomeByDepartmentReport(employees, 95, "income-95-by-department.csv"),
          new AvgIncomeByAgeRangesReport(employees, 10, "income-average-by-age-range.csv"),
          new MedianEmployeeAgeByDepartment(employees, "employee-age-by-department.csv"));

      DataWriter writer = useConsoleWriter
          ? new ConsoleDataWriter(delimiter)
          : new CsvDataWriter(outputDir, delimiter);

      writer.write(reports);

    } catch (Exception ex) {
      System.err.println("\tError: " + ex.toString());
    }
  }
}
