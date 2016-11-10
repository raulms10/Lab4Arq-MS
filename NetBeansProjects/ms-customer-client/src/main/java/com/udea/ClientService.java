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
public class ClientService {
    
    public ClientService(String serviceUrl){
        this.serviceUrl = serviceUrl.startsWith("http") ? serviceUrl: "http//" + serviceUrl;
    }

    public Customer greeting(long id){
        restTemplate = MsCustomerClientApplication.restTemplate();
        return restTemplate.getForObject(serviceUrl + "/customer/{id}", Customer.class, id);        
    }
    
    public Customer greetingDefault() {
        return new Customer(14, "n14","e14");
    }
    
    @Autowired
    protected RestTemplate restTemplate ;
    protected String serviceUrl;
}
