/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servico;

import excecao.AcaoNaoEncontradaException;
import java.util.ArrayList;
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
        Query query = session.createQuery("Select a From Acao a Where a.id = :id");
        query.setParameter("id", id);
        Acao acao = (Acao) query.uniqueResult();
        return acao;
    }

    public boolean pesquisarExistencia(String nome) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("Select a From Acao a Where a.nome like :nome");
        query.setParameter("nome", "%" + nome + "%");
        List<Acao> acoes = query.list();
        for (Acao acao : acoes) {
            if (acao.getNome().toLowerCase().contains(nome.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    public List<Acao> pesquisarPorNome(String nome) throws AcaoNaoEncontradaException {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("Select a From Acao a Where a.nome like :nome");
        query.setParameter("nome", "%" + nome + "%");
        List<Acao> acoes = query.list();
        List<Acao> acoesLista = new ArrayList<Acao>();
        for (Acao acao : acoes) {
            if (acao.getNome().toLowerCase().contains(nome.toLowerCase())) {
                acoesLista.add(acao);
            }
        }
        if (acoesLista.isEmpty()) {
            throw new AcaoNaoEncontradaException("Não foi possivel encontrar " + nome);
        }
        return acoesLista;
    }
}
