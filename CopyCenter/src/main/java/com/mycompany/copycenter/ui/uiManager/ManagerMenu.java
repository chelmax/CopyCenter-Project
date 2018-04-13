/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.copycenter.ui.uiManager;

import com.mycompany.copycenter.tools.Messanger;
import com.mycompany.copycenter.tools.interfaces.MessangerMenu;
import com.mycompany.copycenter.ui.models.OrderPaymentModel;
import com.mycompany.copycenter.ui.OrdersTableFrame;
import com.mycompany.copycenter.ui.UserInfoFrame;

/**
 *
 * @author max19
 */
public class ManagerMenu extends javax.swing.JFrame implements MessangerMenu{

    /**
     * Creates new form ManagerMenu
     */
    public ManagerMenu() {
        init();
    }
    
    private void init(){
        initComponents();
        this.setResizable(false);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        profileButton = new javax.swing.JButton();
        createOrderButton = new javax.swing.JButton();
        payOrderButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        msgArea = new javax.swing.JTextArea();
        refreshMsgButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        profileButton.setText("Show profile");
        profileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profileButtonActionPerformed(evt);
            }
        });

        createOrderButton.setText("Create order");
        createOrderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createOrderButtonActionPerformed(evt);
            }
        });

        payOrderButton.setText("Confirm payment");
        payOrderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payOrderButtonActionPerformed(evt);
            }
        });

        msgArea.setColumns(20);
        msgArea.setRows(5);
        jScrollPane1.setViewportView(msgArea);
        Messanger msg  = new Messanger("manager");
        msgArea.setText(msg.getMsgText());

        refreshMsgButton.setText("Refresh messages");
        refreshMsgButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshMsgButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(createOrderButton, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                    .addComponent(profileButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(payOrderButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(refreshMsgButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(67, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(profileButton)
                .addGap(49, 49, 49)
                .addComponent(createOrderButton)
                .addGap(47, 47, 47)
                .addComponent(payOrderButton)
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(refreshMsgButton)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void createOrderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createOrderButtonActionPerformed
        new OrderCreatorFrame().setVisible(true);
    }//GEN-LAST:event_createOrderButtonActionPerformed

    private void profileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profileButtonActionPerformed
        new UserInfoFrame().setVisible(true);
    }//GEN-LAST:event_profileButtonActionPerformed

    private void payOrderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payOrderButtonActionPerformed
        new OrdersTableFrame(this, new OrderPaymentModel()).setVisible(true);
    }//GEN-LAST:event_payOrderButtonActionPerformed

    private void refreshMsgButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshMsgButtonActionPerformed
        this.updateMsgArea();
    }//GEN-LAST:event_refreshMsgButtonActionPerformed
    
    @Override
    public void updateMsgArea(){
        Messanger msg  = new Messanger("manager");
        msgArea.setText(msg.getMsgText());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton createOrderButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea msgArea;
    private javax.swing.JButton payOrderButton;
    private javax.swing.JButton profileButton;
    private javax.swing.JButton refreshMsgButton;
    // End of variables declaration//GEN-END:variables
}
