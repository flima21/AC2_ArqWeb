package com.example.ac2.services;

import java.util.List;

import com.example.ac2.dtos.CursosDTO;
import com.example.ac2.dtos.DadosCursosDTO;
import com.example.ac2.dtos.DadosProfessoresDTO;
import com.example.ac2.models.Curso;

public interface CursoService {
  List<DadosCursosDTO> findAll();
  DadosCursosDTO findById(Integer id);
  List<DadosProfessoresDTO> findProfessorEspecializado(Integer idCurso);

  Curso store(CursosDTO curso);
  Curso update(CursosDTO professor);

  void delete(Integer id);

}
