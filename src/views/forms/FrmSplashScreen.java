/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views.forms;

import com.formdev.flatlaf.themes.FlatMacLightLaf;
import enums.DialogTypes;
import java.awt.Toolkit;
import utils.AppConnection;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import models.Application;
import views.dialogs.DlgConfig;
import views.dialogs.DlgError;

/**
 *
 * @author vishv
 */
public class FrmSplashScreen extends javax.swing.JFrame {
    
    private Application appData;

    /**
     * Creates new form FrmSplashScreen
     */
    public FrmSplashScreen() {
        initComponents();
        
        this.appData = new Application();

        
        configure();
        
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/assets/img/logo_120.png")));
        
    }
    
    private void configure() {
        
        try {
            ResultSet rsCount = AppConnection.fetch("SELECT COUNT(*) AS count FROM `app_data`");
            rsCount.next();
            if (rsCount.getInt("count") > 1) {
                throw new Exception("Please contact the vendor!");
            } else if (rsCount.getInt("count") == 1) {
                
                ResultSet rs = AppConnection.fetch("SELECT * FROM `app_data` INNER JOIN available_currencies ON `app_data`.`available_currencies_id` = `available_currencies`.`id`");
                rs.next();
                
                appData.setShopName(rs.getString("shop_name"));
                appData.setShopMobile(rs.getString("shop_mobile"));
                appData.setShopAddress(rs.getString("shop_address"));
                appData.setCurrencyId(rs.getInt("available_currencies.id"));
                appData.setCurrencyValue(rs.getString("available_currencies.value"));
                
                timeWait();
            } else {
                
                DlgConfig dlg = new DlgConfig(this, true, DialogTypes.CREATE);
                dlg.setVisible(true);
                
                if (dlg.isCompleted()) {
                    new DlgError(this, true, "Please re-open the Application.", "Success", DialogTypes.SUCCESS).setVisible(true);
                }
                
                System.exit(0);
                
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Unhandled Exception Occured!", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }
    
    private void timeWait() {
        
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(10);
                    dispose();
                    new FrmAttendance(appData).setVisible(true);
                } catch (InterruptedException ex) {
                    
                }
            }
        });
        thread.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/img/splash_img.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 545, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        FlatMacLightLaf.registerCustomDefaultsSource("styles");
        FlatMacLightLaf.setup();
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmSplashScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

}
