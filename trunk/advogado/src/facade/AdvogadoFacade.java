/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;
 
import excecao.AcaoJaExisteException;
import excecao.AtributoNaoEncontrado;
import excecao.CPFInvalidoException;
import modelo.Cliente;
import servico.ClienteDAO;
import excecao.ClienteNaoEncontradoException;
import excecao.ComarcaJaExisteException;
import excecao.FaseJaExisteException;
import excecao.JuizJaExisteException;
import excecao.ProcessoInvalidoException;
import excecao.VaraJaExisteException;
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

    private ClienteDAO clienteDAO;
    private VaraDAO varaDAO;
    private ComarcaDAO comarcaDAO;
    private JuizDAO juizDAO;
    private AcaoDAO acaoDAO;
    private FaseDAO faseDAO;
    private ProcessoDAO processoDAO;

    public AdvogadoFacade() {
        clienteDAO = new ClienteDAO();
        varaDAO = new VaraDAO();
        comarcaDAO = new ComarcaDAO();
        juizDAO = new JuizDAO();
        acaoDAO = new AcaoDAO();
        faseDAO = new FaseDAO();
        processoDAO = new ProcessoDAO();
    }

    public Cliente criarCliente(String nome, String cpf, String rg, String endereco, String bairro, String cidade, String cep, String uf, String telefone, String celular, String email, String visita, String preposto) throws AtributoNaoEncontrado, CPFInvalidoException {
        verificaAtributos(nome, cpf);
        verificaCPFValido(cpf);
        verificaUnicoCPF(cpf);
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
        cliente.setVisita(visita);
        cliente.setPreposto(preposto);
        clienteDAO.salvar(cliente);
        return cliente;
    }

    public Cliente atualizarCliente(Cliente cliente) throws AtributoNaoEncontrado, CPFInvalidoException {
        verificaAtributos(cliente.getNome(), cliente.getCpf());
        verificaCPFValido(cliente.getCpf());
        verificaUnicoCPF(cliente);
        clienteDAO.atualizar(cliente);
        return cliente;
    }

    public Processo atualizarProcesso(Processo processo) throws AtributoNaoEncontrado, ProcessoInvalidoException {
        verificaAtributosProcesso(processo.getNome(), processo.getIdCliente());
        verificaUnicoProcesso(processo);
        processoDAO.atualizar(processo);
        return processo;
    }


    public Processo criarProcesso(String nome, Long comarcaId, Long varaId, Long acaoId, Long faseId, Long clienteId, Long juizId, String status, String posicao, String parteOposta, String advogadoOposto, String valorDaCausa, String honorarios, String observacoes, String estrategia) throws AtributoNaoEncontrado, ProcessoInvalidoException {
        verificaAtributosProcesso(nome, clienteId);
        verificaUnicoProcesso(nome);
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

    public Vara criarVara(String nome) throws VaraJaExisteException {
        Vara vara = new Vara();
        vara.setNome(nome);
        if (varaJaExiste(vara)) {
            throw new VaraJaExisteException("A vara " + nome + " já existe.");
        }
        varaDAO.salvar(vara);
        return vara;
    }

    private boolean varaJaExiste(Vara vara) {
        return varaDAO.pesquisarExistencia(vara.getNome());
    }

    public Comarca criarComarca(String nome) throws ComarcaJaExisteException {
        Comarca comarca = new Comarca();
        comarca.setNome(nome);
        if (comarcaJaExiste(comarca)) {
            throw new ComarcaJaExisteException("A comarca " + nome + " já existe.");
        }
        comarcaDAO.salvar(comarca);
        return comarca;

    }

    private boolean comarcaJaExiste(Comarca comarca) {
        return comarcaDAO.pesquisarExistencia(comarca.getNome());
    }

    public Juiz criarJuiz(String nome) throws JuizJaExisteException {
        Juiz juiz = new Juiz();
        juiz.setNome(nome);
        if (juizJaExiste(juiz)) {
            throw new JuizJaExisteException("O juiz " + nome + " já existe.");
        }
        juizDAO.salvar(juiz);
        return juiz;
    }

    private boolean juizJaExiste(Juiz juiz) {
        return juizDAO.pesquisarExistencia(juiz.getNome());
    }

    public Acao criarAcao(String nome) throws AcaoJaExisteException {
        Acao acao = new Acao();
        acao.setNome(nome);
        if (acaoJaExiste(acao)) {
            throw new AcaoJaExisteException("A ação " + nome + " já existe.");
        }
        acaoDAO.salvar(acao);
        return acao;
    }

    private boolean acaoJaExiste(Acao acao) {
        return acaoDAO.pesquisarExistencia(acao.getNome());
    }

    public Fase criarFase(String nome) throws FaseJaExisteException {
        Fase fase = new Fase();
        fase.setNome(nome);
        if (faseJaExiste(fase)) {
            throw new FaseJaExisteException("A fase " + nome + " já existe.");
        }
        faseDAO.salvar(fase);
        return fase;
    }

    private boolean faseJaExiste(Fase fase) {
        return faseDAO.pesquisarExistencia(fase.getNome());
    }

    private boolean verificaAtributos(String nome, String cpf) throws AtributoNaoEncontrado {
        System.out.println("");
        System.out.println("Verificando atributos: Nome e CPF.");
        String menssagem = "Atributo requerido: ";
        boolean erro = false;
        if (nome == null || nome.equals("")) {
            erro = true;
            menssagem += "Nome";
        }
        if (cpf == null || cpf.equals("")) {
            if (erro == true) {
                menssagem += ", ";
            }
            erro = true;
            menssagem += "CPF";
        }
        if (erro == true) {
            throw new AtributoNaoEncontrado(menssagem + ".");
        }
        return false;
    }

    private void verificaCPFValido(String cpf) throws CPFInvalidoException {
        System.out.println("");
        System.out.println("Verificando CPF válido");
        String A, B, C, D, E, F, G, H, I, J, K = "";
        int a, b, c, d, x, f, g, h, i, j, k, s1, s2;

        A = cpf.substring(0, 1);
        B = cpf.substring(1, 2);
        C = cpf.substring(2, 3);
        D = cpf.substring(4, 5);
        E = cpf.substring(5, 6);
        F = cpf.substring(6, 7);
        G = cpf.substring(8, 9);
        H = cpf.substring(9, 10);
        I = cpf.substring(10, 11);
        J = cpf.substring(12, 13);
        K = cpf.substring(13);

        a = Integer.parseInt(A);
        b = Integer.parseInt(B);
        c = Integer.parseInt(C);
        d = Integer.parseInt(D);
        x = Integer.parseInt(E);
        f = Integer.parseInt(F);
        g = Integer.parseInt(G);
        h = Integer.parseInt(H);
        i = Integer.parseInt(I);

        /*
         * OBTENDO O DÍGITO J
         *
         * O resultado da soma, s1 = 10a+9b+8c+7d+6x+5f+4g+3h+2i, é dividido por 11 e o RESTO
         * dessa divisão:
         *
         * RESTO                                 j
         * Se for 0 ou 1                         O dígito j é [0] (zero)
         * Se for 2, 3, 4, 5, 6, 7, 8, 9 ou 10     O dígito j é [11 - RESTO]
         *
         */

        s1 = ((10 * a) + (9 * b) + (8 * c) + (7 * d) + (6 * x) + (5 * f) + (4 * g) + (3 * h) + (2 * i)) % 11;

        if ((s1 == 0) || (s1 == 1)) {
            j = 0;
        } else {
            j = (11 - s1);
        }


        /*
         * OBTENDO O DÍGITO k
         *
         * O resultado da soma, S2 = 11a+10b+9c+8d+7x+6f+5g+4h+3i+2j, é dividido por 11 e o RESTO
         * dessa divisão:
         *
         * RESTO                                 k
         * Se for 0 ou 1                         O dígito k é [0] (zero)
         * Se for 2, 3, 4, 5, 6, 7, 8, 9 ou 10     O dígito k é [11 - RESTO]
         *
         */

        s2 = ((11 * a) + (10 * b) + (9 * c) + (8 * d) + (7 * x) + (6 * f) + (5 * g) + (4 * h) + (3 * i) + (2 * j)) % 11;

        if ((s2 == 0) || (s2 == 1)) {
            k = 0;
        } else {
            k = (11 - s2);
        }

        // compara os resultados j com o J e k com o K e verifica se todos os dígitos não são iguais
        if ((j != (Integer.parseInt(J))) || (k != (Integer.parseInt(K))) || ((a == b) & (b == c) & (c == d) & (d == x) & (x == f) & (f == g) & (g == h) & (h == i))) {
            throw new CPFInvalidoException("CPF " + cpf + " inválido.");
        }

    }

    private void verificaUnicoCPF(String cpf) throws CPFInvalidoException {
        System.out.println("");
        System.out.println("Verificando CPF único");
        List<Cliente> clienteLista = clienteDAO.getTodosClientes();
        for (Cliente cliente : clienteLista) {
            if (cliente.getCpf().toLowerCase().contains(cpf.toLowerCase())) {
                throw new CPFInvalidoException("Um cliente com o CPF " + cpf + " já está cadastrado.");
            }
        }
    }

    private boolean verificaUnicoCPF(Cliente cliente) throws CPFInvalidoException {
        System.out.println("");
        System.out.println("Verificando CPF único");
        List<Cliente> clienteLista = clienteDAO.getTodosClientes();
        for (Cliente clienteFor : clienteLista) {
            if (clienteFor.getCpf().toLowerCase().contains(cliente.getCpf().toLowerCase()) && !clienteFor.getId().equals(cliente.getId())) {
                throw new CPFInvalidoException("Um cliente com o CPF " + cliente.getCpf() + " já está cadastrado.");
            }
        }
        return true;
    }

    private void verificaUnicoProcesso(String processo) throws ProcessoInvalidoException {
        List<Processo> processoLista = processoDAO.getTodosProcessos();
        for (Processo processoFor : processoLista) {
            if (processoFor.getNome().toLowerCase().contains(processo.toLowerCase())) {
                throw new ProcessoInvalidoException("Um processo com o nome " + processo + " já está cadastrado.");
            }
        }
    }

    private void verificaUnicoProcesso(Processo processo) throws ProcessoInvalidoException {
        List<Processo> processoLista = processoDAO.getTodosProcessos();
        for (Processo processoFor : processoLista) {
            if (processoFor.getNome().toLowerCase().contains(processo.getNome().toLowerCase()) && !processoFor.getId().equals(processo.getId())) {
                throw new ProcessoInvalidoException("Um processo com o nome " + processo + " já está cadastrado.");
            }
        }
    }

    private boolean verificaAtributosProcesso(String nome, Long cliente) throws AtributoNaoEncontrado {
        System.out.println("");
        System.out.println("Verificando atributos: Nome");
        String menssagem = "Atributo requerido: ";
        boolean erro = false;
        if (nome == null || nome.equals("")) {
            erro = true;
            menssagem += "Nome";
        }
        if (cliente == null) {
            System.out.println("Eita pesteeeeeeeeeeeeeeeeee");
            if (erro == true) {
                menssagem += ", ";
            }
            erro = true;
            menssagem += "Cliente";
        }
        if (erro == true) {
            throw new AtributoNaoEncontrado(menssagem + ".");
        }
        return false;
    }

    public List<Cliente> pesquisarPorNome(String nome) throws ClienteNaoEncontradoException {
        return clienteDAO.pesquisarPorNome(nome);
    }

    public Comarca pesquisarComarcaPorId(Long id) {
        return comarcaDAO.pesquisarPorId(id);
    }

    public Acao pesquisarAcaoPorId(Long id) {
        return acaoDAO.pesquisarPorId(id);
    }

    public Fase pesquisarFasePorId(Long id) {
        return faseDAO.pesquisarPorId(id);
    }

    public Juiz pesquisarJuizPorId(Long id) {
        return juizDAO.pesquisarPorId(id);
    }

    public Vara pesquisarVaraPorId(Long id) {
        return varaDAO.pesquisarPorId(id);
    }

    public Cliente pesquisarClientePorId(Long id) {
        return clienteDAO.pesquisarPorId(id);
    }

    public Processo pesquisarProcessoPorId(Long id) {
        return processoDAO.pesquisarPorId(id);
    }

    public String getClienteAtributo(Long id, String atributo) {
        return clienteDAO.getClienteAtributo(id, atributo);
    }

    public String getProcessoAtributo(Long id, String atributo) {
        Processo processo = processoDAO.pesquisarPorId(id);
        String resultado = "";

        if (atributo.equals("nome")) {
            resultado = processo.getNome();
        } else if (atributo.equals("comarca")) {
            resultado = comarcaDAO.pesquisarPorId(processo.getIdComarca()).getNome();
        } else if (atributo.equals("vara")) {
            resultado = varaDAO.pesquisarPorId(processo.getIdVara()).getNome();
        } else if (atributo.equals("acao")) {
            resultado = acaoDAO.pesquisarPorId(processo.getIdTipoDaAcao()).getNome();
        } else if (atributo.equals("fase")) {
            resultado = faseDAO.pesquisarPorId(processo.getIdFase()).getNome();
        } else if (atributo.equals("cliente")) {
            resultado = clienteDAO.pesquisarPorId(processo.getIdCliente()).getNome();
        } else if (atributo.equals("status")) {
            resultado = processo.getStatus();
        } else if (atributo.equals("posicao")) {
            resultado = processo.getPosicao();
        } else if (atributo.equals("parteoposta")) {
            resultado = processo.getParteOposta();
        } else if (atributo.equals("advogadooposto")) {
            resultado = processo.getAdvogadoOposto();
        } else if (atributo.equals("estrategia")) {
            resultado = processo.getEstrategia();
        } else if (atributo.equals("honorarios")) {
            resultado = processo.getHonorarios();
        } else if (atributo.equals("observacoes")) {
            resultado = processo.getObservacoes();
        } else if (atributo.equals("valordacausa")) {
            resultado = processo.getValorDaCausa();
        } else if (atributo.equals("id")) {
            resultado = processo.getId().toString();
        }
        return resultado;
    }

    public List<Cliente> getTodosClientes() {
        return clienteDAO.getTodosClientes();
    }

    public List<Vara> getTodasVaras() {
        return varaDAO.getTodasVaras();
    }

    public List<Comarca> getTodasComarcas() {
        return comarcaDAO.getTodasComarcas();
    }

    public List<Juiz> getTodosJuizes() {
        return juizDAO.getTodosJuizes();
    }

    public List<Acao> getTodasAcoes() {
        return acaoDAO.getTodasAcoes();
    }

    public List<Fase> getTodasFases() {
        return faseDAO.getTodasFases();
    }

    public List<Processo> getTodosProcessos() {
        return processoDAO.getTodosProcessos();
    }
}
