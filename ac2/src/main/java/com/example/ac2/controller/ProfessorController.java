package com.example.ac2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ac2.dtos.ProfessoresDTO;
import com.example.ac2.interfaces.ProfessorImpl;
import com.example.ac2.models.Professor;

import jakarta.transaction.Transactional;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/professor")
public class ProfessorController {
  @Autowired
  private ProfessorImpl professorImpl;

  @GetMapping()
  public List<ProfessoresDTO> listAllProfessores() {
    return this.professorImpl.findAll();
  }

  @GetMapping("/{id}")
  public ProfessoresDTO professorById(@PathVariable Integer id) {
    {
      return this.professorImpl.findById(id);
    }
  }

  @PostMapping()
  @Transactional
  public Professor registerProfessor(@RequestBody ProfessoresDTO professor) {
    return this.professorImpl.store(professor);
  }
}
