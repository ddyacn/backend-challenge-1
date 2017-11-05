package org.challenge.report;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static org.hamcrest.core.Is.is;

import java.util.List;
import java.util.Map;
import org.challenge.data.model.Employee;
import org.challenge.report.AvgIncomeByAgeRangesReport;
import org.challenge.report.Report;
import org.junit.Assert;
import org.junit.Test;

public class AvgIncomeByAgeRangesReportTest {

  @Test
  public void testThatReportCalculatesAvgIncomeByAgeRangesWithFactorOf10() {

    List<Employee> employees = asList(
        Employee.of("June Holland", "f", 20, 1, "A", 3000.00),
        Employee.of("Opal Ballard", "m", 29, 2, "B", 2000.00),
        Employee.of("Hilda Fisher", "f", 30, 3, "C", 2000.00),
        Employee.of("Randy Warner", "m", 39, 4, "D", 3000.00));

    int factor = 10;

    Map<String, Double> rows =
        new AvgIncomeByAgeRangesReport(employees, factor, "whatever-name").getRows();

    Assert.assertThat(rows.get("20-30"), is(2500.0));
    Assert.assertThat(rows.get("30-40"), is(2500.0));
  }

  @Test
  public void testThatReportCalculatesAvgIncomeByAgeRangesWithFactorOf15() {

    List<Employee> employees = asList(
        Employee.of("Byron Powell", "m", 19, 1, "A", 1000.00),
        Employee.of("June Holland", "f", 20, 2, "B", 3000.00),
        Employee.of("Opal Ballard", "m", 29, 3, "C", 2000.00),
        Employee.of("Hilda Fisher", "f", 30, 4, "D", 2000.00),
        Employee.of("Randy Warner", "m", 39, 5, "E", 3000.00));

    int factor = 15;

    Map<String, Double> rows =
        new AvgIncomeByAgeRangesReport(employees, factor, "whatever-name").getRows();

    Assert.assertThat(rows.get("15-30"), is(2000.0));
    Assert.assertThat(rows.get("30-45"), is(2500.0));
  }

  @Test
  public void testThatReportReturnsCorrectColumnNames() {

    int factor = 10;
    Report report = new AvgIncomeByAgeRangesReport(emptyList(), factor, "whatever-name");

    Assert.assertThat(report.getColumns(), is(asList("ageRange", "averageIncome")));
  }

  @Test
  public void testThatReportReturnsCorrectReportName() {

    int factor = 10;
    Report report =
        new AvgIncomeByAgeRangesReport(emptyList(), factor, "income-average-by-age-range.csv");

    Assert.assertThat(report.getName(), is("income-average-by-age-range.csv"));
  }
}
