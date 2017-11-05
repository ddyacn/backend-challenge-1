package org.challenge.report;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.challenge.Statistics;
import org.challenge.data.model.Employee;

public class PercentileIncomeByDepartmentReport implements Report {

  private List<Employee> employees;

  private int percentile;

  private String name;

  public PercentileIncomeByDepartmentReport(List<Employee> employees, int percentile, String name) {
    this.employees = new ArrayList<>(employees);
    this.percentile = percentile;
    this.name = name;
  }

  @Override
  public Map<String, Double> getRows() {
    return employees.stream()
        .collect(
            groupingBy(Employee::getDepartmentName,
                mapping(Employee::getSalaryDouble,
                    collectingAndThen(toList(), l -> Statistics.percentile(percentile, l)))));
  }

  @Override
  public List<String> getColumns() {
    return Arrays.asList("department", percentile + "percentile");
  }

  @Override
  public String getName() {
    return name;
  }
}
