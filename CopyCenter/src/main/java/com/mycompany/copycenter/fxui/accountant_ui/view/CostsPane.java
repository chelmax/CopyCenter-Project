/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.copycenter.fxui.accountant_ui.view;

import com.mycompany.copycenter.fxui.models.accountant.CostsModel;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 *
 * @author max19
 */
public class CostsPane extends GridPane {
    
    private final CostsModel MODEL = new CostsModel();
    
    public CostsPane(){
        initNodes();
    }
    
    private void initNodes(){
        setHgap(50);
        setVgap(50);
        setAlignment(Pos.CENTER);
        
        TextField electricity = new TextField();
        electricity.setEditable(false);
        electricity.setText(MODEL.getEleCost());
        TextField lease = new TextField();
        lease.setEditable(false);
        lease.setText(MODEL.getLeaseCost());
        TextField materials = new TextField();
        materials.setEditable(false);
        materials.setText(MODEL.getMaterialCost());
        TextField salaries = new TextField();
        salaries.setEditable(false);
        salaries.setText(MODEL.getSalariesCost());
        TextField total = new TextField();
        total.setEditable(false);
        total.setText(MODEL.getTotalCost());


        add(new Label("Electricity:"), 0, 0);
        add(electricity, 1, 0);
        add(new Label("Lease:"), 0, 1);
        add(lease, 1, 1);
        add(new Label("Materials:"), 0, 2);
        add(materials, 1, 2); 
        add(new Label("Salaries:"), 0, 3);
        add(salaries, 1, 3); 
        add(new Label("Total:"), 0, 4);
        add(total, 1, 4); 
    }
    
}
