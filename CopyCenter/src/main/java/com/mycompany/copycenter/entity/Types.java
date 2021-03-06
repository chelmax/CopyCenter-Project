package com.mycompany.copycenter.entity;
// Generated 18.05.2018 13:12:55 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Types generated by hbm2java
 */
public class Types  implements java.io.Serializable {


     private Integer idType;
     private String name;
     private Set costs = new HashSet(0);
     private Set orderses = new HashSet(0);

    public Types() {
    }

	
    public Types(String name) {
        this.name = name;
    }
    public Types(String name, Set costs, Set orderses) {
       this.name = name;
       this.costs = costs;
       this.orderses = orderses;
    }
   
    public Integer getIdType() {
        return this.idType;
    }
    
    public void setIdType(Integer idType) {
        this.idType = idType;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public Set getCosts() {
        return this.costs;
    }
    
    public void setCosts(Set costs) {
        this.costs = costs;
    }
    public Set getOrderses() {
        return this.orderses;
    }
    
    public void setOrderses(Set orderses) {
        this.orderses = orderses;
    }




}


