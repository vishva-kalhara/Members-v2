/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author vishv
 */
public class PaymentPlan {
    
     /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the validity
     */
    public int getValidity() {
        return validity;
    }

    /**
     * @param validity the validity to set
     */
    public void setValidity(int validity) {
        this.validity = validity;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * @return the statusId
     */
    public int getStatusId() {
        return statusId;
    }

    /**
     * @param statusId the statusId to set
     */
    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    /**
     * @return the statusValue
     */
    public String getStatusValue() {
        return statusValue;
    }

    /**
     * @param statusValue the statusValue to set
     */
    public void setStatusValue(String statusValue) {
        this.statusValue = statusValue;
    }
    
    private String id;
    private String title;
    private int validity;
    private double price;
    private int statusId;
    private String statusValue;
}
