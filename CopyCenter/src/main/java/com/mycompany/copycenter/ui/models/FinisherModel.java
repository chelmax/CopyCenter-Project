/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.copycenter.ui.models;

import com.mycompany.copycenter.tools.interfaces.TextWithBox;
import com.mycompany.copycenter.entity.Cost;
import com.mycompany.copycenter.entity.Materials;
import com.mycompany.copycenter.entity.Orders;
import com.mycompany.copycenter.entity.Users;
import com.mycompany.copycenter.tools.CostsHolder;
import com.mycompany.copycenter.tools.CurrentUser;
import com.mycompany.copycenter.tools.Messanger;
import com.mycompany.copycenter.tools.PriceHolder;
import com.mycompany.copycenter.tools.QueryExecuter;
import java.util.Set;

/**
 *
 * @author max19
 */
public class FinisherModel implements TextWithBox{

    private final String infoText = "The number of the processed order is";
    
    @Override
    public String getInfoText() {
        return infoText;
    }

    @Override
    public boolean update(String id) {
        Orders currentOrder = (Orders) QueryExecuter.executeGetterHQLQuery(
                "from Orders o where o.id = " + id
        ).get(0);
        Set<Cost> currentCost = currentOrder.getTypes().getCosts();
        boolean flag = false;
        for(Cost cost : currentCost){
            Materials material = cost.getMaterials();
            int finalCost = cost.getSizePerOne() * currentOrder.getSize();
            if(material.getQuantity() < finalCost){
                Messanger.createMaterialsMsg(
                        material.getName() + " (order #" + id + ")",
                        (finalCost - material.getQuantity())
                );
                flag = true;
            }
        }
        if(flag)
            return false;
        currentCost.forEach((cost) -> {                                           
            QueryExecuter.executeSQLQuery("UPDATE Materials "
                    + "set quantity = quantity - " + cost.getSizePerOne() * currentOrder.getSize() + " "
                    + "where idMaterials = " + cost.getMaterials().getIdMaterials());
        });
        QueryExecuter.executeSQLQuery("UPDATE Orders "
                + "set orderStatus = 'Processed' "
                + "where idOrder = " + id);
        CostsHolder ch = new CostsHolder();
        Float eleCost = ch.getElement("electricity") 
                + new PriceHolder().getElement("electricity") * currentOrder.getSize();
        ch.setMap("electricity", eleCost);
        CurrentUser.setCurrentUser((Users)QueryExecuter.executeGetterHQLQuery(
                "from Users u where u.id = " + CurrentUser.getCurrentUser().getIdUser()
        ).get(0));
        return true;
    }
    
}
