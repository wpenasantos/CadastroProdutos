/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.map.CadastroProdutos.gui;

import br.edu.map.CadastroProdutos.dao.ProdutoDAO;
import br.edu.map.CadastroProdutos.model.Produto;
//import br.edu.map.CadastroProdutos.util.DateUtil;
import br.edu.map.CadastroProdutos.util.MensagensUtil;
import br.edu.map.CadastroProdutos.util.RelatorioManager;
import java.util.List;
import javax.swing.JFrame;
import java.util.logging.Level;
import java.util.Date;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
//import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.swing.JRViewer;

/**
 *
 * @author Washington
 */
public class ProdutosJFrame extends javax.swing.JFrame {
    private ProdutoDAO dao = new ProdutoDAO();
    private ProdutoDAO produtoDAO;
    private Produto produtoSelecionado;
    
    /**
     * Creates new form ProdutosJFrame
     */
    
    public ProdutosJFrame() {
        produtoDAO = new ProdutoDAO();
        this.setTitle("Produtos");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setIconImage(new ImageIcon(getClass().getResource("/img/produto.png")).getImage());
        initComponents();
        preencherTabela(null);
        atualizarStrings();
        this.setLocationRelativeTo(null);
    }
    
    private void atualizarStrings(){
        this.setTitle(MensagensUtil.getMensagem(MensagensUtil.LABEL_TITULO));
        buttonNovo.setText(MensagensUtil.getMensagem(MensagensUtil.BUTTON_NOVO));
        buttonSair.setText(MensagensUtil.getMensagem(MensagensUtil.BUTTON_SAIR));
        buttonExcluir.setText(MensagensUtil.getMensagem(MensagensUtil.BUTTON_EXCLUIR));
        buttonEditar.setText(MensagensUtil.getMensagem(MensagensUtil.BUTTON_EDITAR));
        labelBuscar.setText(MensagensUtil.getMensagem(MensagensUtil.LABEL_BUSCAR));
        labelTitulo.setText(MensagensUtil.getMensagem(MensagensUtil.LABEL_TITULO));
        jMenu1.setText(MensagensUtil.getMensagem(MensagensUtil.MENU_IDIOMA));
        itemPt_BR.setText(MensagensUtil.getMensagem(MensagensUtil.MENU_IDIOMA_PT_BR));
        itemEn_US.setText(MensagensUtil.getMensagem(MensagensUtil.MENU_IDIOMA_EN_US));
        itemEs_ES.setText(MensagensUtil.getMensagem(MensagensUtil.MENU_IDIOMA_ES_ES));
        jMenu2.setText(MensagensUtil.getMensagem(MensagensUtil.MENU_RELATORIO));
        menuItemListaProdutos.setText(MensagensUtil.getMensagem(MensagensUtil.MENU_RELATORIO_LISTA_PRODUTO));
        menuItemListaProdutosPorPreco.setText(MensagensUtil.getMensagem(MensagensUtil.MENU_RELATORIO_LISTA_PRODUTO_PRECO_MAIOR));
        menuItemListaProdutosPorPrecoMenor.setText(MensagensUtil.getMensagem(MensagensUtil.MENU_RELATORIO_LISTA_PRODUTO_PRECO_MENOR));
        preencherTabela(null);
    }
        
    public void preencherTabela(List<Produto> lista) {
        try {

            List<Produto> produtos = null;

            if (lista == null) {
                produtos = produtoDAO.listar();
            } else {
                produtos = lista;
            }

            DefaultTableModel model = new DefaultTableModel();

            model.setColumnCount(3);
            model.setColumnIdentifiers(
                    new String[]{
                        MensagensUtil.getMensagem(MensagensUtil.TABELA_CODIGO), 
                        MensagensUtil.getMensagem(MensagensUtil.TABELA_NOME), 
                        MensagensUtil.getMensagem(MensagensUtil.TABELA_PRECO)});
            
            model.setRowCount(produtos.size());

            for (int i = 0; i < produtos.size(); i++) {

                Produto p = produtos.get(i);

                model.setValueAt(p.getCodigo(), i, 0);
                model.setValueAt(p.getNome(), i, 1);
                model.setValueAt(p.getPreco(), i, 2);
            }

            tableProdutos.setModel(model);

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro: " + ex.getMessage());
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

        labelTitulo = new javax.swing.JLabel();
        textBusca = new javax.swing.JTextField();
        labelBuscar = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableProdutos = new javax.swing.JTable();
        buttonNovo = new javax.swing.JButton();
        buttonEditar = new javax.swing.JButton();
        buttonExcluir = new javax.swing.JButton();
        buttonSair = new javax.swing.JButton();
        menuIdioma = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        menuItemListaProdutos = new javax.swing.JMenuItem();
        menuItemListaProdutosPorPreco = new javax.swing.JMenuItem();
        menuItemListaProdutosPorPrecoMenor = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        itemPt_BR = new javax.swing.JMenuItem();
        itemEn_US = new javax.swing.JMenuItem();
        itemEs_ES = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labelTitulo.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        labelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTitulo.setText("Produtos");

        textBusca.setToolTipText("");
        textBusca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textBuscaKeyReleased(evt);
            }
        });

        labelBuscar.setText("Buscar:");

        tableProdutos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableProdutosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableProdutos);

        buttonNovo.setText("Novo");
        buttonNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNovoActionPerformed(evt);
            }
        });

        buttonEditar.setText("Editar");
        buttonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEditarActionPerformed(evt);
            }
        });

        buttonExcluir.setText("Excluir");
        buttonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonExcluirActionPerformed(evt);
            }
        });

        buttonSair.setText("Sair");
        buttonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSairActionPerformed(evt);
            }
        });

        jMenu2.setText("Relatórios");

        menuItemListaProdutos.setText("Lista de Produtos");
        menuItemListaProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemListaProdutosActionPerformed(evt);
            }
        });
        jMenu2.add(menuItemListaProdutos);

        menuItemListaProdutosPorPreco.setText("Lista de Produtos por preço");
        menuItemListaProdutosPorPreco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemListaProdutosPorPrecoActionPerformed(evt);
            }
        });
        jMenu2.add(menuItemListaProdutosPorPreco);

        menuItemListaProdutosPorPrecoMenor.setText("Lista de Produtos por preço");
        menuItemListaProdutosPorPrecoMenor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemListaProdutosPorPrecoMenorActionPerformed(evt);
            }
        });
        jMenu2.add(menuItemListaProdutosPorPrecoMenor);

        menuIdioma.add(jMenu2);

        jMenu1.setText("Idioma");

        itemPt_BR.setText("Português");
        itemPt_BR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemPt_BRActionPerformed(evt);
            }
        });
        jMenu1.add(itemPt_BR);

        itemEn_US.setText("Inglês");
        itemEn_US.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemEn_USActionPerformed(evt);
            }
        });
        jMenu1.add(itemEn_US);

        itemEs_ES.setText("Espanhol");
        itemEs_ES.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemEs_ESActionPerformed(evt);
            }
        });
        jMenu1.add(itemEs_ES);

        menuIdioma.add(jMenu1);

        setJMenuBar(menuIdioma);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(labelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(labelBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textBusca)))
                .addGap(10, 10, 10))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buttonNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonSair, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 10, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(labelTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonNovo)
                    .addComponent(buttonEditar)
                    .addComponent(buttonExcluir)
                    .addComponent(buttonSair))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itemPt_BRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemPt_BRActionPerformed
        // TODO add your handling code here:
        MensagensUtil.setLocale(MensagensUtil.PT_BR);
        atualizarStrings();
    }//GEN-LAST:event_itemPt_BRActionPerformed

    private void itemEn_USActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemEn_USActionPerformed
        // TODO add your handling code here:
        MensagensUtil.setLocale(MensagensUtil.EN_US);
        atualizarStrings();
    }//GEN-LAST:event_itemEn_USActionPerformed

    private void itemEs_ESActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemEs_ESActionPerformed
        // TODO add your handling code here:
        MensagensUtil.setLocale(MensagensUtil.ES_ES);
        atualizarStrings();
    }//GEN-LAST:event_itemEs_ESActionPerformed

    private void textBuscaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textBuscaKeyReleased
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            String busca = textBusca.getText();

            List<Produto> produtos = produtoDAO.buscar(busca);

            preencherTabela(produtos);
            
            produtoSelecionado = null;
            
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, MensagensUtil.getMensagem(MensagensUtil.MSG_ERRO_SELECIONAR));
        }
    }//GEN-LAST:event_textBuscaKeyReleased

    private void tableProdutosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableProdutosMouseClicked
        try {
            // TODO add your handling code here:

            // decobrir a linha clicada
            int linha = tableProdutos.rowAtPoint(evt.getPoint());
            // pegar valor do codigo da linha selecionada
            int codigo = (int) tableProdutos.getModel().getValueAt(linha, 0);

            produtoSelecionado = produtoDAO.buscarPorCodigo(codigo);

            System.out.println(produtoSelecionado);

        } catch (Exception ex) {

        }
    }//GEN-LAST:event_tableProdutosMouseClicked

    private void buttonNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNovoActionPerformed
        // TODO add your handling code here:
        ProdutoJFrame janela = new ProdutoJFrame(this, null);
        janela.setVisible(true);
    }//GEN-LAST:event_buttonNovoActionPerformed

    private void buttonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEditarActionPerformed
        // TODO add your handling code here:

        if (produtoSelecionado != null) {
            ProdutoJFrame janela = new ProdutoJFrame(this, produtoSelecionado);
            janela.setVisible(true);
        }
        else{
            JOptionPane.showMessageDialog(this, MensagensUtil.getMensagem(MensagensUtil.MSG_ERRO_SELECIONAR));
        }
    }//GEN-LAST:event_buttonEditarActionPerformed

    private void buttonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonExcluirActionPerformed
        // TODO add your handling code here:

        try {

            if (produtoSelecionado != null) {

                int op = JOptionPane.showConfirmDialog(this, "Excluir o produto " + produtoSelecionado.getNome() + "?", "Excluir", JOptionPane.OK_CANCEL_OPTION);

                if (op == JOptionPane.OK_OPTION) {
                    produtoDAO.remover(produtoSelecionado);
                    produtoSelecionado = null;
                    preencherTabela(null);
                }
            }
            else{
                JOptionPane.showMessageDialog(this, MensagensUtil.getMensagem(MensagensUtil.MSG_ERRO_SELECIONAR));
            }

        } catch (Exception e) {

        }
    }//GEN-LAST:event_buttonExcluirActionPerformed

    private void buttonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSairActionPerformed
        // TODO add your handling code here:
        //this.dispose();
        System.exit(0);
    }//GEN-LAST:event_buttonSairActionPerformed

    private void menuItemListaProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemListaProdutosActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            JasperPrint relatorio = RelatorioManager.gerarRelatorioProdutos(dao.listar());
            //String titrel = "Relatório";
            JFrame frame = new JFrame();
            frame.setSize(1200, 800);
            JRViewer viewer = new JRViewer(relatorio);
            frame.add(viewer);
            frame.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(ProdutosJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_menuItemListaProdutosActionPerformed

    private void menuItemListaProdutosPorPrecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemListaProdutosPorPrecoActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            Double preco = Double.parseDouble(JOptionPane.showInputDialog(null, MensagensUtil.getMensagem(MensagensUtil.MSG_RELATORIO_PRECO_REFERENCIA_MAIOR)));
            JasperPrint relatorio = RelatorioManager.gerarRelatorioProdutos(dao.listar(preco,1));
            JFrame frame = new JFrame();
            frame.setSize(1200, 800);
            JRViewer viewer = new JRViewer(relatorio);
            frame.add(viewer);
            frame.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(ProdutosJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_menuItemListaProdutosPorPrecoActionPerformed

    private void menuItemListaProdutosPorPrecoMenorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemListaProdutosPorPrecoMenorActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            Double preco = Double.parseDouble(JOptionPane.showInputDialog(null, MensagensUtil.getMensagem(MensagensUtil.MSG_RELATORIO_PRECO_REFERENCIA_MENOR)));
            JasperPrint relatorio = RelatorioManager.gerarRelatorioProdutos(dao.listar(preco,-1));
            JFrame frame = new JFrame();
            frame.setSize(1200, 800);
            JRViewer viewer = new JRViewer(relatorio);
            frame.add(viewer);
            frame.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(ProdutosJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_menuItemListaProdutosPorPrecoMenorActionPerformed

    
        
    
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
            java.util.logging.Logger.getLogger(ProdutosJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProdutosJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProdutosJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProdutosJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProdutosJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonEditar;
    private javax.swing.JButton buttonExcluir;
    private javax.swing.JButton buttonNovo;
    private javax.swing.JButton buttonSair;
    private javax.swing.JMenuItem itemEn_US;
    private javax.swing.JMenuItem itemEs_ES;
    private javax.swing.JMenuItem itemPt_BR;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelBuscar;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JMenuBar menuIdioma;
    private javax.swing.JMenuItem menuItemListaProdutos;
    private javax.swing.JMenuItem menuItemListaProdutosPorPreco;
    private javax.swing.JMenuItem menuItemListaProdutosPorPrecoMenor;
    private javax.swing.JTable tableProdutos;
    private javax.swing.JTextField textBusca;
    // End of variables declaration//GEN-END:variables
}
