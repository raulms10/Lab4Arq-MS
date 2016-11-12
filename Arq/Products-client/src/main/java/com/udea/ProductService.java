/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author estudiantelis
 */
@Service
public class ProductService {
    @Autowired
    protected RestTemplate restTemplate ;
    protected String serviceUrl;
    
     public ProductService(String serviceUrl){
        this.serviceUrl = serviceUrl.startsWith("http") ? serviceUrl: "http://" + serviceUrl;
    }

    public Product greeting(long id){
        restTemplate = ProductsClientApplication.restTemplate();
        return restTemplate.getForObject(serviceUrl + "/product/{id}", Product.class, id);        
    }
}
