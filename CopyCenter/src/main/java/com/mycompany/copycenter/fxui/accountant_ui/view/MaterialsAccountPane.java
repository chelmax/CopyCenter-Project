/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.copycenter.fxui.accountant_ui.view;

import com.mycompany.copycenter.fxui.models.accountant.MaterialsTableViewModel;
import com.mycompany.copycenter.entity.Materials;
import com.mycompany.copycenter.fxui.accountant_ui.controller.MaterialsAccountController;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

/**
 *
 * @author max19
 */
public class MaterialsAccountPane extends BorderPane{
    
    private StackPane topPane;
    private TableView<Materials> centerPane;
    private VBox rightPane;
    

    public MaterialsAccountPane() {
        initNodes();
        layoutNodes();
    }

    private void initNodes() {
        topPane = new StackPane();
        centerPane = new MaterialsTableViewModel();
        rightPane = new VBox();
               
        Label topLabel = new Label("Materials Account Table\t\t\t\t\t\t\t\t");
        topPane.getChildren().add(topLabel);
        
        rightPane.setAlignment(Pos.CENTER);
        rightPane.setPadding(new Insets(0,50,0, 50));
        rightPane.setSpacing(150);
        Button alterBtn = new Button("Add material");
        alterBtn.setOnAction((ActionEvent t) -> {
            MaterialsAccountController.addMaterialButtonActionController(
                    this
            );
        });
        alterBtn.setPrefSize(150, 50);
        Button payOffBtn = new Button("Order materials");
        payOffBtn.setOnAction((ActionEvent t) -> {
            MaterialsAccountController.orderMaterialButtonActionController(
                    this
            );
        });
        payOffBtn.setPrefSize(150, 50);
        Button changeBtn = new Button("Change cost");
        changeBtn.setOnAction((ActionEvent t) -> {
            MaterialsAccountController.changeCostButtonActionController(
                    this
            );
        });
        changeBtn.setPrefSize(150, 50);
        rightPane.getChildren().addAll(alterBtn, payOffBtn, changeBtn);
    }

    private void layoutNodes() {
        this.setTop(topPane);
        this.setRight(rightPane);
        this.setCenter(centerPane);
    }
       
}