package org.challenge.exception;

import java.io.IOException;
import java.nio.file.Path;

public class CsvDataWritingException extends RuntimeException {

  public CsvDataWritingException(Path path, Throwable ex) {
    super("Cannot write csv into file [" + path + "]", ex);
  }
}
