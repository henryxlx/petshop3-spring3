package edu.jostutor.petshop.entity;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Business entity used to model an order line item.
 */
public class LineItem implements Serializable {

    // Internal member variables
    private String id;
    private String productName;
    private Integer line;
    private Integer quantity;
    private BigDecimal price;

    /**
     * Default constructor
     * This is required by web services serialization mechanism
     */
    public LineItem() {
    }

    /**
     * Constructor with specified initial values
     * @param id Item Id
     * @param name
     * @param line Line number
     * @param qty Quanity in order
     * @param price Order item price
     */
    public LineItem(String id, String name, Integer line, Integer qty, BigDecimal price) {
        this.id = id;
        this.productName = name;
        this.line = line;
        this.price = price;
        this.quantity = qty;
    }

    // Properties
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getLine() {
        return line;
    }

    public void setLine(Integer line) {
        this.line = line;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getSubtotal() {
        return price.multiply(new BigDecimal(quantity));
    }
}