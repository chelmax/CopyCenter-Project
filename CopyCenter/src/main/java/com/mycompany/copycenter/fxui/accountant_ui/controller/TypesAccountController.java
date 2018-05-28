/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.copycenter.fxui.accountant_ui.controller;

import com.mycompany.copycenter.entity.Types;
import com.mycompany.copycenter.fxui.accountant_ui.view.AddTypeDialog;
import com.mycompany.copycenter.fxui.accountant_ui.view.TypesAccountPane;
import com.mycompany.copycenter.fxui.models.accountant.TypesTableViewModel;
import com.mycompany.copycenter.fxui.ex.WarningDialog;
import com.mycompany.copycenter.fxui.models.accountant.AddTypeModel;
import com.mycompany.copycenter.fxui.models.accountant.TypeRemoverModel;
import java.util.Map;
import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.TableView;
import javafx.util.Pair;

/**
 *
 * @author max19
 */
public class TypesAccountController {
    
    private static final TypeRemoverModel REMOVE_MODEL = new TypeRemoverModel();
    private static final AddTypeModel ADD_MODEL= new AddTypeModel();
    
    public static void deleteTypeButtonActionController(TypesAccountPane view) {
        Types selected = (Types) ((TableView) view.getCenter()).getSelectionModel().getSelectedItem();
        if(selected != null){
            StringBuilder sb = new StringBuilder();
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Delete Diealog");
            alert.setContentText("Are u sure to delete the selected row?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK){
                REMOVE_MODEL.update(
                        selected.getName()
                );
                view.setCenter(new TypesTableViewModel());
            }
        } else{
            Alert alert = new WarningDialog("Wrong action!", "You have to select a row to be deleted at first.");
            alert.showAndWait();
        }
    }

    public static void addTypeButtonActionController(TypesAccountPane view) {
        Dialog dialog = new AddTypeDialog(ADD_MODEL);
        Optional<Pair<String, Float>> result = dialog.showAndWait();
        if (result.isPresent()){
            Pair<String, Float> pair = result.get();
            ADD_MODEL.addType(pair.getKey(), pair.getValue());
            view.setCenter(new TypesTableViewModel());
        }
    }
    
}
