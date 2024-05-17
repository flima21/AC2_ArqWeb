package com.example.ac2.models;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private double cargaHoraria;

    @Column(nullable = false)
    private String objetivo;

    @Column(nullable = false)
    private String ementa;

    @JsonIgnore
    @OneToMany(mappedBy = "cursos")
    private List<Agenda> agenda;
    
    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "cursos_professores", joinColumns = {@JoinColumn(name = "professores_id")},inverseJoinColumns = {@JoinColumn(name = "cursos_id")})
    private List<Professor> professores = new ArrayList<>();

}
