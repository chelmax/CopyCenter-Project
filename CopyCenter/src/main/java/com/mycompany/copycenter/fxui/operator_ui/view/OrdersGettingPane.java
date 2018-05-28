/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.copycenter.fxui.operator_ui.view;

import com.mycompany.copycenter.entity.Orders;
import com.mycompany.copycenter.fxui.operator_ui.controller.GettingTableController;
import com.mycompany.copycenter.fxui.models.OrdersTableViewModel;
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
public class OrdersGettingPane extends BorderPane{
    
    private StackPane topPane;
    private TableView<Orders> centerPane;
    private VBox rightPane;
    

    public OrdersGettingPane() {
        initNodes();
        layoutNodes();
    }

    private void initNodes() {
        topPane = new StackPane();
        centerPane = new OrdersTableViewModel<>("Waiting for processing");
        rightPane = new VBox();
               
        Label topLabel = new Label("New Orders Table\t\t\t\t\t\t\t\t");
        topPane.getChildren().add(topLabel);
        
        rightPane.setAlignment(Pos.CENTER);
        rightPane.setPadding(new Insets(0,50,0, 50));
        rightPane.setSpacing(300);
        Button takeOneBtn = new Button("Take one");
        takeOneBtn.setOnAction((ActionEvent t) -> {
            GettingTableController.takeOneButtonActionPerformed(
                    this
            );
        });
        takeOneBtn.setPrefSize(100, 50);
        rightPane.getChildren().add(takeOneBtn);
    }

    private void layoutNodes() {
        this.setTop(topPane);
        this.setRight(rightPane);
        this.setCenter(centerPane);
    }
    
}
