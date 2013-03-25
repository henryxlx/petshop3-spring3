package edu.jostutor.petshop.entity;

import java.math.BigDecimal;
import java.util.*;

/**
 *
 * @author xulixin
 */
public class Cart {

    public static final String CART_KEY = "petshopCart";

    private final Map<String, CartItem> itemMap = 
            Collections.synchronizedMap(new HashMap<String, CartItem>());
    
    private Integer size;
    
    private BigDecimal total = new BigDecimal(0);

    public List<CartItem> getCartItemList() {
        return new ArrayList<CartItem>(itemMap.values());
    }
    
    public Map<String, CartItem> getItemMap() {
        return itemMap;
    }

    public Integer getSize() {
        return itemMap.size();
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
    
    public boolean containsItemId(String itemId) {
        return itemMap.containsKey(itemId);
    }   
    
    public CartItem getCartItem(String itemId) {
        return itemMap.get(itemId);
    }
    
    public void addItem(Item item, boolean isInStock) {
        CartItem cartItem = (CartItem) itemMap.get(item.getId());
        if (cartItem == null) {
            cartItem = new CartItem(item.getId(), item.getName(),
                    isInStock, 0, item.getPrice());
            itemMap.put(item.getId(), cartItem);
        }
        cartItem.incrementQuantity();
    }  
    
    public void removeItem(String itemId) {
        itemMap.remove(itemId);
    }
    
    public void incrementQuantityByItemId(String itemId) {
        CartItem cartItem = (CartItem) itemMap.get(itemId);
        cartItem.incrementQuantity();
    }

    private CreditCard creditCard;

    private Address billingAddress;

    private Address shippingAddress;

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
}
