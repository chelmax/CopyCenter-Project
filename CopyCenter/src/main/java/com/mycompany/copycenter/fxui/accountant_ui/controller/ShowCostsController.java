/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.copycenter.fxui.accountant_ui.controller;

import com.mycompany.copycenter.fxui.accountant_ui.view.ShowCostsPane;
import com.mycompany.copycenter.fxui.view.HomePane;
import com.mycompany.copycenter.fxui.models.accountant.CostsModel;
import javafx.scene.layout.BorderPane;

/**
 *
 * @author max19
 */
public class ShowCostsController {
    
    private static final CostsModel MODEL = new CostsModel();
    
    public static void payOffButtonActionPerformed(ShowCostsPane view) {
        MODEL.payOff();
        ((BorderPane) view.getParent()).setCenter(new HomePane());
    }
    
}
