/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.copycenter.ui.models;

import com.mycompany.copycenter.entity.Types;
import com.mycompany.copycenter.tools.PriceHolder;
import com.mycompany.copycenter.tools.QueryExecuter;
import com.mycompany.copycenter.tools.interfaces.TextWithBox;
import java.util.List;
import java.util.Map;

/**
 *
 * @author max19
 */
public class TypeRemoverModel implements TextWithBox{                           //не дебажилось

    private final String infoText = "The name of the type to delete is";
    
    @Override
    public String getInfoText() {
        return infoText;
    }

    @Override
    public boolean update(String name) {
        List<Types> deletedType = QueryExecuter.executeGetterHQLQuery(
                "from Types t where t.name = '" + name + "'"
        );
        Integer id = deletedType.get(0).getIdType();
        QueryExecuter.executeSQLQuery("Delete from Cost "
                + "where Type_idType = " + id
        );
        QueryExecuter.executeSQLQuery("Delete from Types "
                + "where idType = " + id
        );
        PriceHolder ph = new PriceHolder();
        Map phMap = ph.getMap();
        phMap.remove(name);
        ph.setMap(phMap);
        return true;
    }
    
}
