/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.copycenter.fxui.accountant_ui.view;

import com.mycompany.copycenter.fxui.view.MainPane;

/**
 *
 * @author max19
 */
public class AccountantMainPane extends MainPane {
    
    public AccountantMainPane() {
        super(new AccountantMainMenu(), new AccountantMessages());
    }
    
}
