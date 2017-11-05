package org.challenge.data.mapper;

import static org.hamcrest.core.Is.is;

import org.challenge.data.model.EmployeeAge;
import org.junit.Assert;
import org.junit.Test;

public class AgeLineMapperTest {

  @Test
  public void testThatStringCsvLineIsMappedIntoEmployeeAge() {

    EmployeeAge employeeAge = new AgeLineMapper(",").map("Opal Ballard,23");

    Assert.assertThat(employeeAge.getAge(), is(23));
    Assert.assertThat(employeeAge.getEmployeeName(), is("Opal Ballard"));
  }

  @Test
  public void testThatReturnsNullInCaseOfWrongCsvLineFormat() {

    Assert.assertNull(new AgeLineMapper(",").map(""));
    Assert.assertNull(new AgeLineMapper(",").map("name,"));
    Assert.assertNull(new AgeLineMapper(",").map("name,twenty three"));
  }
}
