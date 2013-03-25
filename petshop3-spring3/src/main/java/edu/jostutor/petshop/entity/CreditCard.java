package edu.jostutor.petshop.entity;

import java.io.Serializable;

/**
 * Business entity used to model credit card information.
 */
public class CreditCard implements Serializable {

    // Internal member variables
    private String cardType;
    private String cardNumber;
    private String cardExpiration;

    // Default constructor
    public CreditCard() {
    }

    /**
     * Constructor with specified initial values
     * @param cardType Card type, e.g. Visa, Master Card, American Express
     * @param cardNumber Number on the card
     * @param cardExpiration Expiry Date, form  MM/YY
     */
    public CreditCard(String cardType, String cardNumber, String cardExpiration) {
        this.cardType = cardType;
        this.cardNumber = cardNumber;
        this.cardExpiration = cardExpiration;
    }

    // Properties
    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardExpiration() {
        return cardExpiration;
    }

    public void setCardExpiration(String cardExpiration) {
        this.cardExpiration = cardExpiration;
    }
}
