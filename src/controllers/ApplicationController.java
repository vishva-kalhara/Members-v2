/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.sql.SQLException;
import utils.AppConnection;
import models.Application;

/**
 *
 * @author vishv
 */
public class ApplicationController {

    public boolean createAppConfig(Application appData) throws SQLException {

        return AppConnection.mutate("INSERT INTO app_data ("
                + "`id`, "
                + "`shop_name`, "
                + "`shop_mobile`, "
                + "`shop_address`,"
                + "`available_currencies_id`"
                + ") VALUES ("
                + "1,"
                + "'" + appData.getShopName() + "',"
                + "'" + appData.getShopMobile() + "', "
                + "'" + appData.getShopAddress() + "', "
                + "'" + appData.getCurrencyId() + "')");
    }
}
