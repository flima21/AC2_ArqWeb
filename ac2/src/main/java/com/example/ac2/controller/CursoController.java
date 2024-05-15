package com.example.ac2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ac2.models.Curso;
import com.example.ac2.repository.CursoRepository;

import jakarta.transaction.Transactional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("curso")
public class CursoController {
  // @Autowired
  // private CursoRepository cursoRepository;

  // @GetMapping("")
  // public ResponseEntity<List<Curso>> listAllCourses(@RequestParam String param) {
  //   List<Curso> cursoList = cursoRepository.findAll();

  //   return ResponseEntity.ok(cursoList);

  // }

  // @GetMapping("/{id}")
  // public ResponseEntity<Curso> courserById(@PathVariable(name = "id") Integer param) {
  //   Curso curso = cursoRepository.getReferenceById(param);

  //   return ResponseEntity.ok(curso);
  // }

  // @PostMapping("")
  // @Transactional
  // public ResponseEntity<Curso> registerCourses(@RequestBody Curso param) {
  //     Curso curso = new Curso(param);
  //     cursoRepository.save(curso);      
  //     return ResponseEntity.ok(curso);
  // }
  
}
