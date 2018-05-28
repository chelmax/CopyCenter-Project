/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.copycenter.fxui.accountant_ui.view;

import com.mycompany.copycenter.fxui.accountant_ui.controller.AccountantMainMenuController;
import javafx.event.ActionEvent;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.StackPane;

/**
 *
 * @author max19
 */
public class AccountantMainMenu extends StackPane {
    
    private MenuBar menuBar;
    
    public AccountantMainMenu(){
        initNodes();
        layoutNodes();
    }

    private void initNodes() {
        Menu[] menus = new Menu[2];
        menus[0] = new Menu("Profile");
        menus[1] = new Menu("Accountment");
        
        MenuItem profile = new MenuItem("Show info");
        profile.setOnAction((ActionEvent t) -> {
            AccountantMainMenuController.profileMenuItemActionController(
                    this
            );
        });
        menus[0].getItems().add(profile);
        
        MenuItem[] menuItemsManagement = new MenuItem[5];
        MenuItem mi1 = new MenuItem("Orders Log");
        mi1.setOnAction((ActionEvent t) -> {
            AccountantMainMenuController.ordersLogMenuItemActionController(
                    this
            );
        });
        MenuItem mi2 = new MenuItem("Account types");
        mi2.setOnAction((ActionEvent t) -> {
            AccountantMainMenuController.accountTypesMenuItemActionController(
                    this
            );
        });
        MenuItem mi3 = new MenuItem("Account salaries");
        mi3.setOnAction((ActionEvent t) -> {
            AccountantMainMenuController.accountSalariesMenuItemActionController(
                    this
            );
        });
        MenuItem mi4 = new MenuItem("Account materials");
        mi4.setOnAction((ActionEvent t) -> {
            AccountantMainMenuController.accountMaterialsMenuItemActionController(
                    this
            );
        });
        MenuItem mi5 = new MenuItem("Show costs");
        mi5.setOnAction((ActionEvent t) -> {
            AccountantMainMenuController.showCostsMenuItemActionController(
                    this
            );
        });
        menuItemsManagement[0] = mi1;
        menuItemsManagement[1] = mi2;
        menuItemsManagement[2] = mi3;
        menuItemsManagement[3] = mi4;
        menuItemsManagement[4] = mi5;
        menus[1].getItems().addAll(menuItemsManagement);
        
        menuBar = new MenuBar();
        menuBar.getMenus().addAll(menus);
    }

    private void layoutNodes() {
        menuBar.useSystemMenuBarProperty().set(true);
        getChildren().add(menuBar);
    }
       
    public MenuBar getMenuBar() {
        return menuBar;
    }
}
