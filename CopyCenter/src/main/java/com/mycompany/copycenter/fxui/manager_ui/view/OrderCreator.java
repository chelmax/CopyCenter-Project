/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.copycenter.fxui.manager_ui.view;

import com.mycompany.copycenter.fxui.manager_ui.controller.OrderCreatorController;
import com.mycompany.copycenter.fxui.models.manager.OrderCreatorModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

/**
 *
 * @author max19
 */
public class OrderCreator extends BorderPane{
    
    private final OrderCreatorModel model = new OrderCreatorModel();
            
    private StackPane topPane;
    private StackPane leftPane;
    private StackPane rightPane;
    private StackPane bottomPane;
    private ComboBox typeBox;
    private TextField sizeField;
    private TextField priceField;
    private TextField surnameField;
    private TextField contactsField;

    public OrderCreator() {
        initNodes();
        layoutNodes();
    }

    private void initNodes() {
        topPane = new StackPane();
        leftPane = new StackPane();
        rightPane = new StackPane();
        bottomPane = new StackPane();
        sizeField = new TextField();
        priceField = new TextField();
        priceField.setEditable(false);
        surnameField = new TextField();
        contactsField = new TextField();   
        
        String[] optionsArr = model.getTypesNames();
        ObservableList<String> options = FXCollections.observableArrayList(
                optionsArr
        );
        typeBox = new ComboBox(options);
        typeBox.setPrefWidth(200);
        
        topPane.setAlignment(Pos.CENTER);
        topPane.setPadding(new Insets (10, 0, 0, 0));
        
        Label topLabel = new Label("Order creation form");
        topLabel.setFont(new Font("Arial Bold", 25));
        
        topPane.getChildren().add(topLabel);
        
        VBox labels = new VBox();
        labels.setPadding(new Insets(25, 25, 25, 0));
        labels.setAlignment(Pos.CENTER);
        labels.setSpacing(60);
        ObservableList<Node> labelsChildren = labels.getChildren();
        labelsChildren.add(new Label("Type:              "));
        labelsChildren.add(new Label("Size:              "));
        Button priceButton  = new Button(" Count Price ");
        priceButton.setOnAction((ActionEvent t) -> {
            OrderCreatorController.priceButtonActionPerformed(
                    priceField, 
                    (String) typeBox.getValue(), 
                    sizeField.getText()
            );
        });
        labelsChildren.add(priceButton);
        labelsChildren.add(new Label("Client surname:"));
        labelsChildren.add(new Label("Client phone:   "));
        leftPane.getChildren().add(labels);
        
        VBox fields = new VBox();
        fields.setPadding(new Insets(25, 350, 25, 25));
        fields.setAlignment(Pos.CENTER);
        fields.setSpacing(50);
        ObservableList<Node> fieldsChildren = fields.getChildren();
        fieldsChildren.add(typeBox);
        fieldsChildren.add(sizeField);
        fieldsChildren.add(priceField);
        fieldsChildren.add(surnameField);
        fieldsChildren.add(contactsField);
        rightPane.getChildren().add(fields);
        
        
        HBox btnPane  = new HBox();
        btnPane.setAlignment(Pos.CENTER);
        btnPane.setPadding(new Insets (0, 0, 20, 0));
        
        Button createButton = new Button("Create");
        createButton.setOnAction((ActionEvent t) -> {
            OrderCreatorController.createButtonActionPerformed(
                    this,
                    (String) typeBox.getValue(), 
                    sizeField.getText(), 
                    priceField.getText(), 
                    surnameField.getText(), 
                    contactsField.getText()
            );
        });
        btnPane.getChildren().add(createButton);

        bottomPane.getChildren().add(btnPane);

    }

    private void layoutNodes() {
        this.setTop(topPane);
        this.setCenter(leftPane);
        this.setRight(rightPane);
        this.setBottom(bottomPane);
    }
    
}
