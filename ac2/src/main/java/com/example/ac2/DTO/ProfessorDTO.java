package com.example.ac2.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProfessorDTO {
  private Integer id;
  private String nome;
  private String cpf;
  private String rg;
  private String endereco;
  private String celular;

  private CursoDTO cursos;
}
