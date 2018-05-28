/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.copycenter.fxui.accountant_ui.view;

import com.mycompany.copycenter.fxui.ex.ErrorDialog;
import com.mycompany.copycenter.fxui.models.accountant.AddTypeModel;
import java.util.Map;
import java.util.Optional;
import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.util.Pair;

/**
 *
 * @author max19
 */
public class AddTypeDialog extends Dialog {
    
    private TextField name;
    private TextField price;
    private TextArea text;
    private final AddTypeModel model;
    
    public AddTypeDialog(AddTypeModel model){
        this.model = model;
        
        name = new TextField();
        price = new TextField();
        text = new TextArea();
        text.setPrefSize(350, 200);
        text.setEditable(false);
        
        setTitle("Add Material Dialog");
        setHeaderText("Input characteristics of the new material below");
        getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
        GridPane root = new GridPane();

        root.setPadding(new Insets(20));
        root.setHgap(25);
        root.setVgap(15);

        Button addMatBtn = new Button("Add Material");
        addMatBtn.setOnAction((ActionEvent t) -> {
                BindMaterialToTypeDialog dialog = new BindMaterialToTypeDialog(model); 
                Optional<String> result = dialog.showAndWait();
                if(result.isPresent()){
                    refreshMaterialsArea();
                }
        });
        Button deleteMatBtn = new Button("Delete Material");
        deleteMatBtn.setOnAction((ActionEvent t) -> {
                RemoveMaterialFromTypeDialog dialog = new RemoveMaterialFromTypeDialog(model); 
                Optional<String> result = dialog.showAndWait();
                if(result.isPresent()){
                    refreshMaterialsArea();
                }
        });

        root.add(new Label("Name"), 0, 0);
        root.add(new Label("Price"), 0, 1);
        root.add(name, 1, 0);
        root.add(price, 1, 1);
        root.add(text, 0, 2, 2, 1);
        GridPane.setHalignment(addMatBtn, HPos.LEFT);
        root.add(addMatBtn, 0, 3);
        GridPane.setHalignment(deleteMatBtn, HPos.RIGHT);
        root.add(deleteMatBtn, 1, 3);
        
        getDialogPane().setContent(root);
        
        setResultConverter(dialogButton -> {
            if (dialogButton == ButtonType.OK) {
                try{
                    String nameValue = name.getText();
                    if(nameValue.isEmpty() || text.getText().isEmpty())
                        throw new Exception();
                    Float priceValue = Float.parseFloat(price.getText());
                    return new Pair(nameValue, priceValue);
                } catch (Exception ex){
                    Alert alert = new ErrorDialog(
                            "Wrong action!", 
                            "All fields must be fulfilled and price must be a float."
                    );
                    alert.showAndWait();
                }
            }
            return null;
        });
    }
    
    public void refreshMaterialsArea(){
        StringBuilder sb = new StringBuilder(); 
        Map<String, Integer> materialsSizeMap = model.getAddedMaterialsSizeMap();
        materialsSizeMap.keySet().forEach((key) -> {
            sb.append("Needed ")
                    .append(materialsSizeMap.get(key))
                    .append(" pieces of ")
                    .append(key)
                    .append("\n");
        });
        text.setText(sb.toString());
    }
}
