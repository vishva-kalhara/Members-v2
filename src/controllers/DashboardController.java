/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import utils.AppConnection;
import java.sql.ResultSet;
import utils.Formatter;

/**
 *
 * @author vishv
 */
public class DashboardController {

    public String[] getProfitCardData() throws Exception {

        String[] data = new String[2];

        Date today = new Date();

        int yr = Integer.parseInt(new SimpleDateFormat("yyyy").format(today));
        int month = Integer.parseInt(new SimpleDateFormat("MM").format(today));

        double profitThis = 0.0;

        ResultSet rsThis = AppConnection.fetch("CALL get_profit_of_yr_and_month(" + yr + ", " + month + ");");
        if (rsThis.next()) {
            profitThis = rsThis.getDouble("monthlyTotal");
        }

        int pastMonth = month - 1;
        int pastYr = yr;
        double profitPast = 0.0;
        if (month == 01) {

            pastMonth = 12;
            pastYr--;
        }
        ResultSet rsPast = AppConnection.fetch("CALL get_profit_of_yr_and_month(" + pastYr + ", " + pastMonth + ");");
        if (rsPast.next()) {
            profitPast = rsPast.getDouble("monthlyTotal");
        }

//      Calculation
        double percentage = (((profitThis / profitPast) * 100) - 100);

        Formatter formatter = new Formatter();

        data[0] = formatter.addZeroToDouble(profitThis);
        data[1] = formatter.addZeroToDouble(percentage);

        return data;
    }
}
