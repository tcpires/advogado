/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package facade;

import modelo.Cliente;
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
public class AdvogadoFacadeTest {

    public AdvogadoFacadeTest() {
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
     * Test of CriarCliente method, of class AdvogadoFacade.
     */
    @Test
    public void testCriarCliente() {
        System.out.println("CriarCliente");
        String nome = "Andre";
        String cidade = "Campina";
        AdvogadoFacade instance = new AdvogadoFacade();
        Cliente cliente = instance.CriarCliente(nome, cidade);
        assertEquals("Andre", cliente.getNome());
    }

    /**
     * Test of pesquisarPorNome method, of class AdvogadoFacade.
     */
    @Test
    public void testPesquisarPorNome() throws ClienteNaoEncontradoException{
        System.out.println("pesquisarPorNome");
        String nome = "Andre";
        AdvogadoFacade instance = new AdvogadoFacade();
        List <Cliente> result = instance.pesquisarPorNome(nome);
        Cliente cliente = result.get(0);
        assertEquals(nome, cliente.getNome());
    }

}