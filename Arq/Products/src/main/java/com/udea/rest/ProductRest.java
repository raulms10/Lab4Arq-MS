/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.rest;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author estudiantelis
 */
@Named
@Path("/")
public class ProductRest {
    private static final List<Product> Products = new ArrayList<Product>();
    static{
        Product product1 = new Product(1, "Product1", "Description1", 10, 150);
        Product product2 = new Product(2, "Product2", "Description2", 23, 30);
        Product product3 = new Product(3, "Product3", "Description3", 55, 105);
        Product product4 = new Product(4, "Product4", "Description4", 27, 45);
        Product product5 = new Product(5, "Product5", "Description5", 87, 120);
        
        Products.add(product1);
        Products.add(product2);
        Products.add(product3);
        Products.add(product4);
        Products.add(product5);
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> getProducts(){
        return Products;
    }
    
    @GET
    @Path("/product/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Product getCustomer(@PathParam("id") long id) {
        Product prod = null;
        for (Product p : Products) {
            if (p.getId() == id)
                prod = p;
        }
        return prod;
    }
}
