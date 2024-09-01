/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import views.dialogs.DlgError;
import views.layouts.AppLayout;

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
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/members", "root", "Wishva!23");

            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public static ResultSet execute(String query) {
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
            if (!e.getSQLState().equals("45000")) {

                e.printStackTrace();
            } else 
                new DlgError(AppLayout.appLayout, true, e.getMessage()).setVisible(true);
            return null;
        }
    }

}
