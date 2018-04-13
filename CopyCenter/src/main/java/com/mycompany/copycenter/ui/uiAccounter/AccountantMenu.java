/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.copycenter.ui.uiAccounter;

import com.mycompany.copycenter.tools.Messanger;
import com.mycompany.copycenter.tools.interfaces.MessangerMenu;
import com.mycompany.copycenter.ui.UserInfoFrame;
import com.mycompany.copycenter.ui.models.OrderLogModel;

/**
 *
 * @author max19
 */
public class AccountantMenu extends javax.swing.JFrame implements MessangerMenu{

    /**
     * Creates new form AccounterMenu
     */
    public AccountantMenu() {
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

        salariesButton = new javax.swing.JButton();
        materialsButton = new javax.swing.JButton();
        costsButton = new javax.swing.JButton();
        profileButton = new javax.swing.JButton();
        typesLabel = new javax.swing.JButton();
        logButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        msgArea = new javax.swing.JTextArea();
        refreshMsgButton = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        salariesButton.setText("Account salaries");
        salariesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salariesButtonActionPerformed(evt);
            }
        });

        materialsButton.setText("Account materials");
        materialsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                materialsButtonActionPerformed(evt);
            }
        });

        costsButton.setText("Show costs");
        costsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                costsButtonActionPerformed(evt);
            }
        });

        profileButton.setText("Show profile");
        profileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profileButtonActionPerformed(evt);
            }
        });

        typesLabel.setText("Acccount types");
        typesLabel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                typesLabelActionPerformed(evt);
            }
        });

        logButton.setText("Orders log");
        logButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logButtonActionPerformed(evt);
            }
        });

        msgArea.setColumns(20);
        msgArea.setRows(5);
        jScrollPane1.setViewportView(msgArea);
        Messanger msg  = new Messanger("accountant");
        msgArea.setText(msg.getMsgText());

        refreshMsgButton.setText("Refresh messages");
        refreshMsgButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshMsgButtonActionPerformed(evt);
            }
        });

        jButton2.setText("Clear messages");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(materialsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(salariesButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(costsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(profileButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(typesLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(logButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(refreshMsgButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(profileButton)
                .addGap(41, 41, 41)
                .addComponent(logButton)
                .addGap(42, 42, 42)
                .addComponent(typesLabel)
                .addGap(44, 44, 44)
                .addComponent(salariesButton)
                .addGap(51, 51, 51)
                .addComponent(materialsButton)
                .addGap(48, 48, 48)
                .addComponent(costsButton)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(refreshMsgButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void salariesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salariesButtonActionPerformed
        new SalariesTableFrame().setVisible(true);
    }//GEN-LAST:event_salariesButtonActionPerformed

    private void costsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_costsButtonActionPerformed
        new CostsFrame().setVisible(true);
    }//GEN-LAST:event_costsButtonActionPerformed

    private void profileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profileButtonActionPerformed
        new UserInfoFrame().setVisible(true);
    }//GEN-LAST:event_profileButtonActionPerformed

    private void materialsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_materialsButtonActionPerformed
        new MaterialsTableFrame().setVisible(true);
    }//GEN-LAST:event_materialsButtonActionPerformed

    private void typesLabelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_typesLabelActionPerformed
        new TypesTableFrame().setVisible(true);
    }//GEN-LAST:event_typesLabelActionPerformed

    private void logButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logButtonActionPerformed
        new  TableFrame(new OrderLogModel()).setVisible(true);
    }//GEN-LAST:event_logButtonActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
       Messanger.clearMsgMap();
    }//GEN-LAST:event_formWindowClosed

    private void refreshMsgButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshMsgButtonActionPerformed
        this.updateMsgArea();
    }//GEN-LAST:event_refreshMsgButtonActionPerformed
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Messanger.clearMsgMap();
        this.updateMsgArea();
    }//GEN-LAST:event_jButton2ActionPerformed

    @Override
    public void updateMsgArea(){
        Messanger msg  = new Messanger("accountant");
        msgArea.setText(msg.getMsgText());
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton costsButton;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton logButton;
    private javax.swing.JButton materialsButton;
    private javax.swing.JTextArea msgArea;
    private javax.swing.JButton profileButton;
    private javax.swing.JButton refreshMsgButton;
    private javax.swing.JButton salariesButton;
    private javax.swing.JButton typesLabel;
    // End of variables declaration//GEN-END:variables
}
