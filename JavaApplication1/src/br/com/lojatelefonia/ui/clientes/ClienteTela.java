package br.com.lojatelefonia.ui.clientes;

import br.com.lojatelefonia.dao.DaoCliente;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import br.com.lojatelefonia.models.Cliente;
import br.com.lojatelefonia.services.ServiceCliente;

public class ClienteTela extends javax.swing.JInternalFrame {

    /**
     * Creates new form ClienteInfo
     */
    public ClienteTela() {
        initComponents();
        ListarClientes();
        buttonUpdate.setEnabled(false);
    }

    //Mostrar dados na tabela
    public void ListarClientes() {
        ArrayList<Cliente> lista = DaoCliente.getListaClientes();
        DefaultTableModel model = (DefaultTableModel) jTableClientes.getModel();
        model.setRowCount(0);
        Object[] row = new Object[7];
        for (int i = 0; i < lista.size(); i++) {
            row[0] = lista.get(i).getId();
            row[1] = lista.get(i).getNome();
            row[2] = lista.get(i).getNasc();
            row[3] = lista.get(i).getTelefone();
            row[4] = lista.get(i).getEnd();
            row[5] = lista.get(i).getEmail();
            row[6] = lista.get(i).getCpf();
            model.addRow(row);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        clienteTabela = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableClientes = new javax.swing.JTable();
        buttonDelete = new javax.swing.JButton();
        txtPesquisa = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        clienteInfo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        buttonUpdate = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtClienteNasc = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        txtClienteID = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtClienteNome = new javax.swing.JTextField();
        fTxtClienteCPF = new javax.swing.JFormattedTextField();
        buttonInserir = new javax.swing.JButton();
        txtClienteTel = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtClienteEnd = new javax.swing.JTextField();
        txtClienteMail = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Sistema Loja Clientes");
        setPreferredSize(new java.awt.Dimension(900, 590));

        clienteTabela.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Tabela de Clientes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        jTableClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Data de Nascimento", "Telefone", "Endereço", "E-Mail", "CPF"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableClientes);

        buttonDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/image/excluir.png"))); // NOI18N
        buttonDelete.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        buttonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeleteActionPerformed(evt);
            }
        });

        txtPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesquisaKeyReleased(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/image/filtroBuscar.png"))); // NOI18N
        jLabel6.setText("Filtro:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("* Duplo clique para atualizar");

        javax.swing.GroupLayout clienteTabelaLayout = new javax.swing.GroupLayout(clienteTabela);
        clienteTabela.setLayout(clienteTabelaLayout);
        clienteTabelaLayout.setHorizontalGroup(
            clienteTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(clienteTabelaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(clienteTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(clienteTabelaLayout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, clienteTabelaLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPesquisa)))
                .addContainerGap())
        );
        clienteTabelaLayout.setVerticalGroup(
            clienteTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(clienteTabelaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(clienteTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(19, 19, 19)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 437, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(clienteTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonDelete)
                    .addComponent(jLabel9))
                .addGap(5, 5, 5))
        );

        clienteInfo.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Informações do Cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("ID:");

        buttonUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/image/atualizar.png"))); // NOI18N
        buttonUpdate.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        buttonUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUpdateActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Nome:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Data de Nascimento:");

        try {
            txtClienteNasc.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtClienteNasc.setFocusLostBehavior(javax.swing.JFormattedTextField.COMMIT);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Telefone:");

        txtClienteID.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("CPF:");

        try {
            fTxtClienteCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        buttonInserir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/image/adicionar.png"))); // NOI18N
        buttonInserir.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        buttonInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonInserirActionPerformed(evt);
            }
        });

        try {
            txtClienteTel.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtClienteTel.setFocusLostBehavior(javax.swing.JFormattedTextField.COMMIT);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Endereço:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("E-Mail:");

        javax.swing.GroupLayout clienteInfoLayout = new javax.swing.GroupLayout(clienteInfo);
        clienteInfo.setLayout(clienteInfoLayout);
        clienteInfoLayout.setHorizontalGroup(
            clienteInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, clienteInfoLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(buttonInserir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonUpdate)
                .addContainerGap())
            .addGroup(clienteInfoLayout.createSequentialGroup()
                .addGroup(clienteInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(clienteInfoLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(clienteInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, clienteInfoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(clienteInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(clienteInfoLayout.createSequentialGroup()
                        .addGroup(clienteInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtClienteID, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtClienteMail, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fTxtClienteCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(clienteInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtClienteNasc, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtClienteTel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)))
                        .addGap(0, 47, Short.MAX_VALUE))
                    .addGroup(clienteInfoLayout.createSequentialGroup()
                        .addGroup(clienteInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtClienteEnd, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtClienteNome))
                        .addGap(15, 15, 15))))
        );

        clienteInfoLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {buttonInserir, buttonUpdate});

        clienteInfoLayout.setVerticalGroup(
            clienteInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, clienteInfoLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(clienteInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(txtClienteID, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(clienteInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtClienteNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(clienteInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtClienteNasc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(clienteInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtClienteTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(clienteInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtClienteEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(clienteInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtClienteMail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(clienteInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(fTxtClienteCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(clienteInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonInserir)
                    .addComponent(buttonUpdate))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        clienteInfoLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {fTxtClienteCPF, txtClienteNasc, txtClienteNome});

        clienteInfoLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {buttonInserir, buttonUpdate});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(clienteInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(clienteTabela, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(22, 22, 22))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(clienteTabela, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(clienteInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 242, Short.MAX_VALUE)))
                .addContainerGap())
        );

        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Pegar informacoes da tabela com o clique
    private void jTableClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableClientesMouseClicked
        int i = jTableClientes.getSelectedRow();
        TableModel model = jTableClientes.getModel();
        txtClienteID.setText(model.getValueAt(i, 0).toString());
        txtClienteNome.setText(model.getValueAt(i, 1).toString());
        txtClienteNasc.setText(model.getValueAt(i, 2).toString());
        txtClienteTel.setText(model.getValueAt(i, 3).toString());
        txtClienteEnd.setText(model.getValueAt(i, 4).toString());
        txtClienteMail.setText(model.getValueAt(i, 5).toString());
        fTxtClienteCPF.setText(model.getValueAt(i, 6).toString());
        // Mostrar linha selecionada no JTextField
        if (evt.getClickCount() > 1) {
            // Contador de cliques
            int j = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja editar?", "Aviso!", JOptionPane.YES_NO_OPTION);
            if (j == JOptionPane.YES_OPTION) {
                buttonUpdate.setEnabled(true);
                txtClienteID.setText(model.getValueAt(i, 0).toString());
                txtClienteNome.setText(model.getValueAt(i, 1).toString());
                txtClienteNasc.setText(model.getValueAt(i, 2).toString());
                txtClienteTel.setText(model.getValueAt(i, 3).toString());
                txtClienteEnd.setText(model.getValueAt(i, 4).toString());
                txtClienteMail.setText(model.getValueAt(i, 5).toString());
                fTxtClienteCPF.setText(model.getValueAt(i, 6).toString());
            }
        }
    }//GEN-LAST:event_jTableClientesMouseClicked

    //Deletar item da tabela
    private void buttonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeleteActionPerformed
        if (jTableClientes.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(this, "Nenhum cliente selecionado.", "ERRO", JOptionPane.ERROR_MESSAGE);
        } else {
            int id = Integer.parseInt(txtClienteID.getText());
            int option = JOptionPane.showConfirmDialog(this, "Deseja deletar o cliente selecionado?", "Aviso!", JOptionPane.YES_NO_OPTION);
            try {
                ServiceCliente.excliurCliente(id, option);
                if (option == 0) {
                    ListarClientes();
                    JOptionPane.showMessageDialog(this, "Cliente excluido");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
            txtClienteID.setText("");
            txtClienteNome.setText("");
            txtClienteNasc.setText("");
            txtClienteTel.setText("");
            txtClienteEnd.setText("");
            txtClienteMail.setText("");
            fTxtClienteCPF.setText("");
        }
        buttonUpdate.setEnabled(false);
    }//GEN-LAST:event_buttonDeleteActionPerformed

    //Pesquisar item na tabela
    private void txtPesquisaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisaKeyReleased
        TableRowSorter sorter = null;
        DefaultTableModel model = (DefaultTableModel) jTableClientes.getModel();
        sorter = new TableRowSorter<TableModel>(model);
        jTableClientes.setRowSorter(sorter);
        String text = txtPesquisa.getText();
        if (text.length() == 0) {
            sorter.setRowFilter(null);
        } else {
            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
        }
    }//GEN-LAST:event_txtPesquisaKeyReleased

    //Inserir item na tabela
    private void buttonInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonInserirActionPerformed
        String nome = txtClienteNome.getText();
        String nasc = txtClienteNasc.getText();
        String tel = txtClienteTel.getText();
        String end = txtClienteEnd.getText();
        String email = txtClienteMail.getText();
        String cpf = fTxtClienteCPF.getText();
        try {
            ServiceCliente.cadastrarCliente(nome, nasc, tel, end, email, cpf);
            ListarClientes();
            JOptionPane.showMessageDialog(this, "Cliente cadastrado");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        txtClienteID.setText("");
        txtClienteNome.setText("");
        txtClienteNasc.setText("");
        txtClienteTel.setText("");
        txtClienteEnd.setText("");
        txtClienteMail.setText("");
        fTxtClienteCPF.setText("");
        buttonUpdate.setEnabled(false);
    }//GEN-LAST:event_buttonInserirActionPerformed

    //Atualizar item da tabela
    private void buttonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUpdateActionPerformed
        int id = Integer.parseInt(txtClienteID.getText());
        String nome = txtClienteNome.getText();
        String nasc = txtClienteNasc.getText();
        String tel = txtClienteTel.getText();
        String end = txtClienteEnd.getText();
        String email = txtClienteMail.getText();
        String cpf = fTxtClienteCPF.getText();
        try {
            ServiceCliente.atualizarCliente(id, nome, nasc, tel, end, email, cpf);
            ListarClientes();
            JOptionPane.showMessageDialog(this, "Cliente atualizado");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        txtClienteID.setText("");
        txtClienteNome.setText("");
        txtClienteNasc.setText("");
        txtClienteTel.setText("");
        txtClienteEnd.setText("");
        txtClienteMail.setText("");
        fTxtClienteCPF.setText("");
        buttonUpdate.setEnabled(false);
    }//GEN-LAST:event_buttonUpdateActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonDelete;
    private javax.swing.JButton buttonInserir;
    private javax.swing.JButton buttonUpdate;
    private javax.swing.JPanel clienteInfo;
    private javax.swing.JPanel clienteTabela;
    private javax.swing.JFormattedTextField fTxtClienteCPF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableClientes;
    private javax.swing.JTextField txtClienteEnd;
    private javax.swing.JLabel txtClienteID;
    private javax.swing.JTextField txtClienteMail;
    private javax.swing.JFormattedTextField txtClienteNasc;
    private javax.swing.JTextField txtClienteNome;
    private javax.swing.JFormattedTextField txtClienteTel;
    private javax.swing.JTextField txtPesquisa;
    // End of variables declaration//GEN-END:variables
}
