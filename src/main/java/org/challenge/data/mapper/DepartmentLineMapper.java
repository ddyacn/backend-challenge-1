package org.challenge.data.mapper;

public class DepartmentLineMapper implements CsvLineMapper<String> {

  @Override
  public String map(String line) {
    return line.isEmpty() ? null : line;
  }
}
