/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.copycenter.ui.models;

import com.mycompany.copycenter.entity.Materials;
import com.mycompany.copycenter.tools.PriceHolder;
import com.mycompany.copycenter.tools.QueryExecuter;
import com.mycompany.copycenter.tools.interfaces.TableWithButtons;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author max19
 */
public class MaterialsTableModel implements TableWithButtons{
    private List<Materials> materialsList;
    private Vector<Object> materials;
    private Vector<String> columnNames;
    private final String buttonText1 = "Add material";
    private final String buttonText2 = "Order material";
    private final String buttonText3 = "Change cost";
    
    
    public MaterialsTableModel(){
        getDataFromDB();
    }

   
    @Override
    public final void getDataFromDB(){
        materialsList = new ArrayList<>();
        materials = new Vector<>();
        columnNames = new Vector<>();
        materialsList = QueryExecuter.executeGetterHQLQuery(
                "from Materials"
        ); 
        PriceHolder ph = new PriceHolder();
        Vector<Object> commun = new Vector<>();
        commun.add("electricity");
        commun.add(null);
        commun.add(ph.getElement("electricity"));
        materials.add(commun);
        commun = new Vector<>();
        commun.add("lease");
        commun.add(null);
        commun.add(ph.getElement("lease"));
        materials.add(commun);
        materialsList.stream().map((m) -> {
            Vector<Object> oneRow = new Vector<>();
            oneRow.add(m.getName());
            oneRow.add(m.getQuantity());
            oneRow.add(m.getCost());
            return oneRow;
        }).forEachOrdered((oneRow) -> {
            materials.add(oneRow);
        });
        columnNames.add("Name");
        columnNames.add("Quantity");
        columnNames.add("Cost");
    }
   
    @Override
    public Vector<Object> getRows() {
        return materials;
    }

   
    @Override
    public Vector<String> getColumnNames() {
        return columnNames;
    }
    
   
    @Override
    public List<String> getButtonsText() {
        List<String> buttonsText = new ArrayList<>();
        buttonsText.add(buttonText1);
        buttonsText.add(buttonText2);
        buttonsText.add(buttonText3);
        return buttonsText;
    }
    
    @Override
    public String[] getDialogBoxData(){
        List<String> materialsNames = new ArrayList<>();
        materialsList.forEach((m) -> {
            materialsNames.add(String.valueOf(m.getName()));
        });
        return materialsNames.toArray(new String[materialsNames.size()]);
    }
}
