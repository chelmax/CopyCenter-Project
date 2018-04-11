/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.copycenter.tools.interfaces;

import java.util.Vector;

/**
 *
 * @author max19
 */
public interface Table {
     /**
     * Fills/Refresh the object's properties with a data from Data Base
     */
    public void getDataFromDB();
    
    /**
     * Gets Vector of the Orders with a specified sattus
     * @return 
     */
    public Vector<Object> getRows();
    
    /**
     * Gets Vector of the column name of a current table
     * @return 
     */
    public Vector<String> getColumnNames();
    
}
