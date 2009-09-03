/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servico;

import java.util.List;
import modelo.Acao;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author andrehadm
 */
public class AcaoDAO {

    private Session session;

    public AcaoDAO() {
        //Construtor default
    }

    public void salvar(Acao acao) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(acao);
        session.getTransaction().commit();
    }

    public List<Acao> getTodasAcoes() {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("Select a From Acao a order by nome");
        List<Acao> acaoLista = query.list();
        return acaoLista;
    }

    public Acao pesquisarPorId(Long id) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("Select a From Acao a Where a.id: id");
        query.setParameter("id", id);
        Acao acao = (Acao) query.uniqueResult();
        return acao;
    }

}
