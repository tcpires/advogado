/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package advogado;

import org.hibernate.dialect.Sybase11Dialect;

/**
 *
 * @author andrehadm
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Cliente c1 = new Cliente();
        c1.setNome("Raul");
        c1.setCidade("Campina");
        Cliente c2 = new Cliente();
        c2.setNome("Bruce");
        c2.setCidade("Natal");
        ClienteDAO clienteDAO = new ClienteDAO();

        System.out.println("Id:" + c1.getId());
        System.out.println("Nome:" + c1.getNome());
        System.out.println("Nome:" + c1.getCidade());

        clienteDAO.salvar(c1);
        //clienteDAO.salvar(c2);

        System.out.println("FIMMMM !!!");

    }

}
