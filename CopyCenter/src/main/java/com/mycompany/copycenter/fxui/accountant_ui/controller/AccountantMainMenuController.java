/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.copycenter.fxui.accountant_ui.controller;

import com.mycompany.copycenter.fxui.accountant_ui.view.AccountantMainMenu;
import com.mycompany.copycenter.fxui.accountant_ui.view.AccountantMainPane;
import com.mycompany.copycenter.fxui.accountant_ui.view.MaterialsAccountPane;
import com.mycompany.copycenter.fxui.accountant_ui.view.OrdersLogPane;
import com.mycompany.copycenter.fxui.accountant_ui.view.SalariesAccountPane;
import com.mycompany.copycenter.fxui.accountant_ui.view.ShowCostsPane;
import com.mycompany.copycenter.fxui.accountant_ui.view.TypesAccountPane;
import com.mycompany.copycenter.fxui.view.Profile;

/**
 *
 * @author max19
 */
public class AccountantMainMenuController {
    
    public static void profileMenuItemActionController(AccountantMainMenu view) {
        AccountantMainPane mainPane  = (AccountantMainPane) view.getParent();
        mainPane.setCenter(new Profile());
    }

    public static void ordersLogMenuItemActionController(AccountantMainMenu view) {
        AccountantMainPane mainPane  = (AccountantMainPane) view.getParent();
        mainPane.setCenter(new OrdersLogPane());
    }

    public static void accountSalariesMenuItemActionController(AccountantMainMenu view) {
        AccountantMainPane mainPane  = (AccountantMainPane) view.getParent();
        mainPane.setCenter(new SalariesAccountPane());
    }
    
    public static void accountMaterialsMenuItemActionController(AccountantMainMenu view) {
        AccountantMainPane mainPane  = (AccountantMainPane) view.getParent();
        mainPane.setCenter(new MaterialsAccountPane());
    }

    public static void showCostsMenuItemActionController(AccountantMainMenu view) {
        AccountantMainPane mainPane  = (AccountantMainPane) view.getParent();
        mainPane.setCenter(new ShowCostsPane());
    }

    public static void accountTypesMenuItemActionController(AccountantMainMenu view) {
        AccountantMainPane mainPane  = (AccountantMainPane) view.getParent();
        mainPane.setCenter(new TypesAccountPane());
    }
    
}
