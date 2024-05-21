package com.example.ac2.services;

import java.util.List;

import com.example.ac2.dtos.AgendaDTO;
import com.example.ac2.dtos.TreinamentoDTO;
import com.example.ac2.models.Agenda;

public interface AgendaService {
  Agenda store(AgendaDTO agenda);
  Agenda findById(Integer id);
  List<Agenda> findAll();
  
  Agenda setTreinamento(TreinamentoDTO treinamentoDTO);

  List<Agenda> findAgendaByProfessor(int professorId);

  void delete(int agendaId);

  boolean existsByProfessoresId(Integer professor_id);
  boolean existsByCursosId(Integer cursos_id);
}
