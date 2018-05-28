/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.copycenter.fxui;

import com.mycompany.copycenter.entity.Orders;
import com.mycompany.copycenter.entity.Users;
import com.mycompany.copycenter.tools.QueryExecuter;
import com.sun.javafx.property.PropertyReference;
import java.util.List;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TableColumn;
import javafx.util.Callback;

/**
 *
 * @author max19
 */
public class SalaryPropertyValueFactory implements Callback<TableColumn.CellDataFeatures, ObservableValue>{
    
    private final String property;

    private final Class<Users> columnClass = Users.class;
    private String previousProperty;
    private PropertyReference<Integer> propertyRef;
    
    public SalaryPropertyValueFactory() {
        this.property = "salary";
    }
    
    
    @Override
    public ObservableValue call(TableColumn.CellDataFeatures param) {
        return getCellDataReflectively((Users) param.getValue());
    }
    
    public final String getProperty() { 
        return property; 
    }
    
    private ObservableValue<Integer> getCellDataReflectively(Users rowData) {
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
                Integer value = propertyRef.get(rowData);
                float salary = 0;
                if(rowData.getPost().equals("operator")){
                    List<Orders> processedOrders = QueryExecuter.executeGetterHQLQuery(
                            "from Orders o where o.users.idUser = " + rowData.getIdUser()
                    );
                    for(Orders o : processedOrders){
                        salary = o.getPrice() * 0.1f;
                    }
                }
                return new ReadOnlyObjectWrapper(value + salary);
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
