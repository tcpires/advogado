/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package advogado;

import java.util.List;
import modelo.Vara;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import servico.VaraDAO;

/**
 *
 * @author andrehadm
 */
public class VaraDAOTest {

    public VaraDAOTest() {
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
     * Test of salvar method, of class VaraDAO.
     */
    @Test
    public void testSalvar() {
        System.out.println("salvar");
        Vara vara = new Vara();
        vara.setNome("Pequenas Causas");
        VaraDAO instance = new VaraDAO();
        instance.salvar(vara);

        Vara vara2 = new Vara();
        vara2.setNome("Família");
        instance.salvar(vara2);
    }

    /**
     * Test of getComarca method, of class VaraDAO.
     */
    @Test
    public void testGetVara() {
        System.out.println("getVara");
        VaraDAO instance = new VaraDAO();

        String vara = "Pequenas Causas";
        String vara2 = "Família";

        List<Vara> result = instance.getTodasVaras();
        assertEquals(vara, result.get(0).getNome());
        assertEquals(vara2, result.get(1).getNome());
    }
}
