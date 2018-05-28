/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.copycenter.fxui.view;

import com.mycompany.copycenter.fxui.controller.AuthController;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;

/**
 *
 * @author max19
 */
public class Authorization extends BorderPane {
    
    private StackPane topPane;
    private StackPane centerPane;
    private StackPane bottomPane;
    

    public Authorization() {
        initNodes();
        layoutNodes();
    }

    private void initNodes() {
        topPane = new StackPane();
        centerPane = new StackPane();
        bottomPane = new StackPane();
        
        topPane.setAlignment(Pos.CENTER);
        topPane.setPadding(new Insets (10, 0, 0, 0));
        
        Label authLabel = new Label("Authorization");
        authLabel.setFont(new Font("Arial Bold", 25));
        
        topPane.getChildren().add(authLabel);
        
        centerPane.setAlignment(Pos.CENTER);
        
        VBox textFieldPane  = new VBox();
        textFieldPane.setSpacing(10);
        textFieldPane.setPadding(new Insets (25, 20, 20, 20));
        
        Label nameLabel = new Label("Name: ");
        Label surnameLabel = new Label("Surname: ");
        Label passwordLabel = new Label("Password: ");

        TextField nameField = new TextField();
        TextField surnameField = new TextField();
        PasswordField passwordField = new PasswordField();
        passwordField.setText("password");
        passwordField.focusedProperty().addListener((
                ObservableValue<? extends Boolean> observable, 
                Boolean oldValue, 
                Boolean newValue
        ) -> {
            AuthController.passwordFieldFocusGainedController(passwordField, newValue);
        });
        
        textFieldPane.getChildren().add(nameLabel);
        textFieldPane.getChildren().add(nameField);
        textFieldPane.getChildren().add(surnameLabel);
        textFieldPane.getChildren().add(surnameField);
        textFieldPane.getChildren().add(passwordLabel);
        textFieldPane.getChildren().add(passwordField);
        
        centerPane.getChildren().add(textFieldPane);
        
        HBox btnPane  = new HBox();
        btnPane.setAlignment(Pos.CENTER);
        btnPane.setSpacing(10);
        btnPane.setPadding(new Insets (0, 0, 20, 0));
        
        Button loginButton = new Button("Log In");
        Button signupButton = new Button("Sign Up");
        
        loginButton.setOnAction((ActionEvent t) -> {
            AuthController.logInButtonActionController(
                    this,
                    nameField.getText(),
                    surnameField.getText(),
                    passwordField.getText()
            );
        });
        
        signupButton.setOnAction((ActionEvent t) -> {
            AuthController.signUpButtonActionController(
                    this
            );
        });
        
        btnPane.getChildren().add(loginButton);
        loginButton.setPrefSize(75, 25);
        btnPane.getChildren().add(signupButton);
        signupButton.setPrefSize(75, 25);

        bottomPane.getChildren().add(btnPane);

    }

    private void layoutNodes() {
        this.setTop(topPane);
        this.setCenter(centerPane);
        this.setBottom(bottomPane);
    }
    
    
    
}
