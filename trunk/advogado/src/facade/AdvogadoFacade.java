/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package facade;

import excecao.AtributoNaoEncontrado;
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

    public Cliente CriarCliente(String nome, String cpf, String rg, String endereco, String bairro, String cidade, String cep, String uf, String telefone, String celular, String email, String posicao, String visita) throws AtributoNaoEncontrado{
        verificaAtributos(nome, cpf);
        Cliente cliente = new Cliente();
        cliente.setNome(nome);
        cliente.setCpf(cpf);
        cliente.setRg(rg);
        cliente.setEndereco(endereco);
        cliente.setBairro(bairro);
        cliente.setCidade(cidade);
        cliente.setCep(cep);
        cliente.setUf(uf);
        cliente.setTelefone(telefone);
        cliente.setCelular(celular);
        cliente.setEmail(email);
        cliente.setPosicao(posicao);
        cliente.setVisita(visita);
        cliente_DAO.salvar(cliente);
        return cliente;
    }

    private boolean verificaAtributos(String nome, String cpf) throws AtributoNaoEncontrado {
	String menssagem = "Atributo requerido: ";
        System.out.println("Passei no verifica atributos.");
	boolean erro = false;
	if (nome == null || nome.equals("")) {
            erro = true;
            menssagem += "Nome";
	}
	if (cpf == null || cpf.equals("")) {
            if (erro == true)
		menssagem += ", ";
            erro = true;
            menssagem += "CPF";
	}
	if (erro == true)
            throw new AtributoNaoEncontrado(menssagem);
        return false;
    }

    private boolean verificaUnicoCPF(String cpf) {
        return false;
    }

    public List <Cliente> pesquisarPorNome(String nome) throws ClienteNaoEncontradoException {
        return cliente_DAO.pesquisarPorNome(nome);
    }

    public String getClienteAtributo(Long id, String atributo) {
        return cliente_DAO.getClienteAtributo(id, atributo);
    }

}
