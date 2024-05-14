package com.example.ac2.models;

import java.util.List;

import jakarta.persistence.Entity;
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
public class Curso {
    @Id
    private Long id;
    private String descricao;
    private String cargaHoraria;
    private String objetivo;
    private String ementa;

    public Curso getCursoId(int idCurso){
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

    @OneToOne
    private Agenda agenda;

    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;

    public Curso(Curso param){
        this.descricao = param.getDescricao();
        this.cargaHoraria = param.getCargaHoraria();
        this.objetivo = param.getObjetivo();
        this.ementa = param.getEmenta();
    }
}
