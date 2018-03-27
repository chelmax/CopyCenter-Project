/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.copycenter.tools;

/**
 *
 * @author max19
 */
public class PaymentModel {
    
    public void update(String id){
        QueryExecuter.executeSQLQuery("UPDATE Orders "
                + "set orderStatus = 'Paid'"
                + "where idOrder = " + id);
    }
}
