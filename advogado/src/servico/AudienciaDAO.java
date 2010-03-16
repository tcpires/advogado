/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servico;

import java.util.List;
import modelo.Audiencia;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author andrehadm
 */
public class AudienciaDAO {

    private Session session;

    public AudienciaDAO() {
        //Construtor default
    }

    public void salvar(Audiencia audiencia) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(audiencia);
        session.getTransaction().commit();
    }

    public List<Audiencia> getTodasAudiencias() {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("Select a From Audiencia a");
        List<Audiencia> clienteLista = query.list();
        return clienteLista;
    }
}
