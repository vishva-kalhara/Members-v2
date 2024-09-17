/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package views.internals;

import com.formdev.flatlaf.FlatClientProperties;
import controllers.DashboardController;
import enums.DialogActions;
import enums.LayoutPages;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import utils.AppConnection;
import views.dialogs.DlgConfirm;
import views.forms.FrmAttendance;
import views.layouts.AppLayout;
import javax.swing.JPanel;
import views.forms.FrmSplashScreen;

/**
 *
 * @author vishv
 */
public class PnlDashboard extends javax.swing.JPanel {

    private JPanel panel;

    private DashboardController controller;

    /**
     * Creates new form PnlDashboard
     */
    public PnlDashboard() {
        initComponents();

        this.controller = new DashboardController();

        setDesign();

        this.panel = this;

        this.removeAll();
        this.add(new PnlFetching(), java.awt.BorderLayout.CENTER);
        this.repaint();
        this.revalidate();

        String now = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date());
        lblTime.setText(now);

        fetchData();

    }

    private void fetchData() {

        new Thread(new Runnable() {
            @Override
            public void run() {

                showClock();

                loadProfitCardData();
                loadMostSoldPackageData();
                loadCustomerData();

                panel.removeAll();
                panel.add(pnlHeader, java.awt.BorderLayout.NORTH);
                panel.add(pnlCenter, java.awt.BorderLayout.CENTER);
                panel.add(pnlFooter, java.awt.BorderLayout.SOUTH);
                panel.repaint();
                panel.revalidate();
            }
        }).start();
    }
    
    private void loadCustomerData(){
        try {
            
            int[] data = controller.getCustomerCardData();
            
            lblCustomersActive.setText( data[0] +" Active");
            lblCustomersNew.setText("+ " + data[1] + " new Members");
            
            if(data[1] > 1) 
                lblCustomersNew.setForeground(new Color(24, 142, 0));
            else
                lblCustomersNew.setForeground(new Color(153, 153, 153));
            
        } catch (Exception e) {
           FrmSplashScreen.logger.log(Level.WARNING, e.getMessage() ,e);
        }
    }

    private void loadMostSoldPackageData() {
        try {
            String[] data = controller.getMostSoldPackageCardData();

            lblPackageTitle.setText(data[0]);

            int perccentage = Integer.parseInt(data[1]);

            if (perccentage > 0) {
                lblPackageSub.setText("+ " + perccentage + " more subscriptions");
                lblPackageSub.setForeground(new Color(24, 142, 0));
            } else {
                lblPackageSub.setText("N/A");
                lblPackageSub.setForeground(new Color(153, 153, 153));
            }

        } catch (Exception e) {
            FrmSplashScreen.logger.log(Level.WARNING, e.getMessage() ,e);
        }
    }

    private void loadProfitCardData() {
        try {

            String[] data = controller.getProfitCardData();

            if (Double.parseDouble(data[0]) != 0.0) {
                lblProfit.setText(AppLayout.appData.getCurrencyValue() + " " + data[0]);
                lblProfitSub.setText("+ " + data[1] + "% vs Last month");
            } else {
                lblProfit.setText("N/A");
            }

        } catch (Exception e) {
            FrmSplashScreen.logger.log(Level.WARNING, e.getMessage() ,e);
        }
    }

    private void showClock() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {

                    Thread.sleep(1000);
                    while (true) {

                        String now = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date());
                        lblTime.setText(now);
                    }
                } catch (InterruptedException e) {
                   FrmSplashScreen.logger.log(Level.WARNING, e.getMessage() ,e);
                }
            }
        }).start();
    }

    private void setDesign() {
        pnlCard1.putClientProperty(FlatClientProperties.STYLE, "arc: 24");
        pnlCard2.putClientProperty(FlatClientProperties.STYLE, "arc: 24");
        pnlCard3.putClientProperty(FlatClientProperties.STYLE, "arc: 24");
        pnlCard4.putClientProperty(FlatClientProperties.STYLE, "arc: 24");
        pnlCard5.putClientProperty(FlatClientProperties.STYLE, "arc: 24");
        pnlCard6.putClientProperty(FlatClientProperties.STYLE, "arc: 24");
        pnlCard7.putClientProperty(FlatClientProperties.STYLE, "arc: 24");
        pnlCard8.putClientProperty(FlatClientProperties.STYLE, "arc: 24");

        btnAttendance.putClientProperty("JButton.buttonType", "borderless");
        btnSubscriptionDetails.putClientProperty("JButton.buttonType", "borderless");
        btnMemberDetails.putClientProperty("JButton.buttonType", "borderless");
        btnAttendanceDetails.putClientProperty("JButton.buttonType", "borderless");
        btnExit.putClientProperty("JButton.buttonType", "borderless");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlCenter = new javax.swing.JPanel();
        pnlCard3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lblCustomersActive = new javax.swing.JLabel();
        lblCustomersNew = new javax.swing.JLabel();
        pnlCard1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        lblProfit = new javax.swing.JLabel();
        lblProfitSub = new javax.swing.JLabel();
        pnlCard2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        lblPackageTitle = new javax.swing.JLabel();
        lblPackageSub = new javax.swing.JLabel();
        pnlHeader = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblTime = new javax.swing.JLabel();
        pnlFooter = new javax.swing.JPanel();
        pnlCard4 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        btnAttendance = new javax.swing.JButton();
        pnlCard5 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        btnSubscriptionDetails = new javax.swing.JButton();
        pnlCard6 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        btnMemberDetails = new javax.swing.JButton();
        pnlCard7 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        btnAttendanceDetails = new javax.swing.JButton();
        pnlCard8 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        btnExit = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(1160, 900));
        setMinimumSize(new java.awt.Dimension(1160, 900));
        setLayout(new java.awt.BorderLayout());

        pnlCenter.setBackground(new java.awt.Color(255, 255, 255));
        pnlCenter.setMaximumSize(new java.awt.Dimension(1133, 210));
        pnlCenter.setMinimumSize(new java.awt.Dimension(1133, 210));
        pnlCenter.setPreferredSize(new java.awt.Dimension(1133, 210));

        pnlCard3.setBackground(new java.awt.Color(251, 251, 251));

        jLabel2.setBackground(new java.awt.Color(153, 153, 153));
        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Members");

        lblCustomersActive.setFont(new java.awt.Font("Segoe UI Semibold", 0, 30)); // NOI18N
        lblCustomersActive.setText("156 Active");

        lblCustomersNew.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        lblCustomersNew.setForeground(new java.awt.Color(255, 52, 0));
        lblCustomersNew.setText("- 5% vs Last month");

        javax.swing.GroupLayout pnlCard3Layout = new javax.swing.GroupLayout(pnlCard3);
        pnlCard3.setLayout(pnlCard3Layout);
        pnlCard3Layout.setHorizontalGroup(
            pnlCard3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCard3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(pnlCard3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2)
                    .addComponent(lblCustomersActive, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                    .addComponent(lblCustomersNew, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        pnlCard3Layout.setVerticalGroup(
            pnlCard3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCard3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel2)
                .addGap(31, 31, 31)
                .addComponent(lblCustomersActive)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCustomersNew)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pnlCard1.setBackground(new java.awt.Color(251, 251, 251));

        jLabel5.setBackground(new java.awt.Color(153, 153, 153));
        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Monthly Profit");

        lblProfit.setFont(new java.awt.Font("Segoe UI Semibold", 0, 30)); // NOI18N
        lblProfit.setText("LKR 21,300.00");

        lblProfitSub.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        lblProfitSub.setForeground(new java.awt.Color(24, 142, 0));
        lblProfitSub.setText("+ 26% vs Last month");

        javax.swing.GroupLayout pnlCard1Layout = new javax.swing.GroupLayout(pnlCard1);
        pnlCard1.setLayout(pnlCard1Layout);
        pnlCard1Layout.setHorizontalGroup(
            pnlCard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCard1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(pnlCard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5)
                    .addComponent(lblProfitSub, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblProfit, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        pnlCard1Layout.setVerticalGroup(
            pnlCard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCard1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel5)
                .addGap(31, 31, 31)
                .addComponent(lblProfit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblProfitSub)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pnlCard2.setBackground(new java.awt.Color(251, 251, 251));

        jLabel8.setBackground(new java.awt.Color(153, 153, 153));
        jLabel8.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText("Most sold package");

        lblPackageTitle.setFont(new java.awt.Font("Segoe UI Semibold", 0, 30)); // NOI18N
        lblPackageTitle.setText("The One Month");

        lblPackageSub.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        lblPackageSub.setForeground(new java.awt.Color(153, 153, 153));
        lblPackageSub.setText("+ 15% vs Last Month");

        javax.swing.GroupLayout pnlCard2Layout = new javax.swing.GroupLayout(pnlCard2);
        pnlCard2.setLayout(pnlCard2Layout);
        pnlCard2Layout.setHorizontalGroup(
            pnlCard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCard2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(pnlCard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel8)
                    .addComponent(lblPackageTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
                    .addComponent(lblPackageSub, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        pnlCard2Layout.setVerticalGroup(
            pnlCard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCard2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel8)
                .addGap(31, 31, 31)
                .addComponent(lblPackageTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPackageSub)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlCenterLayout = new javax.swing.GroupLayout(pnlCenter);
        pnlCenter.setLayout(pnlCenterLayout);
        pnlCenterLayout.setHorizontalGroup(
            pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCenterLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(pnlCard1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(pnlCard2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlCard3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );
        pnlCenterLayout.setVerticalGroup(
            pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCenterLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlCard2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlCard3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlCard1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        add(pnlCenter, java.awt.BorderLayout.CENTER);

        pnlHeader.setBackground(new java.awt.Color(255, 255, 255));
        pnlHeader.setPreferredSize(new java.awt.Dimension(1160, 100));

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jLabel1.setText("Hello, Wishva Kalhara");

        lblTime.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        lblTime.setForeground(new java.awt.Color(153, 153, 153));
        lblTime.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblTime.setText("DATE TIME");

        javax.swing.GroupLayout pnlHeaderLayout = new javax.swing.GroupLayout(pnlHeader);
        pnlHeader.setLayout(pnlHeaderLayout);
        pnlHeaderLayout.setHorizontalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHeaderLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 605, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTime, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );
        pnlHeaderLayout.setVerticalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHeaderLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTime, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(pnlHeader, java.awt.BorderLayout.NORTH);

        pnlFooter.setBackground(new java.awt.Color(255, 255, 255));
        pnlFooter.setPreferredSize(new java.awt.Dimension(1160, 590));

        pnlCard4.setBackground(new java.awt.Color(251, 251, 251));

        jLabel15.setFont(new java.awt.Font("Segoe UI Semibold", 0, 20)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(153, 153, 153));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Scan membership card or enter your ID.");

        btnAttendance.setBackground(new java.awt.Color(77, 119, 255));
        btnAttendance.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        btnAttendance.setForeground(new java.awt.Color(255, 255, 255));
        btnAttendance.setText("Mark Attendance");
        btnAttendance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAttendanceActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlCard4Layout = new javax.swing.GroupLayout(pnlCard4);
        pnlCard4.setLayout(pnlCard4Layout);
        pnlCard4Layout.setHorizontalGroup(
            pnlCard4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCard4Layout.createSequentialGroup()
                .addGap(271, 271, 271)
                .addComponent(btnAttendance, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(276, Short.MAX_VALUE))
            .addGroup(pnlCard4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlCard4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 699, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        pnlCard4Layout.setVerticalGroup(
            pnlCard4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCard4Layout.createSequentialGroup()
                .addContainerGap(257, Short.MAX_VALUE)
                .addComponent(btnAttendance, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(212, 212, 212))
            .addGroup(pnlCard4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlCard4Layout.createSequentialGroup()
                    .addGap(158, 158, 158)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(264, Short.MAX_VALUE)))
        );

        pnlCard5.setBackground(new java.awt.Color(251, 251, 251));

        jLabel11.setBackground(new java.awt.Color(153, 153, 153));
        jLabel11.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 51, 51));
        jLabel11.setText("Subscription Details");

        btnSubscriptionDetails.setBackground(new java.awt.Color(251, 251, 251));
        btnSubscriptionDetails.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons/chevron-dright.png"))); // NOI18N
        btnSubscriptionDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubscriptionDetailsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlCard5Layout = new javax.swing.GroupLayout(pnlCard5);
        pnlCard5.setLayout(pnlCard5Layout);
        pnlCard5Layout.setHorizontalGroup(
            pnlCard5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCard5Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSubscriptionDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        pnlCard5Layout.setVerticalGroup(
            pnlCard5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCard5Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel11)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCard5Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(btnSubscriptionDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        pnlCard6.setBackground(new java.awt.Color(251, 251, 251));

        jLabel12.setBackground(new java.awt.Color(153, 153, 153));
        jLabel12.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(51, 51, 51));
        jLabel12.setText("Member Details");

        btnMemberDetails.setBackground(new java.awt.Color(251, 251, 251));
        btnMemberDetails.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons/chevron-dright.png"))); // NOI18N
        btnMemberDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMemberDetailsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlCard6Layout = new javax.swing.GroupLayout(pnlCard6);
        pnlCard6.setLayout(pnlCard6Layout);
        pnlCard6Layout.setHorizontalGroup(
            pnlCard6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCard6Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnMemberDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        pnlCard6Layout.setVerticalGroup(
            pnlCard6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCard6Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel12)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCard6Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(btnMemberDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        pnlCard7.setBackground(new java.awt.Color(251, 251, 251));

        jLabel13.setBackground(new java.awt.Color(153, 153, 153));
        jLabel13.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(51, 51, 51));
        jLabel13.setText("Attendance Report");

        btnAttendanceDetails.setBackground(new java.awt.Color(251, 251, 251));
        btnAttendanceDetails.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons/chevron-dright.png"))); // NOI18N
        btnAttendanceDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAttendanceDetailsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlCard7Layout = new javax.swing.GroupLayout(pnlCard7);
        pnlCard7.setLayout(pnlCard7Layout);
        pnlCard7Layout.setHorizontalGroup(
            pnlCard7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCard7Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addComponent(btnAttendanceDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        pnlCard7Layout.setVerticalGroup(
            pnlCard7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCard7Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addGroup(pnlCard7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAttendanceDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );

        pnlCard8.setBackground(new java.awt.Color(251, 251, 251));

        jLabel14.setBackground(new java.awt.Color(153, 153, 153));
        jLabel14.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(51, 51, 51));
        jLabel14.setText("Sign out");

        btnExit.setBackground(new java.awt.Color(251, 251, 251));
        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons/chevron-dright.png"))); // NOI18N
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlCard8Layout = new javax.swing.GroupLayout(pnlCard8);
        pnlCard8.setLayout(pnlCard8Layout);
        pnlCard8Layout.setHorizontalGroup(
            pnlCard8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCard8Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        pnlCard8Layout.setVerticalGroup(
            pnlCard8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCard8Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel14)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCard8Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout pnlFooterLayout = new javax.swing.GroupLayout(pnlFooter);
        pnlFooter.setLayout(pnlFooterLayout);
        pnlFooterLayout.setHorizontalGroup(
            pnlFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFooterLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(pnlCard4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(pnlFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlCard5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlCard6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlCard7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlCard8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(40, 40, 40))
        );
        pnlFooterLayout.setVerticalGroup(
            pnlFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFooterLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlCard4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlFooterLayout.createSequentialGroup()
                        .addComponent(pnlCard5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(pnlCard6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(pnlCard7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pnlCard8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(61, 61, 61))
        );

        add(pnlFooter, java.awt.BorderLayout.PAGE_END);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAttendanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAttendanceActionPerformed

        new FrmAttendance(true).setVisible(true);
        AppLayout.appLayout.setVisible(false);
    }//GEN-LAST:event_btnAttendanceActionPerformed

    private void btnSubscriptionDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubscriptionDetailsActionPerformed

        AppLayout.appLayout.changeForm(LayoutPages.SUBSCRIPTIONS);
    }//GEN-LAST:event_btnSubscriptionDetailsActionPerformed

    private void btnMemberDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMemberDetailsActionPerformed

        AppLayout.appLayout.changeForm(LayoutPages.MEMBERS);
    }//GEN-LAST:event_btnMemberDetailsActionPerformed

    private void btnAttendanceDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAttendanceDetailsActionPerformed

        AppLayout.appLayout.changeForm(LayoutPages.ATTENDANCE);
    }//GEN-LAST:event_btnAttendanceDetailsActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed

        try {

            DlgConfirm dialog = new DlgConfirm(AppLayout.appLayout, true, "Confirm Exit!", "Sure you want to sign out.");
            dialog.setVisible(true);
            DialogActions action = dialog.getAction();

            if (action == DialogActions.CONFIRM) {

                AppConnection.closeConnection();
                System.exit(0);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
            FrmSplashScreen.logger.log(Level.WARNING, e.getMessage() ,e);
        }
    }//GEN-LAST:event_btnExitActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAttendance;
    private javax.swing.JButton btnAttendanceDetails;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnMemberDetails;
    private javax.swing.JButton btnSubscriptionDetails;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel lblCustomersActive;
    private javax.swing.JLabel lblCustomersNew;
    private javax.swing.JLabel lblPackageSub;
    private javax.swing.JLabel lblPackageTitle;
    private javax.swing.JLabel lblProfit;
    private javax.swing.JLabel lblProfitSub;
    private javax.swing.JLabel lblTime;
    private javax.swing.JPanel pnlCard1;
    private javax.swing.JPanel pnlCard2;
    private javax.swing.JPanel pnlCard3;
    private javax.swing.JPanel pnlCard4;
    private javax.swing.JPanel pnlCard5;
    private javax.swing.JPanel pnlCard6;
    private javax.swing.JPanel pnlCard7;
    private javax.swing.JPanel pnlCard8;
    private javax.swing.JPanel pnlCenter;
    private javax.swing.JPanel pnlFooter;
    private javax.swing.JPanel pnlHeader;
    // End of variables declaration//GEN-END:variables
}
