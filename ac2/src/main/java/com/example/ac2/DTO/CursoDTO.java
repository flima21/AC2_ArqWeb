package com.example.ac2.DTO;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class CursoDTO {
  private Integer id;
  private String descricao;
  private double cargaHoraria;
  private String objetivos;
  private String ementa;
  private List<ProfessorDTO> professores;
}