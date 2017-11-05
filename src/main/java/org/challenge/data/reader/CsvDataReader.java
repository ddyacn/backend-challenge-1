package org.challenge.data.reader;

import static java.util.stream.Collectors.toList;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import org.challenge.exception.CsvDataReadingException;
import org.challenge.data.mapper.CsvLineMapper;

public class CsvDataReader<T> implements DataReader<T> {

  private String dirPath;

  private String fileName;

  private CsvLineMapper<T> lineMapper;

  public CsvDataReader(String dirPath, String fileName, CsvLineMapper<T> lineMapper) {
    this.dirPath = dirPath;
    this.fileName = fileName;
    this.lineMapper = lineMapper;
  }

  @Override
  public List<T> read() {

    Path path = Paths.get(dirPath, fileName);
    System.out.println("Reading: " + path);

    try {
      return Files.lines(path)
          .filter(this::nonEmpty)
          .map(lineMapper::map)
          .filter(Objects::nonNull)
          .collect(toList());

    } catch (Exception ex) {
      throw new CsvDataReadingException(path, ex);
    }
  }

  private boolean nonEmpty(String line) {
    return line != null && !line.isEmpty();
  }
}
