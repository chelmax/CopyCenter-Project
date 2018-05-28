/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.copycenter.fxui.manager_ui.view;

import com.mycompany.copycenter.fxui.view.MainPane;

/**
 *
 * @author max19
 */
public class ManagerMainPane extends MainPane {
    
    public ManagerMainPane() {
        super(new ManagerMainMenu(), new ManagerMessages());
    }
    
}
