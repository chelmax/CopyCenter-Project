/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.copycenter.fxui.accountant_ui.controller;

import com.mycompany.copycenter.entity.Materials;
import com.mycompany.copycenter.fxui.accountant_ui.view.AddMaterialDialog;
import com.mycompany.copycenter.fxui.accountant_ui.view.MaterialsAccountPane;
import com.mycompany.copycenter.fxui.models.accountant.MaterialsTableViewModel;
import com.mycompany.copycenter.fxui.ex.ErrorDialog;
import com.mycompany.copycenter.fxui.ex.WarningDialog;
import com.mycompany.copycenter.fxui.models.accountant.AddMaterialModel;
import com.mycompany.copycenter.fxui.models.accountant.ChangeCostModel;
import com.mycompany.copycenter.fxui.models.accountant.OrderMaterialModel;
import java.util.List;
import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.Dialog;
import javafx.scene.control.TableView;
import javafx.scene.control.TextInputDialog;

/**
 *
 * @author max19
 */
public class MaterialsAccountController {
    
    private static final AddMaterialModel ADD_MODEL = new AddMaterialModel();
    private static final OrderMaterialModel ORDER_MODEL = new OrderMaterialModel();
    private static final ChangeCostModel CHANGE_MODEL = new ChangeCostModel();
                
    public static void addMaterialButtonActionController(MaterialsAccountPane view) {   //?!
        Dialog dialog = new AddMaterialDialog();
        Optional<List<Object>> result = dialog.showAndWait();
        if (result.isPresent()){
            List<Object> resList = result.get();
            ADD_MODEL.addMaterial(
                    (String) resList.get(0), 
                    (Integer) resList.get(1), 
                    (Float) resList.get(2)
            );
            view.setCenter(new MaterialsTableViewModel());
        }
    }
    
    public static void orderMaterialButtonActionController(MaterialsAccountPane view) {
        Materials selected = (Materials) ((TableView) view.getCenter()).getSelectionModel().getSelectedItem();
        if(selected != null){
            if(!selected.getName().equals("electricity") && !selected.getName().equals("lease")){
                StringBuilder sb = new StringBuilder();
                TextInputDialog dialog = new TextInputDialog();
                dialog.setTitle("Order Dialog");
                dialog.setHeaderText("Ordering selected material");
                dialog.setContentText("Please enter quantity of the ordered materials:");
                Optional<String> result = dialog.showAndWait();
                if (result.isPresent()){
                    try{
                        ORDER_MODEL.update(
                        sb.append(selected.getName())
                                .append(" ")
                                .append(Integer.parseInt(result.get()))
                                .toString()
                        );
                        view.setCenter(new MaterialsTableViewModel());
                    } catch(NumberFormatException notInteger){
                        Alert alert = new ErrorDialog("Wrong action!", "The input must be an integer");
                        alert.showAndWait();
                    }
                }
            } else{
                Alert alert = new WarningDialog("Wrong action!", "Selected row can't be lease or electricity");
                alert.showAndWait();
            }
        } else{
            Alert alert = new WarningDialog("Wrong action!", "You have to select a row to be ordered at first.");
            alert.showAndWait();
        }
    }
    
    public static void changeCostButtonActionController(MaterialsAccountPane view) {
        Materials selected = (Materials) ((TableView) view.getCenter()).getSelectionModel().getSelectedItem();
        if(selected != null){
            StringBuilder sb = new StringBuilder();
            TextInputDialog dialog = new TextInputDialog();
            dialog.setTitle("Change Cost Dialog");
            dialog.setHeaderText("Changing cost of the selected material");
            dialog.setContentText("Please new cost of the selected material: ");
            Optional<String> result = dialog.showAndWait();
            if (result.isPresent()){
                try{
                    CHANGE_MODEL.update(
                    sb.append(selected.getName())
                            .append(" ")
                            .append(Float.parseFloat(result.get()))
                            .toString()
                    );
                    view.setCenter(new MaterialsTableViewModel());
                } catch(NumberFormatException notInteger){
                    Alert alert = new ErrorDialog("Wrong action!", "The input must be a float");
                    alert.showAndWait();
                }
            }
        } else{
            Alert alert = new WarningDialog("Wrong action!", "You have to select a row to be ordered at first.");
            alert.showAndWait();
        }
    }

    
}
