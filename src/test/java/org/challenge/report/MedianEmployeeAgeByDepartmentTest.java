package org.challenge.report;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static org.hamcrest.core.Is.is;

import java.util.List;
import java.util.Map;
import org.challenge.data.model.Employee;
import org.challenge.report.MedianEmployeeAgeByDepartment;
import org.challenge.report.Report;
import org.junit.Assert;
import org.junit.Test;

public class MedianEmployeeAgeByDepartmentTest {

  @Test
  public void testThatReportCalculatesMedianEmployeeAgeByDepartment() {

    List<Employee> employees = asList(
        Employee.of("Byron Powell", "m", 19, 1, "Marketing", 1000.00),
        Employee.of("June Holland", "f", 23, 1, "Marketing", 1000.00),
        Employee.of("Opal Ballard", "m", 27, 1, "Marketing", 1000.00),
        Employee.of("Hilda Fisher", "f", 30, 2, "Sales", 1000.00),
        Employee.of("Randy Warner", "m", 40, 2, "Sales", 1000.00));

    Map<String, Double> rows =
        new MedianEmployeeAgeByDepartment(employees, "whatever-name").getRows();

    Assert.assertThat(rows.get("Marketing"), is(23.0));
    Assert.assertThat(rows.get("Sales"), is(35.0));
  }

  @Test
  public void testThatReportReturnsCorrectColumnNames() {
    Report report =
        new MedianEmployeeAgeByDepartment(emptyList(), "whatever-name");

    Assert.assertThat(report.getColumns(), is(asList("department", "medianEmployeeAge")));
  }

  @Test
  public void testThatReportReturnsCorrectReportName() {
    Report report =
        new MedianEmployeeAgeByDepartment(emptyList(), "employee-age-by-department.csv");

    Assert.assertThat(report.getName(), is("employee-age-by-department.csv"));
  }
}
