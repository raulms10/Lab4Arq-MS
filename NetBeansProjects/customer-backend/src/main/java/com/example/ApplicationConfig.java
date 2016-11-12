/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import javax.inject.Named;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;
/**
 *
 * @author Rosita
 */
@Configuration
public class ApplicationConfig {
@Named
static class JerseyConfig extends ResourceConfig {
public JerseyConfig() {
this.packages("com.example.rest");
}
}
}
