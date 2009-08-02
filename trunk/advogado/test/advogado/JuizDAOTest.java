/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package advogado;

import java.util.List;
import modelo.Juiz;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import servico.JuizDAO;

/**
 *
 * @author andrehadm
 */
public class JuizDAOTest {

    public JuizDAOTest() {
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
     * Test of salvar method, of class JuizDAO.
     */
    @Test
    public void testSalvar() {
        System.out.println("salvar");
        Juiz juiz = new Juiz();
        juiz.setNome("Antonio");
        JuizDAO instance = new JuizDAO();
        instance.salvar(juiz);

        Juiz juiz2 = new Juiz();
        juiz2.setNome("Sivanildo");
        instance.salvar(juiz2);
    }

    /**
     * Test of getJuiz method, of class JuizDAO.
     */
    @Test
    public void testGetJuiz() {
        System.out.println("getJuiz");
        JuizDAO instance = new JuizDAO();

        String juiz = "Antonio";
        String juiz2 = "Sivanildo";

        List<Juiz> result = instance.getJuiz();
        assertEquals(juiz, result.get(0).getNome());
        assertEquals(juiz2, result.get(1).getNome());
    }

}