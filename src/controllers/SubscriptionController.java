/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import config.AppConfig;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import models.Subscription;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import utils.AppConnection;
import utils.Formatter;
import views.layouts.AppLayout;
import java.sql.ResultSet;

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
                + "'" + subscription.getPackageId() + "', "
                + "'" + subscription.getCustomerId() + "' "
                + ")");
    }

    private String getEndDate(Date fromDate, int validity) {

        Formatter formatter = new Formatter();

        String[] parts = formatter.sanitizeDate(fromDate).split("-");

        LocalDate today = LocalDate.of(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));

        LocalDate dateLocal = today.plusDays(validity - 1);

        Date newDate = Date.from(dateLocal.atStartOfDay(ZoneId.systemDefault()).toInstant());

        return formatter.sanitizeDate(newDate);
    }

    public Date getStartDate(Date endDate) {

        Formatter formatter = new Formatter();

        String[] parts = formatter.sanitizeDate(endDate).split("-");

        LocalDate today = LocalDate.of(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));

        LocalDate dateLocal = today.plusDays(1);

        Date newDate = Date.from(dateLocal.atStartOfDay(ZoneId.systemDefault()).toInstant());

        return newDate;
    }

    public JasperPrint generateInvoice(Subscription subscription) {

        try {

            ResultSet rsCustomerName = AppConnection.fetch("SELECT CONCAT('(" + subscription.getCustomerId() + ") ',`first_name`, ' ', `last_name`) AS full_name "
                    + "FROM `customers` "
                    + "WHERE `id` = '" + subscription.getCustomerId() + "';");
            rsCustomerName.next();

            ResultSet rsPackageName = AppConnection.fetch("SELECT CONCAT('(" + subscription.getPackageId() + ") ',`title`) AS package_title "
                    + "FROM `packages` "
                    + "WHERE `id` = '" + subscription.getPackageId() + "';");
            rsPackageName.next();

            String issedDate = new SimpleDateFormat("yyyy-MM-ss HH:mm").format(new Date());

            String startDate = new Formatter().sanitizeDate(subscription.getStartDate());
            String endDate = getEndDate(subscription.getStartDate(), subscription.getValidity());

            String paidAmount = AppLayout.appData.getCurrencyValue() + " " + new Formatter().addZeroToDouble(subscription.getPaidAmount());

            HashMap<String, Object> params = new HashMap();
            params.put("shopName", "TSK Gym");
            params.put("shopMobile", "+31 2260118");
            params.put("shopAddress", "Negombo rd, Dankotuwa");
            params.put("issuedDateTime", issedDate);
            params.put("issuedBy", "This need to be changed");
            params.put("customer", rsCustomerName.getString("full_name"));
            params.put("package", rsPackageName.getString("package_title"));
            params.put("validFrom", startDate);
            params.put("validTo", endDate);
            params.put("paidAmount", paidAmount);

            JREmptyDataSource source = new JREmptyDataSource();

            return JasperFillManager.fillReport(AppConfig.getReportPath("members_invoice.jasper"), params, source);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
