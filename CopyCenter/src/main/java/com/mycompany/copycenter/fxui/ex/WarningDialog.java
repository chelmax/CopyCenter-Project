/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.copycenter.fxui.ex;

import javafx.scene.control.Alert;

/**
 *
 * @author max19
 */
public class WarningDialog extends Alert{
    
    private final String  headerMsg;
    private final String  exceptionMsg;
    
    public WarningDialog(String headerMsg, String exceptionMsg){
        super(Alert.AlertType.WARNING);
        this.headerMsg = headerMsg;
        this.exceptionMsg = exceptionMsg;
        initNodes();
    }

    private void initNodes() {
        this.setTitle("Warning");
        this.setHeaderText(headerMsg);
        this.setContentText(exceptionMsg);
    }
    
}
