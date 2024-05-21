package com.example.ac2.services;

import java.util.List;

import com.example.ac2.dtos.CursosDTO;
import com.example.ac2.dtos.DadosCursosDTO;
import com.example.ac2.dtos.DadosProfessoresDTO;
import com.example.ac2.models.Curso;
import com.example.ac2.models.Professor;

public interface CursoService {
  List<DadosCursosDTO> findAll();
  DadosCursosDTO findById(Integer id);
  List<Professor> findProfessorEspecializado(Integer idCurso);

  Curso store(DadosCursosDTO curso);
  Curso update(DadosCursosDTO professor);

  void delete(Integer id);

}
