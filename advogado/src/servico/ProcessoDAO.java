/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servico;

import java.util.List;
import modelo.Processo;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author andrehadm
 */
public class ProcessoDAO {

    private Session session;

    public ProcessoDAO() {
        //Construtor default
    }

    public void salvar(Processo processo) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(processo);
        session.getTransaction().commit();
    }

    public void atualizar(Processo processo) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.update(processo);
        session.getTransaction().commit();
    }

    public List<Processo> getTodosProcessos() {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("Select p From Processo p order by nome");
        List<Processo> processoLista = query.list();
        return processoLista;
    }

    public Processo pesquisarPorId(Long id) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("Select p From Processo p Where p.id = :id");
        query.setParameter("id", id);
        Processo processo = (Processo) query.uniqueResult();
        return processo;
    }

    public List<Processo> pesquisarPorCliente(Long idCliente) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("Select p From Processo p Where p.idCliente = :idCliente");
        query.setParameter("idCliente", idCliente);
        List<Processo> processoLista = query.list();
        return processoLista;
    }

    public List<Processo> pesquisarPorComarca(Long idComarca) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("Select p From Processo p Where p.idComarca = :idComarca");
        query.setParameter("idComarca", idComarca);
        List<Processo> processoLista = query.list();
        return processoLista;
    }

    public List<Processo> pesquisarPorVara(Long idVara) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("Select p From Processo p Where p.idVara = :idVara");
        query.setParameter("idVara", idVara);
        List<Processo> processoLista = query.list();
        return processoLista;
    }

    public List<Processo> pesquisarPorJuiz(Long idJuiz) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("Select p From Processo p Where p.idJuiz = :idJuiz");
        query.setParameter("idJuiz", idJuiz);
        List<Processo> processoLista = query.list();
        return processoLista;
    }

    public List<Processo> pesquisarPorTipoDaAcao(Long idTipoDaAcao) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("Select p From Processo p Where p.idTipoDaAcao = :idTipoDaAcao");
        query.setParameter("idTipoDaAcao", idTipoDaAcao);
        List<Processo> processoLista = query.list();
        return processoLista;
    }

    public List<Processo> pesquisarPorFase(Long idFase) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("Select p From Processo p Where p.idFase = :idFase");
        query.setParameter("idFase", idFase);
        List<Processo> processoLista = query.list();
        return processoLista;
    }
}
