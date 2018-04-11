/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.copycenter.ui.models;

import com.mycompany.copycenter.tools.interfaces.TextWithBoxAndValue;
import com.mycompany.copycenter.ui.uiAccounter.AddTypeDialog;

/**
 *
 * @author max19
 */
public class BindMaterialToTypeModel implements TextWithBoxAndValue{
    
    private final AddTypeDialog parent;
    private final String infoText = "The size of&is";
    
    public BindMaterialToTypeModel(AddTypeDialog parent){
        this.parent = parent;
    }
    
    @Override
    public boolean validate(String value){
        try{                                                                    
            if(Integer.parseInt(value) < 1)
                throw new NumberFormatException();
            return true;
        } catch(NumberFormatException wrongInput){
            return false;
        }
    }
    
    @Override
    public String getInfoText(){
        return infoText;
    }
    
    @Override
    public boolean update(String materialCost){
        String[] arr = materialCost.split(" ");
        if(arr[0] == null)
            return false;
        parent.getModel().addMaterial(arr[0], Integer.parseInt(arr[1]));
        parent.refreshMaterialsArea();
        return true;
        /*String[] arr = nameCost.split(" ");
        if(arr.length > 1){
            String info = "Needed " + arr[1] + " pieces of " + arr[0] + "\n";
            parent.refreshMaterialsArea(info);
            parent.getModel().addMaterial(arr[0], Integer.parseInt(arr[1]));
            return true;
        } else{
            parent.getModel().deleteMaterial(arr[0]);                           //как удалять из ТекстАреа?
            return true;
        }*/
    }                                     

    
}
