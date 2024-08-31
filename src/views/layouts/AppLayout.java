/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views.layouts;

import com.formdev.flatlaf.FlatClientProperties;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPanel;
import views.internals.PnlDashboard;
import views.internals.PnlEmployees;

/**
 *
 * @author vishv
 */
public class AppLayout extends javax.swing.JFrame {

    public static AppLayout appLayout;
    public JButton selectedButton;

    public enum Pages {
        DASHBOARD, SUBSCRIPTIONS, MEMBERS, PACKAGES, EMPLOYEES, REPORTS, SETTINGS
    }

    /**
     * Creates new form AppLayout
     */
    public AppLayout() {
        initComponents();

        appLayout = this;
        this.selectedButton = btnDashboard;

        setDesign();

    }

    private void setDesign() {

        changeForm(Pages.DASHBOARD);

        getRootPane().putClientProperty(FlatClientProperties.TITLE_BAR_BACKGROUND, new Color(0, 0, 0));
        getRootPane().putClientProperty(FlatClientProperties.TITLE_BAR_FOREGROUND, new Color(0, 0, 0));
        getRootPane().putClientProperty(FlatClientProperties.TITLE_BAR_SHOW_CLOSE, false);
        getRootPane().putClientProperty(FlatClientProperties.TITLE_BAR_SHOW_MAXIMIZE, false);
        getRootPane().putClientProperty(FlatClientProperties.TITLE_BAR_SHOW_ICONIFFY, false);

        btnDashboard.putClientProperty("JButton.buttonType", "borderless");
        btnSubscriptions.putClientProperty("JButton.buttonType", "borderless");
        btnMembers.putClientProperty("JButton.buttonType", "borderless");
        btnPackages.putClientProperty("JButton.buttonType", "borderless");
        btnEmployees.putClientProperty("JButton.buttonType", "borderless");
        btnReports.putClientProperty("JButton.buttonType", "borderless");
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

        newButton.setBackground(new Color(5, 81, 45));
        newButton.setForeground(new Color(255, 255, 255));

        selectedButton = newButton;
        selectedButton.grabFocus();
    }

    public void changeForm(AppLayout.Pages form) {
        switch (form) {
            case DASHBOARD:
                changeSideBarButtons(btnDashboard);
                showForm(new PnlDashboard());
                break;
            case EMPLOYEES:
                changeSideBarButtons(btnEmployees);
                showForm(new PnlEmployees());
                break;

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
        jPanel5 = new javax.swing.JPanel();
        btnSettings = new javax.swing.JButton();
        btnReports = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pnlPlaceholder = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1440, 900));
        setMinimumSize(new java.awt.Dimension(1440, 900));
        setPreferredSize(new java.awt.Dimension(1440, 900));
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel3.setBackground(new java.awt.Color(249, 249, 249));
        jPanel3.setPreferredSize(new java.awt.Dimension(280, 900));
        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(249, 249, 249));

        btnDashboard.setBackground(new java.awt.Color(5, 81, 45));
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

        btnMembers.setBackground(new java.awt.Color(249, 249, 249));
        btnMembers.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        btnMembers.setText("Members");
        btnMembers.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);

        btnPackages.setBackground(new java.awt.Color(249, 249, 249));
        btnPackages.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        btnPackages.setText("Packages");
        btnPackages.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);

        btnEmployees.setBackground(new java.awt.Color(249, 249, 249));
        btnEmployees.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        btnEmployees.setText("Employees");
        btnEmployees.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnEmployees.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmployeesActionPerformed(evt);
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
                    .addComponent(btnEmployees, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addComponent(btnMembers, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPackages, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEmployees, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(270, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel1, java.awt.BorderLayout.CENTER);

        jPanel5.setBackground(new java.awt.Color(249, 249, 249));

        btnSettings.setBackground(new java.awt.Color(249, 249, 249));
        btnSettings.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        btnSettings.setText("Settings");
        btnSettings.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);

        btnReports.setBackground(new java.awt.Color(249, 249, 249));
        btnReports.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        btnReports.setText("Reports");
        btnReports.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnReports, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSettings, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(btnReports, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSettings, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        jPanel3.add(jPanel5, java.awt.BorderLayout.PAGE_END);

        jPanel6.setBackground(new java.awt.Color(249, 249, 249));
        jPanel6.setPreferredSize(new java.awt.Dimension(280, 150));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/img/title.png"))); // NOI18N

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                .addContainerGap())
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
        changeForm(Pages.DASHBOARD);
    }//GEN-LAST:event_btnDashboardActionPerformed

    private void btnEmployeesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmployeesActionPerformed
        changeForm(Pages.EMPLOYEES);
    }//GEN-LAST:event_btnEmployeesActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDashboard;
    private javax.swing.JButton btnEmployees;
    private javax.swing.JButton btnMembers;
    private javax.swing.JButton btnPackages;
    private javax.swing.JButton btnReports;
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