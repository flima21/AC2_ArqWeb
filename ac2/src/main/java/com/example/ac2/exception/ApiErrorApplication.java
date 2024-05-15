package com.example.ac2.exception;

public class ApiErrorApplication extends RuntimeException {
  public ApiErrorApplication(String message) {
    super(message);
  }
}
