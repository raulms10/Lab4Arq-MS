package com.udea;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(useDefaultFilters=false) //Desactive el escaner de componente
public class ProductsClientApplication {
    private static final String SERVICE_URL = "http://localhost:4444";
    
    public static void main(String[] args) {
            SpringApplication.run(ProductsClientApplication.class, args);
    }
        
    @LoadBalanced
    @Bean
    public static RestTemplate restTemplate(){
        return new RestTemplate();
    }
    
    @Bean
    public static ProductService productService(){
        return new ProductService(SERVICE_URL);
    }
    
    @Bean
    public ProductController productController(){
        return new ProductController();
    }
}
