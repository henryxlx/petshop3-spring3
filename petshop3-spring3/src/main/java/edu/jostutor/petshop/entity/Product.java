package edu.jostutor.petshop.entity;

import java.io.Serializable;

/**
 * Business entity used to model a product
 */
public class Product implements Serializable {

    // Internal member variables
    private String id;
    private String name;
    private String description;

    // Default constructor
    public Product() {
    }

    /**
     * Constructor with specified initial values
     * @param id Product Id
     * @param name Product Name
     * @param description Product Description
     */
    public Product(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    // Properties
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}