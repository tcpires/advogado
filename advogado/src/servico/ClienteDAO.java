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

    public ClienteDAO() {
        //Construtor default
    }

    public void salvar(Cliente cliente) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(cliente);
        session.getTransaction().commit();
    }

    public List<Cliente> pesquisarPorNome(String nome) throws ClienteNaoEncontradoException {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("Select c From Cliente c Where c.nome like :nome");
        query.setParameter("nome", "%" + nome + "%");
        List<Cliente> clientes = query.list();
        List<Cliente> clienteLista = new ArrayList<Cliente>();
        for (Cliente cliente : clientes) {
            if (cliente.getNome().toLowerCase().contains(nome.toLowerCase())) {
                clienteLista.add(cliente);
            }
        }
        if (clienteLista.isEmpty()) {
            throw new ClienteNaoEncontradoException("Não foi possivel encontrar " + nome);
        }

        return clienteLista;
    }

    public Cliente pesquisarPorId(Long id) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("Select c From Cliente c Where c.id: id");
        query.setParameter("id", id);
        Cliente cliente = (Cliente) query.uniqueResult();
        return cliente;
    }

    public String getClienteAtributo(Long id, String atributo) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("Select c From Cliente c Where c.id = :id");
        query.setParameter("id", id);
        Cliente cliente = (Cliente) query.uniqueResult();
        String resultado = "";

        //Melhorar depois o getAtributo
        if (atributo.equals("nome")) {
            resultado = cliente.getNome();
        } else if (atributo.equals("cidade")) {
            resultado = cliente.getCidade();
        } else if (atributo.equals("bairro")) {
            resultado = cliente.getBairro();
        } else if (atributo.equals("celular")) {
            resultado = cliente.getCelular();
        } else if (atributo.equals("cep")) {
            resultado = cliente.getCep();
        } else if (atributo.equals("cpf")) {
            resultado = cliente.getCpf();
        } else if (atributo.equals("email")) {
            resultado = cliente.getEmail();
        } else if (atributo.equals("endereco")) {
            resultado = cliente.getEndereco();
        } else if (atributo.equals("preposto")) {
            resultado = cliente.getPreposto();
        } else if (atributo.equals("rg")) {
            resultado = cliente.getRg();
        } else if (atributo.equals("telefone")) {
            resultado = cliente.getTelefone();
        } else if (atributo.equals("uf")) {
            resultado = cliente.getUf();
        } else if (atributo.equals("visita")) {
            resultado = cliente.getVisita();
        } else if (atributo.equals("id")) {
            resultado = cliente.getId().toString();
        }

        return resultado;
    }
}
