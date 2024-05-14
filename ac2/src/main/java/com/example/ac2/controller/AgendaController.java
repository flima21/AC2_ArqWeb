package com.example.ac2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ac2.models.Agenda;
import com.example.ac2.repository.AgendaRepository;

import jakarta.transaction.Transactional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("agenda")
public class AgendaController {
  @Autowired
  private AgendaRepository agendaRepository;

  @GetMapping("")
  public ResponseEntity<List<Agenda>> listAllAgenda(@RequestParam String param) {
    List<Agenda> agendaList = agendaRepository.findAll();
    return ResponseEntity.ok(agendaList);
  }
  

  @GetMapping("/{id}")
  public ResponseEntity<Agenda> agendaById(@PathVariable(name="id") Integer param) {
    Agenda agenda = agendaRepository.getReferenceById(param);
    return ResponseEntity.ok(agenda);
  }
  
  @PostMapping("")
  @Transactional
  public ResponseEntity<Agenda> registerAgenda(@RequestBody Agenda param) {
    Agenda agenda = new Agenda(param);
    agendaRepository.save(agenda);
    return ResponseEntity.ok(agenda);
  }
  

}
