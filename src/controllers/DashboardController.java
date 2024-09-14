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

    public String[] getMostSoldPackageCardData() throws Exception {

        String[] data = new String[2];

        ResultSet rsPackageId = AppConnection.fetch("SELECT packages_id, COUNT(*) AS record_count "
                + "FROM subscriptions "
                + "GROUP BY packages_id "
                + "ORDER BY record_count "
                + "DESC LIMIT 1;");

        if (!rsPackageId.next()) {

            data[0] = "N/A";
            data[1] = "N/A";
            return data;
        }
        
        String packageId = rsPackageId.getString("packages_id");
        ResultSet rsPacakgeTitle = AppConnection.fetch("SELECT `title` FROM packages WHERE `packages`.`id` = '"+ packageId +"'");
        
        if(!rsPacakgeTitle.next()){
            return data;
        }
        
        String packageTitle = rsPacakgeTitle.getString("title");
        
        Date today = new Date();
        int yr = Integer.parseInt(new SimpleDateFormat("yyyy").format(today));
        int month = Integer.parseInt(new SimpleDateFormat("MM").format(today));
        
        ResultSet rsCountThis = AppConnection.fetch("CALL get_count_of_package('"+ packageId +"', 1, "+ yr +", "+ month +")");
        rsCountThis.next();
        int countThis = rsCountThis.getInt("count");
        
        ResultSet rsCountOthers = AppConnection.fetch("CALL get_count_of_package('"+ packageId +"', 0, "+ yr +", "+ month +")");
        rsCountOthers.next();
        int countOthers = rsCountOthers.getInt("count");
        
        double percentage = (((countThis / countOthers) * 100) - 100);
        
        data[0] = packageTitle;
        data[1] = String.valueOf(percentage);

        return data;
    }
}
