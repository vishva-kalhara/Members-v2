/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 *
 * @author vishv
 */
public class AppConnection {

    private static Connection connection;

    private static void setUpConnection() {

        if (connection == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                DriverManager.getConnection("jdbc:mysql://localhost:3306/members", "root", "wishva!23");

            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    private static ResultSet execute(String query) {
        if (connection == null) {
            setUpConnection();
        }

        try {
            if (query.startsWith("SELECT")) {
                return connection.createStatement().executeQuery(query);
            } else {
                connection.createStatement().executeUpdate(query);
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}
