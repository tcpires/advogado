/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package facade;

import excecao.AtributoNaoEncontrado;
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


    public Integer criarCliente (String nome, String cpf, String rg, String endereco, String bairro, String cidade, String cep, String uf, String telefone, String celular, String email, String posicao, String visita) throws AtributoNaoEncontrado {
        Integer saida = advogadoFacade.CriarCliente(nome, cpf, rg, endereco, bairro, cidade, cep, uf, telefone, celular, email, posicao, visita).getId().intValue();
        System.out.println("Criar: " + saida);
        return saida; 
    }

    public String getClienteAtributo (String id, String atributo) {
        Long idLong = new Long(id);
        return advogadoFacade.getClienteAtributo(idLong, atributo);
    }

}
