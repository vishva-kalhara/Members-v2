/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views.layouts;

import com.formdev.flatlaf.FlatClientProperties;
import enums.LayoutPages;
import java.awt.Color;
import java.awt.Toolkit;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JPanel;
import models.Application;
import raven.toast.Notifications;
import views.internals.PnlAttendance;
import views.internals.PnlDashboard;
import views.internals.PnlEmployees;
import views.internals.PnlMembers;
import views.internals.PnlNoAccess;
import views.internals.PnlPackages;
import views.internals.PnlSettings;
import views.internals.PnlSubscriptions;

/**
 *
 * @author vishv
 */
public class AppLayout extends javax.swing.JFrame {

    public static Application appData;
    public static AppLayout appLayout;

    public JButton selectedButton;

    public static HashMap<String, String> employeeData = new HashMap();

    /**
     * Creates new form AppLayout
     *
     * @param appData
     * @param employeeData
     */
    public AppLayout(Application appData, HashMap<String, String> employeeData) {
        initComponents();

        appLayout = this;
        AppLayout.appData = appData;
        this.selectedButton = btnDashboard;

        this.employeeData = employeeData;

        setDesign();

        this.setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/assets/img/logo_120.png")));

        Notifications.getInstance().setJFrame(this);
        Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.BOTTOM_RIGHT, "Hello " + employeeData.get("fName"));
    }

    private void setDesign() {

        changeForm(LayoutPages.DASHBOARD);

        getRootPane().putClientProperty(FlatClientProperties.TITLE_BAR_BACKGROUND, new Color(0, 0, 0));
        getRootPane().putClientProperty(FlatClientProperties.TITLE_BAR_FOREGROUND, new Color(0, 0, 0));
        getRootPane().putClientProperty(FlatClientProperties.TITLE_BAR_SHOW_CLOSE, false);
        getRootPane().putClientProperty(FlatClientProperties.TITLE_BAR_SHOW_MAXIMIZE, false);
        getRootPane().putClientProperty(FlatClientProperties.TITLE_BAR_SHOW_ICONIFFY, false);
        getRootPane().putClientProperty(FlatClientProperties.TITLE_BAR_SHOW_ICON, false);
        getRootPane().putClientProperty(FlatClientProperties.TITLE_BAR_SHOW_TITLE, false);

        btnDashboard.putClientProperty("JButton.buttonType", "borderless");
        btnSubscriptions.putClientProperty("JButton.buttonType", "borderless");
        btnAttendance.putClientProperty("JButton.buttonType", "borderless");
        btnMembers.putClientProperty("JButton.buttonType", "borderless");
        btnPackages.putClientProperty("JButton.buttonType", "borderless");
        btnEmployees.putClientProperty("JButton.buttonType", "borderless");
        btnSettings.putClientProperty("JButton.buttonType", "borderless");
    }

    private void showForm(JPanel form) {
        pnlPlaceholder.removeAll();
        pnlPlaceholder.add(form, java.awt.BorderLayout.CENTER);
        pnlPlaceholder.repaint();
        pnlPlaceholder.revalidate();
    }

    private void changeSideBarButtons(JButton newButton) {
        selectedButton.setBackground(new Color(249, 249, 249));
        selectedButton.setForeground(new Color(38, 38, 38));

        newButton.setBackground(new Color(77, 119, 255));
        newButton.setForeground(new Color(255, 255, 255));

        selectedButton = newButton;
        selectedButton.grabFocus();
    }

    private boolean checkAccess() {

        return (Integer.parseInt(employeeData.get("role_id")) > 3);
    }

    public void changeForm(LayoutPages form) {

//        if(Integer.parseInt(employeeData.get("role_id")) == 1){
//            
//            showForm(new PnlNoAccess());
//            return;
//        }
        switch (form) {
            case DASHBOARD:
                changeSideBarButtons(btnDashboard);
                showForm(new PnlDashboard());
                return;
            case SUBSCRIPTIONS:
                changeSideBarButtons(btnSubscriptions);
                showForm(new PnlSubscriptions());
                break;
            case ATTENDANCE:
                changeSideBarButtons(btnAttendance);
                showForm(new PnlAttendance());
                break;
            case MEMBERS:
                changeSideBarButtons(btnMembers);
                showForm(new PnlMembers());
                break;
            case PACKAGES:
                changeSideBarButtons(btnPackages);
                showForm(new PnlPackages());
                break;
            case EMPLOYEES:
                changeSideBarButtons(btnEmployees);
                showForm(new PnlEmployees());
                break;
            case SETTINGS:
                changeSideBarButtons(btnSettings);
                showForm(new PnlSettings());
                break;

        }

        if (checkAccess()) {
            showForm(new PnlNoAccess());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        btnDashboard = new javax.swing.JButton();
        btnSubscriptions = new javax.swing.JButton();
        btnMembers = new javax.swing.JButton();
        btnPackages = new javax.swing.JButton();
        btnEmployees = new javax.swing.JButton();
        btnAttendance = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        btnSettings = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pnlPlaceholder = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Members");
        setMaximumSize(new java.awt.Dimension(1440, 900));
        setMinimumSize(new java.awt.Dimension(1440, 900));
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel3.setBackground(new java.awt.Color(249, 249, 249));
        jPanel3.setPreferredSize(new java.awt.Dimension(280, 900));
        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(249, 249, 249));

        btnDashboard.setBackground(new java.awt.Color(77, 119, 255));
        btnDashboard.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        btnDashboard.setForeground(new java.awt.Color(255, 255, 255));
        btnDashboard.setText("Dashboard");
        btnDashboard.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnDashboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDashboardActionPerformed(evt);
            }
        });

        btnSubscriptions.setBackground(new java.awt.Color(249, 249, 249));
        btnSubscriptions.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        btnSubscriptions.setText("Subscriptions");
        btnSubscriptions.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnSubscriptions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubscriptionsActionPerformed(evt);
            }
        });

        btnMembers.setBackground(new java.awt.Color(249, 249, 249));
        btnMembers.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        btnMembers.setText("Members");
        btnMembers.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnMembers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMembersActionPerformed(evt);
            }
        });

        btnPackages.setBackground(new java.awt.Color(249, 249, 249));
        btnPackages.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        btnPackages.setText("Packages");
        btnPackages.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnPackages.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPackagesActionPerformed(evt);
            }
        });

        btnEmployees.setBackground(new java.awt.Color(249, 249, 249));
        btnEmployees.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        btnEmployees.setText("Employees");
        btnEmployees.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnEmployees.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmployeesActionPerformed(evt);
            }
        });

        btnAttendance.setBackground(new java.awt.Color(249, 249, 249));
        btnAttendance.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        btnAttendance.setText("Attendance");
        btnAttendance.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnAttendance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAttendanceActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSubscriptions, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMembers, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPackages, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEmployees, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAttendance, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(btnDashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSubscriptions, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAttendance, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnMembers, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPackages, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEmployees, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(219, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel1, java.awt.BorderLayout.CENTER);

        jPanel5.setBackground(new java.awt.Color(249, 249, 249));

        btnSettings.setBackground(new java.awt.Color(249, 249, 249));
        btnSettings.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        btnSettings.setText("Settings");
        btnSettings.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnSettings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSettingsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(btnSettings, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(80, Short.MAX_VALUE)
                .addComponent(btnSettings, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        jPanel3.add(jPanel5, java.awt.BorderLayout.PAGE_END);

        jPanel6.setBackground(new java.awt.Color(249, 249, 249));
        jPanel6.setPreferredSize(new java.awt.Dimension(280, 150));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/img/title_black.png"))); // NOI18N
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 22, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel6, java.awt.BorderLayout.PAGE_START);

        jPanel2.add(jPanel3, java.awt.BorderLayout.WEST);

        pnlPlaceholder.setBackground(new java.awt.Color(255, 255, 255));
        pnlPlaceholder.setMaximumSize(new java.awt.Dimension(1160, 900));
        pnlPlaceholder.setMinimumSize(new java.awt.Dimension(1160, 900));
        pnlPlaceholder.setPreferredSize(new java.awt.Dimension(1160, 900));
        pnlPlaceholder.setLayout(new java.awt.BorderLayout());
        jPanel2.add(pnlPlaceholder, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnDashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDashboardActionPerformed
        changeForm(LayoutPages.DASHBOARD);
    }//GEN-LAST:event_btnDashboardActionPerformed

    private void btnEmployeesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmployeesActionPerformed
        changeForm(LayoutPages.EMPLOYEES);
    }//GEN-LAST:event_btnEmployeesActionPerformed

    private void btnPackagesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPackagesActionPerformed
        changeForm(LayoutPages.PACKAGES);
    }//GEN-LAST:event_btnPackagesActionPerformed

    private void btnMembersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMembersActionPerformed
        changeForm(LayoutPages.MEMBERS);
    }//GEN-LAST:event_btnMembersActionPerformed

    private void btnSubscriptionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubscriptionsActionPerformed
        changeForm(LayoutPages.SUBSCRIPTIONS);
    }//GEN-LAST:event_btnSubscriptionsActionPerformed

    private void btnAttendanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAttendanceActionPerformed
        
        changeForm(LayoutPages.ATTENDANCE);
    }//GEN-LAST:event_btnAttendanceActionPerformed

    private void btnSettingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSettingsActionPerformed
        changeForm(LayoutPages.SETTINGS);
    }//GEN-LAST:event_btnSettingsActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAttendance;
    private javax.swing.JButton btnDashboard;
    private javax.swing.JButton btnEmployees;
    private javax.swing.JButton btnMembers;
    private javax.swing.JButton btnPackages;
    private javax.swing.JButton btnSettings;
    private javax.swing.JButton btnSubscriptions;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel pnlPlaceholder;
    // End of variables declaration//GEN-END:variables
}
