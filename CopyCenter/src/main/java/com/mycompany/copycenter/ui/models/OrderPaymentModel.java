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
public class OrderPaymentModel implements OrdersTableWithButtons{
    
    private List<Orders> processedOrdersList = new ArrayList();
    private Vector<Object> processedOrders = new Vector<>();
    private Vector<String> columnNames = new Vector<>();
    private final PaymentModel model = new PaymentModel();
    private final String buttonText = "Payment";

    
    
    
    public OrderPaymentModel(){
        getDataFromDB();
    }
    
    @Override
    public final void getDataFromDB(){
        processedOrdersList = new ArrayList();
        processedOrders = new Vector<>();
        columnNames = new Vector<>();
        processedOrdersList = QueryExecuter.executeGetterHQLQuery(
                "from Orders o where o.orderStatus = 'Processed'"
        ); 
        processedOrdersList.stream().map((o) -> {
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
            processedOrders.add(oneRow);
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
    public PaymentModel getModel() {
        return model;
    }

    @Override
    public Vector<Object> getRows() {
        return processedOrders;
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
        processedOrdersList.forEach((order) -> {
            ordersID.add(String.valueOf(order.getIdOrder()));
        });
        return ordersID.toArray(new String[ordersID.size()]);
    }
    
}
