package org.challenge.data.model;

import java.math.BigDecimal;

public class Employee {

  private String name;
  private String gender;
  private int age;
  private int departmentId;
  private String departmentName;
  private BigDecimal salary;

  public static Employee of(
      String name, String gender, int departmentId, double salary) {

    return Employee.of(name, gender, 0, departmentId, null, salary);
  }

  public static Employee of(
      String name, String gender, int age, int departmentId, String departmentName, double salary) {

    Employee employee = new Employee();
    employee.setName(name);
    employee.setGender(gender);
    employee.setAge(age);
    employee.setDepartmentId(departmentId);
    employee.setDepartmentName(departmentName);
    employee.setSalary(BigDecimal.valueOf(salary));

    return employee;
  }

  public int getDepartmentId() {
    return departmentId;
  }

  public void setDepartmentId(int departmentId) {
    this.departmentId = departmentId;
  }

  public String getDepartmentName() {
    return departmentName;
  }

  public void setDepartmentName(String departmentName) {
    this.departmentName = departmentName;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public Double getAgeDouble() {
    return (double) age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public BigDecimal getSalary() {
    return salary;
  }

  public Double getSalaryDouble() {
    return salary.doubleValue();
  }

  public void setSalary(BigDecimal salary) {
    this.salary = salary;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  @Override
  public String toString() {
    return "Employee{" +
        "name='" + name + '\'' +
        ", gender='" + gender + '\'' +
        ", age=" + age +
        ", departmentId=" + departmentId +
        ", departmentName='" + departmentName + '\'' +
        ", salary=" + salary +
        '}';
  }
}
