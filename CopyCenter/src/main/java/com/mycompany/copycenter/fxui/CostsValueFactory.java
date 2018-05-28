/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.copycenter.fxui;

import com.mycompany.copycenter.entity.Cost;
import com.mycompany.copycenter.entity.Orders;
import com.mycompany.copycenter.entity.Types;
import com.mycompany.copycenter.entity.Users;
import com.mycompany.copycenter.tools.QueryExecuter;
import com.sun.javafx.property.PropertyReference;
import java.util.List;
import java.util.Set;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TableColumn;
import javafx.util.Callback;

/**
 *
 * @author max19
 */
public class CostsValueFactory implements Callback<TableColumn.CellDataFeatures, ObservableValue>{
    
    private final String property;

    private final Class<Types> columnClass = Types.class;
    private String previousProperty;
    private PropertyReference<Set<Cost>> propertyRef;
    
    public CostsValueFactory() {
        this.property = "costs";
    }
    
    
    @Override
    public ObservableValue call(TableColumn.CellDataFeatures param) {
        return getCellDataReflectively((Types) param.getValue());
    }
    
    public final String getProperty() { 
        return property; 
    }
    
    private ObservableValue<Set<Cost>> getCellDataReflectively(Types rowData) {
        if (getProperty() == null || getProperty().isEmpty() || rowData == null) 
            return null;

        try {
            if (columnClass == null || previousProperty == null ||
                    ! previousProperty.equals(getProperty())) {
                this.previousProperty = property;
                this.propertyRef = new PropertyReference(columnClass, property);
            }

            if (propertyRef.hasProperty()) {
                return propertyRef.getProperty(rowData);
            } else {
                Set<Cost> value = propertyRef.get(rowData);
                StringBuilder sb = new StringBuilder();
                Set<Cost> costSet = rowData.getCosts();
                costSet.forEach((cost) -> {
                sb.append(cost.getSizePerOne())
                        .append(" pieces of ")
                        .append(cost.getMaterials().getName())
                        .append("; ");
                });
                return new ReadOnlyObjectWrapper(sb.toString());
            }
        } catch (IllegalStateException e) {
            // log the warning and move on
            /*final PlatformLogger logger = Logging.getControlsLogger();
            if (logger.isLoggable(Level.WARNING)) {
               logger.finest("Can not retrieve property '" + getProperty() +
                        "' in PropertyValueFactory: " + this +
                        " with provided class type: " + rowData.getClass(), e);
            }*/
        }

        return null;
    }
    
}
