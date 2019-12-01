/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetotarefa.infra;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import projetotarefa.model.Pessoa;

/**
 *
 * @author julio
 */
public class PessoaDAO {
    public void salvar(Pessoa pessoa) {

        //cria um gerenciador de entidades
        EntityManager em = ConnectionFactoryHibernate.getEntityManager();

        try {
            //abrir uma transacao
            em.getTransaction().begin();

            pessoa = em.merge(pessoa);
            em.persist(pessoa);
            //fechar a transacao
            em.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //encerra o gerenciador de entidades
            em.close();
        }
    }

    public List<Pessoa> recuperarTodos() {
        List<Pessoa> pessoas = new ArrayList<>();

        try {
            //cria um gerenciador de entidades
            EntityManager em = ConnectionFactoryHibernate.getEntityManager();

            //solicita ao gerenciador todas as instâncias da classe Funcionario
            Query query = em.createQuery("from Pessoa");
            pessoas = query.getResultList();
            
            //encerra o gerenciador de entidades
            em.close();
        } catch (Exception e) {
            e.getMessage();
        }
        return pessoas;
    }
}
