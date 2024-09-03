/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author vishv
 */
public class Application {

    /**
     * @return the currencyId
     */
    public int getCurrencyId() {
        return currencyId;
    }

    /**
     * @param currencyId the currencyId to set
     */
    public void setCurrencyId(int currencyId) {
        this.currencyId = currencyId;
    }

    /**
     * @return the currencyValue
     */
    public String getCurrencyValue() {
        return currencyValue;
    }

    /**
     * @param currencyValue the currencyValue to set
     */
    public void setCurrencyValue(String currencyValue) {
        this.currencyValue = currencyValue;
    }

    /**
     * @return the shopName
     */
    public String getShopName() {
        return shopName;
    }

    /**
     * @param shopName the shopName to set
     */
    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    /**
     * @return the shopMobile
     */
    public String getShopMobile() {
        return shopMobile;
    }

    /**
     * @param shopMobile the shopMobile to set
     */
    public void setShopMobile(String shopMobile) {
        this.shopMobile = shopMobile;
    }

    /**
     * @return the shopAddress
     */
    public String getShopAddress() {
        return shopAddress;
    }

    /**
     * @param shopAddress the shopAddress to set
     */
    public void setShopAddress(String shopAddress) {
        this.shopAddress = shopAddress;
    }
    
    private String shopName;
    private String shopMobile;
    private String shopAddress;
    private int currencyId;
    private String currencyValue;
}
