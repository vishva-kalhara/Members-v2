/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;
import java.sql.SQLException;
import utils.AppConnection;

/**
 *
 * @author vishv
 */
public class AttendanceController {
    
    public boolean markAttendance(int subscriptionId) throws SQLException {
        
        return AppConnection.mutate("INSERT INTO `attendance` ("
                + "subscriptions_id) VALUES ('"+ subscriptionId +"')");
    } 
}
