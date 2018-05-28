/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.copycenter.fxui.accountant_ui.view;

import com.mycompany.copycenter.fxui.models.accountant.TypesTableViewModel;
import com.mycompany.copycenter.entity.Types;
import com.mycompany.copycenter.fxui.accountant_ui.controller.TypesAccountController;
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
public class TypesAccountPane extends BorderPane{
    
    private StackPane topPane;
    private TableView<Types> centerPane;
    private VBox rightPane;
    

    public TypesAccountPane() {
        initNodes();
        layoutNodes();
    }

    private void initNodes() {
        topPane = new StackPane();
        centerPane = new TypesTableViewModel();
        rightPane = new VBox();
               
        Label topLabel = new Label("Types Account Table\t\t\t\t\t\t\t\t");
        topPane.getChildren().add(topLabel);
        
        rightPane.setAlignment(Pos.CENTER);
        rightPane.setPadding(new Insets(0,50,0, 50));
        rightPane.setSpacing(300);
        Button alterBtn = new Button("Add type");
        alterBtn.setOnAction((ActionEvent t) -> {
            TypesAccountController.addTypeButtonActionController(
                    this
            );
        });
        alterBtn.setPrefSize(100, 50);
        Button payOffBtn = new Button("Delete type");
        payOffBtn.setOnAction((ActionEvent t) -> {
            TypesAccountController.deleteTypeButtonActionController(
                    this
            );
        });
        payOffBtn.setPrefSize(100, 50);
        rightPane.getChildren().addAll(alterBtn, payOffBtn);
    }

    private void layoutNodes() {
        this.setTop(topPane);
        this.setRight(rightPane);
        this.setCenter(centerPane);
    }
    
}
