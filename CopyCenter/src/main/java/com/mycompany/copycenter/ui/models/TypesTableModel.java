/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.copycenter.ui.models;

import com.mycompany.copycenter.entity.Cost;
import com.mycompany.copycenter.entity.Types;
import com.mycompany.copycenter.tools.QueryExecuter;
import com.mycompany.copycenter.tools.interfaces.TableWithButtons;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Vector;

/**
 *
 * @author max19
 */
public class TypesTableModel implements TableWithButtons{
    
    private List<Types> typesList;
    private Vector<Object> types;
    private Vector<String> columnNames;
    private final String buttonText1 = "Add type";
    private final String buttonText2 = "Delete type";
    
    
    public TypesTableModel(){
        getDataFromDB();
    }

   
    @Override
    public final void getDataFromDB(){
        typesList = new ArrayList<>();
        types = new Vector<>();
        columnNames = new Vector<>();
        typesList = QueryExecuter.executeGetterHQLQuery(
                "from Types"
        ); 
        
        typesList.stream().map((t) -> {
            Vector<Object> oneRow = new Vector<>();
            oneRow.add(t.getIdType());
            oneRow.add(t.getName()); 
            StringBuilder sb = new StringBuilder();
            Set<Cost> costSet = t.getCosts();
            costSet.forEach((cost) -> {
                sb.append(cost.getSizePerOne())
                        .append(" pieces of ")
                        .append(cost.getMaterials().getName())
                        .append(" ");
            });
            oneRow.add(sb.toString());
            return oneRow;
            
        }).forEachOrdered((oneRow) -> {
            types.add(oneRow);
        });
        columnNames.add("Id");
        columnNames.add("Type");
        columnNames.add("Cost");
    }
   
    @Override
    public Vector<Object> getRows() {
        return types;
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
        return buttonsText;
    }
    
    @Override
    public String[] getDialogBoxData(){
        List<String> typesNames = new ArrayList<>();
        typesList.forEach((m) -> {
            typesNames.add(String.valueOf(m.getName()));
        });
        return typesNames.toArray(new String[typesNames.size()]);
    }
}
