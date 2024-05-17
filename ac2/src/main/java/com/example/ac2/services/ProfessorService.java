package com.example.ac2.services;

import com.example.ac2.dtos.AgendaDTO;
import com.example.ac2.dtos.DadosProfessoresDTO;
import com.example.ac2.dtos.ProfessoresDTO;
import com.example.ac2.models.Agenda;
import com.example.ac2.models.Professor;
import java.util.List;

public interface ProfessorService {
  List<ProfessoresDTO> findAll();
  
  ProfessoresDTO findById(Integer id);
  Professor store(DadosProfessoresDTO professor);
  Professor update(DadosProfessoresDTO professor);

  List<Agenda> getAgenda(Integer id);

  void delete(Integer id);
}
