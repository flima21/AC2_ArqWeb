package com.example.ac2.DTO;

import java.util.Arrays;
import java.util.List;

import lombok.Getter;

@Getter
public class ApiErrorDTO {
  private List<String> errors;

  public ApiErrorDTO(String mensagem) {
    this.errors = Arrays.asList(mensagem);
  }

}
