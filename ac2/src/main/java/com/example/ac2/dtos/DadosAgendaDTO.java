package com.example.ac2.dtos;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DadosAgendaDTO {
    private Integer id;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFinal;
    private String cidade;
    private String estado;
    private String cep;
    private String horarioInicio;
    private String horarioFim;
    private String treinamento;

    private ProfessoresDTO professores;
    private CursosDTO cursos;
}
