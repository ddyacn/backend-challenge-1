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

public class MedianEmployeeAgeByDepartment implements Report {

  private List<Employee> employees;

  private String name;

  public MedianEmployeeAgeByDepartment(List<Employee> employees, String name) {
    this.employees = new ArrayList<>(employees);
    this.name = name;
  }

  @Override
  public Map<String, Double> getRows() {
    return employees.stream()
        .collect(
            groupingBy(Employee::getDepartmentName,
                mapping(Employee::getAgeDouble,
                    collectingAndThen(toList(), Statistics::median))));
  }

  @Override
  public List<String> getColumns() {
    return Arrays.asList("department", "medianEmployeeAge");
  }

  @Override
  public String getName() {
    return name;
  }
}
