package org.challenge.exception;

public class DirectoryCreationException extends RuntimeException {

  public DirectoryCreationException(String path, Throwable cause) {
    super("Cannot create directory [" + path + "]", cause);
  }
}
