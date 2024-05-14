package com.example.ac2.models;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Agenda {
    private int id;
    private Date inicio;
    private Date fim;
    private String cidade;
    private String estado;
    private String cep;
    private String treinamento;

    public Professor getProfessor(int idProfessor){
        return new Professor();
    }

    public Professor associarProfessor(Professor professor){
        return professor;
    }

    public List<Professor> obterTodosProfessores(){
        List<Professor> professores = null;
        return professores;
    }

    public Agenda obterPorId(int id){
        return new Agenda();
    }

    public Agenda salvar(Agenda agenda){
        return agenda;
    }

    public Agenda editar(Agenda agenda){
        return agenda;
    }

    public Agenda setTreinamento(int idAgenda, String treinamento){
        return new Agenda();
    }

    @OneToOne(mappedBy = "agenda2")
    private Professor professor;

    @OneToOne(mappedBy = "agenda")
    private Curso curso;

    public Agenda(Agenda param){
        this.inicio = param.getInicio();
        this.fim = param.getFim();
        this.cidade = param.getCidade();
        this.estado = param.getEstado();
        this.cep = param.getCep();
        this.treinamento = param.getTreinamento();
        this.professor = param.getProfessor();
        this.curso = param.getCurso();
    }
}
