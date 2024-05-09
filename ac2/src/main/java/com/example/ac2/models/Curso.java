package com.example.ac2.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Curso {
    @Id
    private int id;
    private String descricao;
    private String cargaHoraria;
    private String objetivo;
    private String ementa;

    public Curso(int id, String descricao, String cargaHoraria, String objetivo, String ementa) {
        this.id = id;
        this.descricao = descricao;
        this.cargaHoraria = cargaHoraria;
        this.objetivo = objetivo;
        this.ementa = ementa;
    }

    public Curso() {
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public String getCargaHoraria() {
        return cargaHoraria;
    }
    public void setCargaHoraria(String cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }
    public String getObjetivo() {
        return objetivo;
    }
    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }
    public String getEmenta() {
        return ementa;
    }
    public void setEmenta(String ementa) {
        this.ementa = ementa;
    }

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

    @Override
    public String toString() {
        return "Curso [cargaHoraria=" + cargaHoraria + ", descricao=" + descricao + ", ementa=" + ementa + ", id=" + id
                + ", objetivo=" + objetivo + "]";
    }
}
