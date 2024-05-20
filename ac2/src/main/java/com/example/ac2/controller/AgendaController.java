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

import com.example.ac2.dtos.AgendaDTO;
import com.example.ac2.dtos.DadosAgendaDTO;
import com.example.ac2.models.Agenda;
import com.example.ac2.services.AgendaService;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/agenda")
@AllArgsConstructor
public class AgendaController {
  private AgendaService agendaImpl;

  @PostMapping()
  @ResponseStatus(HttpStatus.CREATED)
  public Agenda registerAgenda(@RequestBody AgendaDTO agenda) {
    return this.agendaImpl.store(agenda);
  }

  @DeleteMapping("{id}")
  @ResponseStatus(HttpStatus.GONE)
  public void delete(@PathVariable Integer id) {
    this.agendaImpl.delete(id);
  }
}
