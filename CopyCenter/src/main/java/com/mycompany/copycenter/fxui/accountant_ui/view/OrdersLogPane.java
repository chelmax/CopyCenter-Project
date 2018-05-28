/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.copycenter.fxui.accountant_ui.view;

import com.mycompany.copycenter.entity.Orders;
import com.mycompany.copycenter.fxui.models.OrdersTableViewModel;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;

/**
 *
 * @author max19
 */
public class OrdersLogPane extends BorderPane{
    
    private StackPane topPane;
    private TableView<Orders> centerPane;
    

    public OrdersLogPane() {
        initNodes();
        layoutNodes();
    }

    private void initNodes() {
        topPane = new StackPane();
        centerPane = new OrdersTableViewModel<>("");
               
        Label topLabel = new Label("Orders Log\t\t\t\t\t\t\t\t");
        topPane.getChildren().add(topLabel);
    }

    private void layoutNodes() {
        this.setTop(topPane);
        this.setCenter(centerPane);
    }
    
    
}
