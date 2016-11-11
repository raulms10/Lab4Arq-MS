/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
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
    
    @Autowired
    ClientService helloWorldService;
    
    @RequestMapping("/customer")
    public String goHome(Model model){
        helloWorldService = MsCustomerClientApplication.clientService();
        List<Customer> customers = helloWorldService.greetingAll();
        Map<String,Object> params = new HashMap<>();
        for (int i=0; i<customers.size(); i++){
            params.put("email"+i,customers.get(i).getEmail());
            params.put("name"+i, customers.get(i).getName());
        }
        model.addAllAttributes(params);
        return "greetingAll";
    }
    
    @RequestMapping("/customer/{id}")
    @HystrixCommand(fallbackMethod = "greetingDefault")
    public String greeting(Model model, @PathVariable("id") long id){
        helloWorldService = MsCustomerClientApplication.clientService();
        Customer greeting = helloWorldService.greeting(id);
        Map<String,Object> params = new HashMap<>();
        params.put("email",greeting.getEmail());
        params.put("name", greeting.getName());
        System.out.println("name: " + greeting.getName());
        System.out.println("email: " + greeting.getEmail());
        model.addAllAttributes(params);
        return "greeting";
    }
    public String greetingDefault(Model model, @PathVariable("id") long id){
        Customer greeting = helloWorldService.greetingDefault();
        Map<String,Object> params = new HashMap<>();
        params.put("email",greeting.getEmail());
        params.put("name", greeting.getName());
        System.out.println("name2: " + greeting.getName());
        System.out.println("email2: " + greeting.getEmail());
        model.addAllAttributes(params);
        return "greeting";
    }
}
