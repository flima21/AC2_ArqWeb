package com.example.ac2.interfaces;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.ac2.dtos.AgendaDTO;
import com.example.ac2.dtos.CursosDTO;
import com.example.ac2.dtos.DadosProfessoresDTO;
import com.example.ac2.dtos.ProfessoresDTO;
import com.example.ac2.exception.ApiErrorApplication;
import com.example.ac2.models.Agenda;
import com.example.ac2.models.Curso;
import com.example.ac2.models.Professor;
import com.example.ac2.repository.AgendaRepository;
import com.example.ac2.repository.CursoRepository;
import com.example.ac2.repository.ProfessorRepository;
import com.example.ac2.services.ProfessorService;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ProfessorImpl implements ProfessorService {
  private ProfessorRepository professorRepository;
  private AgendaRepository agendaRepository;

  @Override
  @Transactional
  public Professor store(DadosProfessoresDTO professor) {
    Professor professorObjeto = new Professor();

    professorObjeto.setCelular(professor.getCelular());
    professorObjeto.setCpf(professor.getCpf());
    professorObjeto.setEndereco(professor.getEndereco());
    professorObjeto.setNome(professor.getNome());
    professorObjeto.setRg(professor.getRg());
    professorObjeto.setId(professor.getId());

    return this.professorRepository.save(professorObjeto);
  }

  @Override
  @Transactional
  public ProfessoresDTO findById(Integer id) {
    Professor professor = this.professorRepository.findById(id).orElseThrow(() -> new ApiErrorApplication("Professor não encontrado"));
    ProfessoresDTO professorDTO = new ProfessoresDTO();
    
    List<CursosDTO> cursos = new ArrayList<>();
    List<Agenda> agenda = this.agendaRepository.findAgendaByIdProfessoresFetchProfessores(id);
    List<AgendaDTO> agendaDTOs = new ArrayList<>();

    professorDTO.setCelular(professor.getCelular());
    professorDTO.setCpf(professor.getCpf());
    professorDTO.setEndereco(professor.getEndereco());
    professorDTO.setId(professor.getId());
    professorDTO.setNome(professor.getNome());
    professorDTO.setRg(professor.getRg());
    
    for (Curso curso : professor.getCursos()) {
      CursosDTO cursosDTO =  new CursosDTO();

      cursosDTO.setCargaHoraria(curso.getCargaHoraria());
      cursosDTO.setDescricao(curso.getDescricao());
      cursosDTO.setId(curso.getId());
      cursosDTO.setObjetivos(curso.getObjetivo());
      cursosDTO.setEmenta(curso.getEmenta());
      cursos.add(cursosDTO);
    }

    for (Agenda agenda2 : agenda) {
      AgendaDTO agendaDTO = new AgendaDTO();
      
      agendaDTO.setCep(agenda2.getCep());
      agendaDTO.setCidade(agenda2.getCidade());
      agendaDTO.setCurso_id(agenda2.getId());
      agendaDTO.setDataFinal(agenda2.getFim());
      agendaDTO.setDataInicio(agenda2.getInicio());
      agendaDTO.setEstado(agenda2.getEstado());
      agendaDTO.setId(agenda2.getId());
      agendaDTO.setProfessores_id(id);
      agendaDTO.setTreinamento(agenda2.getTreinamento());

      agendaDTOs.add(agendaDTO);
    }

    professorDTO.setAgenda(agendaDTOs);
    professorDTO.setCursos(cursos);

    return professorDTO;
  }

  @Override
  @Transactional
  public List<ProfessoresDTO> findAll() {
    List<Professor> professors = this.professorRepository.findAll();
    List<ProfessoresDTO> professorDTOs = new ArrayList<ProfessoresDTO>();
    
    for (Professor professor : professors) {
      ProfessoresDTO professorDTO = new ProfessoresDTO();
      List<Agenda> agendas = this.agendaRepository.findAgendaByIdProfessoresFetchProfessores(professor.getId());
      List<CursosDTO> cursos = new ArrayList<>();
      List<AgendaDTO> agendaDTOs = new ArrayList<>();

      professorDTO.setCelular(professor.getCelular());
      professorDTO.setCpf(professor.getCpf());
      professorDTO.setEndereco(professor.getEndereco());
      professorDTO.setId(professor.getId());
      professorDTO.setNome(professor.getNome());
      professorDTO.setRg(professor.getRg());
      
      for (Curso curso : professor.getCursos()) {
        CursosDTO cursosDTO =  new CursosDTO();
  
        cursosDTO.setCargaHoraria(curso.getCargaHoraria());
        cursosDTO.setDescricao(curso.getDescricao());
        cursosDTO.setId(curso.getId());
        cursosDTO.setObjetivos(curso.getObjetivo());
        cursosDTO.setEmenta(curso.getEmenta());
        
        cursos.add(cursosDTO);
      }

      
      for (Agenda agenda : agendas) {
        AgendaDTO agendaDTO = new AgendaDTO();
        
        agendaDTO.setCep(agenda.getCep());
        agendaDTO.setCidade(agenda.getCidade());
        agendaDTO.setCurso_id(agenda.getId());
        agendaDTO.setDataFinal(agenda.getFim());
        agendaDTO.setDataInicio(agenda.getInicio());
        agendaDTO.setEstado(agenda.getEstado());
        agendaDTO.setId(agenda.getId());
        agendaDTO.setProfessores_id(professor.getId());
        agendaDTO.setTreinamento(agenda.getTreinamento());
  
        agendaDTOs.add(agendaDTO);
      }
  
      professorDTO.setAgenda(agendaDTOs);
      professorDTO.setCursos(cursos);
      professorDTOs.add(professorDTO);
    }

    return professorDTOs;
  }

  @Override
  @Transactional
  public void delete(Integer id) {
    Professor professor = this.professorRepository.findById(id).orElseThrow(() -> new ApiErrorApplication("Professor não localizado"));
    
    if (this.agendaRepository.existsByProfessoresId(professor.getId())) throw new ApiErrorApplication("O professor está associado com agendas e não pode ser excluido, remaneje as agendas"); 

    this.professorRepository.delete(professor);
  }

  @Override
  @Transactional
  public Professor update(DadosProfessoresDTO professor) {
    Professor professor2 = this.professorRepository.findById(professor.getId()).orElseThrow(() -> new ApiErrorApplication("Professor não localizado"));
    return this.store(professor);
  }

  @Override
  @Transactional
  public List<Agenda> getAgenda(Integer id) {
    return this.agendaRepository.findAgendaByIdProfessoresFetchProfessores(id);
  }
}
