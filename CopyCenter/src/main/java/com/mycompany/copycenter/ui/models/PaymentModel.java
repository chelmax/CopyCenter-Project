/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.copycenter.ui.models;

import com.mycompany.copycenter.tools.QueryExecuter;
import com.mycompany.copycenter.tools.interfaces.TextWithBox;

/**
 *
 * @author max19
 */
public class PaymentModel implements TextWithBox{
    
    private final String infoText = "The number of the paid order is";

    @Override
    public String getInfoText() {
        return infoText;
    }
    
    @Override
    public boolean update(String id){
        QueryExecuter.executeSQLQuery("UPDATE Orders "
                + "set orderStatus = 'Paid' "
                + "where idOrder = " + id);
        return true;
    }
}
