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
import modelo.Acao;
import modelo.Comarca;
import modelo.Fase;
import modelo.Juiz;
import modelo.Processo;
import modelo.Vara;
import servico.AcaoDAO;
import servico.ComarcaDAO;
import servico.FaseDAO;
import servico.JuizDAO;
import servico.ProcessoDAO;
import servico.VaraDAO;

/**
 *
 * @author andrehadm
 */
public class AdvogadoFacade {

    private ClienteDAO cliente_DAO;
    private VaraDAO varaDAO;
    private ComarcaDAO comarcaDAO;
    private JuizDAO juizDAO;
    private AcaoDAO acaoDAO;
    private FaseDAO faseDAO;
    private ProcessoDAO processoDAO;
    
    public AdvogadoFacade (){
        cliente_DAO = new ClienteDAO();
        varaDAO = new VaraDAO();
        comarcaDAO = new ComarcaDAO();
        juizDAO = new JuizDAO();
        acaoDAO = new AcaoDAO();
        faseDAO = new FaseDAO();
        processoDAO = new ProcessoDAO();
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

    public Processo CriarProcesso(String nome, Long comarcaId, Long varaId, Long acaoId, Long faseId, Long clienteId, Long juizId, String status, String posicao, String parteOposta, String advogadoOposto, Double valorDaCausa, Double honorarios, String observacoes, String estrategia) {
        Processo processo = new Processo();
        processo.setNome(nome);
        processo.setIdComarca(comarcaId);
        processo.setIdVara(varaId);
        processo.setIdTipoDaAcao(acaoId);
        processo.setIdFase(faseId);
        processo.setIdCliente(clienteId);
        processo.setIdJuiz(juizId);
        processo.setStatus(status);
        processo.setPosicao(posicao);
        processo.setParteOposta(parteOposta);
        processo.setAdvogadoOposto(advogadoOposto);
        processo.setValorDaCausa(valorDaCausa);
        processo.setHonorarios(honorarios);
        processo.setObservacoes(observacoes);
        processo.setEstrategia(estrategia);
        processoDAO.salvar(processo);
        return processo;
    }

    public Vara CriarVara(String nome) {
        Vara vara = new Vara();
        vara.setNome(nome);
        varaDAO.salvar(vara);
        return vara;
    }

    public Comarca CriarComarca(String nome) {
        Comarca comarca = new Comarca();
        comarca.setNome(nome);
        comarcaDAO.salvar(comarca);
        return comarca;
    }

    public Juiz CriarJuiz(String nome) {
        Juiz juiz = new Juiz();
        juiz.setNome(nome);
        juizDAO.salvar(juiz);
        return juiz;
    }

    public Acao CriarAcao(String nome) {
        Acao acao = new Acao();
        acao.setNome(nome);
        acaoDAO.salvar(acao);
        return acao;
    }

    public Fase CriarFase(String nome) {
        Fase fase = new Fase();
        fase.setNome(nome);
        faseDAO.salvar(fase);
        return fase;
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

    public List<Cliente> getTodosClientes () {
        return cliente_DAO.getTodosClientes();
    }

    public List<Vara> getTodasVaras () {
        return varaDAO.getTodasVaras();
    }

    public List<Comarca> getTodasComarcas () {
        return comarcaDAO.getTodasComarcas();
    }

    public List<Juiz> getTodosJuizes () {
        return juizDAO.getTodosJuizes();
    }

    public List<Acao> getTodasAcoes() {
        return acaoDAO.getTodasAcoes();
    }

    public List<Fase> getTodasFases() {
        return faseDAO.getTodasFases();
    }
    
}
