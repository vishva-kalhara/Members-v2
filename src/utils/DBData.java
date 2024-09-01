/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.util.HashMap;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

/**
 *
 * @author vishv
 */
public class DBData {

    
    public HashMap<String, Integer> getSubTableData(String tableName) {

        HashMap<String, Integer> map = new HashMap();
        
        ResultSet rs = AppConnection.execute("SELECT * FROM `" + tableName + "`");
        try {

            while (rs.next()) {
                map.put(rs.getString("value"), rs.getInt("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return map;
    }
   
    public static HashMap<String, Integer> getSubTableData(String tableName, JComboBox target) {

        HashMap<String, Integer> map = new HashMap();
        
        Vector<String> data = new Vector();
        data.add("Select");

        ResultSet rs = AppConnection.execute("SELECT * FROM `" + tableName + "`");
        try {

            while (rs.next()) {
                map.put(rs.getString("value"), rs.getInt("id"));
                data.add(rs.getString("value"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        DefaultComboBoxModel model = new DefaultComboBoxModel(data);
        target.setModel(model);

        return map;
    }

    public HashMap<String, Integer> getSubTableData(String tableName, String constraints) {

        HashMap<String, Integer> map = new HashMap();

        ResultSet rs = AppConnection.execute("SELECT * FROM `" + tableName + "` WHERE " + constraints);
        try {

            while (rs.next()) {
                map.put(rs.getString("value"), rs.getInt("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return map;
    }
    
}
