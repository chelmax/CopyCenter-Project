/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.copycenter.fxui.manager_ui.controller;

import com.mycompany.copycenter.fxui.ex.ErrorDialog;
import com.mycompany.copycenter.fxui.view.HomePane;
import com.mycompany.copycenter.fxui.manager_ui.view.OrderCreator;
import com.mycompany.copycenter.fxui.models.manager.OrderCreatorModel;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

/**
 *
 * @author max19
 */
public class OrderCreatorController {
    
    public static void priceButtonActionPerformed(TextField priceField, String type, String size){
        try{
            float price = new OrderCreatorModel().getPrice(type, size);
            priceField.setText(String.format("%.2f", price).replace(",", "."));
        }catch(Exception ex){
            Alert alert  = new ErrorDialog("Wrong Input!", "Check data and retry");
            alert.showAndWait();
        }
    }
    
    public static void createButtonActionPerformed(OrderCreator view, String type, String size, String price, String name, String phone){
        if(price.isEmpty()){
            Alert alert  = new ErrorDialog("Wrong Input!", "All order info must be filled");
            alert.showAndWait();
        }
        new OrderCreatorModel().createOrder(
                type,
                size,
                price,
                name,
                phone
        );
        ((BorderPane) view.getParent()).setCenter(new HomePane());
    }
    
}
