package org.challenge.report;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static org.hamcrest.core.Is.is;

import java.util.List;
import java.util.Map;
import org.challenge.data.model.Employee;
import org.junit.Assert;
import org.junit.Test;

public class PercentileIncomeByDepartmentReportTest {

  @Test
  public void testThatReportCalculates95PercentileIncomeByDepartmentReport() {

    List<Employee> employees = asList(
        Employee.of("Byron Powell", "m", 19, 1, "Marketing", 3500.00),
        Employee.of("June Holland", "f", 23, 1, "Marketing", 3000.00),
        Employee.of("Opal Ballard", "m", 27, 1, "Marketing", 2000.00),
        Employee.of("Hilda Fisher", "f", 30, 2, "Sales", 3000.00),
        Employee.of("Randy Warner", "m", 40, 2, "Sales", 2000.00));

    int percentile = 95;

    Map<String, Double> rows =
        new PercentileIncomeByDepartmentReport(employees, percentile, "whatever-name").getRows();

    System.out.println(rows);

    Assert.assertThat(rows.get("Marketing"), is(3500.0));
    Assert.assertThat(rows.get("Sales"), is(3000.0));
  }

  @Test
  public void testThatReportReturnsCorrectColumnNames() {
    Report report;

    report = new PercentileIncomeByDepartmentReport(emptyList(), 95, "whatever-name");
    Assert.assertThat(report.getColumns(), is(asList("department", "95percentile")));

    report = new PercentileIncomeByDepartmentReport(emptyList(), 27, "whatever-name");
    Assert.assertThat(report.getColumns(), is(asList("department", "27percentile")));
  }

  @Test
  public void testThatReportReturnsCorrectReportName() {
    Report report =
        new PercentileIncomeByDepartmentReport(emptyList(), 95, "income-95-by-department.csv");

    Assert.assertThat(report.getName(), is("income-95-by-department.csv"));
  }
}
