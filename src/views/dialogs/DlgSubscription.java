/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package views.dialogs;

import com.formdev.flatlaf.FlatClientProperties;
import com.wishva.*;
import controllers.SubscriptionController;
import enums.DialogTypes;
import enums.LayoutPages;
import java.awt.Color;
import java.util.Date;
import java.util.Vector;
import java.sql.ResultSet;
import java.util.HashMap;
import javax.swing.DefaultComboBoxModel;
import models.PaymentPlan;
import models.Subscription;
import raven.toast.Notifications;
import utils.AppConnection;
import utils.Formatter;
import views.layouts.AppLayout;

/**
 *
 * @author vishv
 */
public class DlgSubscription extends javax.swing.JDialog {

    HashMap<String, String> customerMap = new HashMap();
    HashMap<String, PaymentPlan> packagesMap = new HashMap();

    /**
     * Creates new form DlgSubscription
     */
    public DlgSubscription(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        setDesign();

        txtCustomerId.grabFocus();
        dateFrom.setEnabled(false);

        fetchData();
    }

    private void setDesign() {

        getRootPane().putClientProperty(FlatClientProperties.TITLE_BAR_BACKGROUND, new Color(255, 255, 255));
        getRootPane().putClientProperty(FlatClientProperties.TITLE_BAR_FOREGROUND, new Color(0, 0, 0));
        getRootPane().putClientProperty(FlatClientProperties.TITLE_BAR_SHOW_CLOSE, false);
        getRootPane().putClientProperty(FlatClientProperties.TITLE_BAR_SHOW_MAXIMIZE, false);
        getRootPane().putClientProperty(FlatClientProperties.TITLE_BAR_SHOW_ICONIFFY, false);

        btnSubmit.putClientProperty("JButton.buttonType", "borderless");
        btnClose.putClientProperty("JButton.buttonType", "borderless");

        txtCustomerId.putClientProperty(FlatClientProperties.STYLE, "arc: 10");
        txtCustomerId.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "cus-");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btnClose = new javax.swing.JButton();
        lblHeading = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cboCustomerName = new javax.swing.JComboBox<>();
        cboPackage = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        dateFrom = new com.toedter.calendar.JDateChooser();
        txtCustomerId = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btnSubmit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(695, 80));

        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons/x.png"))); // NOI18N
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        lblHeading.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        lblHeading.setText("Issue a subscription");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(lblHeading, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 198, Short.MAX_VALUE)
                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnClose, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                    .addComponent(lblHeading, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, java.awt.BorderLayout.NORTH);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setMaximumSize(new java.awt.Dimension(0, 0));

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Customer Id:");

        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Customer Name:");

        cboCustomerName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Loading" }));
        cboCustomerName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboCustomerNameActionPerformed(evt);
            }
        });

        cboPackage.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Loading" }));
        cboPackage.setToolTipText("");
        cboPackage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboPackageActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Valid From:");

        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Pacakge:");

        txtCustomerId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCustomerIdActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(cboPackage, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(dateFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5)
                            .addComponent(txtCustomerId, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(cboCustomerName, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(185, 185, 185)
                                .addComponent(jLabel4)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(32, 32, 32))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cboCustomerName, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCustomerId))
                .addGap(25, 25, 25)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(dateFrom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cboPackage, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel5, java.awt.BorderLayout.CENTER);

        jPanel2.setBackground(new java.awt.Color(248, 248, 248));
        jPanel2.setPreferredSize(new java.awt.Dimension(528, 130));

        btnSubmit.setBackground(new java.awt.Color(77, 119, 255));
        btnSubmit.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        btnSubmit.setForeground(new java.awt.Color(255, 255, 255));
        btnSubmit.setText("Select a Package");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(btnSubmit, javax.swing.GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE)
                .addGap(35, 35, 35))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );

        jPanel1.add(jPanel2, java.awt.BorderLayout.PAGE_END);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 528, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void cboCustomerNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboCustomerNameActionPerformed

        if (cboCustomerName.getSelectedIndex() == 0) {
            txtCustomerId.setText("");
            return;
        }

        txtCustomerId.setText(customerMap.get(String.valueOf(cboCustomerName.getSelectedItem())));

        getStartDate();
    }//GEN-LAST:event_cboCustomerNameActionPerformed

    private void txtCustomerIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCustomerIdActionPerformed

        String input = txtCustomerId.getText();
        if (input.isBlank()) {
            return;
        }

        try {

            if (!input.startsWith("cus-") && Character.isDigit(input.charAt(0))) {
                txtCustomerId.setText("cus-" + input);
            }

            ResultSet rs = AppConnection.fetch("SELECT CONCAT(`first_name`, ' ', `last_name`) AS full_name "
                    + "FROM customers "
                    + "WHERE `id` = '" + txtCustomerId.getText() + "' AND `statuses_id` = '1'");

            if (rs.next()) {
                cboCustomerName.setSelectedItem(rs.getString("full_name"));
                cboPackage.grabFocus();
                getStartDate();
            } else {
                cboCustomerName.setSelectedIndex(0);
                new DlgError(AppLayout.appLayout, true, "Not Found!", "There is no active customer with the same Id.").setVisible(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_txtCustomerIdActionPerformed

    private void cboPackageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboPackageActionPerformed

        if (cboPackage.getSelectedIndex() == 0) {
            btnSubmit.setText("Select a Package");
            return;
        }

        String price = new Formatter().addZeroToDouble(packagesMap.get(String.valueOf(cboPackage.getSelectedItem())).getPrice());
        btnSubmit.setText("Issue Subscription (" + AppLayout.appData.getCurrencyValue() + " " + price + ")");
    }//GEN-LAST:event_cboPackageActionPerformed

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed

        try {

            Subscription subscription = getSubscriptionFromForm();
            subscription.setPaidAmount(packagesMap.get(String.valueOf(cboPackage.getSelectedItem())).getPrice());

            new DlgPayment(AppLayout.appLayout, true, subscription).setVisible(true);
            this.dispose();

            new DlgError(AppLayout.appLayout, true, "Subscription Issued Success.", "Success", DialogTypes.SUCCESS).setVisible(true);
            Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.BOTTOM_CENTER, "Subscription issued success!");
            AppLayout.appLayout.changeForm(LayoutPages.SUBSCRIPTIONS);
        } catch (SparkException e) {
            new DlgError(AppLayout.appLayout, true, "Validation Error", e.getMessage()).setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }//GEN-LAST:event_btnSubmitActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JComboBox<String> cboCustomerName;
    private javax.swing.JComboBox<String> cboPackage;
    private com.toedter.calendar.JDateChooser dateFrom;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel lblHeading;
    private javax.swing.JTextField txtCustomerId;
    // End of variables declaration//GEN-END:variables

    private void fetchData() {
        new Thread(new Runnable() {
            @Override
            public void run() {

                loadCustomers();
                loadPackages();
            }
        }).start();
    }

    private void loadCustomers() {

        try {

            Vector<String> customers = new Vector();
            customers.add("Select");
            customerMap.put("Select", "0");

            ResultSet rs = AppConnection.fetch("SELECT `id`, CONCAT(`first_name`, ' ', `last_name`) AS full_name "
                    + "FROM customers "
                    + "WHERE `statuses_id` = '1' "
                    + "ORDER BY `first_name` ASC");

            while (rs.next()) {
                String fullName = rs.getString("full_name");
                customers.add(fullName);
                customerMap.put(fullName, rs.getString("id"));
            }

            cboCustomerName.setModel(new DefaultComboBoxModel<String>(customers));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadPackages() {
        try {

            Vector<String> packages = new Vector();
            packages.add("Select");

            packagesMap.put("Select", new PaymentPlan());

            ResultSet rs = AppConnection.fetch("SELECT `id`, CONCAT(`title`, ' - ', `validity`, 'd') as displayName, `price`, `validity` "
                    + "FROM members_v2.packages "
                    + "WHERE `statuses_id` = '1';");

            while (rs.next()) {
                String fullName = rs.getString("displayName") + " (" + AppLayout.appData.getCurrencyValue() + rs.getString("price") + ")";
                packages.add(fullName);

                PaymentPlan plan = new PaymentPlan();
                plan.setPrice(rs.getDouble("price"));
                plan.setId(rs.getString("id"));
                plan.setValidity(rs.getInt("validity"));
                packagesMap.put(fullName, plan);
            }

            cboPackage.setModel(new DefaultComboBoxModel<>(packages));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void getStartDate() {

        try {

            String customerId = customerMap.get(String.valueOf(cboCustomerName.getSelectedItem()));

            ResultSet rs = AppConnection.fetch("SELECT `end` "
                    + "FROM subscriptions "
                    + "WHERE `customers_id` = '" + customerId + "' "
                    + "ORDER BY `id` DESC "
                    + "LIMIT 1;");

            if (rs.next()) {

                Date endDate = rs.getDate("end");
                Date startDate = new SubscriptionController().getStartDate(endDate);
                dateFrom.setDate(startDate);
                dateFrom.setMinSelectableDate(startDate);
            } else {
                dateFrom.setDate(new Date());
                dateFrom.setMinSelectableDate(new Date());
            }

            dateFrom.setEnabled(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Subscription getSubscriptionFromForm() throws SparkException {

        Subscription subscription = new Subscription();

        subscription.setCustomerId(new Spark("Customer Id", txtCustomerId.getText())
                .required()
                .endString());

        if (cboCustomerName.getSelectedIndex() == 0) {
            throw new SparkException("Select a customer name!");
        }

        if (!customerMap.get(String.valueOf(cboCustomerName.getSelectedItem())).equals(subscription.getCustomerId())) {
            txtCustomerId.setText("");
            cboCustomerName.setSelectedIndex(0);
            throw new SparkException("Select the customer again!");
        }

        if (cboPackage.getSelectedIndex() == 0) {
            throw new SparkException("Select a package!");
        }
        subscription.setPackageId(packagesMap.get(String.valueOf(cboPackage.getSelectedItem())).getId());

        if (dateFrom.getDate() == null) {
            throw new SparkException("Select a start date!");
        }
        subscription.setStartDate(dateFrom.getDate());
        subscription.setValidity(packagesMap.get(String.valueOf(cboPackage.getSelectedItem())).getValidity());

        return subscription;
    }
}
