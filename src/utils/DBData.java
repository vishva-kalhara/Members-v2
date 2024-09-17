/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.util.HashMap;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import views.forms.FrmSplashScreen;

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
            FrmSplashScreen.logger.log(Level.WARNING, e.getMessage() ,e);
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
            FrmSplashScreen.logger.log(Level.WARNING, e.getMessage() ,e);
        }
        
        DefaultComboBoxModel model = new DefaultComboBoxModel(data);
        target.setModel(model);

        return map;
    }

    public static HashMap<String, Integer> getSubTableData(String tableName, String suffix, JComboBox target) {

        HashMap<String, Integer> map = new HashMap();
        
        Vector<String> data = new Vector();
        data.add("All " + suffix);
        

        ResultSet rs = AppConnection.execute("SELECT * FROM `" + tableName + "`");
        try {

            while (rs.next()) {
                map.put(rs.getString("value") + " " + suffix, rs.getInt("id"));
                data.add(rs.getString("value") + " " + suffix);
            }
        } catch (SQLException e) {
            FrmSplashScreen.logger.log(Level.WARNING, e.getMessage() ,e);
        }
        
        DefaultComboBoxModel model = new DefaultComboBoxModel(data);
        target.setModel(model);

        return map;
    }
    
}
