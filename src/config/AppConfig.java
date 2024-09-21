/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package config;

/**
 *
 * @author vishv
 */
@Deprecated
public class AppConfig {
    
    private static final String REPORT_PATH = "src/reports/";
    
    public static String getReportPath(String reportName){
        
        return AppConfig.REPORT_PATH + reportName;
    }
}
