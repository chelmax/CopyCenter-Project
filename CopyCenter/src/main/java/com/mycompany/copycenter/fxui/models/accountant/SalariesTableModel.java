/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.copycenter.fxui.models.accountant;

import com.mycompany.copycenter.tools.CostsHolder;
import com.mycompany.copycenter.tools.QueryExecuter;

/**
 *
 * @author max19
 */
public class SalariesTableModel {

    public void payOff(float salariesSum) {
        CostsHolder ch = new CostsHolder();
        ch.setMap("salaries", ch.getElement("salaries") + salariesSum);
        QueryExecuter.executeSQLQuery(
                "Update Orders set idUser = null where idOrder > 0 " +
                "and orderStatus not like 'Processing'"
        );
    }
    
}
