/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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
    
    @HystrixCommand(fallbackMethod = "greetingDefault")
    public Customer greeting(long id){
        restTemplate = MsCustomerClientApplication.restTemplate();
        return restTemplate.getForObject(serviceUrl + "/customer/{id}", Customer.class, id);        
    }
    
    public Customer greetingDefault(long id) {
        System.out.println(":) " + id);
        return new Customer(14, "n14","e14");
        
     }
    
    @Autowired
    protected RestTemplate restTemplate ;
    protected String serviceUrl;
}
