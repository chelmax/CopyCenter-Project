/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.copycenter.fxui.accountant_ui.view;

import com.mycompany.copycenter.fxui.ex.ErrorDialog;
import java.util.ArrayList;
import java.util.List;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 *
 * @author max19
 */
public class AddMaterialDialog extends Dialog {
    
    private TextField name;
    private TextField quantity;
    private TextField cost;
    
    public AddMaterialDialog(){
        name = new TextField();
        quantity = new TextField();
        cost = new TextField();
        
        setTitle("Add Material Dialog");
        setHeaderText("Input characteristics of the new material below");
        
        getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
        
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));

        grid.add(new Label("Name:"), 0, 0);
        grid.add(name, 1, 0);
        grid.add(new Label("Quantity:"), 0, 1);
        grid.add(quantity, 1, 1);
        grid.add(new Label("Cost:"), 0, 2);
        grid.add(cost, 1, 2); 
        
        getDialogPane().setContent(grid);
        
        setResultConverter(dialogButton -> {
            if (dialogButton == ButtonType.OK) {
                try{
                    String nameValue = name.getText();
                    if(nameValue.isEmpty()) throw new Exception();
                    Integer quantityValue =  Integer.parseInt(quantity.getText());
                    Float costValue = Float.parseFloat(cost.getText());
                    List<Object> resList = new ArrayList<>();
                    resList.add(nameValue);
                    resList.add(quantityValue);
                    resList.add(costValue);
                    return resList;
                } catch (Exception ex){
                    Alert alert = new ErrorDialog(
                            "Wrong action!", 
                            "The quantity must be an integer and cost must be a float"
                    );
                    alert.showAndWait();
                }
            }
            return null;
        });
    }
    
}
