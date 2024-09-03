/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.sql.SQLException;
import models.PaymentPlan;
import utils.AppConnection;

/**
 *
 * @author vishv
 */
public class PackageController {

    public boolean createPackage(PaymentPlan plan) throws SQLException {

        return AppConnection.mutate("INSERT INTO `packages` ("
                + "`title`, "
                + "`price`, "
                + "`validity`, "
                + "`statuses_id`) "
                + "VALUES ("
                + "'" + plan.getTitle() + "',"
                + "'" + plan.getPrice() + "', "
                + "'" + plan.getValidity() + "', "
                + "'" + plan.getStatusId() + "')");
    }
}
