/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.copycenter.ui.models;

import com.mycompany.copycenter.tools.CostsHolder;
import com.mycompany.copycenter.tools.PriceHolder;
import java.util.Map;

/**
 *
 * @author max19
 */
public class CostsModel {
    
    public String getEleCost(){
        return String.format("%.2f", new CostsHolder().getElement("electricity"));
    }
    
    public String getLeaseCost(){
        CostsHolder ch = new CostsHolder();
        ch.setMap("lease", new PriceHolder().getElement("lease"));
        return String.format("%.2f", ch.getElement("lease"));
    }
    
    public String getSalariesCost(){
        return String.format("%.2f", new CostsHolder().getElement("salaries"));
    }
    
    public String getMaterialCost(){
        Map<String, Float> allCosts = new CostsHolder().getMap();
        allCosts.remove("salaries");
        allCosts.remove("electricity");
        allCosts.remove("lease");
        double sum = allCosts.keySet().stream()
                .map((key) -> allCosts.get(key))
                .mapToDouble((value) -> value)
                .sum();
        return String.format("%.2f", sum);
    }
    
    public String getTotalCost(){
        Map<String, Float> allCosts = new CostsHolder().getMap();
        double sum = allCosts.keySet().stream()
                .map((key) -> allCosts.get(key))
                .mapToDouble((value) -> value)
                .sum();
        return String.format("%.2f", sum);
    }
    
    public void payOff(){
        CostsHolder ch = new CostsHolder();
        Map<String, Float> allCosts = ch.getMap();
        allCosts.keySet().forEach((key) -> {
            allCosts.put(key, 0f);
        });
        ch.setMap(allCosts);
    }
    
}
