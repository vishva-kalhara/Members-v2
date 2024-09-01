/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import models.Employee;
import utils.AppConnection;

/**
 *
 * @author vishv
 */
public class EmployeeController {
    
    public void createEmployee(Employee employee){
        
        String fields = "";
        String vals = "";
        if(employee.getUsername() != null){
            fields = ",`user_roles_id`, `username`, `password`";
            vals = ",'" + employee.getRoleId() +"', '"+ employee.getUsername() +"', '"+ employee.getPassword() +"'";
        }
        
        AppConnection.execute("INSERT INTO `employees` ("
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
                + "'"+ employee.getMobile1()+"',"
                + "'"+ employee.getMobile2()+"',"
                + "'"+ employee.getAddress1() +"',"
                + "'"+ employee.getFName()+"',"
                + "'"+ employee.getLName()+"',"
                + "'"+ employee.getGenderId()+"',"
                + "'"+ employee.getStatusId()+"',"
                + "'"+ employee.getNIC() +"'"
                + vals
                + ");");
        
        
    }
}
