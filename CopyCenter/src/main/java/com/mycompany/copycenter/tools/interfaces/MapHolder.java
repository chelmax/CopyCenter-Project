/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.copycenter.tools.interfaces;

import java.util.Map;

/**
 *
 * @author max19
 */
public interface MapHolder {
    
    /**
     * Sets new Map into the holder file
     * @param price
     */
    public void setMap(Map<String, Float> price);
    
    /**
     * Gets Map into the holder file
     * @return 
     */
    public Map<String, Float> getMap();
    
    /**
     * Gets float element from the Map
     * @param type
     * @return
     */
    public float getElement(String type);
}
