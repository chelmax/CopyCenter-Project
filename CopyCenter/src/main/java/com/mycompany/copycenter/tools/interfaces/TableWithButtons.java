/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.copycenter.tools.interfaces;

import java.util.List;

/**
 *
 * @author max19
 */
public interface TableWithButtons extends Table{
    /**
     * Gets massive of the Orders' id Strings with a specified sattus
     * @return 
     */
    public String[] getDialogBoxData();
    
    /**
     * Gets the text for buttons on the frame
     * @return 
     */
    public List<String> getButtonsText();
}
