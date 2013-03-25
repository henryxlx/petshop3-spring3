package edu.jostutor.petshop.entity;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Business entity used to model an item.
 */
public class Item implements Serializable {

    // Internal member variables
    private String id;
    private String name;
    private int quantity;
    private BigDecimal price;
    private String productName;
    private String productDesc;

    // Default constructor
    public Item() {
    }

    /**
     * Constructor with specified initial values
     * @param id Item Id
     * @param name Item Name
     * @param quantity Quantity in stock
     * @param price Price
     * @param productName Parent product name
     * @param productDesc Parent product description
     */
    public Item(String id, String name, int quantity, BigDecimal price, String productName, String productDesc) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.productName = productName;
        this.productDesc = productDesc;
    }

    /**
     * Constructor with specified initial values, except inventory information
     * @param id Item Id
     * @param name Item Name
     * @param price Price
     * @param productName Parent product name
     * @param productDesc Parent product description
     */
    public Item(String id, String name, BigDecimal price, String productName, String productDesc) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.productName = productName;
        this.productDesc = productDesc;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }
}
