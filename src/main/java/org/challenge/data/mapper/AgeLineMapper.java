package org.challenge.data.mapper;

import org.challenge.data.model.EmployeeAge;

public class AgeLineMapper implements CsvLineMapper<EmployeeAge> {

  private String delimiter;

  public AgeLineMapper(String delimiter) {
    this.delimiter = delimiter;
  }

  @Override
  public EmployeeAge map(String line) {
    String[] args = line.split(delimiter);

    try {
      return EmployeeAge.of(args[0], Integer.valueOf(args[1]));

    } catch (RuntimeException ex) {
      System.out.println("\tMapping error: from ["
          + line + "] to [EmployeeAge], reason: [" + ex.toString() + "]");
    }

    return null;
  }
}
