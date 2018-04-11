/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.copycenter.ui.models;

import com.mycompany.copycenter.entity.Orders;
import com.mycompany.copycenter.tools.QueryExecuter;
import com.mycompany.copycenter.tools.interfaces.OrdersTableWithButtons;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author max19
 */
public class OrderGettingModel implements OrdersTableWithButtons{
    
    private List<Orders> wfProcessingOrdersList;
    private Vector<Object> wfProcessingOrders;
    private Vector<String> columnNames;
    private final GettingModel model = new GettingModel();
    private final String buttonText = "Take one";
    
    public OrderGettingModel(){
        getDataFromDB();
    }
    
    @Override
    public final void getDataFromDB(){
        wfProcessingOrdersList = new ArrayList();
        wfProcessingOrders = new Vector<>();
        columnNames = new Vector<>();
        wfProcessingOrdersList = QueryExecuter.executeGetterHQLQuery(
                "from Orders o where o.orderStatus = 'Waiting for processing'"
        ); 
        wfProcessingOrdersList.stream().map((o) -> {
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
            wfProcessingOrders.add(oneRow);
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
    public GettingModel getModel() {
        return model;
    }

    @Override
    public Vector<Object> getRows() {
        return wfProcessingOrders;
    }

    @Override
    public Vector<String> getColumnNames() {
        return columnNames;
    }
    
    @Override
    public List<String> getButtonsText() {
        List<String> buttonsText = new ArrayList<>();
        buttonsText.add(buttonText);
        return buttonsText;
    }
    
    @Override
    public String[] getDialogBoxData(){
        List<String> ordersID = new ArrayList<>();
        wfProcessingOrdersList.forEach((order) -> {
            ordersID.add(String.valueOf(order.getIdOrder()));
        });
        return ordersID.toArray(new String[ordersID.size()]);
    }
}
