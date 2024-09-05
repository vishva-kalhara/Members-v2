/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author vishv
 */
public class Formatter {

    public String addZeroToDouble(double value) {
        DecimalFormat df = new DecimalFormat("#.00");
        return df.format(value);
    }
    
    public String sanitizeDate(Date fullDate){
        
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(fullDate);
    }
}
