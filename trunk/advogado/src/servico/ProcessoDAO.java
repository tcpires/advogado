/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servico;

import modelo.Processo;
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

    

}
