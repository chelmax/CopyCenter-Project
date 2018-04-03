/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.copycenter.ui;

import com.mycompany.copycenter.ex.ui.WrongInput;
import com.mycompany.copycenter.ui.models.Authorization;

/**
 *
 * @author max19
 */
public class SignupFrame extends javax.swing.JFrame {

    private final Authorization model;
    
    /**
     * Creates new form SignupForm
     */
    public SignupFrame() {
        this.model = new Authorization();
        init();
    }
    
    private void init() {
        initComponents();
        this.setResizable(false);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nameField = new javax.swing.JTextField();
        passwordLabel = new javax.swing.JLabel();
        loginLabel = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();
        surnameLabel = new javax.swing.JLabel();
        surnameField = new javax.swing.JTextField();
        rpasswordLabel = new javax.swing.JLabel();
        rpasswordField = new javax.swing.JPasswordField();
        postLabel = new javax.swing.JLabel();
        postBox = new javax.swing.JComboBox<>();
        registerButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        passwordLabel.setText("Password:");

        loginLabel.setText("Name:");

        surnameLabel.setText("Surname:");

        rpasswordLabel.setText("Repeat password:");

        postLabel.setText("Post:");

        postBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "operator", "manager", "accountant" }));

        registerButton.setText("Register");
        registerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(postLabel)
                            .addComponent(passwordLabel)
                            .addComponent(rpasswordLabel)
                            .addComponent(rpasswordField)
                            .addComponent(surnameLabel)
                            .addComponent(loginLabel)
                            .addComponent(nameField)
                            .addComponent(surnameField, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                            .addComponent(passwordField)
                            .addComponent(postBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addComponent(registerButton)))
                .addContainerGap(116, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(loginLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(surnameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(surnameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(postLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(postBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(passwordLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(rpasswordLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rpasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(registerButton)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void registerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerButtonActionPerformed
        if(model.signup(
                nameField.getText(), 
                surnameField.getText(), 
                passwordField.getPassword(), 
                rpasswordField.getPassword(), 
                (String) postBox.getSelectedItem()
        )){    
            this.dispose();
        } else{
            new WrongInput(this, true).setVisible(true);
        }
    }//GEN-LAST:event_registerButtonActionPerformed
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel loginLabel;
    private javax.swing.JTextField nameField;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JComboBox<String> postBox;
    private javax.swing.JLabel postLabel;
    private javax.swing.JButton registerButton;
    private javax.swing.JPasswordField rpasswordField;
    private javax.swing.JLabel rpasswordLabel;
    private javax.swing.JTextField surnameField;
    private javax.swing.JLabel surnameLabel;
    // End of variables declaration//GEN-END:variables
}
