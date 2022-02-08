package org.clases.libroservice.controller.error;

import org.clases.libroservice.exception.LibroNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ClasesErrorHandler {

  @ExceptionHandler(value = {LibroNotFoundException.class})
  public ResponseEntity<ErrorMessage> resourceNotFoundException(LibroNotFoundException ex, WebRequest request) {
    ErrorMessage message = new ErrorMessage(
        ex.getMessage(),
        "Libro no encontrado");

    return new ResponseEntity<ErrorMessage>(message, HttpStatus.NOT_FOUND);
  }
}
