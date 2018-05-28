/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.copycenter.fxui.view;

import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;

/**
 *
 * @author max19
 */
public class HomePane extends StackPane{
    
    public HomePane() {
        initNodes();
    }

    private void initNodes() {
        Label centerLabel = new Label("Copy Center application for employees \n Version 2.0");
        centerLabel.setFont(new Font("Arial Bold", 18));
        this.getChildren().add(centerLabel);
    }
    
}
