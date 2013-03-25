package edu.jostutor.petshop.entity;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Business entity used to model items in a shopping cart
 */
public class CartItem implements Serializable {

    private static final String YES = "Yes";
    private static final String NO = "No";

    // Internal member variables
    private int quantity = 1;
    private Boolean inStock = false;
    private String itemId = null;
    private String name;
    private BigDecimal price;

    /**
     * Default constructor
     * @param itemId Every cart item requires an itemId
     */
    public CartItem(String itemId) {
        this.itemId = itemId;
    }

    /**
     * Constructor with specified initial values
     * @param itemId Id of item to add to cart
     * @param name Name of item
     * @param inStock Is the item in stock
     * @param qty Quantity to purchase
     * @param price Price of item
     */
    public CartItem(String itemId, String name, Boolean inStock, int qty, BigDecimal price) {

        this.itemId = itemId;
        this.name = name;
        this.quantity = qty;
        this.price = price;
        this.inStock = inStock;
    }

    // Properties
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Boolean getInStock() {
        return inStock;
    }

    public void setInStock(Boolean inStock) {
        this.inStock = inStock;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public void incrementQuantity() {
        quantity++;
    }
}