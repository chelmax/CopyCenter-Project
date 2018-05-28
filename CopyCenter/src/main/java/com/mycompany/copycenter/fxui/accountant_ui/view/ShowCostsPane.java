/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.copycenter.fxui.accountant_ui.view;

import com.mycompany.copycenter.fxui.accountant_ui.controller.ShowCostsController;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

/**
 *
 * @author max19
 */
public class ShowCostsPane extends BorderPane{
    
    private StackPane topPane;
    private GridPane centerPane;
    private VBox bottomPane;
    

    public ShowCostsPane() {
        initNodes();
        layoutNodes();
    }

    private void initNodes() {
        topPane = new StackPane();
        centerPane = new CostsPane();
        bottomPane = new VBox();
        
        Label topLabel = new Label("Current costs info");
        topLabel.setFont(new Font("Arial Bold", 25));
        topPane.getChildren().add(topLabel);
        
        Button payOffBtn = new Button("Pay Off");
        payOffBtn.setOnAction((ActionEvent t) -> {
            ShowCostsController.payOffButtonActionPerformed(
                    this
                    
            );
        });
        payOffBtn.setPrefSize(150, 50);
        bottomPane.getChildren().addAll(payOffBtn);
        bottomPane.setAlignment(Pos.CENTER);
        bottomPane.setPadding(new Insets(0,50,0, 50));
        bottomPane.setSpacing(300);
    }

    private void layoutNodes() {
        this.setTop(topPane);
        this.setCenter(centerPane);
        this.setBottom(bottomPane);
    }
    
    
}
