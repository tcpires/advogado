/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servico;

import modelo.*;
import excecao.ClienteNaoEncontradoException;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;


/**
 *
 * @author andrehadm
 */
public class ClienteDAO {

      private Session session;

      public ClienteDAO(){
          //Construtor default
      }

      public void salvar(Cliente cliente){
             session = HibernateUtil.getSessionFactory().getCurrentSession();
             session.beginTransaction();
             session.save(cliente);
             session.getTransaction().commit();
      }

      public List <Cliente> pesquisarPorNome(String nome) throws ClienteNaoEncontradoException {
             session = HibernateUtil.getSessionFactory().getCurrentSession();
             session.beginTransaction();
             Query query = session.createQuery("Select c From Cliente c Where c.nome like :nome");
             query.setParameter("nome", "%"+nome+"%");
             List <Cliente> clientes = query.list();
             List <Cliente> clienteLista = new ArrayList<Cliente>();
             for (Cliente cliente : clientes) {
                if (cliente.getNome().toLowerCase().contains(nome.toLowerCase())) {
                    clienteLista.add(cliente);
                }
             }
             if (clienteLista.isEmpty()){
                 throw new ClienteNaoEncontradoException("Não foi possivel encontrar " + nome);
             }

             return clienteLista;
      }

      public String getClienteAtributo (int id, String atributo) {
             session = HibernateUtil.getSessionFactory().getCurrentSession();
             session.beginTransaction();
             Query query = session.createQuery("Select c From Cliente c Where c.id = :id");
             query.setParameter("id", id );
             Cliente cliente = (Cliente) query.uniqueResult();
             String resultado = "";

             //Melhorar depois o getAtributo
             if ( atributo.equals("nome")){
                resultado = cliente.getNome();
             }
             return resultado;
      }

}
