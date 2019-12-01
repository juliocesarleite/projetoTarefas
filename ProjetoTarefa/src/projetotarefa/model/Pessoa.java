/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetotarefa.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 *
 * @author julio
 */

@Entity
public class Pessoa implements Serializable{
    
    @Id
    private int CPF;
    private String nome;
    
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "TAREFA_PESSOA",
            joinColumns = {@JoinColumn(name = "TAREFA_ID")},
            inverseJoinColumns = {@JoinColumn(name = "CPF")})
    private List<Tarefa> tarefas;
    

    public Pessoa() {
    }

    
       
    public int getCPF() {
        return CPF;
    }

    public void setCPF(int CPF) {
        this.CPF = CPF;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Tarefa> getTarefas() {
        return tarefas;
    }

    public void setTarefas(List<Tarefa> tarefas) {
        this.tarefas = tarefas;
    }

    @Override
    public String toString() {
        return "Funcionario{" + "CPF=" + CPF + ", nome=" + nome + ", tarefas=" + tarefas + '}';
    }
}
