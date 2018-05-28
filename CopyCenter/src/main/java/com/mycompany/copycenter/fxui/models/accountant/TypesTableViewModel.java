/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.copycenter.fxui.models.accountant;

import com.mycompany.copycenter.entity.Materials;
import com.mycompany.copycenter.fxui.CostsValueFactory;
import com.mycompany.copycenter.tools.PriceHolder;
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
public class TypesTableViewModel extends TableView {
    
    private final ObservableList<Materials> data;
    
    public TypesTableViewModel(){
        PriceHolder ph = new PriceHolder();
        List<Materials> dataList = QueryExecuter.executeGetterHQLQuery(
                    "from Types"
        );
        data = FXCollections.observableArrayList(dataList);
        this.setEditable(false);
 
        TableColumn nameCol = new TableColumn("Name");
        nameCol.setMinWidth(200);
        nameCol.setCellValueFactory(
                new PropertyValueFactory<>("name"));
        
        TableColumn costsCol = new TableColumn("Cost");
        costsCol.setCellValueFactory(
                new CostsValueFactory());
        
        this.setItems(data);
        this.getColumns().addAll(
                nameCol,
                costsCol
        );
    }
    
}
