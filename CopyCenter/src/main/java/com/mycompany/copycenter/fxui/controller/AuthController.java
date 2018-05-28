/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.copycenter.fxui.controller;

import com.mycompany.copycenter.fxui.accountant_ui.view.AccountantMainPane;
import com.mycompany.copycenter.fxui.ex.ErrorDialog;
import com.mycompany.copycenter.fxui.manager_ui.view.ManagerMainPane;
import com.mycompany.copycenter.fxui.operator_ui.view.OperatorMainPane;
import com.mycompany.copycenter.fxui.view.Authorization;
import com.mycompany.copycenter.fxui.view.Registration;
import com.mycompany.copycenter.tools.CurrentUser;
import com.mycompany.copycenter.fxui.models.AuthModel;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 *
 * @author max19
 */
public class AuthController {
    
    public static void passwordFieldFocusGainedController(PasswordField passwordField, Boolean value){
       if(value)
           passwordField.setText("");
    }

    public static void logInButtonActionController(Authorization view, String name, String surname, String password) {
        if(new AuthModel().login(name, surname, password.toCharArray())){
            Scene scene = null;
            view.getScene().getWindow().hide();
            Stage stage = new Stage();
            stage.setOnCloseRequest(event -> {
                System.exit(0);
            });
            switch(CurrentUser.getCurrentUser().getPost()){
                case "manager": 
                    scene = new Scene(new ManagerMainPane(), 1600, 800);
                    break;
                case "operator":
                    scene = new Scene(new OperatorMainPane(), 1600, 800);
                    break;
                case "accountant":
                    scene = new Scene(new AccountantMainPane(), 1600, 800);           
            }
            stage.setScene(scene);   
            stage.setMaximized(true); 
            stage.show();
        } else{
            Alert alert  = new ErrorDialog("Wrong Password!", "Check data and retry");
            alert.showAndWait();
        }
    }

    public static void signUpButtonActionController(Authorization view) {
        Scene scene = view.getScene();
        scene.setRoot(new Registration());
        Window window = scene.getWindow();
        window.setHeight(550);
        window.setWidth(400);
        window.centerOnScreen();
    }

    public static void registerButtonActionController(Registration view, String name, String surname, String password, String rpassword, String post) {
        AuthModel model = new AuthModel();
        if(model.signup(name, surname, password.toCharArray(), rpassword.toCharArray(), post)){
            Scene scene = view.getScene();
            scene.setRoot(new Authorization());
            Window window = scene.getWindow();
            window.setHeight(350);
            window.setWidth(400);
            window.centerOnScreen();
        } else{
            Alert alert  = new ErrorDialog("Wrong Input!", "Check data and retry");
            alert.showAndWait();
        }
    }
    
}
