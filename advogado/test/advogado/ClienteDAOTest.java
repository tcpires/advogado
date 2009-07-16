/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package advogado;

import modelo.Cliente;
import modelo.ClienteDAO;
import excecao.ClienteNaoEncontradoException;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author andrehadm
 */
public class ClienteDAOTest {

    public ClienteDAOTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of salvar method, of class ClienteDAO.
     */
    @Test
    public void testSalvar() {
        System.out.println("salvar");
        Cliente cliente = new Cliente();
        cliente.setNome("Andre");
        cliente.setCidade("Campina");
        ClienteDAO instance = new ClienteDAO();
        instance.salvar(cliente);


        Cliente cliente2 = new Cliente();
        cliente2.setNome("Lindolfo");
        cliente2.setCidade("Natal");
        instance.salvar(cliente2);

    }

    /**
     * Test of pesquisarPorNome method, of class ClienteDAO.
     */
    @Test
    public void testPesquisarPorNome() throws Exception {
        System.out.println("Pesquisar por nome - Um único resultado");
        String nome = "Andre";
        ClienteDAO instance = new ClienteDAO();
        List <Cliente> result = instance.pesquisarPorNome(nome);
        Cliente cliente = result.get(0);
        assertEquals(nome, cliente.getNome());
    }

    /**
     * Test of pesquisarPorNome method, of class ClienteDAO.
     */
    @Test
    public void testPesquisarPorNome1() throws ClienteNaoEncontradoException {
        System.out.println("Pesquisar por nome - Nenhum resultado");
        String nome = "Lindolfo";
        ClienteDAO instance = new ClienteDAO();
        //List <Cliente> result = instance.pesquisarPorNome(nome);
        //Cliente cliente = result.get(0);
    }

    /**
     * Test of pesquisarPorNome method, of class ClienteDAO.
     */
    @Test
    public void testPesquisarPorNome2() throws Exception {
        System.out.println("Pesquisar por nome - Vários resultados");
        ClienteDAO instance = new ClienteDAO();

        //Criando um novo cliente que contém parte do nome de outro cliente
        Cliente cliente = new Cliente();
        cliente.setNome("Andre Henrique");
        cliente.setCidade("João Pessoa");
        instance.salvar(cliente);

        String nome1 = "Andre";
        String nome2 = "Andre Henrique";

        List <Cliente> result = instance.pesquisarPorNome(nome1);
        Cliente clienteResultado1 = result.get(0);
        Cliente clienteResultado2 = result.get(1);
        assertEquals(nome1, clienteResultado1.getNome());
        assertEquals(nome2, clienteResultado2.getNome());
    }

}