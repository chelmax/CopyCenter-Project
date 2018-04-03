/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.copycenter.ui.models;

import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author max19
 */
public class OrdersTableViewModel extends DefaultTableModel{
    Class[] types = new Class [] {
        java.lang.Integer.class, 
        java.lang.String.class, 
        java.lang.String.class, 
        java.lang.String.class, 
        java.lang.Integer.class, 
        java.lang.Float.class, 
        java.lang.String.class
    };
    
    boolean[] canEdit = new boolean [] {
        false, false, false, false, false, false, false
    };

    @Override
    public Class getColumnClass(int columnIndex) {
        return types [columnIndex];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit [columnIndex];
    }
    
    public OrdersTableViewModel(Vector data, Vector columnNames) {
        super(data, columnNames);
    }
    
    public void changeModel() {
        fireTableDataChanged();
    }
    
    
}
