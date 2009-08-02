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

    public List<Juiz> getJuiz() {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("Select j From Juiz j");
        List<Juiz> juizLista = query.list();
        return juizLista;
    }
}
