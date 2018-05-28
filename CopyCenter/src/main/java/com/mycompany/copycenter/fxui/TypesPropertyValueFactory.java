/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.copycenter.fxui;

import com.mycompany.copycenter.entity.Types;
import com.sun.javafx.property.PropertyReference;
import javafx.beans.NamedArg;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TableColumn;
import javafx.util.Callback;

/**
 *
 * @author max19
 */
public class TypesPropertyValueFactory implements Callback<TableColumn.CellDataFeatures, ObservableValue>{
    
    private final String property;

    private Class<?> columnClass;
    private String previousProperty;
    private PropertyReference<Types> propertyRef;
    
    public TypesPropertyValueFactory(@NamedArg("property") String property) {
        this.property = property;
    }
    
    
    @Override
    public ObservableValue call(TableColumn.CellDataFeatures param) {
        return getCellDataReflectively(param.getValue());
    }
    
    public final String getProperty() { 
        return property; 
    }
    
    private ObservableValue<Types> getCellDataReflectively(Object rowData) {
        if (getProperty() == null || getProperty().isEmpty() || rowData == null) return null;

        try {
            // we attempt to cache the property reference here, as otherwise
            // performance suffers when working in large data models. For
            // a bit of reference, refer to RT-13937.
            if (columnClass == null || previousProperty == null ||
                    ! columnClass.equals(rowData.getClass()) ||
                    ! previousProperty.equals(getProperty())) {

                // create a new PropertyReference
                this.columnClass = rowData.getClass();
                this.previousProperty = getProperty();
                this.propertyRef = new PropertyReference(rowData.getClass(), getProperty());
            }

            if (propertyRef.hasProperty()) {
                return propertyRef.getProperty(rowData);
            } else {
                Types value = propertyRef.get(rowData);
                return new ReadOnlyObjectWrapper(value.getName());
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
