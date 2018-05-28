/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.copycenter.fxui.manager_ui.controller;

import com.mycompany.copycenter.fxui.manager_ui.view.ManagerMainMenu;
import com.mycompany.copycenter.fxui.manager_ui.view.ManagerMainPane;
import com.mycompany.copycenter.fxui.manager_ui.view.OrderCreator;
import com.mycompany.copycenter.fxui.manager_ui.view.OrdersPaymentPane;
import com.mycompany.copycenter.fxui.view.Profile;

/**
 *
 * @author max19
 */
public class ManagerMainMenuController {

    public static void profileMenuItemActionController(ManagerMainMenu view) {
        ManagerMainPane mainPane  = (ManagerMainPane) view.getParent();
        mainPane.setCenter(new Profile());
    }
    
    public static void createOrderMenuItemActionController(ManagerMainMenu view) {
        ManagerMainPane mainPane  = (ManagerMainPane) view.getParent();
        mainPane.setCenter(new OrderCreator());
    }

    public static void confirmPaymentMenuItemActionController(ManagerMainMenu view) {
        ManagerMainPane mainPane  = (ManagerMainPane) view.getParent();
        mainPane.setCenter(new OrdersPaymentPane());
    }
    
}
