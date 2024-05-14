package com.example.ac2.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Curso {
    @Id
    private long id;
    private String descricao;
    private String cargaHoraria;
    private String objetivo;
    private String ementa;

    public Curso getCursoId(long idCurso){
        return new Curso();
    }

    public List<Curso> getTodos(){
        List<Curso> cursos = null;
        return cursos;
    }

    public Curso salvar(Curso curso){
        return curso;
    }

    public Curso editar(Curso curso){
        return curso;
    }
}
