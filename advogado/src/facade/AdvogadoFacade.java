/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package facade;

import modelo.Cliente;
import servico.ClienteDAO;
import excecao.ClienteNaoEncontradoException;
import java.util.List;

/**
 *
 * @author andrehadm
 */
public class AdvogadoFacade {

    private ClienteDAO cliente_DAO;

    public AdvogadoFacade (){
        cliente_DAO = new ClienteDAO();
    }

    public Cliente CriarCliente(String nome, String cidade){
        Cliente cliente = new Cliente();
        cliente.setNome(nome);
        cliente.setCidade(cidade);
        cliente_DAO.salvar(cliente);
        return cliente;
    }

    public List <Cliente> pesquisarPorNome(String nome) throws ClienteNaoEncontradoException {
        return cliente_DAO.pesquisarPorNome(nome);
    }


}
