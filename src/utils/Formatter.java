/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.text.DecimalFormat;

/**
 *
 * @author vishv
 */
public class Formatter {

    public String addZeroToDouble(double value) {
        DecimalFormat df = new DecimalFormat("#.00");
        return df.format(value);
    }
}
