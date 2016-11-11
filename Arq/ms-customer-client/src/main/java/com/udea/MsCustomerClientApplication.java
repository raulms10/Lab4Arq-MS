package com.udea;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
@EnableHystrixDashboard
@ComponentScan(useDefaultFilters=false) //Desactive el escaner de componente
public class MsCustomerClientApplication {
    private static final String SERVICE_URL = "http://localhost:2222";
    
    public static void main(String[] args) {
            SpringApplication.run(MsCustomerClientApplication.class, args);
            System.out.println("Inicia");
    }
    
    @LoadBalanced
    @Bean
    public static RestTemplate restTemplate(){
        return new RestTemplate();
    }
    
    @Bean
    public static ClientService clientService(){
        return new ClientService(SERVICE_URL);
    }
    
    @Bean
    public ClientHomeController homeController(){
        return new ClientHomeController();
    }
}
