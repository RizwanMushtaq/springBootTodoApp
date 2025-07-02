package com.rizwanmushtaq.exceptions;

import org.springframework.http.HttpStatus;

public class ExceptionResponse {
  private String message;
  private boolean success;
  private HttpStatus statusCode;

  public ExceptionResponse(String message, boolean success, HttpStatus statusCode) {
    this.message = message;
    this.success = success;
    this.statusCode = statusCode;
  }

  public ExceptionResponse() {
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public boolean isSuccess() {
    return success;
  }

  public void setSuccess(boolean success) {
    this.success = success;
  }

  public HttpStatus getStatusCode() {
    return statusCode;
  }

  public void setStatusCode(HttpStatus statusCode) {
    this.statusCode = statusCode;
  }
}
