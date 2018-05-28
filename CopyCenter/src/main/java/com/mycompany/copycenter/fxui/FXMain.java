/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.copycenter.fxui;

import com.mycompany.copycenter.fxui.view.Authorization;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author max19
 */
public class FXMain extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        Scene scene = new Scene(new Authorization(), 300, 350);
        //Scene scene = new Scene(new ManagerMainPane(), 1600, 800);                           
                           
        primaryStage.setTitle("Copy Center App");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
        primaryStage.setOnCloseRequest(event -> {
            System.exit(0);
        });
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
