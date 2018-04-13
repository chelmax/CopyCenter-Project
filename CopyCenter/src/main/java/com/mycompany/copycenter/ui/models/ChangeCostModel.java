/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.copycenter.ui.models;

import com.mycompany.copycenter.tools.PriceHolder;
import com.mycompany.copycenter.tools.QueryExecuter;
import com.mycompany.copycenter.tools.interfaces.TextWithBoxAndValue;

/**
 *
 * @author max19
 */
public class ChangeCostModel implements TextWithBoxAndValue{
    private final String infoText = "The cost for&is";
    
    @Override
    public boolean validate(String value){
        try{                                                                    
            if(Float.parseFloat(value) < 0)
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
