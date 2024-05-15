package com.example.ac2.services;

import java.util.List;

import com.example.ac2.dtos.CursosDTO;
import com.example.ac2.dtos.DadosCursosDTO;
import com.example.ac2.models.Curso;

public interface CursoService {
  Curso store(CursosDTO curso);
  List<DadosCursosDTO> findAll();
}
