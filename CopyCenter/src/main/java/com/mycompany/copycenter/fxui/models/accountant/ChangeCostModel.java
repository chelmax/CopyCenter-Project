/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.copycenter.fxui.models.accountant;

import com.mycompany.copycenter.tools.PriceHolder;
import com.mycompany.copycenter.tools.QueryExecuter;

/**
 *
 * @author max19
 */
public class ChangeCostModel{
    
    public boolean update(String nameCost){   
        String[] arr = nameCost.split(" ");
        if(arr[0].equals("electricity") || arr[0].equals("lease"))
            new PriceHolder().setMap(arr[0], Float.parseFloat(arr[1]));
        else
            QueryExecuter.executeSQLQuery("UPDATE Materials "
                    + "set cost = " + arr[1] + " "
                    + "where name = '" + arr[0] + "' "
            );
        return true;
    }
}
