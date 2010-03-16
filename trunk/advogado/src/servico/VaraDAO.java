/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servico;

import excecao.VaraNaoEncontradaException;
import java.util.ArrayList;
import java.util.List;
import modelo.Vara;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author andrehadm
 */
public class VaraDAO {

    private Session session;

    public VaraDAO() {
        //Construtor default
    }

    public void salvar(Vara vara) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(vara);
        session.getTransaction().commit();
    }

    public List<Vara> getTodasVaras() {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("Select v From Vara v order by nome");
        List<Vara> varaLista = query.list();
        return varaLista;
    }

    public Vara pesquisarPorId(Long id) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("Select v From Vara v Where v.id = :id");
        query.setParameter("id", id);
        Vara vara = (Vara) query.uniqueResult();
        return vara;
    }

    public boolean pesquisarExistencia(String nome) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("Select v From Vara v Where v.nome like :nome");
        query.setParameter("nome", "%" + nome + "%");
        List<Vara> varas = query.list();
        for (Vara vara : varas) {
            if (vara.getNome().toLowerCase().contains(nome.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    public List<Vara> pesquisarPorNome(String nome) throws VaraNaoEncontradaException {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("Select v From Vara v Where v.nome like :nome");
        query.setParameter("nome", "%" + nome + "%");
        List<Vara> varas = query.list();
        List<Vara> varasLista = new ArrayList<Vara>();
        for (Vara vara : varas) {
            if (vara.getNome().toLowerCase().contains(nome.toLowerCase())) {
                varasLista.add(vara);
            }
        }
        if (varasLista.isEmpty()) {
            throw new VaraNaoEncontradaException("Não foi possivel encontrar " + nome);
        }

        return varasLista;
    }
}
