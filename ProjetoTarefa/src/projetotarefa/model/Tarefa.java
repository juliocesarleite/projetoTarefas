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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 *
 * @author julio
 */
@Entity
public class Tarefa implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TAREFA_ID")
    private Long id;
    
    private String descricao;
    
    @ManyToMany(mappedBy = "tarefas", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Pessoa> responsaveis;
    
    public Tarefa() {
    }

    
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public List<Pessoa> getResponsaveis() {
        return responsaveis;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setResponsaveis(List<Pessoa> responsaveis) {
        this.responsaveis = responsaveis;
    }

    @Override
    public String toString() {
        return "Tarefa{" + "id=" + id + ", descricao=" + descricao + ", responsaveis=" + responsaveis + '}';
    }
   
}
