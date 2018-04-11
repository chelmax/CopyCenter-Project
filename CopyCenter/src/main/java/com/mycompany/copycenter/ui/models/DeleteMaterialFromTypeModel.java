/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.copycenter.ui.models;


import com.mycompany.copycenter.tools.interfaces.TextWithBox;
import com.mycompany.copycenter.ui.uiAccounter.AddTypeDialog;

/**
 *
 * @author max19
 */
public class DeleteMaterialFromTypeModel implements TextWithBox{
    
    private final String infoText = "Delete from cost material number"; 
    private final AddTypeDialog parent;
    
    public DeleteMaterialFromTypeModel(AddTypeDialog parent){
        this.parent = parent;
    }
    
    @Override
    public String getInfoText() {
        return infoText;
    }

    @Override
    public boolean update(String id) {
        parent.getModel().deleteMaterial(id);    
        parent.refreshMaterialsArea();                                      
        return true;
    }
    
}
