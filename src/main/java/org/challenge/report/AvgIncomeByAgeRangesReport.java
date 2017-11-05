package org.challenge.report;

import static java.util.stream.Collectors.averagingDouble;
import static java.util.stream.Collectors.groupingBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.challenge.data.model.Employee;

public class AvgIncomeByAgeRangesReport implements Report {

  private List<Employee> employees;

  private int factor;

  private String name;

  public AvgIncomeByAgeRangesReport(List<Employee> employees, int factor, String name) {
    this.employees = new ArrayList<>(employees);
    this.factor = factor;
    this.name = name;
  }

  @Override
  public Map<String, Double> getRows() {
    return employees.stream()
        .collect(
            groupingBy(employee -> ageRangeWithFactorOfN(employee, factor),
                averagingDouble(Employee::getSalaryDouble)));
  }

  private String ageRangeWithFactorOfN(Employee employee, int factor) {
    int lowBound = (int) (factor * Math.ceil(employee.getAge() / factor));
    int highBound = lowBound + factor;
    return lowBound + "-" + highBound;
  }

  @Override
  public List<String> getColumns() {
    return Arrays.asList("ageRange", "averageIncome");
  }

  @Override
  public String getName() {
    return name;
  }
}
