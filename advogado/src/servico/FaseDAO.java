/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servico;

import excecao.FaseNaoEncontradaException;
import java.util.ArrayList;
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
        Query query = session.createQuery("Select f From Fase f Where f.id = :id");
        query.setParameter("id", id);
        Fase fase = (Fase) query.uniqueResult();
        return fase;
    }

    public boolean pesquisarExistencia(String nome) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("Select f From Fase f Where f.nome like :nome");
        query.setParameter("nome", "%" + nome + "%");
        List<Fase> fases = query.list();
        for (Fase fase : fases) {
            if (fase.getNome().toLowerCase().contains(nome.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    public List<Fase> pesquisarPorNome(String nome) throws FaseNaoEncontradaException {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("Select f From Fase f Where f.nome like :nome");
        query.setParameter("nome", "%" + nome + "%");
        List<Fase> fases = query.list();
        List<Fase> fasesLista = new ArrayList<Fase>();
        for (Fase fase : fases) {
            if (fase.getNome().toLowerCase().contains(nome.toLowerCase())) {
                fasesLista.add(fase);
            }
        }
        if (fasesLista.isEmpty()) {
            throw new FaseNaoEncontradaException("Não foi possivel encontrar " + nome);
        }

        return fasesLista;
    }
}
