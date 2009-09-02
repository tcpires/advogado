/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package advogado;

import java.util.List;
import modelo.Comarca;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import servico.ComarcaDAO;

/**
 *
 * @author andrehadm
 */
public class ComarcaDAOTest {

    public ComarcaDAOTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        testSalvar();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of salvar method, of class ComarcaDAO.
     */
    private void testSalvar() {
        System.out.println("salvar");
        Comarca comarca = new Comarca();
        comarca.setNome("Campina Grande");
        ComarcaDAO instance = new ComarcaDAO();
        instance.salvar(comarca);

        Comarca comarca2 = new Comarca();
        comarca2.setNome("João Pessoa");
        instance.salvar(comarca2);
    }

    /**
     * Test of getComarca method, of class ComarcaDAO.
     */
    @Test
    public void testGetComarca() {
        System.out.println("getComarca");
        ComarcaDAO instance = new ComarcaDAO();

        String comarca = "Campina Grande";
        String comarca2 = "João Pessoa";

        List<Comarca> result = instance.getTodasComarcas();
        assertEquals(comarca, result.get(0).getNome());
        assertEquals(comarca2, result.get(1).getNome());
    }

}