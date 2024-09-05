/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date; 
import models.Subscription;
import utils.AppConnection;
import utils.Formatter;
import views.layouts.AppLayout;

/**
 *
 * @author vishv
 */
public class SubscriptionController {
    
    public void createSubscription(Subscription subscription) throws SQLException {
        
        subscription.setEmployeeId(AppLayout.employeeData.get("id"));
        
        String endDate = getEndDate(subscription.getStartDate(), subscription.getValidity());

        String startDate = new Formatter().sanitizeDate(subscription.getStartDate());
        
        AppConnection.mutate("INSERT INTO `subscriptions` ("
                + "`paid_amount`, "
                + "`start`, "
                + "`end`, "
                + "`employees_id`, "
                + "`packages_id`, "
                + "`customers_id`) values ("
                + subscription.getPaidAmount() + ", "
                + "'" + startDate + "', "
                + "'" + endDate + "', "
                + "'" + subscription.getEmployeeId() + "', "
                + "'" + subscription.getPackageId()+ "', "
                + "'" + subscription.getCustomerId()+ "' "
                + ")");
    }
    
    private String getEndDate(Date fromDate, int validity){
        
        Formatter formatter = new Formatter();
        
        String[] parts = formatter.sanitizeDate(fromDate).split("-");
        
        LocalDate today = LocalDate.of(Integer.parseInt(parts[0]),Integer.parseInt(parts[1]),Integer.parseInt(parts[2]));

        LocalDate dateLocal = today.plusDays(validity - 1);

        Date newDate = Date.from(dateLocal.atStartOfDay(ZoneId.systemDefault()).toInstant());
    
        return formatter.sanitizeDate(newDate);
    }
}
