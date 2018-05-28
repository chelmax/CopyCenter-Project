/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.copycenter.fxui.models.accountant;

import com.mycompany.copycenter.entity.Materials;
import com.mycompany.copycenter.tools.CostsHolder;
import com.mycompany.copycenter.tools.QueryExecuter;
import java.util.List;

/**
 *
 * @author max19
 */
public class OrderMaterialModel {
    
    public boolean update(String nameQuantity){   
        String[] arr = nameQuantity.split(" ");
        List<Materials> material = QueryExecuter.executeGetterHQLQuery(
                "from Materials m where m.name = '" + arr[0] + "'"
        );
        new CostsHolder().setMap(arr[0], Float.valueOf(arr[1]) * material.get(0).getCost());
        QueryExecuter.executeSQLQuery("UPDATE Materials "
                + "set quantity = quantity + " + arr[1] + " "
                + "where name = '" + arr[0] + "' "
        );
        return true;
    }
    
}
