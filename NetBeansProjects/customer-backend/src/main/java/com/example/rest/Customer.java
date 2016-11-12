/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.rest;

import com.fasterxml.jackson.annotation.JsonRootName;

/**
 *
 * @author Rosita
 */
@JsonRootName("Customer")
public class Customer {
private long id;
private String name;
private String email;

public long getId() {return id;}
public void setId(long id) {this.id = id;}
public String getName() {return name;}
public void setNome(String name) {this.name = name;}
public String getEmail() {return email;}
public void setEmail(String email) {this.email = email;}
}
