/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.copycenter.fxui.models.manager;

import com.mycompany.copycenter.tools.QueryExecuter;

/**
 *
 * @author max19
 */
public class PaymentModel {
    
    public boolean update(String id){
        QueryExecuter.executeSQLQuery("UPDATE Orders "
                + "set orderStatus = 'Paid' "
                + "where idOrder = " + id);
        return true;
    }
}
