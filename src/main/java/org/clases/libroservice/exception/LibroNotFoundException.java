package org.clases.libroservice.exception;

public class LibroNotFoundException extends RuntimeException {
  public LibroNotFoundException(String message) {
    super(message);
  }

  public LibroNotFoundException(String message, Throwable cause) {
    super(message, cause);
  }

  public LibroNotFoundException(Throwable cause) {
    super(cause);
  }

  protected LibroNotFoundException(String message, Throwable cause,
      boolean enableSuppression,
      boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
