/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.copycenter.fxui.models.manager;

import com.mycompany.copycenter.entity.Types;
import com.mycompany.copycenter.tools.PriceHolder;
import com.mycompany.copycenter.tools.QueryExecuter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author max19
 */
public class OrderCreatorModel {
    
    public String[] getTypesNames(){
        List<Types> typesList = QueryExecuter.executeGetterHQLQuery("from Types");
        List<String> typesNames = new ArrayList<>();
        typesList.forEach((type) -> {
            typesNames.add(type.getName());
        });
        return typesNames.toArray(new String[typesNames.size()]);
    }

    public float getPrice(String type, String size) {
        return new PriceHolder().getElement(type) * Integer.parseInt(size);
    }
    
    public void createOrder(String typeName, String size, String price, String name, String phone){
        List<Types> type = QueryExecuter.executeGetterHQLQuery(
                "from Types t where t.name = " + 
                "'" + typeName + "'"
        );
        int idCurrentType = type.get(0).getIdType();
        
        QueryExecuter.executeSQLQuery(
                "INSERT INTO `Orders` (idType, size, price, clientName, "
                + "clientPhone, orderStatus)VALUES ("
                + "'" + idCurrentType + "', "
                + "'" + size + "', "
                + "" + Float.parseFloat(price) + ", "
                + "'" + name + "', "
                + "'" + phone + "', "
                + "'Waiting for processing')"
        );
    } 
    
}
