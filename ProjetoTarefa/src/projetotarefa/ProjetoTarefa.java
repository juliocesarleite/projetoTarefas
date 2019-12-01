/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetotarefa;

import java.util.ArrayList;
import java.util.List;
import projetotarefa.infra.PessoaDAO;
import projetotarefa.infra.TarefaDAO;
import projetotarefa.model.Pessoa;
import projetotarefa.model.Tarefa;

/**
 *
 * @author julio
 */
public class ProjetoTarefa {

    public static void main(String[] args) {

        // Cadastra projetos
        Tarefa t1 = new Tarefa();
        t1.setDescricao("Fazer interface gráfica");

        Tarefa t2 = new Tarefa();
        t2.setDescricao("Fazer conexão com o banco");

        TarefaDAO tdao = new TarefaDAO();
        tdao.salvar(t1);
        tdao.salvar(t2);

        // Cria pessoa Maria
        Pessoa p1 = new Pessoa();
        p1.setCPF(12347362);
        p1.setNome("Maria");

        List<Tarefa> tarefasMaria = new ArrayList<>();
        tarefasMaria.add(t1);
        tarefasMaria.add(t2);
        p1.setTarefas(tarefasMaria);

        // cria funcionario Joao
        Pessoa p2 = new Pessoa();
        p2.setCPF(2345);
        p2.setNome("Joao");

        List<Tarefa> tarefasJoao = new ArrayList<>();
        tarefasJoao.add(t1);
        p2.setTarefas(tarefasJoao);
        
        // cria funcionario Felipe
        Pessoa p3 = new Pessoa();
        p3.setCPF(3456);
        p3.setNome("Felipe");

        List<Tarefa> tarefasFelipe = new ArrayList<>();
        tarefasFelipe.add(t2);
        p3.setTarefas(tarefasFelipe);

        // Cadastra funcionarios criados
        PessoaDAO pdao = new PessoaDAO();
        pdao.salvar(p1);
        pdao.salvar(p2);
        pdao.salvar(p3);

        // lista todos os projetos salvos no banco
        List<Tarefa> tarefas = new ArrayList<>();
        tarefas = tdao.recuperarTodos();
        for (Tarefa t : tarefas) {
            System.out.println("ID: " + t.getId());
            System.out.println("Descricao: " + t.getDescricao());
            System.out.println("Respons.:");
            for (Pessoa p : t.getResponsaveis()) {
                System.out.println("\tID: " + p.getCPF() +". Nome: " + p.getNome());
            }

        }

        // lista todos os funcionarios cadastrados
        List<Pessoa> pessoas = pdao.recuperarTodos();
        for (Pessoa p : pessoas) {
            System.out.println("CPF: " + p.getCPF());
            System.out.println("Nome: " + p.getNome());
            System.out.println("Tarefas:");
            for (Tarefa t : p.getTarefas()) {
                System.out.println("\tID: " + t.getId() +". Nome: " + t.getDescricao());
            }

        }
    }
    
}
