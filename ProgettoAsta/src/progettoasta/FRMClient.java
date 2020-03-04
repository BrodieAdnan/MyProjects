/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettoasta;

/**
 *
 * @author Farhan
 */
public class FRMClient extends javax.swing.JFrame {

    /*Attributi*/
    MODClient mc;
    String nome;
    double budget;

    /**
     * Costruttore
     *
     * @param modello (MODClient)
     */
    public FRMClient(MODClient modello) {
        this.mc = modello;
        toDoFirst();
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panMain = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        lblTitleNuovoAst = new javax.swing.JLabel();
        txtNomeNuovoAst = new javax.swing.JTextField();
        lblTitleBdgAstante = new javax.swing.JLabel();
        txtBdgAstante = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        lblMsgError = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Client");

        panMain.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        lblTitle.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Aggiungi astante");

        lblTitleNuovoAst.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblTitleNuovoAst.setText("Nome: ");

        txtNomeNuovoAst.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtNomeNuovoAst.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lblTitleBdgAstante.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblTitleBdgAstante.setText("Budget:");

        txtBdgAstante.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtBdgAstante.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        btnAdd.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAdd.setText("Aggiungi");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        lblMsgError.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblMsgError.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMsgError.setText("-");

        javax.swing.GroupLayout panMainLayout = new javax.swing.GroupLayout(panMain);
        panMain.setLayout(panMainLayout);
        panMainLayout.setHorizontalGroup(
            panMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panMainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(panMainLayout.createSequentialGroup()
                            .addComponent(lblTitleBdgAstante)
                            .addGap(28, 28, 28)
                            .addComponent(txtBdgAstante))
                        .addGroup(panMainLayout.createSequentialGroup()
                            .addComponent(lblTitleNuovoAst)
                            .addGap(32, 32, 32)
                            .addComponent(txtNomeNuovoAst, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(lblMsgError, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panMainLayout.setVerticalGroup(
            panMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panMainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle)
                .addGap(18, 18, 18)
                .addGroup(panMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitleNuovoAst)
                    .addComponent(txtNomeNuovoAst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitleBdgAstante)
                    .addComponent(txtBdgAstante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMsgError, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Metodo che cattura l'evento del button per creare l'astante
     *
     * @param evt (ActionEvent)
     */
    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        nome = txtNomeNuovoAst.getText();
        if (nome.equals("")) {
            lblMsgError.setText("Nickname non valido!");
        } else {
            try {
                budget = Double.parseDouble(txtBdgAstante.getText());
                mc.creaAstante(nome, budget);
                lblMsgError.setText(nome + " e' stato aggiunto all'asta.");
            } catch (Exception e) {
                lblMsgError.setText("Budget non valido!");
            }
        }
    }//GEN-LAST:event_btnAddActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JLabel lblMsgError;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTitleBdgAstante;
    private javax.swing.JLabel lblTitleNuovoAst;
    private javax.swing.JPanel panMain;
    private javax.swing.JTextField txtBdgAstante;
    private javax.swing.JTextField txtNomeNuovoAst;
    // End of variables declaration//GEN-END:variables

    private void toDoFirst() {
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
            java.util.logging.Logger.getLogger(FRMBanditore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FRMBanditore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FRMBanditore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FRMBanditore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                setVisible(true);
            }
        });
    }

}
