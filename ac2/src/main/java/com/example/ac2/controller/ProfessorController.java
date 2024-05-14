package com.example.ac2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ac2.models.Professor;
import com.example.ac2.repository.ProfessorRepository;

import jakarta.transaction.Transactional;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("professor")
public class ProfessorController {
  @Autowired
  private ProfessorRepository professorRepository;

  @GetMapping("")
  public ResponseEntity<List<Professor>> listAllProfessors(@RequestParam String param) {
    List<Professor> professorList = professorRepository.findAll();

    return ResponseEntity.ok(professorList);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Professor> professorById(@PathVariable(name= "id") Integer param) {
    Professor professor = professorRepository.getReferenceById(param);
      return ResponseEntity.ok(professor);
  }
  
  @PostMapping("")
  @Transactional
  public ResponseEntity<Professor> registerProfessor(@RequestBody Professor param) {
      Professor professor = new Professor(param);
      professorRepository.save(professor);
      return ResponseEntity.ok(professor);
  }
  

}
