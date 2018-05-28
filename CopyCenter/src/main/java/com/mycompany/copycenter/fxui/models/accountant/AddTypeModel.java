/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.copycenter.fxui.models.accountant;

import com.mycompany.copycenter.entity.Materials;
import com.mycompany.copycenter.entity.Types;
import com.mycompany.copycenter.tools.PriceHolder;
import com.mycompany.copycenter.tools.QueryExecuter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author max19
 */
public class AddTypeModel {
    
    private final  List<Materials> notAddedMaterials;
    private final List<Materials> addedMaterials;
    private final Map<String, Integer> addedMaterialsSizeMap;

    public AddTypeModel(){
        addedMaterials = new ArrayList<>();
        addedMaterialsSizeMap = new HashMap<>();
        notAddedMaterials = QueryExecuter.executeGetterHQLQuery("from Materials");
    }
    
    public void deleteMaterial(String name){
        for(Materials m : addedMaterials){
            if(m.getName().equals(name)){
                notAddedMaterials.add(m);
                addedMaterialsSizeMap.remove(name);
                addedMaterials.remove(m);
                break;
            }
        }
    }
    
    public void addMaterial(String name, Integer size){   
        for(Materials m : notAddedMaterials){
            if(m.getName().equals(name)){
                addedMaterials.add(m);
                addedMaterialsSizeMap.put(name, size);
                notAddedMaterials.remove(m);
                break;
            }
        }
    }
    
    public Map<String, Integer> getAddedMaterialsSizeMap() {
        return addedMaterialsSizeMap;
    }
    
    public List<Materials> getNotAddedMaterials() {
        return notAddedMaterials;
    }

    public List<Materials> getAddedMaterials() {
        return addedMaterials;
    }
    
    public boolean validate(String name, String value){
        if(name.equals("") || addedMaterialsSizeMap.isEmpty())
            return false;
        try{                                                                    
            if(Float.parseFloat(value) < 1)
                throw new NumberFormatException();
            return true;
        } catch(NumberFormatException wrongInput){
            return false;
        }
    }
    
    public String[] getNotAddedMaterialsDialogBoxData(){
        List<String> notAddedMaterialsNames = new ArrayList<>();
        notAddedMaterials.forEach((m) -> {
            notAddedMaterialsNames.add(String.valueOf(m.getName()));
        });
        return notAddedMaterialsNames.toArray(new String[notAddedMaterialsNames.size()]);
    }
    
    public String[] getAddedMaterialsDialogBoxData(){
        List<String> addedMaterialsNames = new ArrayList<>();
        addedMaterials.forEach((m) -> {
            addedMaterialsNames.add(String.valueOf(m.getName()));
        });
        return addedMaterialsNames.toArray(new String[addedMaterialsNames.size()]);
    }
    
    public void addType(String name, Float price){                              
        QueryExecuter.executeSQLQuery(
                "Insert into Types (name) values ('" 
                + name + "')"
        );
        List<Types> addedType = QueryExecuter.executeGetterHQLQuery(
                "from Types t where t.name = '" + name + "'"
        );
        int addedTypeId = addedType.get(0).getIdType();
        addedMaterials.forEach((material) -> {
            QueryExecuter.executeSQLQuery("Insert into Cost "
                    + "(Type_idType, Materials_idMaterials, sizePerOne) values("
                    + addedTypeId + ", "
                    + material.getIdMaterials() + ", "
                    + addedMaterialsSizeMap.get(material.getName()) +")"
            );
        });
        new PriceHolder().setMap(name, price);
    }
    
}
