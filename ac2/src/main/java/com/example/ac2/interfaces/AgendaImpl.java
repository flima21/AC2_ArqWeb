package com.example.ac2.interfaces;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.ac2.dtos.AgendaDTO;
import com.example.ac2.dtos.TreinamentoDTO;
import com.example.ac2.exception.ApiErrorApplication;
import com.example.ac2.models.Agenda;
import com.example.ac2.models.Curso;
import com.example.ac2.models.Professor;
import com.example.ac2.repository.AgendaRepository;
import com.example.ac2.repository.CursoRepository;
import com.example.ac2.repository.ProfessorRepository;
import com.example.ac2.services.AgendaService;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AgendaImpl implements AgendaService {
  private AgendaRepository agendaRepository;
  private CursoRepository cursoRepository;
  private ProfessorRepository professorRepository;

  @Override
  @Transactional
  public List<Agenda> findAll() {
    return this.agendaRepository.findAll();
  }

  @Override
  @Transactional
  public Agenda findById(Integer id) {
    Agenda agenda = this.agendaRepository.findById(id).orElseThrow(() -> new ApiErrorApplication("Agenda não localizada"));
    return agenda;
  }


  @Override
  @Transactional
  public Agenda store(AgendaDTO agendaDTO) {
    Professor professor = this.professorRepository.findById(agendaDTO.getProfessores_id()).orElseThrow(() -> new ApiErrorApplication("Professor não localizado"));
    Curso curso = this.cursoRepository.findById(agendaDTO.getCurso_id()).orElseThrow(() -> new ApiErrorApplication("Curso não localizado"));

    if (this.agendaRepository.findAgendaFetchDataInicioProfessores(agendaDTO.getDataInicio(), agendaDTO.getDataFinal(),agendaDTO.getProfessores_id()) != null) throw new ApiErrorApplication("Professor com agenda indisponível");
    if (this.cursoRepository.findCursoByIdFetchProfessores(professor.getId()) == null) throw new ApiErrorApplication("O professor não pode ministrar este curso.");
    
    Agenda agenda = new Agenda();

    agenda.setCep(agendaDTO.getCep());
    agenda.setCidade(agendaDTO.getCidade());
    agenda.setEstado(agendaDTO.getEstado());
    agenda.setFim(agendaDTO.getDataFinal());
    agenda.setInicio(agendaDTO.getDataInicio());
    agenda.setCursos(curso);
    agenda.setProfessores(professor);
    agenda.setId(agendaDTO.getId());
    agenda.setTreinamento(agendaDTO.getTreinamento());

    return this.agendaRepository.save(agenda);
  } 

  @Override
  @Transactional
  public List<Agenda> findAgendaByProfessor(int professorId){
    return this.agendaRepository.findAgendaByIdProfessoresFetchProfessores(professorId);
  }
  
  @Override
  @Transactional
  public void delete(int agendaId) {
    Agenda agenda = this.agendaRepository.findById(agendaId).orElseThrow(() -> new ApiErrorApplication("Agenda não encontrada"));
    this.agendaRepository.delete(agenda);
  }

  @Override
  @Transactional
  public boolean existsByProfessoresId(Integer professor_id) {
    return this.agendaRepository.existsByProfessoresId(professor_id);
  }

  @Override
  @Transactional
  public boolean existsByCursosId(Integer cursos_id) {
    return this.agendaRepository.existsByCursosId(cursos_id);
  }

  @Override
  @Transactional
  public Agenda setTreinamento(TreinamentoDTO treinamento) {
    Agenda agenda = this.agendaRepository.findById(treinamento.getId()).orElseThrow(() -> new ApiErrorApplication("Agenda não encontrada"));

    agenda.setTreinamento(treinamento.getTreinamento());

    return this.agendaRepository.save(agenda);
  }
}
