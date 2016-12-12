package com.store.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Product {
    
    @JsonProperty
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    @JsonProperty
    private String sku;

    @JsonProperty
    private String name;

    @JsonProperty
    private String category;

    @JsonProperty
    private String last_updated;

    @JsonProperty
    private float price;
    
    public Product(){
        
    }

    public Product(int id, String sku, String name, String category, String last_updated, float price) {
        this.id = id;
        this.sku = sku;
        this.name = name;
        this.category = category;
        this.last_updated = last_updated;
        this.price = price;
    }
}
