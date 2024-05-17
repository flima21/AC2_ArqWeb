package com.example.ac2.interfaces;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.ac2.dtos.AgendaDTO;
import com.example.ac2.dtos.CursosDTO;
import com.example.ac2.dtos.DadosAgendaDTO;
import com.example.ac2.exception.ApiErrorApplication;
import com.example.ac2.models.Agenda;
import com.example.ac2.models.Curso;
import com.example.ac2.models.Professor;
import com.example.ac2.repository.AgendaRepository;
import com.example.ac2.repository.CursoRepository;
import com.example.ac2.repository.ProfessorRepository;
import com.example.ac2.services.AgendaService;

@Service
public class AgendaImpl implements AgendaService {
  private AgendaRepository agendaRepository;
  private CursoRepository cursoRepository;
  private ProfessorRepository professorRepository;

  @Override
  public Agenda store(AgendaDTO agendaDTO) {
    if (this.agendaRepository.findAgendaFetchDataInicioProfessores(agendaDTO.getDataInicio(), agendaDTO.getProfessores_id()) != null) throw new ApiErrorApplication("Professor com agenda indisponível");
    
    // Professor professor = this.professorRepository.findById(agendaDTO.getCurso_id()).orElseThrow(() -> new ApiErrorApplication("Professor não localizado"));
    // Curso curso = this.cursoRepository.findCursoByIdFetchProfessores(agendaDTO.getProfessores_id()).orElseThrow(() -> new ApiErrorApplication("Professor não apto para curso"));
    
    Agenda agenda = new Agenda();

    // agenda.setCep(agendaDTO.getCep());
    // agenda.setCidade(agendaDTO.getCidade());
    // agenda.setEstado(agenda.getEstado());
    // agenda.setFim(agendaDTO.getDataFinal());
    // agenda.setInicio(agendaDTO.getDataInicio());
    // agenda.setCursos(curso);
    // agenda.setProfessores(professor);
    // agenda.setId(agendaDTO.getId());
    // agenda.setTreinamento(agendaDTO.getTreinamento());

    return agenda;
  } 

  @Override
  public List<Agenda> findAgendaByProfessor(int professorId){
    return this.agendaRepository.findAgendaByIdProfessoresFetchProfessores(professorId);
  }

  public void delete(int agendaId) {
    Agenda agenda = this.agendaRepository.findById(agendaId).orElseThrow(() -> new ApiErrorApplication("Agenda não encontrada"));

    this.agendaRepository.delete(agenda);
  }
}
