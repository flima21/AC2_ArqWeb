package com.example.ac2.services;

import java.util.List;

import com.example.ac2.dtos.AgendaDTO;
import com.example.ac2.dtos.DadosAgendaDTO;
import com.example.ac2.models.Agenda;

public interface AgendaService {
  Agenda store(AgendaDTO agenda);

  List<Agenda> findAgendaByProfessor(int professorId);

  void delete(int agendaId);
}
