package org.clases.libroservice.controller.error;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * The type Error message.
 */
@Data
@AllArgsConstructor
public class ErrorMessage {

  private String error;
  private String description;
}
