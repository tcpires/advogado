/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servico;

import excecao.JuizNaoEncontradoException;
import java.util.ArrayList;
import java.util.List;
import modelo.Juiz;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author andrehadm
 */
public class JuizDAO {

    private Session session;

    public JuizDAO() {
        //Construtor default
    }

    public void salvar(Juiz juiz) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(juiz);
        session.getTransaction().commit();
    }

    public List<Juiz> getTodosJuizes() {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("Select j From Juiz j order by nome");
        List<Juiz> juizLista = query.list();
        return juizLista;
    }

    public Juiz pesquisarPorId(Long id) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("Select j From Juiz j Where j.id = :id");
        query.setParameter("id", id);
        Juiz juiz = (Juiz) query.uniqueResult();
        return juiz;
    }

    public boolean pesquisarExistencia(String nome) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("Select j From Juiz j Where j.nome like :nome");
        query.setParameter("nome", "%" + nome + "%");
        List<Juiz> juizes = query.list();
        for (Juiz juiz : juizes) {
            if (juiz.getNome().toLowerCase().contains(nome.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    public List<Juiz> pesquisarPorNome(String nome) throws JuizNaoEncontradoException {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("Select j From Juiz j Where j.nome like :nome");
        query.setParameter("nome", "%" + nome + "%");
        List<Juiz> juizes = query.list();
        List<Juiz> juizesLista = new ArrayList<Juiz>();
        for (Juiz juiz : juizes) {
            if (juiz.getNome().toLowerCase().contains(nome.toLowerCase())) {
                juizesLista.add(juiz);
            }
        }
        if (juizesLista.isEmpty()) {
            throw new JuizNaoEncontradoException("Não foi possivel encontrar " + nome);
        }

        return juizesLista;
    }
}
