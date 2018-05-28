/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.copycenter.fxui.models.operator;

import com.mycompany.copycenter.tools.CurrentUser;
import com.mycompany.copycenter.tools.QueryExecuter;

/**
 *
 * @author max19
 */
public class GettingModel {
    
    public boolean update(String id){
        QueryExecuter.executeSQLQuery("UPDATE Orders "
                + "set orderStatus = 'Processing', "
                + "idUser = " + CurrentUser.getCurrentUser().getIdUser() + " "
                + "where idOrder = " + id);
        return true;
    }
    
}
