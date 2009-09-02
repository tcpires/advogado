/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servico;

import java.util.List;
import modelo.Comarca;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author andrehadm
 */
public class ComarcaDAO {

    private Session session;

    public ComarcaDAO() {
        //Construtor default
    }

    public void salvar(Comarca comarca) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(comarca);
        session.getTransaction().commit();
    }

    public List<Comarca> getTodasComarcas()  {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("Select c From Comarca c order by nome");
        List<Comarca> comarcaLista = query.list();
        return comarcaLista;
    }

    public Comarca pesquisarPorId(Long id) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("Select c From Comarca c Where c.id: id");
        query.setParameter("id", id);
        Comarca comarca = (Comarca) query.uniqueResult();
        return comarca;
    }

}
