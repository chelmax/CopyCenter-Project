/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.copycenter.fxui.operator_ui.view;

import com.mycompany.copycenter.fxui.operator_ui.controller.OperatorMainMenuController;
import javafx.event.ActionEvent;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.StackPane;

/**
 *
 * @author max19
 */
public class OperatorMainMenu extends StackPane{
    
    private MenuBar menuBar;
    
    public OperatorMainMenu(){
        initNodes();
        layoutNodes();
    }

    private void initNodes() {
        Menu[] menus = new Menu[2];
        menus[0] = new Menu("Profile");
        menus[1] = new Menu("Orders");
        
        MenuItem profile = new MenuItem("Show info");
        profile.setOnAction((ActionEvent t) -> {
            OperatorMainMenuController.profileMenuItemActionController(
                    this
            );
        });
        menus[0].getItems().add(profile);
        
        MenuItem[] menuItemsManagement = new MenuItem[2];
        MenuItem mi1 = new MenuItem("Take order");
        mi1.setOnAction((ActionEvent t) -> {
            OperatorMainMenuController.takeOrderMenuItemActionController(
                    this
            );
        });
        MenuItem mi2 = new MenuItem("Finish order");
        mi2.setOnAction((ActionEvent t) -> {
            OperatorMainMenuController.finishOrderMenuItemActionController(
                    this
            );
        });
        menuItemsManagement[0] = mi1;
        menuItemsManagement[1] = mi2;
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
