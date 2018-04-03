/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.copycenter.tools.interfaces;

/**
 *
 * @author max19
 */
public interface TextWithBox {
    
    /**
     * Getting text to set in the TextLabel of the Dialog
     * @return 
     */
    public String getInfoText();
    
    /**
     * This method updating connected DataBase using data in the ComboBox
     * @param id
     * @return 
     */
    public boolean update(String id);                                              
    
}
