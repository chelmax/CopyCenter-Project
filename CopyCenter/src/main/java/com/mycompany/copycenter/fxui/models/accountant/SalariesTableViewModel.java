/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.copycenter.fxui.models.accountant;

import com.mycompany.copycenter.entity.Users;
import com.mycompany.copycenter.fxui.SalaryPropertyValueFactory;
import com.mycompany.copycenter.tools.QueryExecuter;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author max19
 */
public class SalariesTableViewModel extends TableView {
    
    private final ObservableList<Users> data;
    
    public SalariesTableViewModel(){
        List<Users> dataList = QueryExecuter.executeGetterHQLQuery(
                    "from Users"
        );
        data = FXCollections.observableArrayList(dataList);
        this.setEditable(false);
 
        TableColumn nameCol = new TableColumn("Name");
        nameCol.setMinWidth(200);
        nameCol.setCellValueFactory(
                new PropertyValueFactory<>("name"));
 
        TableColumn surnameCol = new TableColumn("Surname");
        surnameCol.setMinWidth(200);
        surnameCol.setCellValueFactory(
                new PropertyValueFactory<>("surname"));
        
        TableColumn postCol = new TableColumn("Post");
        postCol.setMinWidth(200);
        postCol.setCellValueFactory(
                new PropertyValueFactory<>("post"));
        
        TableColumn rateCol = new TableColumn("Wage-rate");
        rateCol.setMinWidth(100);
        rateCol.setCellValueFactory(
                new PropertyValueFactory<>("salary"));
        
        TableColumn salaryCol = new TableColumn<>("Salary");
        salaryCol.setMinWidth(300);
        salaryCol.setCellValueFactory(
                new SalaryPropertyValueFactory());
        
        this.setItems(data);
        this.getColumns().addAll(
                nameCol,
                surnameCol,
                postCol,
                rateCol, 
                salaryCol
        );
    }
    
}
