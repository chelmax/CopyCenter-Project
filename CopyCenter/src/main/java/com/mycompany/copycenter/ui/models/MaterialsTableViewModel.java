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
public class MaterialsTableViewModel extends DefaultTableModel{
    Class[] types = new Class [] {
        java.lang.String.class, 
        java.lang.Integer.class, 
        java.lang.Float.class 
    };
    
    boolean[] canEdit = new boolean [] {
        false, false, false
    };

    @Override
    public Class getColumnClass(int columnIndex) {
        return types [columnIndex];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit [columnIndex];
    }
    
    public MaterialsTableViewModel(Vector data, Vector columnNames) {
        super(data, columnNames);
    }
    
    public void changeModel() {
        fireTableDataChanged();
    }
    
}
