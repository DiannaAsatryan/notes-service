package com.mycompany.note.inbound.exception;

import lombok.AllArgsConstructor;
import lombok.Value;

@AllArgsConstructor
@Value
public class ErrorResponse {

  public static enum ErrorCode{
    VALIDATION_ERROR,
    INTERNAL_ERROR,
    NO_RESOURCE_FOUND
  }

  private ErrorCode code;
  private String message;

}
