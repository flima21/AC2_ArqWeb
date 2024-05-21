package com.example.ac2.interfaces;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.ac2.dtos.CursosDTO;
import com.example.ac2.dtos.DadosCursosDTO;
import com.example.ac2.dtos.DadosProfessoresDTO;
import com.example.ac2.exception.ApiErrorApplication;
import com.example.ac2.models.Curso;
import com.example.ac2.models.Professor;
import com.example.ac2.repository.AgendaRepository;
import com.example.ac2.repository.CursoRepository;
import com.example.ac2.repository.ProfessorRepository;
import com.example.ac2.services.CursoService;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CursoImpl implements CursoService {

  private CursoRepository cursoRepository;
  private AgendaRepository agendaRepository;
  private ProfessorRepository professorRepository;

  @Override
  @Transactional
  public Curso store(DadosCursosDTO curso) {
    Curso newCurso = new Curso();
    List<DadosProfessoresDTO> professoresDTOs = curso.getProfessores();
    List<Professor> professoresLista = new ArrayList<>();

    for (DadosProfessoresDTO dadosProfessoresDTO : professoresDTOs) {
      Professor professor = this.professorRepository.findById(dadosProfessoresDTO.getId()).orElseThrow(() -> new ApiErrorApplication("Professor " + dadosProfessoresDTO.getNome() + " não encontrado"));
      professoresLista.add(professor);
    }
    
    newCurso.setCargaHoraria(curso.getCargaHoraria());
    newCurso.setDescricao(curso.getDescricao());
    newCurso.setEmenta(curso.getEmenta());
    newCurso.setId(curso.getId());
    newCurso.setObjetivo(curso.getObjetivos());
    newCurso.setProfessores(professoresLista);

    return this.cursoRepository.save(newCurso);
  }

  @Override
  @Transactional
  public Curso update(DadosCursosDTO curso) {
    Curso newCurso = this.cursoRepository.findById(curso.getId()).orElseThrow(() -> new ApiErrorApplication("Curso não encontrado"));
    List<DadosProfessoresDTO> professoresDTOs = curso.getProfessores();
    List<Professor> professoresLista = new ArrayList<>();

    for (DadosProfessoresDTO dadosProfessoresDTO : professoresDTOs) {
      Professor professor = this.professorRepository.findById(dadosProfessoresDTO.getId()).orElseThrow(() -> new ApiErrorApplication("Professor " + dadosProfessoresDTO.getNome() + " não encontrado"));
      professoresLista.add(professor);
    }
    
    newCurso.setCargaHoraria(curso.getCargaHoraria());
    newCurso.setDescricao(curso.getDescricao());
    newCurso.setEmenta(curso.getEmenta());
    newCurso.setId(curso.getId());
    newCurso.setObjetivo(curso.getObjetivos());
    newCurso.setProfessores(professoresLista);

    return this.cursoRepository.save(newCurso);
  }

  @Override
  @Transactional
  public List<DadosCursosDTO> findAll() {
    List<Curso> cursos = this.cursoRepository.findAll();
    List<DadosCursosDTO> cursosDTOs = new ArrayList<DadosCursosDTO>();
    
    for (Curso curso : cursos) {
      DadosCursosDTO cursosDTO2 = new DadosCursosDTO();
      List<DadosProfessoresDTO> dadosProfessoresDTOs = new ArrayList<>();

      cursosDTO2.setCargaHoraria(curso.getCargaHoraria());
      cursosDTO2.setDescricao(curso.getDescricao());
      cursosDTO2.setEmenta(curso.getEmenta());
      cursosDTO2.setId(curso.getId());
      cursosDTO2.setObjetivos(curso.getObjetivo());
      
      for (Professor professor : curso.getProfessores()) {
        DadosProfessoresDTO dadosProfessoresDTO = new DadosProfessoresDTO();
  
        dadosProfessoresDTO.setCelular(professor.getCelular());
        dadosProfessoresDTO.setCpf(professor.getCpf());
        dadosProfessoresDTO.setEndereco(professor.getEndereco());
        dadosProfessoresDTO.setId(professor.getId());
        dadosProfessoresDTO.setNome(professor.getNome());
        dadosProfessoresDTO.setRg(professor.getRg());
        dadosProfessoresDTOs.add(dadosProfessoresDTO);
      }
  
      cursosDTO2.setProfessores(dadosProfessoresDTOs);
      cursosDTOs.add(cursosDTO2);
    }

    return cursosDTOs;
  }  
  @Override  
  @Transactional
  public DadosCursosDTO findById(Integer id){
    Curso curso = this.cursoRepository.findById(id).orElseThrow(() -> new ApiErrorApplication("Curso não encontrado"));
    DadosCursosDTO cursosDTO = new DadosCursosDTO();
    List<DadosProfessoresDTO> dadosProfessoresDTOs = new ArrayList<>();

    cursosDTO.setCargaHoraria(curso.getCargaHoraria());
    cursosDTO.setDescricao(curso.getDescricao());
    cursosDTO.setEmenta(curso.getEmenta());
    cursosDTO.setId(id);
    cursosDTO.setObjetivos(curso.getObjetivo());

    for (Professor professor : curso.getProfessores()) {
      DadosProfessoresDTO dadosProfessoresDTO = new DadosProfessoresDTO();

      dadosProfessoresDTO.setCelular(professor.getCelular());
      dadosProfessoresDTO.setCpf(professor.getCpf());
      dadosProfessoresDTO.setEndereco(professor.getEndereco());
      dadosProfessoresDTO.setId(professor.getId());
      dadosProfessoresDTO.setNome(professor.getNome());
      dadosProfessoresDTO.setRg(professor.getRg());
      dadosProfessoresDTOs.add(dadosProfessoresDTO);
    }

    cursosDTO.setProfessores(dadosProfessoresDTOs);

    return cursosDTO;
  }

  @Override
  @Transactional
  public void delete(Integer id) {
    Curso curso = this.cursoRepository.findById(id).orElseThrow(() -> new ApiErrorApplication("Curso não encontrado"));
    if (this.agendaRepository.existsByCursosId(id)) throw new ApiErrorApplication("O curso está associado a uma agenda, remaneje-o");

    List<Professor> professores = curso.getProfessores();

    for (Professor professor : professores) {
      curso.getProfessores().remove(professor);  
    }

    this.cursoRepository.delete(curso);
  }

  @Override
  @Transactional
  public List<Professor> findProfessorEspecializado(Integer id) {
    List<Professor> professoresDTOs = this.cursoRepository.findCursoByIdFetchProfessores(id);
    return professoresDTOs;
  }
}
