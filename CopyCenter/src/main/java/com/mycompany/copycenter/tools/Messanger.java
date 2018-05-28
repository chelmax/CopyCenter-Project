/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.copycenter.tools;

import com.mycompany.copycenter.entity.Orders;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author max19
 */
public class Messanger {                                                        
    
    private String msgText;

    public String getMsgText() {
        return msgText;
    }
    
    public Messanger(String callerPost){
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
        if(msgText.isEmpty())
            msgText = sb.append("Nothing new detected").toString();
    }
    
    private String unpaidOrdersMsg(){
        List<Orders> processedOrders = QueryExecuter.executeGetterHQLQuery(
            "from Orders o where o.orderStatus = 'Processed'"
        );
        if(!processedOrders.isEmpty())
            return "Unpaid orders: " + processedOrders.size() + "\n";
        return "";
    }
    
    private String newOrdersMsg(){
        List<Orders> newOrders = QueryExecuter.executeGetterHQLQuery(
            "from Orders o where o.orderStatus = 'Waiting for processing'"
        );
        if(!newOrders.isEmpty())
            return "New orders: " + newOrders.size() + "\n";
        return "";
    }
    
    private String unprocessedOrdersMsg(){
        List<Orders> unprocessedOrders = QueryExecuter.executeGetterHQLQuery(
            "from Orders o where o.orderStatus = 'Processing' " +
            "and o.users.id = " + CurrentUser.getCurrentUser().getIdUser()
        );
        if(!unprocessedOrders.isEmpty())
            return "Unprocessed orders: " + unprocessedOrders.size() + "\n";
        return "";
    }
    
    private String notEnoughMaterialsMsg(){
        Map<String, Integer> msgMap = getMsgMap();
        if(msgMap != null){
            StringBuilder sb = new StringBuilder();
            msgMap.keySet().forEach((key) -> {
                sb.append("Not enough: ")
                        .append(msgMap.get(key))
                        .append(" pieces of ")
                        .append(key)
                        .append("\n");
            });
            return sb.toString();
        } else{
            return "";
        }
    }
    
    private static Map<String, Integer> getMsgMap(){
        try(FileInputStream fis =  new FileInputStream("acntmsgs.bin")){
            ObjectInputStream is = new ObjectInputStream(fis);
            return (Map) is.readObject();
        }catch(Exception ex){
            return null;
        }
    }
    
    public static void createMaterialsMsg(String material, Integer size){
        Map<String, Integer> newMsg = new HashMap<>();
        Map<String, Integer> msgMap = getMsgMap();
        if(msgMap != null){                                                     
            newMsg.putAll(msgMap);
            if(newMsg.get(material) == null)
                newMsg.put(material, size);
            else
                return;
        } else{
            newMsg.put(material, size);
        }
        try(FileOutputStream fos =  new FileOutputStream("acntmsgs.bin")){
            ObjectOutputStream os = new ObjectOutputStream(fos);
            os.writeObject(newMsg);
        }catch(Exception ex){
            System.err.println(ex);
        }
    }
    
    public static void clearMsgMap(){
        File f = new File("acntmsgs.bin");
        f.delete();
        try(FileOutputStream fos =  new FileOutputStream(f)){
            ObjectOutputStream os = new ObjectOutputStream(fos);
            os.writeObject(new HashMap<>());
        }catch(Exception ex){
            System.err.println(ex);
        }
    }
}
