package org.challenge.data.writer;

import static java.util.stream.Collectors.toList;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.challenge.report.Report;

public class ConsoleDataWriter implements DataWriter {

  private String delimiter;

  public ConsoleDataWriter(String delimiter) {
    this.delimiter = delimiter;
  }

  @Override
  public void write(Report report) {

    String columns = report.getColumns().stream()
        .collect(Collectors.joining(delimiter + " "));

    String rows = convertMapEntriesToCsvStringLines(report.getRows()).stream()
        .collect(Collectors.joining("\n\t"));

    System.out.println();
    System.out.println(report.getName());
    System.out.println("\t" + columns);
    System.out.println("\t" + rows);
  }

  private <K, V> List<String> convertMapEntriesToCsvStringLines(Map<K, V> data) {
    return data.entrySet().stream()
        .map(entry -> entry.getKey() + delimiter + String.format(" %.2f", entry.getValue()))
        .collect(toList());
  }
}
