package com.rizwanmushtaq.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
  Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

  // general exception handler for all exceptions
  // can be used to log the exception or return a generic error response
  @ExceptionHandler(Exception.class)
  public ResponseEntity<String> handleException(Exception exception) {
    logger.error("An error occurred: {}", exception.getMessage());
    return new ResponseEntity<String>(
        "An unexpected error occurred." + exception.getMessage(),
        HttpStatus.INTERNAL_SERVER_ERROR
    );
  }
}
