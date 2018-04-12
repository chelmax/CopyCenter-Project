/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.copycenter.tools;

import com.mycompany.copycenter.entity.Orders;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author max19
 */
public class Messenger {                                                        //дебажить
    
    private String msgText;
    
    public Messenger(String callerPost){
        StringBuilder sb = new StringBuilder();
        switch(callerPost){
            case "manager":
                sb.append(unpaidOrdersMsg());
                break;
            case "operator":
                sb.append(newOrdersMsg()).append(unprocessedOrdersMsg());
                break;
            case "accountant":
                sb.append(notEnoughMaterialsMsg());
                break;
            default:
                System.err.println("Unknown caller");
        }
        msgText = sb.toString();
        if(msgText.isEmpty()){
            msgText = sb.append("Nothing new detected").toString();
        }
    }
    
    private String unpaidOrdersMsg(){
        List<Orders> processedOrders = QueryExecuter.executeGetterHQLQuery(
            "from Orders o where o.orderStatus = 'Processed'"
        );
        if(!processedOrders.isEmpty())
            return "Unpaid orders: " + processedOrders.size() + "\n";
        return null;
    }
    
    private String newOrdersMsg(){
        List<Orders> newOrders = QueryExecuter.executeGetterHQLQuery(
            "from Orders o where o.orderStatus = 'Waiting for processing'"
        );
        if(!newOrders.isEmpty())
            return "New orders: " + newOrders.size() + "\n";
        return null;
    }
    
    private String unprocessedOrdersMsg(){
        List<Orders> newOrders = QueryExecuter.executeGetterHQLQuery(
            "from Orders o where o.orderStatus = 'Processing' " +
            "and o.users.id = = " + CurrentUser.getCurrentUser().getIdUser()
        );
        if(!newOrders.isEmpty())
            return "New orders: " + newOrders.size() + "\n";
        return null;
    }
    
    private String notEnoughMaterialsMsg(){
            List<String> msgList = getMsgList();
            if(!msgList.isEmpty()){
                StringBuilder sb = new StringBuilder();
                msgList.forEach((msg) -> {
                    sb.append("Not Enough: ").append(msg).append("\n");
                });
                return sb.toString();
            } else{
                return null;
            }
        
    }
    
    private static List<String> getMsgList(){
        try(FileInputStream fis =  new FileInputStream("acntmsgs.bin")){
            ObjectInputStream is = new ObjectInputStream(fis);
            return (ArrayList) is.readObject();
        }catch(Exception ex){
            return null;
        }
    }
    
    public static void createMaterialsMsg(List<String> materials){
        List<String> newMsg = new ArrayList<>();
        List<String> msgList = getMsgList();
        newMsg.addAll(msgList);
        newMsg.addAll(materials);
        try(FileOutputStream fos =  new FileOutputStream("pricelist.bin")){
            ObjectOutputStream os = new ObjectOutputStream(fos);
            os.writeObject(newMsg);
        }catch(Exception ex){
            System.err.println(ex);
        }
        
    }
}
