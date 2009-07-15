/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package advogado;

import org.hibernate.Session;


/**
 *
 * @author andrehadm
 */
public class ClienteDAO {

      private Session session;

      public ClienteDAO(){
      }

      public void salvar(Cliente cliente){
             session = HibernateUtil.getSessionFactory().getCurrentSession();
             session.beginTransaction();
             session.save(cliente);
             session.getTransaction().commit();
      }

}
