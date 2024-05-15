package com.example.ac2.services;

import com.example.ac2.DTO.ProfessorDTO;
import com.example.ac2.models.Professor;
import java.util.List;

public interface ProfessorService {
  Professor store(ProfessorDTO professor);

  ProfessorDTO findById(Integer id);
  List<ProfessorDTO> findAll();

  void delete(Integer id);
}
