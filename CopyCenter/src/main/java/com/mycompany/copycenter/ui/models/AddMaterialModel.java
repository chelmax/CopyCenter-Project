/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.copycenter.ui.models;

import com.mycompany.copycenter.tools.CostsHolder;
import com.mycompany.copycenter.tools.QueryExecuter;

/**
 *
 * @author max19
 */
public class AddMaterialModel {
    
    public void addMaterial(String name, int quantity, float cost){
        QueryExecuter.executeSQLQuery("Insert into Materials (name, quantity, cost) values ("
                + "'" + name + "', "
                + quantity + ", "
                + cost + ")");
        new CostsHolder().setMap(name, 0f);
    }
    
}
