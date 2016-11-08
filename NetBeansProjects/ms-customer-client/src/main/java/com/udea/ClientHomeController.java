/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea;

import java.util.HashMap;
import java.util.Map;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author estudiantelis
 */
@Controller
public class ClientHomeController {
    @RequestMapping("/")
    public String home(){
        return "index";
    }
    
    @RequestMapping("/customer")
    public String goHome(){
        return "greeting";
    }
    
    @RequestMapping("/customer/{id}")
    public String greeting(Model model, @PathVariable("id") long id){
        ClientService helloWorldService = new ClientService("http://localhost:2222");
        Customer greeting = helloWorldService.greeting(id);
        Map<String,Object> params = new HashMap<>();
        params.put("email",greeting.getEmail());
        params.put("name", greeting.getName());
        System.out.println("email: " + greeting.getEmail());
        model.addAllAttributes(params);
        return "greeting";
    }
}
