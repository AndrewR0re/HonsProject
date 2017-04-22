/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package honsproject;

import javax.swing.JOptionPane;
import java.util.Arrays;

/**
 *
 * @author 1305997
 */
public class ParticipantPasswordGUI extends javax.swing.JFrame {

    /**
     * Creates new form ParticipantPasswordGUI
     */
    
    ParticipantPassword participantGUIPassword = new ParticipantPassword();
    private final char[] password = participantGUIPassword.getPassword();
    public boolean allowAccess = false;

    public ParticipantPasswordGUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        passwordCheckTitle = new javax.swing.JLabel();
        passwordCheckLabel = new javax.swing.JLabel();
        passwordCheckEnterBtn = new javax.swing.JButton();
        passwordCheckBackBtn = new javax.swing.JButton();
        jPasswordField1 = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Enter Password");

        passwordCheckTitle.setText("Participant details are Password Protected!");

        passwordCheckLabel.setText("Enter Password:");

        passwordCheckEnterBtn.setText("Enter");
        passwordCheckEnterBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordCheckEnterBtnActionPerformed(evt);
            }
        });

        passwordCheckBackBtn.setText("Back");
        passwordCheckBackBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordCheckBackBtnActionPerformed(evt);
            }
        });

        jPasswordField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(passwordCheckLabel)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(passwordCheckEnterBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(passwordCheckBackBtn))
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(passwordCheckTitle)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(passwordCheckTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordCheckLabel)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordCheckEnterBtn)
                    .addComponent(passwordCheckBackBtn))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void passwordCheckEnterBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordCheckEnterBtnActionPerformed
        
        //String passwordInput = jPasswordField1.getText();
        char[] passwordFieldInput = jPasswordField1.getPassword();
        
        boolean allowAccess = Arrays.equals(passwordFieldInput,password);
        
        if(allowAccess){
            this.setVisible(false);
            
            ParticipantGUI participantGUI = new ParticipantGUI();
            participantGUI.setLocationRelativeTo(this);
            participantGUI.setVisible(true);
        }
        else{
            JOptionPane.showMessageDialog(null,"Incorrect password. Access Denied.", "Incorrect Password.", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_passwordCheckEnterBtnActionPerformed

    private void passwordCheckBackBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordCheckBackBtnActionPerformed
        MainGUI home = new MainGUI();
        this.setVisible(false);
        home.setVisible(true);
        home.setLocationRelativeTo(this);
    }//GEN-LAST:event_passwordCheckBackBtnActionPerformed

    private void jPasswordField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField1ActionPerformed
        passwordCheckEnterBtn.doClick();
    }//GEN-LAST:event_jPasswordField1ActionPerformed

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
            java.util.logging.Logger.getLogger(ParticipantPasswordGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ParticipantPasswordGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ParticipantPasswordGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ParticipantPasswordGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ParticipantPasswordGUI().setVisible(true);
            }
        });
    }
    private javax.swing.JPasswordField passwordField;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JButton passwordCheckBackBtn;
    private javax.swing.JButton passwordCheckEnterBtn;
    private javax.swing.JLabel passwordCheckLabel;
    private javax.swing.JLabel passwordCheckTitle;
    // End of variables declaration//GEN-END:variables
}
