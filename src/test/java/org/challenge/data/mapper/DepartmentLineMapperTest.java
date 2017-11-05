package org.challenge.data.mapper;

import static org.hamcrest.core.Is.is;

import org.junit.Assert;
import org.junit.Test;

public class DepartmentLineMapperTest {

  @Test
  public void testThatDepartmentCsvLineIsMappedIntoString() {

    Assert.assertThat(new DepartmentLineMapper().map("Sales"), is("Sales"));
  }

  @Test
  public void testThatReturnsDepartmentAsNullInCaseOfWrongCsvLineFormat() {

    Assert.assertNull(new DepartmentLineMapper().map(""));
  }
}
