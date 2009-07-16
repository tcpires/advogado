/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package facade;

import advogado.Cliente;
import advogado.ClienteDAO;

/**
 *
 * @author andrehadm
 */
public class AdvogadoFacade {

    private ClienteDAO cliente_DAO;

    public AdvogadoFacade (){
        //Construtor Default
    }

    public Cliente CriarCliente(String nome, String cidade){
        Cliente cliente = new Cliente();
        cliente.setNome(nome);
        cliente.setCidade(cidade);
        cliente_DAO = new ClienteDAO();
        cliente_DAO.salvar(cliente);
        return cliente;
    }

    public Cliente pesquisarPorNome(String nome) {
        return null;
    }


}
