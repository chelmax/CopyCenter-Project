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
public interface TextWithBoxAndValue extends TextWithBox{
    
    /**
     * Checking value in the text field
     * @param value
     * @return 
     */
    public boolean validate(String value);
    
}
