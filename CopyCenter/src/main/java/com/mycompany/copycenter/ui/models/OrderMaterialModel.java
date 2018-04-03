/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.copycenter.ui.models;

import com.mycompany.copycenter.entity.Materials;
import com.mycompany.copycenter.tools.CostsHolder;
import com.mycompany.copycenter.tools.QueryExecuter;
import com.mycompany.copycenter.tools.interfaces.TextWithBoxAndValue;
import java.util.List;
import java.util.Map;

/**
 *
 * @author max19
 */
public class OrderMaterialModel implements TextWithBoxAndValue{
    private final String infoText = "Order&size";
    
    @Override
    public boolean validate(String value){
        try{                                                                    
            if(Integer.parseInt(value) < 1)
                throw new NumberFormatException();
            return true;
        } catch(NumberFormatException wrongInput){
            return false;
        }
    }
    
    @Override
    public String getInfoText() {
        return infoText;
    }
    
    @Override
    public boolean update(String nameQuantity){   
        String[] arr = nameQuantity.split(" ");
        List<Materials> material = QueryExecuter.executeGetterHQLQuery(
                "from Materials m where m.name = '" + arr[0] + "'"
        );
        CostsHolder ch = new CostsHolder();
        Map<String, Float> currentCosts = ch.getMap();
        currentCosts.put(arr[0], Float.valueOf(arr[1]) * material.get(0).getCost());
        Map test = ch.getMap();
        ch.setMap(currentCosts);
        QueryExecuter.executeSQLQuery("UPDATE Materials "
                + "set quantity = quantity + " + arr[1] + " "
                + "where name = '" + arr[0] + "' "
        );
        return true;
    }
    
}
