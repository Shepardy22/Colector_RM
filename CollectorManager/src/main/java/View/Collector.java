/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Control.areasControl;
import Models.Area;
import java.awt.BorderLayout;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Yuri
 */
public final class Collector extends javax.swing.JFrame {
    
    AreaView areaV = new AreaView();

   private final String area;
   
   private final Area areaResult;

   private final areasControl areaControl;
    
    public Collector() {
       this.area = "mercearia";
       this.areaControl = new areasControl();
       this.areaResult = areaControl.retrieveData(area);
       
       tabela = new JTable();
       jScrollPane2 = new JScrollPane(tabela);
       getContentPane().add(jScrollPane2, BorderLayout.CENTER);
        initComponents();
        preencherTabela(areaResult);
    }
    
    private void cadastrarProduto(String area, String barcode, int qnt){
        areasControl areaControll = new areasControl();
        areaControll.insertData(area, barcode, qnt);
        Area areaRes = areaControl.retrieveData(area);
        preencherTabela(areaRes);
    }
    
    public void preencherTabela(Area areaResult) {

        //areaV.printArea(areaResult);
        DefaultTableModel tabelaModel = (DefaultTableModel) tabela.getModel();

        tabelaModel.setRowCount(0); // limpa as linhas existentes na tabela

        Map<String, Integer> produtos = areaResult.getProdutos();

        for (String barcode : produtos.keySet()) {
            int quantidade = produtos.get(barcode);
            Object[] rowData = {barcode, quantidade};
            tabelaModel.addRow(rowData);
        }
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelAreaTitle = new javax.swing.JLabel();
        jLabelAreaValue = new javax.swing.JLabel();
        jTextFieldNomeArea = new javax.swing.JTextField();
        jLabelNomeArea = new javax.swing.JLabel();
        jButtonGerarArea = new javax.swing.JButton();
        jLabelBarcode = new javax.swing.JLabel();
        jTextFieldBarcode = new javax.swing.JTextField();
        jLabelQnt = new javax.swing.JLabel();
        jTextFieldQuantidade = new javax.swing.JTextField();
        jButtonInserirProduto = new javax.swing.JButton();
        jButtonEditarProduto = new javax.swing.JButton();
        jButtonDeletarProduto = new javax.swing.JButton();
        jButtonDeleteArea = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Visualizar Area");

        jLabelAreaTitle.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabelAreaTitle.setText("Área");

        jLabelAreaValue.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabelAreaValue.setText("001");

        jLabelNomeArea.setText("Nome Área");

        jButtonGerarArea.setText("Gerar Nova Área");
        jButtonGerarArea.setToolTipText("Insira um nome de Clique no Botao Para gerar uma nova Área");
        jButtonGerarArea.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabelBarcode.setText("Barcode");

        jLabelQnt.setText("Qnt");

        jButtonInserirProduto.setText("Inserir Produto");
        jButtonInserirProduto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonInserirProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInserirProdutoActionPerformed(evt);
            }
        });

        jButtonEditarProduto.setText("Editar");
        jButtonEditarProduto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jButtonDeletarProduto.setText("Deletar");
        jButtonDeletarProduto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jButtonDeleteArea.setText("X");

        tabela.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Barcode", "Quantidade"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tabela);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelAreaTitle)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelAreaValue, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelBarcode, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(jTextFieldBarcode, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabelQnt)
                        .addGap(4, 4, 4)
                        .addComponent(jTextFieldQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonInserirProduto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonEditarProduto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonDeletarProduto)
                        .addContainerGap(115, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelNomeArea)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldNomeArea, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonGerarArea)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonDeleteArea, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24))))
            .addComponent(jScrollPane2)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelAreaTitle)
                    .addComponent(jLabelAreaValue, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldNomeArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNomeArea)
                    .addComponent(jButtonGerarArea)
                    .addComponent(jButtonDeleteArea))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelBarcode)
                    .addComponent(jTextFieldBarcode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelQnt)
                    .addComponent(jTextFieldQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonInserirProduto)
                    .addComponent(jButtonEditarProduto)
                    .addComponent(jButtonDeletarProduto))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonInserirProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInserirProdutoActionPerformed

        if (validaCampos()) {
            JOptionPane.showMessageDialog(null, "Preencha com o codigo de barras e quantidade!");
        } else {
            String barcode = jTextFieldBarcode.getText();
            String qntString = jTextFieldQuantidade.getText();
            int qnt = Integer.parseInt(qntString);
            
            cadastrarProduto(area, barcode, qnt);
            jTextFieldBarcode.setText("");
            jTextFieldQuantidade.setText("");
            JOptionPane.showMessageDialog(null, "Produto inserido com Sucesso!");
        }

    }//GEN-LAST:event_jButtonInserirProdutoActionPerformed

    private boolean validaCampos(){
        return (jTextFieldBarcode.getText().equals("")
                || jTextFieldQuantidade.getText().equals(""));
    }
    
    
    public JButton getjButtonDeletarProduto() {
        return jButtonDeletarProduto;
    }

    public void setjButtonDeletarProduto(JButton jButtonDeletarProduto) {
        this.jButtonDeletarProduto = jButtonDeletarProduto;
    }

    public JButton getjButtonDeleteArea() {
        return jButtonDeleteArea;
    }

    public void setjButtonDeleteArea(JButton jButtonDeleteArea) {
        this.jButtonDeleteArea = jButtonDeleteArea;
    }

    public JButton getjButtonEditarProduto() {
        return jButtonEditarProduto;
    }

    public void setjButtonEditarProduto(JButton jButtonEditarProduto) {
        this.jButtonEditarProduto = jButtonEditarProduto;
    }

    public JButton getjButtonGerarArea() {
        return jButtonGerarArea;
    }

    public void setjButtonGerarArea(JButton jButtonGerarArea) {
        this.jButtonGerarArea = jButtonGerarArea;
    }

    public JButton getjButtonInserirProduto() {
        return jButtonInserirProduto;
    }

    public void setjButtonInserirProduto(JButton jButtonInserirProduto) {
        this.jButtonInserirProduto = jButtonInserirProduto;
    }

    public JLabel getjLabelAreaValue() {
        return jLabelAreaValue;
    }

    public void setjLabelAreaValue(JLabel jLabelAreaValue) {
        this.jLabelAreaValue = jLabelAreaValue;
    }

    public JLabel getjLabelNomeArea() {
        return jLabelNomeArea;
    }

    public void setjLabelNomeArea(JLabel jLabelNomeArea) {
        this.jLabelNomeArea = jLabelNomeArea;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane2;
    }

    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane2 = jScrollPane1;
    }

    public JTable getjTable1() {
        return tabela;
    }

    public void setjTable1(JTable jTable1) {
        this.tabela = jTable1;
    }

    public JTextField getjTextFieldBarcode() {
        return jTextFieldBarcode;
    }

    public void setjTextFieldBarcode(JTextField jTextFieldBarcode) {
        this.jTextFieldBarcode = jTextFieldBarcode;
    }

    public JTextField getjTextFieldNomeArea() {
        return jTextFieldNomeArea;
    }

    public void setjTextFieldNomeArea(JTextField jTextFieldNomeArea) {
        this.jTextFieldNomeArea = jTextFieldNomeArea;
    }

    public JTextField getjTextFieldQuantidade() {
        return jTextFieldQuantidade;
    }

    public void setjTextFieldQuantidade(JTextField jTextFieldQuantidade) {
        this.jTextFieldQuantidade = jTextFieldQuantidade;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Collector.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Collector.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Collector.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Collector.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Collector().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonDeletarProduto;
    private javax.swing.JButton jButtonDeleteArea;
    private javax.swing.JButton jButtonEditarProduto;
    private javax.swing.JButton jButtonGerarArea;
    private javax.swing.JButton jButtonInserirProduto;
    private javax.swing.JLabel jLabelAreaTitle;
    private javax.swing.JLabel jLabelAreaValue;
    private javax.swing.JLabel jLabelBarcode;
    private javax.swing.JLabel jLabelNomeArea;
    private javax.swing.JLabel jLabelQnt;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextFieldBarcode;
    private javax.swing.JTextField jTextFieldNomeArea;
    private javax.swing.JTextField jTextFieldQuantidade;
    private javax.swing.JTable tabela;
    // End of variables declaration//GEN-END:variables
}
