package org.challenge.exception;

import java.nio.file.Path;

public class CsvDataReadingException extends RuntimeException {

  public CsvDataReadingException(Path path, Throwable ex) {
    super("Cannot read csv file [" + path + "]", ex);
  }
}
