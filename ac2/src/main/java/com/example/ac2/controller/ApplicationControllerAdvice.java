package com.example.ac2.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.http.HttpStatus;

import com.example.ac2.DTO.ApiErrorDTO;
import com.example.ac2.exception.ApiErrorApplication;

@RestControllerAdvice
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ApplicationControllerAdvice {
  @ExceptionHandler(ApiErrorApplication.class)
  public ApiErrorDTO handleRegraNegocioException(ApiErrorApplication ex) {
    String msg = ex.getMessage();
    return new ApiErrorDTO(msg);
  }
}
