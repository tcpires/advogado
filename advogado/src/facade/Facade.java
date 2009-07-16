/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package facade;

import modelo.Cliente;
import excecao.ClienteNaoEncontradoException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author andrehadm
 */
public class Facade {

    AdvogadoFacade advogadoFacade;

    public Facade () {
        advogadoFacade = new AdvogadoFacade();
    }

    public void removeTodosClientes () {
        
    }

    public List <String> pesquisarPorNome (String nome) throws ClienteNaoEncontradoException {
        List <String> clientesString = new ArrayList<String>();
        List <Cliente> clientes = advogadoFacade.pesquisarPorNome(nome);

        System.out.println("Pesquisa por nome: "+ clientesString);
        for (Cliente cliente : clientes){
            clientesString.add(cliente.getNome());
        }
        return clientesString;
    }

    public Integer criarCliente (String nome, String cidade) {
        Integer saida = advogadoFacade.CriarCliente(nome, cidade).getId().intValue();
        System.out.println("Criar: " + saida);
        return saida;
    }
    
}
