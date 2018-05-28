/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.copycenter.fxui.manager_ui.view;

import com.mycompany.copycenter.fxui.view.Messages;
import com.mycompany.copycenter.tools.Messanger;
import javafx.scene.control.TextArea;

/**
 *
 * @author max19
 */
public class ManagerMessages extends Messages{
    
    private static final String MANAGER = "manager";
    
    public ManagerMessages() {
        super(MANAGER);
    }

    @Override
    public void updateMsgArea() {
        Messanger msg  = new Messanger(MANAGER);
        TextArea msgArea = (TextArea) centerPane.getChildren().get(0);
        msgArea.setText(msg.getMsgText());
    }
    
}
