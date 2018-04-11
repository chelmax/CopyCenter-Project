/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.copycenter.ui.models;

import com.mycompany.copycenter.entity.Orders;
import com.mycompany.copycenter.tools.QueryExecuter;
import com.mycompany.copycenter.tools.interfaces.Table;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author max19
 */
public class OrderLogModel implements Table{
    private List<Orders> ordersList;
    private Vector<Object> orders;
    private Vector<String> columnNames;
    
    public OrderLogModel(){
        getDataFromDB();
    }
    
    @Override
    public final void getDataFromDB(){
        ordersList = new ArrayList();
        orders = new Vector<>();
        columnNames = new Vector<>();
        ordersList = QueryExecuter.executeGetterHQLQuery(
                "from Orders"
        ); 
        ordersList.stream().map((o) -> {
            Vector<Object> oneRow = new Vector<>();
            oneRow.add(o.getIdOrder());
            oneRow.add(o.getClientName());
            oneRow.add(o.getClientPhone());
            oneRow.add(o.getTypes().getName());
            oneRow.add(o.getSize());
            oneRow.add(o.getPrice());
            oneRow.add(o.getOrderStatus());
            return oneRow;
        }).forEachOrdered((oneRow) -> {
            orders.add(oneRow);
        });
        columnNames.add("№");
        columnNames.add("Client Name");
        columnNames.add("Client Phone");
        columnNames.add("Type");
        columnNames.add("Size");
        columnNames.add("Price");
        columnNames.add("Status");
    }
    
    @Override
    public Vector<Object> getRows() {
        return orders;
    }

    @Override
    public Vector<String> getColumnNames() {
        return columnNames;
    }
}
