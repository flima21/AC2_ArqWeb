package com.example.ac2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.ac2.dtos.CursosDTO;
import com.example.ac2.dtos.DadosCursosDTO;
import com.example.ac2.models.Curso;
import com.example.ac2.services.CursoService;

import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/curso")
@AllArgsConstructor
public class CursoController {
  private CursoService cursoImpl;

  @GetMapping()
  @ResponseStatus(HttpStatus.OK)
  public List<CursosDTO> listAllCursos() {
    return this.cursoImpl.findAll();
  }

  @GetMapping("/curso-professor/id")
  @ResponseStatus(HttpStatus.OK)
  public CursosDTO courseById(@PathVariable Integer id) {
    return this.cursoImpl.findById(id);
  }

  @PostMapping()
  @ResponseStatus(HttpStatus.CREATED)
  public Curso registerCourse(@RequestBody DadosCursosDTO curso) {
    return this.cursoImpl.store(curso);
  }

  @PutMapping()
  @ResponseStatus(HttpStatus.OK)
  public Curso update(@RequestBody DadosCursosDTO curso) {
    return this.cursoImpl.update(curso);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public void delete(@PathVariable Integer id) {
    this.cursoImpl.delete(id);
  }
}
