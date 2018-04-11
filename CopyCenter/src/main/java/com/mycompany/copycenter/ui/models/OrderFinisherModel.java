/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.copycenter.ui.models;

import com.mycompany.copycenter.entity.Orders;
import com.mycompany.copycenter.tools.CurrentUser;
import com.mycompany.copycenter.tools.QueryExecuter;
import com.mycompany.copycenter.tools.interfaces.OrdersTableWithButtons;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author max19
 */
public class OrderFinisherModel implements OrdersTableWithButtons{
    
    private List<Orders> processingOrdersList;
    private Vector<Object> processingOrders;
    private Vector<String> columnNames;
    private final FinisherModel model = new FinisherModel();
    private final String buttonText = "Finish one";

    
    
    public OrderFinisherModel(){
        getDataFromDB();
    }

    @Override
    public final void getDataFromDB(){
        processingOrdersList = new ArrayList();
        processingOrders = new Vector<>();
        columnNames = new Vector<>();
        processingOrdersList = QueryExecuter.executeGetterHQLQuery(
                "from Orders o where o.orderStatus = 'Processing'"
                + "and o.users.idUser = " + CurrentUser.getCurrentUser().getIdUser()
        ); 
        processingOrdersList.stream().map((o) -> {
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
            processingOrders.add(oneRow);
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
    public FinisherModel getModel() {
        return model;
    }
    
    @Override
    public Vector<Object> getRows() {
        return processingOrders;
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
        processingOrdersList.forEach((order) -> {
            ordersID.add(String.valueOf(order.getIdOrder()));
        });
        return ordersID.toArray(new String[ordersID.size()]);
    }
    
}
