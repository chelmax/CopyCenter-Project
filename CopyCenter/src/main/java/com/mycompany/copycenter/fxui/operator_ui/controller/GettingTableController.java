/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.copycenter.fxui.operator_ui.controller;

import com.mycompany.copycenter.entity.Orders;
import com.mycompany.copycenter.fxui.ex.WarningDialog;
import com.mycompany.copycenter.fxui.operator_ui.view.OperatorMessages;
import com.mycompany.copycenter.fxui.operator_ui.view.OrdersGettingPane;
import com.mycompany.copycenter.fxui.models.OrdersTableViewModel;
import com.mycompany.copycenter.fxui.models.operator.GettingModel;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;

/**
 *
 * @author max19
 */
public class GettingTableController {

    
    private static final GettingModel MODEL = new GettingModel();
    
    public static void takeOneButtonActionPerformed(OrdersGettingPane view) {
        Orders selected = (Orders) ((TableView) view.getCenter()).getSelectionModel().getSelectedItem();
        if(selected != null){
            MODEL.update(String.valueOf(selected.getIdOrder()));
            view.setCenter(new OrdersTableViewModel<>("Waiting for processing"));
            ((OperatorMessages) ((BorderPane) view.getParent()).getLeft()).updateMsgArea();
        } else{
            Alert alert = new WarningDialog("Wrong action!", "You have to select a row to be taken at first.");
            alert.showAndWait();
        }    
    }
    
}
