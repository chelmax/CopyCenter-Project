/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.copycenter.fxui.models;

import com.mycompany.copycenter.fxui.TypesPropertyValueFactory;
import com.mycompany.copycenter.tools.CurrentUser;
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
 * @param <Orders>
 */
public class OrdersTableViewModel<Orders> extends TableView {
    
    private final ObservableList<Orders> data; 
    
    public OrdersTableViewModel(String status){
        List dataList;
        switch(status){
            case "":
                dataList = QueryExecuter.executeGetterHQLQuery(
                        "from Orders"
                );
                break;
            case "Processing":
                dataList = QueryExecuter.executeGetterHQLQuery(
                        "from Orders o where o.users.id = " +
                        CurrentUser.getCurrentUser().getIdUser() + 
                        " and o.orderStatus = 'Processing'"
                ); 
                break;
            default:
                dataList = QueryExecuter.executeGetterHQLQuery(
                        "from Orders o where o.orderStatus = '" + status + "'"
                );
        }
        data = FXCollections.observableArrayList(dataList);
        this.setEditable(false);
 
        TableColumn numbCol = new TableColumn("№");
        numbCol.setMinWidth(50);
        numbCol.setCellValueFactory(
                new PropertyValueFactory<>("idOrder"));
 
        TableColumn clientNameCol = new TableColumn("Client Name");
        clientNameCol.setMinWidth(200);
        clientNameCol.setCellValueFactory(
                new PropertyValueFactory<>("clientName"));
 
        TableColumn clientPhoneCol = new TableColumn("Client Phone");
        clientPhoneCol.setMinWidth(200);
        clientPhoneCol.setCellValueFactory(
                new PropertyValueFactory<>("clientPhone"));
        
        TableColumn typeCol = new TableColumn("Type");
        typeCol.setMinWidth(200);
        typeCol.setCellValueFactory(
                new TypesPropertyValueFactory("types"));
        
        TableColumn sizeCol = new TableColumn("Size");
        sizeCol.setMinWidth(100);
        sizeCol.setCellValueFactory(
                new PropertyValueFactory<>("size"));
        
        TableColumn priceCol = new TableColumn("Price");
        priceCol.setMinWidth(100);
        priceCol.setCellValueFactory(
                new PropertyValueFactory<>("price"));
        
        TableColumn statusCol = new TableColumn("Status");
        statusCol.setMinWidth(300);
        statusCol.setCellValueFactory(
                new PropertyValueFactory<>("orderStatus"));
        
        this.setItems(data);
        this.getColumns().addAll(
                numbCol,
                clientNameCol,
                clientPhoneCol,
                typeCol, 
                sizeCol, 
                priceCol, 
                statusCol
        );
    }
    
}
