package org.challenge.data.writer;

import static java.util.stream.Collectors.toList;

import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.challenge.exception.CsvDataWritingException;
import org.challenge.exception.DirectoryCreationException;
import org.challenge.report.Report;

public class CsvDataWriter implements DataWriter {

  private String dirPath;

  private String delimiter;

  public CsvDataWriter(String dirPath, String delimiter) {
    this.dirPath = dirPath;
    this.delimiter = delimiter;
  }

  @Override
  public void write(Report report) {

    createDirectoryIfNotExist(dirPath);

    Path path = Paths.get(dirPath, report.getName());
    System.out.println("Writing: " + path);

    try (BufferedWriter writer = Files.newBufferedWriter(path)) {

      String columns = report.getColumns().stream()
          .collect(Collectors.joining(delimiter + " "));

      String rows = convertMapEntriesToCsvStringLines(report.getRows()).stream()
          .collect(Collectors.joining("\n"));

      writer.write(columns);
      writer.newLine();
      writer.write(rows);

    } catch (Exception ex) {
      throw new CsvDataWritingException(path, ex);
    }
  }

  private void createDirectoryIfNotExist(String path) {
    try {
      Path dir = Paths.get(dirPath);
      if (!Files.exists(dir)) {
        Files.createDirectories(dir);
      }
    } catch (Exception ex) {
      throw new DirectoryCreationException(path, ex);
    }
  }

  private <K, V> List<String> convertMapEntriesToCsvStringLines(Map<K, V> data) {
    return data.entrySet().stream()
        .map(entry -> entry.getKey() + delimiter + String.format(" %.2f", entry.getValue()))
        .collect(toList());
  }
}
