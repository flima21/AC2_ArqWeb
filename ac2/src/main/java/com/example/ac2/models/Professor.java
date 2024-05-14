package com.example.ac2.models;

import java.util.List;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Professor {
    private Long id;
    private String nome;
    private String cpf;
    private String rg;
    private String endereco;
    private String celular;
    private List<Agenda> agenda;

    public Professor obterPorId(int id){
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

    @OneToOne
    private Agenda agenda2;

    @JoinColumn
    @OneToMany
    private List<Curso> curso;

    public Professor(Professor param){
        this.nome = param.getNome();
        this.cpf = param.getCpf();
        this.rg = param.getRg();
        this.endereco = param.getEndereco();
        this.celular = param.getCelular();
    }
}
