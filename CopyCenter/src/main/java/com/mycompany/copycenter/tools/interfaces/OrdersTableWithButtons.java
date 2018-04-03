/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.copycenter.tools.interfaces;

import java.util.List;
import java.util.Vector;

/**
 *
 * @author max19
 */
public interface OrdersTableWithButtons {
    
    /**
     * Fills/Refresh the object's properties with a data from Data Base
     */
    public void getDataFromDB();
    
    /**
     * Gets Vector of the Orders with a specified sattus
     * @return 
     */
    public Vector<Object> getOrders();
    
    /**
     * Gets Vector of the column name of a current table
     * @return 
     */
    public Vector<String> getColumnNames();
    
    /**
     * Gets massive of the Orders' id Strings with a specified sattus
     * @return 
     */
    public String[] getOrdersID();
    
    /**
     * Gets the text for buttons on the frame
     * @return 
     */
    public List<String> getButtonsText();
    
    /**
     * Gets the model of a child Dialog
     * @return 
     */
    public TextWithBox getModel();
}
