/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.copycenter.fxui.models.accountant;

import com.mycompany.copycenter.entity.Types;
import com.mycompany.copycenter.tools.PriceHolder;
import com.mycompany.copycenter.tools.QueryExecuter;
import java.util.List;
import java.util.Map;

/**
 *
 * @author max19
 */
public class TypeRemoverModel {
    
    public boolean update(String name) {
        List<Types> deletedType = QueryExecuter.executeGetterHQLQuery(
                "from Types t where t.name = '" + name + "'"
        );
        Integer id = deletedType.get(0).getIdType();
        QueryExecuter.executeSQLQuery("Delete from Cost "
                + "where Type_idType = " + id
        );
        QueryExecuter.executeSQLQuery("Delete from Orders "
                + "where idType = " + id
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
