/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servico;

import java.util.List;
import modelo.Fase;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author andrehadm
 */
public class FaseDAO {

    private Session session;

    public FaseDAO() {
        //Construtor default
    }

    public void salvar(Fase fase) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(fase);
        session.getTransaction().commit();
    }

    public List<Fase> getTodasFases() {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("Select f From Fase f order by nome");
        List<Fase> faseLista = query.list();
        return faseLista;
    }

    public Fase pesquisarPorId(Long id) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("Select f From Fase f Where f.id: id");
        query.setParameter("id", id);
        Fase fase = (Fase) query.uniqueResult();
        return fase;
    }

}
