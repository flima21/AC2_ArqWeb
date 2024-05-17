package com.example.ac2.interfaces;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.ac2.dtos.AgendaDTO;
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
    Professor professor = this.professorRepository.findById(agendaDTO.getCurso_id()).orElseThrow(() -> new ApiErrorApplication("Professor não localizado"));
    Curso curso = this.cursoRepository.findById(agendaDTO.getCurso_id()).orElseThrow(() -> new ApiErrorApplication("Curso não localizado"));

    if (this.agendaRepository.findAgendaFetchDataInicioProfessores(agendaDTO.getDataInicio(), agendaDTO.getDataFinal(),agendaDTO.getProfessores_id()) != null) throw new ApiErrorApplication("Professor com agenda indisponível");
    if (this.cursoRepository.findCursoByIdFetchProfessores(professor.getId()) == null) throw new ApiErrorApplication("O professor não pode ministrar este curso.");
    
    Agenda agenda = new Agenda();

    agenda.setCep(agendaDTO.getCep());
    agenda.setCidade(agendaDTO.getCidade());
    agenda.setEstado(agenda.getEstado());
    agenda.setFim(agendaDTO.getDataFinal());
    agenda.setInicio(agendaDTO.getDataInicio());
    agenda.setCursos(curso);
    agenda.setProfessores(professor);
    agenda.setId(agendaDTO.getId());
    agenda.setTreinamento(agendaDTO.getTreinamento());

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

  @Override
  public boolean existsByProfessoresId(Integer professor_id) {
    return this.agendaRepository.existsByProfessoresId(professor_id);
  }

  @Override
  public boolean existsByCursosId(Integer cursos_id) {
    return this.agendaRepository.existsByCursosId(cursos_id);
  }
}
