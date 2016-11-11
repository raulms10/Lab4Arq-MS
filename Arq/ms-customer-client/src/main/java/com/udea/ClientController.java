/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author estudiantelis
 */
@Controller
public class ClientController {
    private ClientService helloWorldService;
    //No se ejecuta
    public ClientController(){
    }
    
    public ClientController(ClientService helloWorldService){
        this.helloWorldService = helloWorldService;
    }
    
    @RequestMapping("/customer")
    public String goHome(){
        return "greeting";
    }
    
    @RequestMapping("/customer/{id}")
    public String greeting(@PathVariable("id") long id){
        System.out.println("al menos");
        Customer greeting = helloWorldService.greeting(id);
        Map<String,Object> params = new HashMap<>();
        params.put("email",greeting.getEmail());
        params.put("name", greeting.getName());
        //model.addAllAttributes(params);
        return "greeting";
    }
    
  
}
