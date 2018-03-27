/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.copycenter.tools;

import com.mycompany.copycenter.entity.Orders;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author max19
 */
public class OrderPaymentModel {
    
    private List<Orders> processedOrdersList = new ArrayList();
    private Vector<Object> processedOrders = new Vector<>();
    private Vector<String> columnNames = new Vector<>();
    
    public OrderPaymentModel(){
        processedOrdersList = QueryExecuter.executeGetterHQLQuery(
                "from Orders o where o.orderStatus = 'Processed'"
        ); 
        for(Orders o : processedOrdersList){
            Vector<Object> oneRow = new Vector<>();
            oneRow.add(o.getIdOrder());
            oneRow.add(o.getClientName());
            oneRow.add(o.getClientPhone());
            oneRow.add(o.getTypes().getName());
            oneRow.add(o.getSize());
            oneRow.add(o.getPrice());
            oneRow.add(o.getOrderStatus());
            processedOrders.add(oneRow);
        }
        columnNames.add("№");
        columnNames.add("Client Name");
        columnNames.add("Client Phone");
        columnNames.add("Type");
        columnNames.add("Size");
        columnNames.add("Price");
        columnNames.add("Status");
    }
    
    
    public List<Orders> getProcessedOrdersList() {
        return processedOrdersList;
    }

    public Vector<Object> getProcessedOrders() {
        return processedOrders;
    }

    public Vector<String> getColumnNames() {
        return columnNames;
    }
    
    public String[] getOrdersID(){
        List<String> ordersID = new ArrayList<>();
        getProcessedOrdersList().forEach((order) -> {
            ordersID.add(String.valueOf(order.getIdOrder()));
        });
        return ordersID.toArray(new String[ordersID.size()]);
    }
    
}
