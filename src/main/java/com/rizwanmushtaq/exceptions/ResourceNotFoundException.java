package com.rizwanmushtaq.exceptions;

import org.springframework.http.HttpStatus;

public class ResourceNotFoundException extends RuntimeException {
  private String message;
  private HttpStatus statusCode;

  public ResourceNotFoundException(String message, HttpStatus statusCode) {
    super(message);
    this.message = message;
    this.statusCode = statusCode;
  }

  @Override
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public HttpStatus getStatusCode() {
    return statusCode;
  }

  public void setStatusCode(HttpStatus statusCode) {
    this.statusCode = statusCode;
  }
}
