/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea;

import java.util.HashMap;
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
public class ProductController {
  
    @RequestMapping("/")
    public String home(){
        return "index";
    }   
    
    @Autowired
    ProductService helloWorldService;
    
    @RequestMapping("/product")
    public String goHome(){
        return "index";
    }
    
    @RequestMapping("/product/{id}")
    public String greeting(Model model, @PathVariable("id") long id){
        helloWorldService = ProductsClientApplication.productService();
        Product greeting = helloWorldService.greeting(id);
        Map<String,Object> params = new HashMap<>();
        params.put("name",greeting.getName());
        params.put("description", greeting.getDescription());
        params.put("amount",greeting.getAmount());
        params.put("pu",greeting.getPu());
        model.addAllAttributes(params);
        return "greeting";
    }
}
