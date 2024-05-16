package com.example.ac2.models;

import java.time.LocalDateTime;
import java.util.Date;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Agenda {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    private LocalDateTime inicio;

    @Column(nullable = false)
    private LocalDateTime fim;

    @Column(nullable = false,length = 80)
    private String cidade;

    @Column(nullable = false,length = 80)
    private String estado;

    @Column(nullable = false,length = 80)
    private String cep;

    @Column(length = 80)
    private String treinamento;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso cursos;
    
    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professor professores;
}
