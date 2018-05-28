/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.copycenter.fxui.view;

import com.mycompany.copycenter.entity.Orders;
import com.mycompany.copycenter.entity.Users;
import com.mycompany.copycenter.tools.CurrentUser;
import java.util.Set;
import javafx.geometry.Insets;
import javafx.scene.control.TextArea;
import javafx.scene.layout.StackPane;

/**
 *
 * @author max19
 */
public class Profile extends StackPane{
 
    public Profile() {
        initNodes();
    }

    private void initNodes() {
        TextArea profileInfoArea = new TextArea();
        profileInfoArea.setEditable(false);
        profileInfoArea.setPadding(new Insets(50, 100, 50, 100));
        profileInfoArea.setText(getUserInfo());
        this.getChildren().add(profileInfoArea);
    }
    
    private String getUserInfo() {
        Users currentUser = CurrentUser.getCurrentUser();
        String userInfo = "Name - " +  currentUser.getName() + 
                "\nSurname - " + currentUser.getSurname() +
                "\nPost - " + currentUser.getPost() +
                "\nSalary - " + currentUser.getSalary();
        if(currentUser.getPost().equals("operator")){
            Set<Orders> usersOrders = currentUser.getOrderses();
            int count = (int) usersOrders.stream()
                    .filter((o) -> (o.getOrderStatus().equals("Processed")))
                    .count();
            userInfo += " +10% from processed orders" +
                    "\nProcessed orders - " + count;
        }  
        return userInfo;
    }
    
    
}
