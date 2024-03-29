/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ProcessoRelatorioGUI.java
 *
 * Created on 06/03/2010, 15:38:07
 */

package gui;

import facade.AdvogadoFacade;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import modelo.Processo;

/**
 *
 * @author andrehadm
 */
public class ProcessoRelatorioGUI extends javax.swing.JPanel {

    AdvogadoFacade advogadoFacade;

    /** Creates new form ProcessoRelatorioGUI */
    public ProcessoRelatorioGUI(AdvogadoFacade advogadoFacade) {
        this.advogadoFacade = advogadoFacade;
        initComponents();
        carregaProcessos();
    }

    public void carregaProcessos() {
        System.out.println("");
        System.out.println("Carregando processos");
        List <Processo> processo = advogadoFacade.getTodosProcessos();

        Object[][] processoTable = new Object[processo.size()][4]; // Define uma matriz bidimensional para armazenar os valores
        Object[] titulo = new Object[3]; // Define uma matriz unidimensional para armazenar os titulos


        jTable1.removeAll();
        int processoContador = 0;
        for (Processo processoFor : advogadoFacade.getTodosProcessos()) {
            processoTable[processoContador][0] = processoFor.getId().toString();
            processoTable[processoContador][1] = advogadoFacade.pesquisarClientePorId(processoFor.getIdCliente()).getNome();
            processoTable[processoContador][2] = processoFor.getNome();
            processoContador++;
            System.out.println("Processo: "+ processoFor.getId() + " - " + processoFor.getNome());
        }
        System.out.println("Processos carregados.");

        // titulos
        titulo[0] = "Id";
        titulo[1] = "Cliente";
        titulo[2] = "Processo"; // criando objeto modelo

        DefaultTableModel modelo = new DefaultTableModel(processoTable, titulo);

        // definindo o modelo da tabela
        jTable1.setModel(modelo);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

}
