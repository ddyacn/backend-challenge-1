package org.challenge.data.model;

public class EmployeeAge {

  private int age;
  private String employeeName;

  public static EmployeeAge of(String employeeName, int age) {

    EmployeeAge employeeAge = new EmployeeAge();
    employeeAge.setEmployeeName(employeeName);
    employeeAge.setAge(age);

    return employeeAge;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getEmployeeName() {
    return employeeName;
  }

  public void setEmployeeName(String employeeName) {
    this.employeeName = employeeName;
  }

  @Override
  public String toString() {
    return "EmployeeAge{" +
        "age=" + age +
        ", employeeName='" + employeeName + '\'' +
        '}';
  }
}
