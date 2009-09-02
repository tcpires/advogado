/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servico;

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
        Query query = session.createQuery("Select v From Vara v Where v.id: id");
        query.setParameter("id", id);
        Vara vara = (Vara) query.uniqueResult();
        return vara;
    }

}
