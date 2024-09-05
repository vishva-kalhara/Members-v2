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

    private void sanitizeData(Member member) {

        if (member.getMobile2() == null) {
            member.setMobile2("");
        }

        if (member.getEmail() == null) {
            member.setEmail("");
        }

        if (member.getNic() == null) {
            member.setNic("");
        }
    }

    public boolean createMember(Member member) throws SQLException {

        sanitizeData(member);

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

    public void updateMember(Member member) throws SQLException {

        sanitizeData(member);

        AppConnection.mutate("UPDATE `customers` SET "
                + "`first_name` = '" + member.getFirstName() + "', "
                + "`last_name` = '" + member.getLastName() + "', "
                + "`mobile1` = '" + member.getMobile1() + "', "
                + "`mobile2` = '" + member.getMobile2() + "', "
                + "`email` = '" + member.getEmail() + "', "
                + "`nic` = '" + member.getNic() + "', "
                + "`statuses_id` = '" + member.getStatusId() + "' "
                + "WHERE `id` = '" + member.getId() + "'");
    }
}
