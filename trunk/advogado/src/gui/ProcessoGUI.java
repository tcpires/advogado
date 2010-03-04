/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ProcessoGUI.java
 *
 * Created on 09/08/2009, 21:38:29
 */

package gui;

import excecao.AtributoNaoEncontrado;
import excecao.ProcessoInvalidoException;
import facade.AdvogadoFacade;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import modelo.Acao;
import modelo.Cliente;
import modelo.Comarca;
import modelo.Fase;
import modelo.Juiz;
import modelo.Vara;

/**
 *
 * @author andrehadm
 */
public class ProcessoGUI extends javax.swing.JPanel {

    private AdvogadoFacade advogadoFacade;
    private JPanel areaDeTrabalho;
    private JToolBar barraDeFerramentas;

    /** Creates new form ClienteGUI */
    public ProcessoGUI(JPanel areaDeTrabalho, JToolBar barra, AdvogadoFacade advogadoFacade) {
        this.advogadoFacade = advogadoFacade;
        this.areaDeTrabalho = areaDeTrabalho;
        this.barraDeFerramentas = barra;
        initComponents();
        carregaComarca();
        carregaVara();
        carregaCliente();
        carregaJuiz();
        carregaFase();
        carregaAcao();
        this.setVisible(true);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel_Processo = new javax.swing.JLabel();
        jTextField_Processo = new javax.swing.JTextField();
        jLabel_Comarca = new javax.swing.JLabel();
        jComboBox_Comarca = new javax.swing.JComboBox();
        jLabel_Vara = new javax.swing.JLabel();
        jCombo_BoxVara = new javax.swing.JComboBox();
        jLabel_TipoDaAcao = new javax.swing.JLabel();
        jComboBox_TipoDaAcao = new javax.swing.JComboBox();
        jButton_NovoTipoDaAcao = new javax.swing.JButton();
        jLabel_Fase = new javax.swing.JLabel();
        jComboBox_Fase = new javax.swing.JComboBox();
        jButton_NovaFase = new javax.swing.JButton();
        jLabel_Cliente = new javax.swing.JLabel();
        jComboBox_Cliente = new javax.swing.JComboBox();
        jLabel_Status = new javax.swing.JLabel();
        jComboBox_Status1 = new javax.swing.JComboBox();
        jComboBox_Status2 = new javax.swing.JComboBox();
        jLabel_ParteOposta = new javax.swing.JLabel();
        jTextField_ParteOposta = new javax.swing.JTextField();
        jLabel_AdvogadoOposto = new javax.swing.JLabel();
        jTextField_AdvogadoOposto = new javax.swing.JTextField();
        jLabel_Juiz = new javax.swing.JLabel();
        jComboBox_Juiz = new javax.swing.JComboBox();
        jButton_NovoJuiz = new javax.swing.JButton();
        jLabel_ValorDaCausa = new javax.swing.JLabel();
        jLabel_Honorarios = new javax.swing.JLabel();
        jLabel_Observacoes = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea_Observacoes = new javax.swing.JTextArea();
        jLabel_Estrategia = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea_Estrategia = new javax.swing.JTextArea();
        jButton_Salvar = new javax.swing.JButton();
        jButton_Limpar = new javax.swing.JButton();
        jButton_Sair = new javax.swing.JButton();
        jButton_NovaComarca = new javax.swing.JButton();
        jButton_NovaVara = new javax.swing.JButton();
        jFormattedTextField_Honorários = new javax.swing.JFormattedTextField();
        jFormattedTextField_ValorDaCausa = new javax.swing.JFormattedTextField();

        setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Novo Processo", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));
        setPreferredSize(new java.awt.Dimension(543, 381));

        jLabel_Processo.setText("Processo");

        jLabel_Comarca.setText("Comarca");

        jLabel_Vara.setText("Vara");

        jLabel_TipoDaAcao.setText("Tipo da Ação");

        jButton_NovoTipoDaAcao.setText("Novo");
        jButton_NovoTipoDaAcao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_NovoTipoDaAcaoMouseClicked(evt);
            }
        });

        jLabel_Fase.setText("Fase");

        jButton_NovaFase.setText("Novo");
        jButton_NovaFase.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_NovaFaseMouseClicked(evt);
            }
        });

        jLabel_Cliente.setText("Cliente");

        jLabel_Status.setText("Status");

        jComboBox_Status1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ativo", "Inativo" }));

        jComboBox_Status2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Autor", "Litisconsorte", "Réu" }));

        jLabel_ParteOposta.setText("Parte Oposta");

        jLabel_AdvogadoOposto.setText("Advogado Oposto");

        jLabel_Juiz.setText("Juiz");

        jButton_NovoJuiz.setText("Novo");
        jButton_NovoJuiz.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_NovoJuizMouseClicked(evt);
            }
        });

        jLabel_ValorDaCausa.setText("Valor da Causa");

        jLabel_Honorarios.setText("Honorários");

        jLabel_Observacoes.setText("Observações");

        jTextArea_Observacoes.setColumns(20);
        jTextArea_Observacoes.setRows(5);
        jScrollPane1.setViewportView(jTextArea_Observacoes);

        jLabel_Estrategia.setText("Estratégia");

        jTextArea_Estrategia.setColumns(20);
        jTextArea_Estrategia.setRows(5);
        jScrollPane2.setViewportView(jTextArea_Estrategia);

        jButton_Salvar.setText("Salvar");
        jButton_Salvar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_SalvarMouseClicked(evt);
            }
        });

        jButton_Limpar.setText("Limpar");
        jButton_Limpar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_LimparMouseClicked(evt);
            }
        });

        jButton_Sair.setText("Sair");
        jButton_Sair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_SairMouseClicked(evt);
            }
        });

        jButton_NovaComarca.setText("Novo");
        jButton_NovaComarca.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_NovaComarcaMouseClicked(evt);
            }
        });

        jButton_NovaVara.setText("Novo");
        jButton_NovaVara.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_NovaVaraMouseClicked(evt);
            }
        });

        jFormattedTextField_Honorários.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,###.00"))));
        jFormattedTextField_Honorários.setMaximumSize(new java.awt.Dimension(12, 30));
        jFormattedTextField_Honorários.setMinimumSize(new java.awt.Dimension(12, 30));

        jFormattedTextField_ValorDaCausa.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,###.00"))));
        jFormattedTextField_ValorDaCausa.setMaximumSize(new java.awt.Dimension(12, 30));
        jFormattedTextField_ValorDaCausa.setMinimumSize(new java.awt.Dimension(12, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_Comarca)
                    .addComponent(jLabel_Vara)
                    .addComponent(jLabel_TipoDaAcao)
                    .addComponent(jLabel_Fase)
                    .addComponent(jLabel_Cliente)
                    .addComponent(jLabel_Status)
                    .addComponent(jLabel_ParteOposta)
                    .addComponent(jLabel_Processo)
                    .addComponent(jLabel_AdvogadoOposto)
                    .addComponent(jLabel_Juiz)
                    .addComponent(jLabel_ValorDaCausa)
                    .addComponent(jLabel_Observacoes)
                    .addComponent(jLabel_Estrategia))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton_Salvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_Limpar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_Sair))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField_AdvogadoOposto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE)
                            .addComponent(jTextField_ParteOposta, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE)
                            .addComponent(jTextField_Processo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jComboBox_Status1, 0, 155, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox_Status2, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jComboBox_Cliente, javax.swing.GroupLayout.Alignment.LEADING, 0, 334, Short.MAX_VALUE)
                            .addComponent(jComboBox_Fase, javax.swing.GroupLayout.Alignment.LEADING, 0, 334, Short.MAX_VALUE)
                            .addComponent(jComboBox_TipoDaAcao, javax.swing.GroupLayout.Alignment.LEADING, 0, 334, Short.MAX_VALUE)
                            .addComponent(jCombo_BoxVara, javax.swing.GroupLayout.Alignment.LEADING, 0, 334, Short.MAX_VALUE)
                            .addComponent(jComboBox_Comarca, javax.swing.GroupLayout.Alignment.LEADING, 0, 334, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton_NovaVara)
                            .addComponent(jButton_NovaComarca)
                            .addComponent(jButton_NovaFase)
                            .addComponent(jButton_NovoTipoDaAcao)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jFormattedTextField_ValorDaCausa, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel_Honorarios)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jFormattedTextField_Honorários, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jComboBox_Juiz, 0, 334, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_NovoJuiz)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_Processo)
                    .addComponent(jTextField_Processo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_Comarca)
                    .addComponent(jComboBox_Comarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_NovaComarca))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_Vara)
                    .addComponent(jCombo_BoxVara, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_NovaVara))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_TipoDaAcao)
                    .addComponent(jComboBox_TipoDaAcao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_NovoTipoDaAcao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_Fase)
                    .addComponent(jComboBox_Fase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_NovaFase))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_Cliente)
                    .addComponent(jComboBox_Cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_Status)
                    .addComponent(jComboBox_Status1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox_Status2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_ParteOposta)
                    .addComponent(jTextField_ParteOposta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_AdvogadoOposto)
                    .addComponent(jTextField_AdvogadoOposto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel_Juiz)
                            .addComponent(jComboBox_Juiz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel_ValorDaCausa)
                            .addComponent(jFormattedTextField_ValorDaCausa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel_Honorarios)
                            .addComponent(jFormattedTextField_Honorários, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButton_NovoJuiz))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_Observacoes)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_Estrategia)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_Limpar)
                    .addComponent(jButton_Salvar)
                    .addComponent(jButton_Sair))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_SairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_SairMouseClicked
        habilitaBotoesBarraDeFerramentas();
        areaDeTrabalho.removeAll();
        areaDeTrabalho.revalidate();
        areaDeTrabalho.repaint();
    }//GEN-LAST:event_jButton_SairMouseClicked

    private void jButton_LimparMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_LimparMouseClicked
        limpaCampos();
    }//GEN-LAST:event_jButton_LimparMouseClicked

    private void jButton_NovaVaraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_NovaVaraMouseClicked
        VaraGUI vg = new VaraGUI(advogadoFacade,null, true);
        vg.setVisible(true);
        carregaVara();
    }//GEN-LAST:event_jButton_NovaVaraMouseClicked

    private void jButton_NovaComarcaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_NovaComarcaMouseClicked
        ComarcaGUI cg = new ComarcaGUI(advogadoFacade,null, true);
        cg.setVisible(true);
        carregaComarca();
    }//GEN-LAST:event_jButton_NovaComarcaMouseClicked

    private void jButton_NovoJuizMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_NovoJuizMouseClicked
        JuizGUI jg = new JuizGUI(advogadoFacade, null, true);
        jg.setVisible(true);
        carregaJuiz();
    }//GEN-LAST:event_jButton_NovoJuizMouseClicked

    private void jButton_NovaFaseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_NovaFaseMouseClicked
        FaseGUI fg = new FaseGUI(advogadoFacade, null, true);
        fg.setVisible(true);
        carregaFase();
    }//GEN-LAST:event_jButton_NovaFaseMouseClicked

    private void jButton_NovoTipoDaAcaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_NovoTipoDaAcaoMouseClicked
        AcaoGUI ag = new AcaoGUI(advogadoFacade, null, true);
        ag.setVisible(true);
        carregaAcao();
    }//GEN-LAST:event_jButton_NovoTipoDaAcaoMouseClicked

    private void jButton_SalvarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_SalvarMouseClicked
        String nome = jTextField_Processo.getText();
        
        Long comarcaID = null;
        if (jComboBox_Comarca.getItemCount() > 0 ){
            Comarca comarca = (Comarca) jComboBox_Comarca.getSelectedItem();
            comarcaID = comarca.getId();
        }


        Long varaID = null;
        if (jCombo_BoxVara.getItemCount() > 0) {
            Vara vara = (Vara) jCombo_BoxVara.getSelectedItem();
            varaID = vara.getId();
        }


        Long acaoID = null;
        if (jComboBox_TipoDaAcao.getItemCount() > 0){
            Acao acao = (Acao) jComboBox_TipoDaAcao.getSelectedItem();
            acaoID = acao.getId();
        }
        
        Long faseID = null;
        if (jComboBox_Fase.getItemCount() > 0) {
            Fase fase = (Fase) jComboBox_Fase.getSelectedItem();
            faseID = fase.getId();
        }
        
        Long clienteID = null;
        if (jComboBox_Cliente.getItemCount() > 0) {
            Cliente cliente = (Cliente) jComboBox_Cliente.getSelectedItem();
            clienteID = cliente.getId();
        }

        //Status sempre tem item
        String status = jComboBox_Status1.getSelectedItem().toString();
        String posicao = jComboBox_Status2.getSelectedItem().toString();

        String parteOposta = jTextField_ParteOposta.getText();
        String advogadoOposto = jTextField_AdvogadoOposto.getText();
        
        
        Long juizID = null;
        if (jComboBox_Juiz.getItemCount() > 0) {
            Juiz juiz = (Juiz) jComboBox_Juiz.getSelectedItem();
            juizID = juiz.getId();
        }

        String valorDaCausa = jFormattedTextField_ValorDaCausa.getText();
        String honorarios = jFormattedTextField_Honorários.getText();
        String observacoes = jTextArea_Observacoes.getText();
        String estrategia = jTextArea_Estrategia.getText();

        try {
            advogadoFacade.criarProcesso(nome, comarcaID, varaID, acaoID, faseID, clienteID, juizID, status, posicao, parteOposta, advogadoOposto, valorDaCausa, honorarios, observacoes, estrategia);
            JOptionPane.showMessageDialog(null, "Processo "+nome+" salvo com sucesso.");
            limpaCampos();
        } catch (AtributoNaoEncontrado ex) {
            System.out.println("");
            System.out.println("Erro: Falta algum atributo.");
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            if (ex.getMessage().contains("Nome")){
                jTextField_Processo.setText("");
                jTextField_Processo.requestFocus();
            }
        } catch (ProcessoInvalidoException ex) {
            System.out.println("");
            System.out.println("Erro: Processo já existe.");
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            jTextField_Processo.setText("");
            jTextField_Processo.requestFocus();
        }
    }//GEN-LAST:event_jButton_SalvarMouseClicked

    private void habilitaBotoesBarraDeFerramentas(){
        for (Component botoes: barraDeFerramentas.getComponents()) {
            botoes.setEnabled(true);
        }
        System.out.println("");
        System.out.println("Todos os botoes habilitados.");
    }

    private void limpaCampos(){
        jTextField_Processo.setText("");
        jTextField_AdvogadoOposto.setText("");
        jTextField_ParteOposta.setText("");
        jTextArea_Estrategia.setText("");
        jTextArea_Observacoes.setText("");
        jFormattedTextField_Honorários.setText("");
        jFormattedTextField_ValorDaCausa.setText("");
        System.out.println("");
        System.out.println("Todos os campos limpos.");
    }

    private void carregaVara () {
        jCombo_BoxVara.removeAllItems();
        System.out.println("");
        System.out.println("Carregando varas");
        for (Vara vara : advogadoFacade.getTodasVaras()) {
            jCombo_BoxVara.addItem(vara);
            System.out.println("Vara: "+ vara.getId() + " - " + vara.getNome());
        }
        System.out.println("Tamanho da lista de varas:" + jCombo_BoxVara.getItemCount());
        System.out.println("Varas carregadas");
    }

    private void carregaComarca () {
        jComboBox_Comarca.removeAllItems();
        System.out.println("");
        System.out.println("Carregando comarcas");
        for (Comarca comarca : advogadoFacade.getTodasComarcas()) {
            jComboBox_Comarca.addItem(comarca);
            System.out.println("Comarca: "+ comarca.getId() + " - " + comarca.getNome());
        }
        System.out.println("Tamanho da lista de comarcas: " + jComboBox_Comarca.getItemCount());
        System.out.println("Comarcas carregadas.");
    }

    private void carregaCliente () {
        jComboBox_Cliente.removeAllItems();
        System.out.println("");
        System.out.println("Carregando clientes");
        for (Cliente cliente : advogadoFacade.getTodosClientes()) {
            jComboBox_Cliente.addItem(cliente);
            System.out.println("Cliente: "+ cliente.getId() + " - " + cliente.getNome());
        }
        System.out.println("Tamanho da lista de clientes: " + jComboBox_Comarca.getItemCount());
        System.out.println("Clientes carregados.");
    }

    private void carregaJuiz () {
        jComboBox_Juiz.removeAllItems();
        System.out.println("");
        System.out.println("Carregando juizes");
        for (Juiz juiz : advogadoFacade.getTodosJuizes()) {
            jComboBox_Juiz.addItem(juiz);
            System.out.println("Juiz: "+ juiz.getId() + " - " + juiz.getNome());
        }
        System.out.println("Tamanho da lista de juizes: " + jComboBox_Juiz.getItemCount());
        System.out.println("Juizes carregados.");
    }

    private void carregaFase() {
        jComboBox_Fase.removeAllItems();
        System.out.println("");
        System.out.println("Carregando fases");
        for (Fase fase : advogadoFacade.getTodasFases()) {
            jComboBox_Fase.addItem(fase);
            System.out.println("Fase: "+ fase.getId() + " - " + fase.getNome());
        }
        System.out.println("Tamanho da lista de fases: " + jComboBox_Fase.getItemCount());
        System.out.println("fases carregados.");
    }

    private void carregaAcao() {
        jComboBox_TipoDaAcao.removeAllItems();
        System.out.println("");
        System.out.println("Carregando tipo de ações");
        for (Acao acao : advogadoFacade.getTodasAcoes()) {
            jComboBox_TipoDaAcao.addItem(acao);
            System.out.println("Tipo de Ação: "+ acao.getId() + " - " + acao.getNome());
        }
        System.out.println("Tamanho da lista de tipo de ações: " + jComboBox_TipoDaAcao.getItemCount());
        System.out.println("Tipo de ações carregados.");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Limpar;
    private javax.swing.JButton jButton_NovaComarca;
    private javax.swing.JButton jButton_NovaFase;
    private javax.swing.JButton jButton_NovaVara;
    private javax.swing.JButton jButton_NovoJuiz;
    private javax.swing.JButton jButton_NovoTipoDaAcao;
    private javax.swing.JButton jButton_Sair;
    private javax.swing.JButton jButton_Salvar;
    private javax.swing.JComboBox jComboBox_Cliente;
    private javax.swing.JComboBox jComboBox_Comarca;
    private javax.swing.JComboBox jComboBox_Fase;
    private javax.swing.JComboBox jComboBox_Juiz;
    private javax.swing.JComboBox jComboBox_Status1;
    private javax.swing.JComboBox jComboBox_Status2;
    private javax.swing.JComboBox jComboBox_TipoDaAcao;
    private javax.swing.JComboBox jCombo_BoxVara;
    private javax.swing.JFormattedTextField jFormattedTextField_Honorários;
    private javax.swing.JFormattedTextField jFormattedTextField_ValorDaCausa;
    private javax.swing.JLabel jLabel_AdvogadoOposto;
    private javax.swing.JLabel jLabel_Cliente;
    private javax.swing.JLabel jLabel_Comarca;
    private javax.swing.JLabel jLabel_Estrategia;
    private javax.swing.JLabel jLabel_Fase;
    private javax.swing.JLabel jLabel_Honorarios;
    private javax.swing.JLabel jLabel_Juiz;
    private javax.swing.JLabel jLabel_Observacoes;
    private javax.swing.JLabel jLabel_ParteOposta;
    private javax.swing.JLabel jLabel_Processo;
    private javax.swing.JLabel jLabel_Status;
    private javax.swing.JLabel jLabel_TipoDaAcao;
    private javax.swing.JLabel jLabel_ValorDaCausa;
    private javax.swing.JLabel jLabel_Vara;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea_Estrategia;
    private javax.swing.JTextArea jTextArea_Observacoes;
    private javax.swing.JTextField jTextField_AdvogadoOposto;
    private javax.swing.JTextField jTextField_ParteOposta;
    private javax.swing.JTextField jTextField_Processo;
    // End of variables declaration//GEN-END:variables

}