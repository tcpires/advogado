/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package teste;

import easyaccept.EasyAcceptFacade;
import facade.Facade;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author andrehadm
 */
public class TesteCliente {

    public static void main(String[] args) throws Exception {

        List<String> files = new ArrayList<String>();

        //Put the testScript1 file into the "test scripts" list

        files.add("src/teste/us-cliente.txt");

        //Put the testScript2 file into the "test scripts" list

        //files.add("testScript2.txt");

        //Instantiate your software façade

        Facade yourTestFacade = new Facade();

        //Instantiate EasyAccept façade

        EasyAcceptFacade eaFacade = new EasyAcceptFacade(yourTestFacade, files);

        //Execute the tests

        eaFacade.executeTests();

        //Print the tests execution results

        System.out.println(eaFacade.getCompleteResults());

    }


}
