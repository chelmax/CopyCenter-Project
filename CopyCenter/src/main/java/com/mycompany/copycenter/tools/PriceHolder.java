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
public class PriceHolder implements MapHolder{
    
    @Override
    public void setMap(Map<String, Float> price) {
        Map<String, Float> priceList = getMap();
        priceList.putAll(price);
        try(FileOutputStream fos =  new FileOutputStream("pricelist.bin")){
            ObjectOutputStream os = new ObjectOutputStream(fos);
            os.writeObject(priceList);
        }catch(Exception ex){
            System.err.println(ex);
        }
    }
    
    @Override
    public void setMap(String key, Float price) {
        Map<String, Float> priceList = getMap();
        priceList.put(key, price);
        try(FileOutputStream fos =  new FileOutputStream("pricelist.bin")){
            ObjectOutputStream os = new ObjectOutputStream(fos);
            os.writeObject(priceList);
        }catch(Exception ex){
            System.err.println(ex);
        }
    }
    
    @Override
    public Map<String, Float> getMap(){
        Map<String, Float> priceList = new HashMap<>();
        try(FileInputStream fis =  new FileInputStream("priceList.bin")){
            ObjectInputStream is = new ObjectInputStream(fis);
            priceList = (Map) is.readObject();
        }catch(Exception ex){
            System.err.println(ex);
        }
        return priceList;
    }
    
   
    @Override
    public float getElement(String type) {
        return getMap().get(type);
    }  
}
