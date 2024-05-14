package com.example.ac2.models;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Professor {
    private long id;
    private String nome;
    private String cpf;
    private String rg;
    private String endereco;
    private String celular;
    private List<Agenda> agenda;

    public Professor obterPorId(long id){
        return new Professor();
    }

    public List<Professor> obterTodos(){
        List<Professor> professores = null;
        return professores;
    }

    public Professor salvar(Professor professor){
        return professor;
    }
    public Professor editar(Professor professor){
        return professor;
    }

}
