/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.sql.SQLException;
import utils.AppConnection;
import models.Application;
import java.sql.ResultSet;

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

    public Application getAppConfig() throws Exception {

        ResultSet rs = AppConnection.fetch("SELECT `shop_name`, `shop_mobile`, `shop_address`, `available_currencies`.`value` FROM `app_data` INNER JOIN `available_currencies` ON `app_data`.`available_currencies_id` = `available_currencies`.`id`");

        if (!rs.next()) {
            throw new Exception("Please contact the vendor!");
        }

        Application app = new Application();
        app.setShopName(rs.getString("shop_name"));
        app.setShopMobile(rs.getString("shop_mobile"));
        app.setShopAddress(rs.getString("shop_address"));
        app.setCurrencyValue(rs.getString("available_currencies.value"));

        return app;
    }

    public boolean updateAppConfig(Application appData) throws Exception {

        return AppConnection.mutate("UPDATE `app_data` SET "
                + "`shop_name` = '" + appData.getShopName() + "', "
                + "`shop_mobile` = '" + appData.getShopMobile() + "', "
                + "`shop_address` = '" + appData.getShopAddress() + "', "
                + "`available_currencies_id` = '" + appData.getCurrencyId() + "' "
                + "WHERE `id` = '1'");
    }
}
