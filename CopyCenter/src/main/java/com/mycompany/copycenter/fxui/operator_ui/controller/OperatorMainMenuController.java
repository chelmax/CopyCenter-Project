/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.copycenter.fxui.operator_ui.controller;

import com.mycompany.copycenter.fxui.operator_ui.view.OperatorMainMenu;
import com.mycompany.copycenter.fxui.operator_ui.view.OperatorMainPane;
import com.mycompany.copycenter.fxui.operator_ui.view.OrdersFinisherPane;
import com.mycompany.copycenter.fxui.operator_ui.view.OrdersGettingPane;
import com.mycompany.copycenter.fxui.view.Profile;

/**
 *
 * @author max19
 */
public class OperatorMainMenuController {
    
    public static void profileMenuItemActionController(OperatorMainMenu view) {
        OperatorMainPane mainPane  = (OperatorMainPane) view.getParent();
        mainPane.setCenter(new Profile());
    }
    
    public static void takeOrderMenuItemActionController(OperatorMainMenu view) {
        OperatorMainPane mainPane  = (OperatorMainPane) view.getParent();
        mainPane.setCenter(new OrdersGettingPane());
    }

    public static void finishOrderMenuItemActionController(OperatorMainMenu view) {
        OperatorMainPane mainPane  = (OperatorMainPane) view.getParent();
        mainPane.setCenter(new OrdersFinisherPane());
    }
    
}
