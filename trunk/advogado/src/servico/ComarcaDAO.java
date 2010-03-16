/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servico;

import java.util.ArrayList;
import java.util.List;
import excecao.ComarcaNaoEncontradaException;
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

    public List<Comarca> getTodasComarcas() {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("Select c From Comarca c order by nome");
        List<Comarca> comarcaLista = query.list();
        return comarcaLista;
    }

    public Comarca pesquisarPorId(Long id) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("Select c From Comarca c Where c.id = :id");
        query.setParameter("id", id);
        Comarca comarca = (Comarca) query.uniqueResult();
        return comarca;
    }

    public boolean pesquisarExistencia(String nome) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("Select c From Comarca c Where c.nome like :nome");
        query.setParameter("nome", "%" + nome + "%");
        List<Comarca> comarcas = query.list();
        for (Comarca comarca : comarcas) {
            if (comarca.getNome().toLowerCase().contains(nome.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    public List<Comarca> pesquisarPorNome(String nome) throws ComarcaNaoEncontradaException {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("Select c From Comarca c Where c.nome like :nome");
        query.setParameter("nome", "%" + nome + "%");
        List<Comarca> comarcas = query.list();
        List<Comarca> comarcasLista = new ArrayList<Comarca>();
        for (Comarca comarca : comarcas) {
            if (comarca.getNome().toLowerCase().contains(nome.toLowerCase())) {
                comarcasLista.add(comarca);
            }
        }
        if (comarcasLista.isEmpty()) {
            throw new ComarcaNaoEncontradaException("Não foi possivel encontrar " + nome);
        }

        return comarcasLista;
    }
}
