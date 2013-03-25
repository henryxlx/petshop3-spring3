package edu.jostutor.petshop.entity;

import java.io.Serializable;

/**
 * Business entity used to model accounts
 */
public class Account implements Serializable {

    // Internal member variables
    private String userId;
    private String password;
    private String email;
    private Address address;
    private String language;
    private String category;
    private Integer showFavorites;
    private Integer showBanners;

    // Default constructor
    public Account() {
    }

    /**
     * Constructor with specified initial values
     *
     * @param userId Unique identifier
     * @param password Password
     * @param email Email address
     * @param address The default address object
     * @param language Prefered language
     * @param category Favourite Category
     * @param showFavorites Show customized favourites based on prefered category
     * @param showBanners Show personalized banners
     */
    public Account(String userId, String password, String email, Address address, String language,
                   String category, Integer showFavorites, Integer showBanners) {
        this.userId = userId;
        this.password = password;
        this.email = email;
        this.address = address;
        this.language = language;
        this.category = category;
        this.showFavorites = showFavorites;
        this.showBanners = showBanners;
    }

    // Properties


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getShowFavorites() {
        return showFavorites;
    }

    public void setShowFavorites(Integer showFavorites) {
        this.showFavorites = showFavorites;
    }

    public Integer getShowBanners() {
        return showBanners;
    }

    public void setShowBanners(Integer showBanners) {
        this.showBanners = showBanners;
    }
}