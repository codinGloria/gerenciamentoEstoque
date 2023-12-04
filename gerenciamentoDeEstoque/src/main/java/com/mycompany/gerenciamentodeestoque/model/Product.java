/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gerenciamentodeestoque.model;

/**
 *
 * @author Glória
 */
public class Product {
    
    private Integer id;
    private Integer code;
    private String name;
    private Integer quantity;
    
    public Product (Integer id, Integer code, String name, Integer quantity){
        this.id = id;
        this.code = code;
        this.name = name;
        this.quantity = quantity;
    }
    
    public Product (Integer code, String name, Integer quantity){
        this.id = id;
        this.code = code;
        this.name = name;
        this.quantity = quantity;
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the code
     */
    public Integer getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(Integer code) {
        this.code = code;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the quantity
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
