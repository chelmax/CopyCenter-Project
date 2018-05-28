/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.copycenter.fxui.view;

import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;

/**
 *
 * @author max19
 */
public abstract class MainPane extends BorderPane {
    
    private StackPane topPane;
    private BorderPane centerPane;
    private StackPane bottomPane;
    private BorderPane leftPane;
    

    public MainPane(StackPane top, BorderPane left) {
        initNodes(top, left);
        layoutNodes();
    }

    private void initNodes(StackPane top, BorderPane left) {
        topPane = top;
        centerPane = new BorderPane();
        leftPane = left;
        bottomPane = new StackPane();
        
        
        Label bottomLabel = new Label("COPYRIGHT © MAXIM IVANCHENKO 2018");
        bottomPane.getChildren().add(bottomLabel);
        
        centerPane.setCenter(new HomePane());
        
        centerPane.setPrefSize(1350, 400);
        leftPane.setPrefSize(250, 400);
    }

    private void layoutNodes() {
        this.setTop(topPane);
        this.setCenter(centerPane);
        this.setBottom(bottomPane);
        this.setLeft(leftPane);
    }
}
