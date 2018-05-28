/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.copycenter.fxui.accountant_ui.view;

import com.mycompany.copycenter.fxui.models.accountant.SalariesTableViewModel;
import com.mycompany.copycenter.entity.Users;
import com.mycompany.copycenter.fxui.accountant_ui.controller.SalariesAccountController;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

/**
 *
 * @author max19
 */
public class SalariesAccountPane extends BorderPane{
    
    private StackPane topPane;
    private TableView<Users> centerPane;
    private VBox rightPane;
    

    public SalariesAccountPane() {
        initNodes();
        layoutNodes();
    }

    private void initNodes() {
        topPane = new StackPane();
        centerPane = new SalariesTableViewModel();
        rightPane = new VBox();
               
        Label topLabel = new Label("Salaries Account Table\t\t\t\t\t\t\t\t");
        topPane.getChildren().add(topLabel);
        
        rightPane.setAlignment(Pos.CENTER);
        rightPane.setPadding(new Insets(0,50,0, 50));
        rightPane.setSpacing(300);
        Button alterBtn = new Button("Alter Rate");
        alterBtn.setOnAction((ActionEvent t) -> {
            SalariesAccountController.alterRateButtonActionController(
                    this
            );
        });
        alterBtn.setPrefSize(100, 50);
        Button payOffBtn = new Button("Pay Off");
        payOffBtn.setOnAction((ActionEvent t) -> {
            SalariesAccountController.payOffButtonActionController(
                    this
            );
        });
        payOffBtn.setPrefSize(100, 50);
        rightPane.getChildren().addAll(alterBtn, payOffBtn);
    }

    private void layoutNodes() {
        this.setTop(topPane);
        this.setRight(rightPane);
        this.setCenter(centerPane);
    }
       
}
