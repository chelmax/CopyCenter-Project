/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.copycenter.fxui.models.accountant;

import com.mycompany.copycenter.tools.QueryExecuter;

/**
 *
 * @author max19
 */
public class ChangeRateModel {
    
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
