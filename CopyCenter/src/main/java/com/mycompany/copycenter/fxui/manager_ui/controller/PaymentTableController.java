/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.copycenter.fxui.manager_ui.controller;

import com.mycompany.copycenter.entity.Orders;
import com.mycompany.copycenter.fxui.ex.WarningDialog;
import com.mycompany.copycenter.fxui.manager_ui.view.ManagerMessages;
import com.mycompany.copycenter.fxui.manager_ui.view.OrdersPaymentPane;
import com.mycompany.copycenter.fxui.models.OrdersTableViewModel;
import com.mycompany.copycenter.fxui.models.manager.PaymentModel;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;

/**
 *
 * @author max19
 */
public class PaymentTableController {
    
    private static final PaymentModel MODEL = new PaymentModel();
    
    public static void paymentButtonActionPerformed(OrdersPaymentPane view) {
        Orders selected = (Orders) ((TableView) view.getCenter()).getSelectionModel().getSelectedItem();
        if(selected != null){
            MODEL.update(String.valueOf(selected.getIdOrder()));
            view.setCenter(new OrdersTableViewModel<>("Processed"));
            ((ManagerMessages) ((BorderPane) view.getParent()).getLeft()).updateMsgArea();
        } else{
            Alert alert = new WarningDialog("Wrong action!", "You have to select a row to be paid at first.");
            alert.showAndWait();
        }
    }
    
}
