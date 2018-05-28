/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.copycenter.fxui.view;

import com.mycompany.copycenter.fxui.controller.AuthController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

/**
 *
 * @author max19
 */
public class Registration extends BorderPane{
    
    private StackPane topPane;
    private StackPane centerPane;
    private StackPane bottomPane;
    

    public Registration() {
        initNodes();
        layoutNodes();
    }

    private void initNodes() {
        topPane = new StackPane();
        centerPane = new StackPane();
        bottomPane = new StackPane();
        
        topPane.setAlignment(Pos.CENTER);
        topPane.setPadding(new Insets (10, 0, 0, 0));
        
        Label authLabel = new Label("Registration");
        authLabel.setFont(new Font("Arial Bold", 25));
        
        topPane.getChildren().add(authLabel);
        
        centerPane.setAlignment(Pos.CENTER);
        
        VBox textFieldPane  = new VBox();
        textFieldPane.setSpacing(10);
        textFieldPane.setPadding(new Insets (25, 20, 20, 20));
        
        Label nameLabel = new Label("Name: ");
        Label surnameLabel = new Label("Surname: ");
        Label postLabel = new Label("Post: ");
        Label passwordLabel = new Label("Password: ");
        Label rpasswordLabel = new Label("Repeat password: ");

        TextField nameField = new TextField();
        TextField surnameField = new TextField();
        
        String[] test = {
                "manager",
                "operator",
                "accountant"
        };
        
        ObservableList<String> options = FXCollections.observableArrayList(
                test
        );
        ComboBox postBox = new ComboBox(options);
        postBox.setValue("manager");
        
        PasswordField passwordField = new PasswordField();
        PasswordField rpasswordField = new PasswordField();
        
        textFieldPane.getChildren().add(nameLabel);
        textFieldPane.getChildren().add(nameField);
        textFieldPane.getChildren().add(surnameLabel);
        textFieldPane.getChildren().add(surnameField);
        textFieldPane.getChildren().add(postLabel);
        textFieldPane.getChildren().add(postBox);
        textFieldPane.getChildren().add(passwordLabel);
        textFieldPane.getChildren().add(passwordField);
        textFieldPane.getChildren().add(rpasswordLabel);
        textFieldPane.getChildren().add(rpasswordField);
        
        
        postBox.setPrefWidth(400);
        
        centerPane.getChildren().add(textFieldPane);
        
        HBox btnPane  = new HBox();
        btnPane.setAlignment(Pos.CENTER);
        btnPane.setPadding(new Insets (0, 0, 20, 0));
        
        Button registerButton = new Button("Register");
        registerButton.setOnAction((ActionEvent t) -> {
            AuthController.registerButtonActionController(
                    this,
                    nameField.getText(),
                    surnameField.getText(),
                    passwordField.getText(),
                    rpasswordField.getText(),
                    (String) postBox.getValue()
            );
        });
        btnPane.getChildren().add(registerButton);

        bottomPane.getChildren().add(btnPane);

    }

    private void layoutNodes() {
        this.setTop(topPane);
        this.setCenter(centerPane);
        this.setBottom(bottomPane);
    }
}
