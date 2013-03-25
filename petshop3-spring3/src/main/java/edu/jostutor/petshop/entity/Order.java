package edu.jostutor.petshop.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Business entity used to model an order
 */
public class Order implements Serializable {

    // Internal member variables
    private int orderId;
    private Date date;
    private String userId;
    private CreditCard creditCard;
    private Address billingAddress;
    private Address shippingAddress;
    private BigDecimal orderTotal;
    private LineItem[] lineItems;

    /**
     * Default constructor
     * This is required by web services serialization mechanism
     */
    public Order() {
    }

    /**
     * Constructor with specified initial values
     * @param orderId Unique identifier
     * @param date Order date
     * @param userId User placing order
     * @param creditCard Credit card used for order
     * @param billing Billing address for the order
     * @param shipping Shipping address for the order
     * @param total Order total value
     */
    public Order(int orderId, Date date, String userId, CreditCard creditCard,
                 Address billing, Address shipping, BigDecimal total) {
        this.orderId = orderId;
        this.date = date;
        this.userId = userId;
        this.creditCard = creditCard;
        this.billingAddress = billing;
        this.shippingAddress = shipping;
        this.orderTotal = total;
    }

    // Properties

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    public Address getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public BigDecimal getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(BigDecimal orderTotal) {
        this.orderTotal = orderTotal;
    }

    public LineItem[] getLineItems() {
        return lineItems;
    }

    public void setLineItems(LineItem[] lineItems) {
        this.lineItems = lineItems;
    }
}