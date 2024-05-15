package com.example.ac2.dtos;

import java.time.LocalDate;
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
    private LocalDate dataInicio;
    private LocalDate dataFinal;
    private String cidade;
    private String estado;
    private String cep;
    private String horarioInicio;
    private String horarioFim;
    private String treinamento;

    private ProfessoresDTO professores;
    private CursosDTO cursos;
}
