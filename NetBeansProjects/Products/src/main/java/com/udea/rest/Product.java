/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.rest;

import com.fasterxml.jackson.annotation.JsonRootName;

/**
 *
 * @author estudiantelis
 */
@JsonRootName("Product")
public class Product {
    private long id;
    private String name;
    private String description;
    private long amount;
    private long pu;

    public Product() {
    }

    public Product(long id, String name, String description, long amount, long pu) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.amount = amount;
        this.pu = pu;
    }

    public long getId() {return id;}

    public void setId(long id) {this.id = id;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}
    
    public String getDescription() {return description;}

    public void setDescription(String description) {this.description = description;}
    
    public long getAmount() {return amount;}

    public void setAmount(long amount) {this.amount = amount;}

    public long getPu() {return pu;}

    public void setPu(long pu) {this.pu = pu;}
    
}
