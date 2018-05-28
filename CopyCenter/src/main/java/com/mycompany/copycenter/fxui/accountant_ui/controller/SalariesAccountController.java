/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.copycenter.fxui.accountant_ui.controller;

import com.mycompany.copycenter.entity.Users;
import com.mycompany.copycenter.fxui.accountant_ui.view.SalariesAccountPane;
import com.mycompany.copycenter.fxui.models.accountant.SalariesTableViewModel;
import com.mycompany.copycenter.fxui.ex.ErrorDialog;
import com.mycompany.copycenter.fxui.ex.WarningDialog;
import com.mycompany.copycenter.fxui.view.HomePane;
import com.mycompany.copycenter.fxui.models.accountant.ChangeRateModel;
import com.mycompany.copycenter.fxui.models.accountant.SalariesTableModel;
import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.BorderPane;

/**
 *
 * @author max19
 */
public class SalariesAccountController {

    private static final ChangeRateModel CHANGE_MODEL = new ChangeRateModel();
    private static final SalariesTableModel PAYOFF_MODEL = new SalariesTableModel();
    
    public static void alterRateButtonActionController(SalariesAccountPane view) {
        Users selected = (Users) ((TableView) view.getCenter()).getSelectionModel().getSelectedItem();
        if(selected != null){
            StringBuilder sb = new StringBuilder();
            TextInputDialog dialog = new TextInputDialog();
            dialog.setTitle("Rate Dialog");
            dialog.setHeaderText("Changing rate of the selected user");
            dialog.setContentText("Please enter new rate:");
            Optional<String> result = dialog.showAndWait();
            if (result.isPresent()){
                try{
                    CHANGE_MODEL.update(
                    sb.append(selected.getName())
                            .append(" ")
                            .append(selected.getSurname())
                            .append(" ")
                            .append(Integer.parseInt(result.get()))
                            .toString()
                    );
                    view.setCenter(new SalariesTableViewModel());
                } catch(NumberFormatException notInteger){
                    Alert alert = new ErrorDialog("Wrong action!", "The input must be an integer");
                    alert.showAndWait();
                }
            }
        } else{
            Alert alert = new WarningDialog("Wrong action!", "You have to select a row to be changed at first.");
            alert.showAndWait();
        }
    }
    
    public static void payOffButtonActionController(SalariesAccountPane view) {
        int size = ((TableView) view.getCenter()).getItems().size();
        float sum = 0;
        for(int i = 0; i < size; i++)   
            sum += (Float) ((TableColumn) ((TableView) view.getCenter()).getColumns().get(4)).getCellData(i);
        PAYOFF_MODEL.payOff(sum);        
        ((BorderPane) view.getParent()).setCenter(new HomePane());
    }
    
}
