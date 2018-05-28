/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.copycenter.fxui.accountant_ui.view;

import com.mycompany.copycenter.fxui.ex.ErrorDialog;
import com.mycompany.copycenter.fxui.models.accountant.AddTypeModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

/**
 *
 * @author max19
 */
public class RemoveMaterialFromTypeDialog extends Dialog {
    
    private ComboBox materialsList;
    private final AddTypeModel model;
    
    public RemoveMaterialFromTypeDialog(AddTypeModel model){
        this.model = model;
        
        setTitle("Remove Material Dialog");
        getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
        
        HBox content = new HBox();
        content.setSpacing(0);
        Label firstPart = new Label("The name of material to be deleted is ");
        ObservableList<String> options = FXCollections.observableArrayList(
                this.model.getAddedMaterialsDialogBoxData()
        );
        materialsList = new ComboBox(options);
        
        content.getChildren().addAll(firstPart, materialsList);
        getDialogPane().setContent(content);
        
        setResultConverter(dialogButton -> {
            if (dialogButton == ButtonType.OK) {
                try{
                    String materialName = (String) materialsList.getSelectionModel().getSelectedItem();
                    if(materialName.isEmpty()) throw new Exception();
                    model.deleteMaterial(materialName);
                    return true;
                } catch (Exception ex){
                    Alert alert = new ErrorDialog(
                            "Wrong action!", 
                            "The quantity must be an integer"
                    );
                    alert.show();
                }
            }
            return null;
        });
    }
}
