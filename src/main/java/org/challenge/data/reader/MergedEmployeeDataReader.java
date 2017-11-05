package org.challenge.data.reader;

import static java.util.stream.Collectors.toMap;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.challenge.data.model.Employee;
import org.challenge.data.model.EmployeeAge;

public class MergedEmployeeDataReader implements DataReader<Employee> {

  private DataReader<Employee> employeeReader;
  private DataReader<String> departmentReader;
  private DataReader<EmployeeAge> ageReader;

  public MergedEmployeeDataReader(
      DataReader<Employee> employeeReader,
      DataReader<EmployeeAge> employeeAgeReader,
      DataReader<String> departmentReader) {

    this.employeeReader = employeeReader;
    this.departmentReader = departmentReader;
    this.ageReader = employeeAgeReader;
  }

  @Override
  public List<Employee> read() {

    List<Employee> employees = employeeReader.read();
    List<String> departments = departmentReader.read();

    Map<String, Integer> ages = ageReader.read().stream()
        .collect(toMap(EmployeeAge::getEmployeeName, EmployeeAge::getAge));

    employees.forEach(employee -> {
      employee.setAge(ages.get(employee.getName()));

      int departmentId = employee.getDepartmentId() - 1;
      if (departmentId < departments.size()) {
        employee.setDepartmentName(departments.get(departmentId));
      } else {
        employee.setDepartmentName("unknown_department_" + employee.getDepartmentId());
      }
    });

    return Collections.unmodifiableList(employees);
  }
}
