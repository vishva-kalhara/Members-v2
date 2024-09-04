/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.sql.SQLException;
import models.Member;
import utils.AppConnection;

/**
 *
 * @author vishv
 */
public class MemberController {

    public boolean createMember(Member member) throws SQLException {

        if (member.getMobile2() == null) {
            member.setMobile2("");
        }

        if (member.getEmail() == null) {
            member.setEmail("");
        }

        if (member.getNic() == null) {
            member.setNic("");
        }

        return AppConnection.mutate("INSERT INTO `customers` ("
                + "`first_name`, "
                + "`last_name`, "
                + "`mobile1`, "
                + "`mobile2`, "
                + "`email`, "
                + "`nic`, "
                + "`statuses_id`, "
                + "`gender_id`"
                + ") VALUES ("
                + "'" + member.getFirstName() + "', "
                + "'" + member.getLastName() + "', "
                + "'" + member.getMobile1() + "', "
                + "'" + member.getMobile2() + "', "
                + "'" + member.getEmail() + "', "
                + "'" + member.getNic() + "', "
                + "'" + member.getStatusId() + "', "
                + "'" + member.getGenderId() + "'"
                + ")");
    }
}
