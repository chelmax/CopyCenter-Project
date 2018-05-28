/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.copycenter.fxui.models.accountant;

import com.mycompany.copycenter.entity.Materials;
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
public class MaterialsTableViewModel extends TableView {
    
    private final ObservableList<Materials> data;
    
    public MaterialsTableViewModel(){
        PriceHolder ph = new PriceHolder();
        data = FXCollections.observableArrayList();
        data.add(new Materials("electricity", -1, ph.getElement("electricity")));
        data.add(new Materials("lease", -1, ph.getElement("lease")));
        List<Materials> dataList = QueryExecuter.executeGetterHQLQuery(
                    "from Materials"
        );
        data.addAll(dataList);
        this.setEditable(false);
 
        TableColumn nameCol = new TableColumn("Name");
        nameCol.setMinWidth(200);
        nameCol.setCellValueFactory(
                new PropertyValueFactory<>("name"));
 
        TableColumn quantCol = new TableColumn("Quantity");
        quantCol.setMinWidth(200);
        quantCol.setCellValueFactory(
                new PropertyValueFactory<>("quantity"));
        
        TableColumn costCol = new TableColumn("Cost");
        costCol.setMinWidth(200);
        costCol.setCellValueFactory(
                new PropertyValueFactory<>("cost"));
        
        this.setItems(data);
        this.getColumns().addAll(
                nameCol,
                quantCol,
                costCol
        );
    }
    
}
