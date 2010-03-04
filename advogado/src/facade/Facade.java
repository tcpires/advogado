/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import excecao.AtributoNaoEncontrado;
import excecao.CPFInvalidoException;
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

    public Facade() {
        advogadoFacade = new AdvogadoFacade();
    }

    public void removeTodosClientes() {
    }

    public List<String> pesquisarPorNome(String nome) throws ClienteNaoEncontradoException {
        List<String> clientesString = new ArrayList<String>();
        List<Cliente> clientes = advogadoFacade.pesquisarPorNome(nome);

        System.out.println("Pesquisa por nome: " + clientesString);
        for (Cliente cliente : clientes) {
            clientesString.add(cliente.getNome());
        }
        return clientesString;
    }

    public Integer criarCliente(String nome, String cpf, String rg, String endereco, String bairro, String cidade, String cep, String uf, String telefone, String celular, String email, String visita, String preposto) throws AtributoNaoEncontrado, CPFInvalidoException {
        Integer saida = advogadoFacade.criarCliente(nome, cpf, rg, endereco, bairro, cidade, cep, uf, telefone, celular, email, visita, preposto).getId().intValue();
        System.out.println("Cliente criado ID:" + saida);
        return saida;
    }

    public String getClienteAtributo(String id, String atributo) {
        Long idLong = new Long(id);
        return advogadoFacade.getClienteAtributo(idLong, atributo);
    }

    public Integer atualizarCliente(String id, String nome, String cpf, String rg, String endereco, String bairro, String cidade, String cep, String uf, String telefone, String celular, String email, String visita, String preposto) throws AtributoNaoEncontrado, CPFInvalidoException {
        System.out.println("");
        System.out.println("Atualizar cliente Facade");
        Cliente cliente = advogadoFacade.pesquisarClientePorId(Long.parseLong(id));
        System.out.println("Carreguei o cliente");
        String cpfverificado = "";
        if (cpf != null){
            cpfverificado = cpf;
        }
        String nomeverificado = "";
        if (nome != null){
            nomeverificado = nome;
        }
        cliente.setBairro(bairro);
        cliente.setCelular(celular);
        cliente.setCep(cep);
        cliente.setCidade(cidade);
        cliente.setCpf(cpfverificado);
        cliente.setEmail(email);
        cliente.setEndereco(endereco);
        cliente.setNome(nomeverificado);
        cliente.setPreposto(preposto);
        cliente.setRg(rg);
        cliente.setTelefone(telefone);
        cliente.setUf(uf);
        cliente.setVisita(visita);
        Integer saida = advogadoFacade.atualizarCliente(cliente).getId().intValue();
        System.out.println("Cliente atualizado ID: " + saida);
        return saida;
    }
}
