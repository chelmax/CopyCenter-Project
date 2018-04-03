/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.copycenter.tools;

import com.mycompany.copycenter.tools.interfaces.MapHolder;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author max19
 */
public class CostsHolder implements MapHolder{
    
    @Override
    public void setMap(Map<String, Float> price) {
        Map<String, Float> currentCosts = getMap();
        currentCosts.putAll(price);
        try(FileOutputStream fos =  new FileOutputStream("currentcosts.bin")){
            ObjectOutputStream os = new ObjectOutputStream(fos);
            os.writeObject(currentCosts);
        }catch(Exception ex){
            System.err.println(ex);
        }
    }
    
    @Override
    public Map<String, Float> getMap(){
        Map<String, Float> currentCosts = new HashMap<>();
        try(FileInputStream fis =  new FileInputStream("currentcosts.bin")){
            ObjectInputStream is = new ObjectInputStream(fis);
            currentCosts = (Map) is.readObject();
        }catch(Exception ex){
            System.err.println(ex);
        }
        return currentCosts;
    }
    
    @Override
    public float getElement(String type) {
        return getMap().get(type);
    }
    
}
