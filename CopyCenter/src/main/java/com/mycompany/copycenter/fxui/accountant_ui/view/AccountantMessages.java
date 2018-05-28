/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.copycenter.fxui.accountant_ui.view;

import com.mycompany.copycenter.fxui.view.Messages;
import com.mycompany.copycenter.tools.Messanger;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

/**
 *
 * @author max19
 */
public class AccountantMessages extends Messages{
    
    private static final String ACCOUNTANT = "accountant";
    
    public AccountantMessages() {
        super(ACCOUNTANT);
        Button clearBtn = new Button("Clear area");
        clearBtn.setOnAction((ActionEvent t) -> {
                Messanger.clearMsgMap();
                updateMsgArea();
        });
        clearBtn.setPrefWidth(111);
        bottomPane.getChildren().add(clearBtn);
    }

    @Override
    public void updateMsgArea() {
        Messanger msg  = new Messanger(ACCOUNTANT);
        TextArea msgArea = (TextArea) centerPane.getChildren().get(0);
        msgArea.setText(msg.getMsgText());
    }
    
}
