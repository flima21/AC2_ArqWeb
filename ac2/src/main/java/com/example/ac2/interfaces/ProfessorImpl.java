package com.example.ac2.interfaces;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.ac2.DTO.ProfessorDTO;
import com.example.ac2.exception.ApiErrorApplication;
import com.example.ac2.models.Professor;
import com.example.ac2.repository.ProfessorRepository;
import com.example.ac2.services.ProfessorService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ProfessorImpl implements ProfessorService {
  private ProfessorRepository professorRepository;

  @Override
  public Professor store(ProfessorDTO professor) {
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
  public ProfessorDTO findById(Integer id) {
    Professor professor = this.professorRepository.findById(id).orElseThrow(() -> new ApiErrorApplication("Professor não encontrado"));
    ProfessorDTO professorDTO = new ProfessorDTO();

    professorDTO.setCelular(professor.getCelular());
    professorDTO.setCpf(professor.getCpf());
    professorDTO.setCursos(professorDTO.getCursos());
    professorDTO.setEndereco(professorDTO.getEndereco());
    professorDTO.setId(professorDTO.getId());
    professorDTO.setNome(professorDTO.getNome());
    professorDTO.setRg(professor.getRg());

    return professorDTO;
  }

  @Override
  public List<ProfessorDTO> findAll() {
    List<Professor> professors = this.professorRepository.findAll();
    List<ProfessorDTO> professorDTOs = new ArrayList<ProfessorDTO>();

    for (Professor professor : professors) {
      ProfessorDTO professorDTO = new ProfessorDTO();

      professorDTO.setCelular(professor.getCelular());
      professorDTO.setCpf(professor.getCpf());
      professorDTO.setCursos(professorDTO.getCursos());
      professorDTO.setEndereco(professorDTO.getEndereco());
      professorDTO.setId(professorDTO.getId());
      professorDTO.setNome(professorDTO.getNome());
      professorDTO.setRg(professor.getRg());
      
      professorDTOs.add(professorDTO);
    }

    return professorDTOs;
  }

  public void delete(Integer id) {
    Professor professor = this.professorRepository.findById(id).orElseThrow(() -> new ApiErrorApplication("Professor não localizado"));
    this.professorRepository.delete(professor);
  }
}
