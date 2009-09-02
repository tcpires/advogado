/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servico;

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
        Query query = session.createQuery("Select j From Juiz j Where j.id: id");
        query.setParameter("id", id);
        Juiz juiz = (Juiz) query.uniqueResult();
        return juiz;
    }

}
