package com.example.ac2.models;

import java.sql.Date;
import java.util.List;

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

}
