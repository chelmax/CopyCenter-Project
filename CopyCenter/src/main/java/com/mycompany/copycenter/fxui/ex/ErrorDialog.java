/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.copycenter.fxui.ex;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 *
 * @author max19
 */
public class ErrorDialog extends Alert{
    
    private final String  headerMsg;
    private final String  exceptionMsg;
    
    public ErrorDialog(String headerMsg, String exceptionMsg){
        super(AlertType.ERROR);
        this.headerMsg = headerMsg;
        this.exceptionMsg = exceptionMsg;
        initNodes();
    }

    private void initNodes() {
        this.setTitle("Error");
        this.setHeaderText(headerMsg);
        this.setContentText(exceptionMsg);
    }
    
}
