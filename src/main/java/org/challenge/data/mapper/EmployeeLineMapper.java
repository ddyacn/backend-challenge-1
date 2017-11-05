package org.challenge.data.mapper;

import java.math.BigDecimal;
import org.challenge.data.model.Employee;

public class EmployeeLineMapper implements CsvLineMapper<Employee> {

  private String delimiter;

  public EmployeeLineMapper(String delimiter) {
    this.delimiter = delimiter;
  }

  @Override
  public Employee map(String line) {

    if (line.isEmpty()) {
      return null;
    }

    String[] args = line.split(delimiter);

    try {
      Employee employee = new Employee();
      employee.setDepartmentId(Integer.valueOf(args[0]));
      employee.setName(args[1]);
      employee.setGender(args[2]);
      employee.setSalary(new BigDecimal(args[3]));
      return employee;

    } catch (RuntimeException ex) {
      System.out.println("\tMapping error: from ["
          + line + "] to [Employee], reason: [" + ex.toString() + "]");
    }

    return null;
  }
}
