/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.copycenter.tools;

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
public class PriceHolder {
    
    private Map<String, Float> priceList;

    public PriceHolder() {
        priceList = new HashMap<>();
        try(FileInputStream fis =  new FileInputStream("priceList.bin")){
            ObjectInputStream is = new ObjectInputStream(fis);
            priceList = (Map) is.readObject();
        }catch(Exception ex){
            System.err.println(ex);
        }
    }

    public void setPriceList(Map<String, Float> price) {
        priceList.putAll(price);
        try(FileOutputStream fos =  new FileOutputStream("pricelist.bin")){
            ObjectOutputStream os = new ObjectOutputStream(fos);
            os.writeObject(priceList);
        }catch(Exception ex){
            System.err.println(ex);
        }
    }
    
    public float getPrice(String type) {
        return priceList.get(type);
    }
    
    
    
}
