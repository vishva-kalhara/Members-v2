/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.sql.SQLException;
import models.Employee;
import utils.AppConnection;

/**
 *
 * @author vishv
 */
public class EmployeeController {

    public boolean createEmployee(Employee employee) throws SQLException {

        String fields = "";
        String vals = "";
        if (employee.getUsername() != null) {
            fields = ",`user_roles_id`, `username`, `password`";
            vals = ",'" + employee.getRoleId() + "', '" + employee.getUsername() + "', '" + employee.getPassword() + "'";
        }

        if (employee.getMobile2() == null) {
            employee.setMobile2("");
        }

        return AppConnection.mutate("INSERT INTO `employees` ("
                + "`mobile1`, "
                + "`mobile2`, "
                + "`address1`, "
                + "`first_name`, "
                + "`last_name`, "
                + "`gender_id`, "
                + "`statuses_id`,"
                + "`nic`"
                + fields
                + ") VALUES ("
                + "'" + employee.getMobile1() + "',"
                + "'" + employee.getMobile2() + "',"
                + "'" + employee.getAddress1() + "',"
                + "'" + employee.getFName() + "',"
                + "'" + employee.getLName() + "',"
                + "'" + employee.getGenderId() + "',"
                + "'" + employee.getStatusId() + "',"
                + "'" + employee.getNIC() + "'"
                + vals
                + ");");
    }

    public boolean updateEmployee(Employee employee)throws SQLException {

        String vals;
        if (employee.getRoleId() != 0) {
            vals = " `username` = '" + employee.getUsername() + "', "
                    + "`password` = '" + employee.getPassword() + "', "
                    + "`user_roles_id` = '" + employee.getRoleId() + "' ";
        } else {
            vals = " `username` = '', "
                    + "`password` = '', "
                    + "`user_roles_id` = NULL ";
        }

        if (employee.getMobile2() == null) {
            employee.setMobile2("");
        }

        return AppConnection.mutate("UPDATE `employees` SET "
                + "`first_name` = '" + employee.getFName() + "', "
                + "`last_name` = '" + employee.getLName() + "', "
                + "`address1` = '" + employee.getAddress1() + "', "
                + "`statuses_id` = '" + employee.getStatusId() + "', "
                + "`mobile1` = '" + employee.getMobile1() + "', "
                + "`mobile2` = '" + employee.getMobile2() + "', "
                + vals
                + "WHERE `id` = '" + employee.getId() + "'");
    }
}
