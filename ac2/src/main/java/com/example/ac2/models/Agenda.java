package com.example.ac2.models;

import java.sql.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Agenda {
    private long id;
    private Date inicio;
    private Date fim;
    private String cidade;
    private String estado;
    private String cep;
    private String treinamento;

    public Professor getProfessor(long idProfessor){
        return new Professor();
    }

    public Professor associarProfessor(Professor professor){
        return professor;
    }

    public List<Professor> obterTodosProfessores(){
        List<Professor> professores = null;
        return professores;
    }

    public Agenda obterPorId(long id){
        return new Agenda();
    }

    public Agenda salvar(Agenda agenda){
        return agenda;
    }

    public Agenda editar(Agenda agenda){
        return agenda;
    }

    public Agenda setTreinamento(long idAgenda, String treinamento){
        return new Agenda();
    }

}
