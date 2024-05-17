package com.example.ac2.models;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @Column(nullable = false)
    private String nome;
    
    @Column(nullable = false)
    private String cpf;
    
    @Column(nullable = false)
    private String rg;
    
    @Column(nullable = false)
    private String endereco;
    
    @Column(nullable = false)
    private String celular;

    @JsonIgnore
    @OneToMany(mappedBy = "professores")
    private List<Agenda> agenda = new ArrayList<>();;

    // Alterar para many to many
    @JsonIgnore
    @ManyToMany(mappedBy = "professores")
    private List<Curso> cursos = new ArrayList<>();

}
