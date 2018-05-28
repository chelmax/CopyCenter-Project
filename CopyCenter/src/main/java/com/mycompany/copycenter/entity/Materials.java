package com.mycompany.copycenter.entity;
// Generated 18.05.2018 13:12:55 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Materials generated by hbm2java
 */
public class Materials  implements java.io.Serializable {


     private Integer idMaterials;
     private String name;
     private int quantity;
     private float cost;
     private Set costs = new HashSet(0);

    public Materials() {
    }

	
    public Materials(String name, int quantity, float cost) {
        this.name = name;
        this.quantity = quantity;
        this.cost = cost;
    }
    public Materials(String name, int quantity, float cost, Set costs) {
       this.name = name;
       this.quantity = quantity;
       this.cost = cost;
       this.costs = costs;
    }
   
    public Integer getIdMaterials() {
        return this.idMaterials;
    }
    
    public void setIdMaterials(Integer idMaterials) {
        this.idMaterials = idMaterials;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public int getQuantity() {
        return this.quantity;
    }
    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public float getCost() {
        return this.cost;
    }
    
    public void setCost(float cost) {
        this.cost = cost;
    }
    public Set getCosts() {
        return this.costs;
    }
    
    public void setCosts(Set costs) {
        this.costs = costs;
    }




}


