package br.com.lojatelefonia.ui;

import br.com.lojatelefonia.services.ServiceUtils;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class TelaPrincipal extends javax.swing.JFrame {

    ClienteTela clienteInfo = null;
    ProdutoTela produtoInfo = null;
    VendaTela realizarVenda = null;
    ListagemTela relatorioInfo = null;

    public TelaPrincipal() {
        this.dbError();
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            SwingUtilities.updateComponentTreeUI(this);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro no LookAndFeel");
        }
    }

    private void dbError() {
        if (ServiceUtils.checkConnection() == false) {
            JOptionPane.showMessageDialog(rootPane, "Nao ha conexao com o banco de dados!");
            JOptionPane.showMessageDialog(rootPane, "Se conecte ao banco de dados e tente novamente!");
            System.exit(0);
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

        desktop = new javax.swing.JDesktopPane(){
            private Image image;
            {
                try {
                    image = ImageIO.read(new URL("http://i.imgur.com/dE2ishu.jpg"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        };
        telaPrincipalMenu = new javax.swing.JMenuBar();
        menuClientes = new javax.swing.JMenu();
        menuItemClientes = new javax.swing.JMenuItem();
        menuProdutos = new javax.swing.JMenu();
        menuItemProdutos = new javax.swing.JMenuItem();
        menuVenda = new javax.swing.JMenu();
        menuRealizarVenda = new javax.swing.JMenuItem();
        menuRelatorio = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Loja Telefonia");

        desktop.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        desktop.setMinimumSize(new java.awt.Dimension(800, 600));
        desktop.setName(""); // NOI18N
        desktop.setPreferredSize(new java.awt.Dimension(1600, 1000));

        menuClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/image/clientes.png"))); // NOI18N
        menuClientes.setText("Cliente");

        menuItemClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/image/clientes.png"))); // NOI18N
        menuItemClientes.setText("Gerenciar Clientes");
        menuItemClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemClientesActionPerformed(evt);
            }
        });
        menuClientes.add(menuItemClientes);

        telaPrincipalMenu.add(menuClientes);

        menuProdutos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/image/produtos.png"))); // NOI18N
        menuProdutos.setText("Produto");

        menuItemProdutos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/image/produtos.png"))); // NOI18N
        menuItemProdutos.setText("Gerenciar Produtos");
        menuItemProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemProdutosActionPerformed(evt);
            }
        });
        menuProdutos.add(menuItemProdutos);

        telaPrincipalMenu.add(menuProdutos);

        menuVenda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/image/Vendas.png"))); // NOI18N
        menuVenda.setText("Venda");

        menuRealizarVenda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/image/Vendas.png"))); // NOI18N
        menuRealizarVenda.setText("Realizar Venda");
        menuRealizarVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuRealizarVendaActionPerformed(evt);
            }
        });
        menuVenda.add(menuRealizarVenda);

        menuRelatorio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/image/relatorio.gif"))); // NOI18N
        menuRelatorio.setText("Listagem de Vendas");
        menuRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuRelatorioActionPerformed(evt);
            }
        });
        menuVenda.add(menuRelatorio);

        telaPrincipalMenu.add(menuVenda);

        setJMenuBar(telaPrincipalMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktop, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuItemClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemClientesActionPerformed
        if (clienteInfo == null || !clienteInfo.isDisplayable()) {
            clienteInfo = new ClienteTela();
            desktop.add(clienteInfo);
            this.openFrameInCenter(clienteInfo);
        }
        clienteInfo.toFront();
    }//GEN-LAST:event_menuItemClientesActionPerformed

    private void menuItemProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemProdutosActionPerformed
        if (produtoInfo == null || !produtoInfo.isDisplayable()) {
            produtoInfo = new ProdutoTela();
            desktop.add(produtoInfo);
            this.openFrameInCenter(produtoInfo);
        }
        produtoInfo.toFront();
    }//GEN-LAST:event_menuItemProdutosActionPerformed

    private void menuRealizarVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRealizarVendaActionPerformed
        if (realizarVenda == null || !realizarVenda.isDisplayable()) {
            realizarVenda = new VendaTela();
            desktop.add(realizarVenda);
            this.openFrameInCenter(realizarVenda);
        }
        realizarVenda.toFront();
    }//GEN-LAST:event_menuRealizarVendaActionPerformed

    private void menuRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRelatorioActionPerformed
        if (relatorioInfo == null || !relatorioInfo.isDisplayable()) {
            relatorioInfo = new ListagemTela();
            desktop.add(relatorioInfo);
            this.openFrameInCenter(relatorioInfo);
        }
        relatorioInfo.toFront();
    }//GEN-LAST:event_menuRelatorioActionPerformed

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
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    public void openFrameInCenter(JInternalFrame jif) {
        Dimension desktopSize = desktop.getSize();
        Dimension jInternalFrameSize = jif.getSize();
        int width = (desktopSize.width - jInternalFrameSize.width) / 2;
        int height = (desktopSize.height - jInternalFrameSize.height) / 2;
        jif.setLocation(width, height);
        jif.setVisible(true);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane desktop;
    private javax.swing.JMenu menuClientes;
    private javax.swing.JMenuItem menuItemClientes;
    private javax.swing.JMenuItem menuItemProdutos;
    private javax.swing.JMenu menuProdutos;
    private javax.swing.JMenuItem menuRealizarVenda;
    private javax.swing.JMenuItem menuRelatorio;
    private javax.swing.JMenu menuVenda;
    private javax.swing.JMenuBar telaPrincipalMenu;
    // End of variables declaration//GEN-END:variables
}
