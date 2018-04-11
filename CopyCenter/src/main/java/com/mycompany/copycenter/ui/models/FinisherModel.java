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
import com.mycompany.copycenter.tools.CostsHolder;
import com.mycompany.copycenter.tools.PriceHolder;
import com.mycompany.copycenter.tools.QueryExecuter;
import java.util.List;

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
        List<Cost> currentCost = QueryExecuter.executeGetterHQLQuery("from Cost c "
                + "where c.types.id = "
                + "(from Orders o "
                + "where o.id = " + id + ")"
        );
        for(Cost cost : currentCost){
            List<Materials> materials = QueryExecuter.executeGetterHQLQuery("from Materials m "
                + "where m.id = " + cost.getMaterials().getIdMaterials());
            if(materials.get(0).getQuantity() < cost.getSizePerOne() * currentOrder.getSize()){
                return false;
            }
        }
        currentCost.forEach((cost) -> {                                           
            QueryExecuter.executeSQLQuery("UPDATE Materials "
                    + "set quantity = quantity - " + cost.getSizePerOne() * currentOrder.getSize() + " "
                    + "where idMaterials = " + cost.getMaterials().getIdMaterials());
        });
        QueryExecuter.executeSQLQuery("UPDATE Orders "
                + "set orderStatus = 'Processed' "
                + "where idOrder = " + id);
        CostsHolder ch = new CostsHolder();
        Float eleCost = ch.getElement("electricity") + new PriceHolder().getElement("electricity");
        ch.setMap("electricity", eleCost);
        return true;
    }
    
}
