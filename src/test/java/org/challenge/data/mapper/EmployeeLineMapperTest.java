package org.challenge.data.mapper;

import static org.hamcrest.core.Is.is;

import java.math.BigDecimal;
import org.challenge.data.model.Employee;
import org.junit.Assert;
import org.junit.Test;

public class EmployeeLineMapperTest {

  @Test
  public void testThatStringCsvLineIsMappedIntoEmployeeAge() {

    Employee employee = new EmployeeLineMapper(",").map("7,Otis Bell,m,2650.55");

    Assert.assertThat(employee.getDepartmentId(), is(7));
    Assert.assertThat(employee.getName(), is("Otis Bell"));
    Assert.assertThat(employee.getGender(), is("m"));
    Assert.assertThat(employee.getSalaryDouble(), is(2650.55));
    Assert.assertThat(employee.getSalary(), is(BigDecimal.valueOf(2650.55)));
  }

  @Test
  public void testThatReturnsNullInCaseOfWrongCsvLineFormat() {

    Assert.assertNull(new EmployeeLineMapper(",").map(""));
    Assert.assertNull(new EmployeeLineMapper(",").map("6,Doreen Rodgers f,2060.00"));
    Assert.assertNull(new EmployeeLineMapper(",").map("7,Joel Scott,m,4470.0O"));
  }
}
