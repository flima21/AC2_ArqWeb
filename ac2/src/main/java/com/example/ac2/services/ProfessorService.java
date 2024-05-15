package com.example.ac2.services;

import com.example.ac2.dtos.ProfessoresDTO;
import com.example.ac2.models.Professor;
import java.util.List;

public interface ProfessorService {
  Professor store(ProfessoresDTO professor);

  ProfessoresDTO findById(Integer id);
  List<ProfessoresDTO> findAll();

  void delete(Integer id);
}
