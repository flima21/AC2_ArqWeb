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

import com.example.ac2.dtos.DadosProfessoresDTO;
import com.example.ac2.dtos.ProfessoresDTO;
import com.example.ac2.interfaces.ProfessorImpl;
import com.example.ac2.models.Professor;
import com.example.ac2.services.ProfessorService;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/professor")
@AllArgsConstructor
public class ProfessorController {
  private ProfessorService professorImpl;

  @GetMapping()
  @ResponseStatus(HttpStatus.OK)
  public List<ProfessoresDTO> listAllProfessores() {
    return this.professorImpl.findAll();
  }

  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public ProfessoresDTO professorById(@PathVariable Integer id) {
    return this.professorImpl.findById(id);
  }

  @PostMapping()
  @ResponseStatus(HttpStatus.CREATED)
  public Professor registerProfessor(@RequestBody DadosProfessoresDTO professor) {
    return this.professorImpl.store(professor);
  }

  @PutMapping()
  @ResponseStatus(HttpStatus.OK)
  public Professor update(@RequestBody DadosProfessoresDTO professor) {
    return this.professorImpl.update(professor);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public void delete(@PathVariable Integer id) {
    this.professorImpl.delete(id);
  }
}
