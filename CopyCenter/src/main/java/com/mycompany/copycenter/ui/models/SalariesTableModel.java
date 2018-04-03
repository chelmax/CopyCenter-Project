/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.copycenter.ui.models;

import com.mycompany.copycenter.entity.Orders;
import com.mycompany.copycenter.entity.Users;
import com.mycompany.copycenter.tools.CostsHolder;
import com.mycompany.copycenter.tools.QueryExecuter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

/**
 *
 * @author max19
 */
public class SalariesTableModel {
    private List<Users> stuffList;
    private Vector<Object> stuff;
    private Vector<String> columnNames;
    private final String buttonText1 = "Change wage-rate";
    private final String buttonText2 = "Pay off";
    
    
    public SalariesTableModel(){
        getDataFromDB();
    }

   
    public final void getDataFromDB(){
        stuffList = new ArrayList<>();
        stuff = new Vector<>();
        columnNames = new Vector<>();
        stuffList = QueryExecuter.executeGetterHQLQuery(
                "from Users"
        ); 
        stuffList.stream().map((u) -> {
            Vector<Object> oneRow = new Vector<>();
            oneRow.add(u.getName());
            oneRow.add(u.getSurname());
            oneRow.add(u.getPost());
            oneRow.add(u.getSalary());
            float salary = 0;
            if(u.getPost().equals("operator")){
                List<Orders> processedOrders = QueryExecuter.executeGetterHQLQuery(
                        "from Orders o where o.users.idUser = " + u.getIdUser()
                );
                for(Orders o : processedOrders){
                    salary = o.getPrice() * 0.1f;
                }
            }
            oneRow.add(u.getSalary() + salary);
            return oneRow;
        }).forEachOrdered((oneRow) -> {
            stuff.add(oneRow);
        });
        columnNames.add("Name");
        columnNames.add("Surname");
        columnNames.add("Post");
        columnNames.add("Wage-rate");
        columnNames.add("Salary");
    }
   
    public Vector<Object> getStuff() {
        return stuff;
    }

   
    public Vector<String> getColumnNames() {
        return columnNames;
    }
    
   
    public List<String> getButtonsText() {
        List<String> buttonsText = new ArrayList<>();
        buttonsText.add(buttonText1);
        buttonsText.add(buttonText2);
        return buttonsText;
    }
    
    public String[] getStuffNames(){
        List<String> stuffNames = new ArrayList<>();
        stuffList.forEach((user) -> {
            stuffNames.add(String.valueOf(user.getName()) + " " + user.getSurname());
        });
        return stuffNames.toArray(new String[stuffNames.size()]);
    }

    public void payOff(float salariesSum) {
        CostsHolder ch = new CostsHolder();
        Map<String, Float> currentCosts = ch.getMap();
        currentCosts.put("salaries", salariesSum);
        ch.setMap(currentCosts);
        QueryExecuter.executeSQLQuery(
                "Update Orders set idUser = null where idOrder > 0"
        );
    }
    
}