/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package facade;

import excecao.AtributoNaoEncontrado;
import excecao.CPFInvalidoException;
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
    public void testCriarCliente() throws AtributoNaoEncontrado, CPFInvalidoException {
        System.out.println("CriarCliente");
        String nome = "Andre";
        String cpf = "12345678901";
        String rg="1234567"; 
        String endereco="Rua Sem Saida";
        String bairro = "centro";
        String cidade="João Pessoa";
        String cep="58000000";
        String uf="PB";
        String telefone="3333-3333";
        String celular="8888-8888";
        String email="andre@email";
        String posicao="";
        String visita="";


        AdvogadoFacade instance = new AdvogadoFacade();
        Cliente cliente = instance.criarCliente(nome, cpf, rg, endereco, bairro, cidade, cep, uf, telefone, celular, email, posicao, visita);
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

        /**
     * Test of getAtributo method, of class ClienteDAO.
     */
    @Test
    public void testGetAtributo() throws Exception {
        System.out.println("getAtributo - Nome");
        String valorEsperado = "Andre";
        String atributo = "nome";
        AdvogadoFacade instance = new AdvogadoFacade();
        Long indice = new Long(1);
        assertEquals(valorEsperado, instance.getClienteAtributo(indice, atributo));

        System.out.println("getAtributo - Cidade");
        valorEsperado = "João Pessoa";
        atributo = "cidade";
        assertEquals(valorEsperado, instance.getClienteAtributo(indice, atributo));
    }

}