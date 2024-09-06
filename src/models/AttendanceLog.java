/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.util.Date;

/**
 *
 * @author vishv
 */
public class AttendanceLog {

    /**
     * @return the markedAt
     */
    public Date getMarkedAt() {
        return markedAt;
    }

    /**
     * @param markedAt the markedAt to set
     */
    public void setMarkedAt(Date markedAt) {
        this.markedAt = markedAt;
    }

    /**
     * @return the subscriptionId
     */
    public int getSubscriptionId() {
        return subscriptionId;
    }

    /**
     * @param subscriptionId the subscriptionId to set
     */
    public void setSubscriptionId(int subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    private int id;
    private Date markedAt;
    private int subscriptionId;

}
