package com.example.ac2.interfaces;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.ac2.dtos.CursosDTO;
import com.example.ac2.dtos.DadosCursosDTO;
import com.example.ac2.dtos.ProfessoresDTO;
import com.example.ac2.models.Curso;
import com.example.ac2.models.Professor;
import com.example.ac2.repository.CursoRepository;
import com.example.ac2.services.CursoService;

@Service
public class CursoImpl implements CursoService {

  private CursoRepository cursoRepository;

  @Override
  public Curso store(CursosDTO curso) {
    Curso newCurso = new Curso();

    newCurso.setCargaHoraria(curso.getCargaHoraria());
    newCurso.setDescricao(curso.getDescricao());
    newCurso.setEmenta(curso.getEmenta());
    newCurso.setId(curso.getId());
    newCurso.setObjetivo(curso.getObjetivos());

    return this.cursoRepository.save(newCurso);
  }

  @Override
  public List<DadosCursosDTO> findAll() {
    List<Curso> cursos = this.cursoRepository.findAll();
    List<DadosCursosDTO> cursosDTOs = new ArrayList<DadosCursosDTO>();

    for (Curso curso : cursos) {
      DadosCursosDTO cursosDTO2 = new DadosCursosDTO();

      cursosDTO2.setCargaHoraria(curso.getCargaHoraria());
      cursosDTO2.setDescricao(curso.getDescricao());
      cursosDTO2.setEmenta(curso.getEmenta());
      cursosDTO2.setId(curso.getId());
      cursosDTO2.setObjetivos(curso.getObjetivo());
      // cursosDTO2.setProfessores(curso.getProfessores());

      cursosDTOs.add(cursosDTO2);
    }

    return cursosDTOs;
  }  

}
