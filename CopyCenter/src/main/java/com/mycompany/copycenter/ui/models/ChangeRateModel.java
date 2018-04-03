/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.copycenter.ui.models;

import com.mycompany.copycenter.tools.QueryExecuter;
import com.mycompany.copycenter.tools.interfaces.TextWithBoxAndValue;

/**
 *
 * @author max19
 */
public class ChangeRateModel implements TextWithBoxAndValue{
    private final String infoText = "The rate for&is";

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
    public boolean update(String nameSurnameRate){   
        String[] arr = nameSurnameRate.split(" ");
        QueryExecuter.executeSQLQuery("UPDATE Users "
                + "set salary = " + arr[2] + " "
                + "where name = '" + arr[0] + "' "
                + "and surname = '" + arr[1] + "'"
        );
        return true;
    }
}
