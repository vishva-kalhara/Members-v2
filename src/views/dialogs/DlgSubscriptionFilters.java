/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package views.dialogs;

import com.formdev.flatlaf.FlatClientProperties;
import enums.DialogTypes;
import java.awt.Color;
import utils.AppConnection;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import views.layouts.AppLayout;

/**
 *
 * @author vishv
 */
public class DlgSubscriptionFilters extends javax.swing.JDialog {

    private HashMap<String, String> packagesMap = new HashMap();
    private HashMap<String, String> customersMap = new HashMap();

    private HashMap<String, String> reportData;

    private StringBuilder query = new StringBuilder();

    /**
     * Creates new form DlgSubscriptionFilters
     *
     * @param parent
     * @param modal
     * @param reportData
     *
     */
    public DlgSubscriptionFilters(java.awt.Frame parent, boolean modal, HashMap<String, String> reportData) {
        super(parent, modal);
        initComponents();

        setDesign();

        this.reportData = reportData;

        cboPackage.grabFocus();

        fetchData();
    }

    private void setDesign() {

        getRootPane().putClientProperty(FlatClientProperties.TITLE_BAR_BACKGROUND, new Color(255, 255, 255));
        getRootPane().putClientProperty(FlatClientProperties.TITLE_BAR_FOREGROUND, new Color(0, 0, 0));
        getRootPane().putClientProperty(FlatClientProperties.TITLE_BAR_SHOW_CLOSE, false);
        getRootPane().putClientProperty(FlatClientProperties.TITLE_BAR_SHOW_MAXIMIZE, false);
        getRootPane().putClientProperty(FlatClientProperties.TITLE_BAR_SHOW_ICONIFFY, false);
        getRootPane().putClientProperty(FlatClientProperties.TITLE_BAR_SHOW_ICON, false);

        btnClear.putClientProperty("JButton.buttonType", "borderless");
        btnSubmit.putClientProperty("JButton.buttonType", "borderless");

        txtCustomerId.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "cus-");
        txtCustomerId.putClientProperty(FlatClientProperties.STYLE, "arc: 10");
        txtAmountFrom.putClientProperty(FlatClientProperties.STYLE, "arc: 10");
        txtAmountTo.putClientProperty(FlatClientProperties.STYLE, "arc: 10");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        lblHeading = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        dateFrom = new com.toedter.calendar.JDateChooser();
        dateTo = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        txtAmountFrom = new javax.swing.JFormattedTextField();
        txtAmountTo = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cboPackage = new javax.swing.JComboBox<>();
        txtCustomerId = new javax.swing.JTextField();
        cboCustomer = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        btnSubmit = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(373, 733));
        setMinimumSize(new java.awt.Dimension(373, 733));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(695, 80));

        lblHeading.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        lblHeading.setText("Advanced Filters");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(lblHeading, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(116, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(lblHeading, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, java.awt.BorderLayout.NORTH);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setMaximumSize(new java.awt.Dimension(0, 0));

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Issued date:");

        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("to");

        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Paid Amount:");

        txtAmountFrom.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        txtAmountFrom.setHorizontalAlignment(javax.swing.JTextField.TRAILING);

        txtAmountTo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        txtAmountTo.setHorizontalAlignment(javax.swing.JTextField.TRAILING);

        jLabel6.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("to");

        jLabel7.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("Filter by Package:");

        jLabel8.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText("Filter By Customer:");

        cboPackage.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Loading" }));

        txtCustomerId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCustomerIdActionPerformed(evt);
            }
        });

        cboCustomer.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Loading" }));
        cboCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboCustomerActionPerformed(evt);
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
                        .addComponent(jLabel2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel7))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cboPackage, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(txtCustomerId, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cboCustomer, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(txtAmountFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(dateFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(3, 3, 3)))
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dateTo, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addComponent(txtAmountTo, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(33, 33, 33))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboPackage, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cboCustomer)
                    .addComponent(txtCustomerId, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAmountFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAmountTo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(dateTo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dateFrom, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46))
        );

        jPanel1.add(jPanel5, java.awt.BorderLayout.CENTER);

        jPanel2.setBackground(new java.awt.Color(248, 248, 248));
        jPanel2.setPreferredSize(new java.awt.Dimension(528, 184));

        btnSubmit.setBackground(new java.awt.Color(77, 119, 255));
        btnSubmit.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        btnSubmit.setForeground(new java.awt.Color(255, 255, 255));
        btnSubmit.setText("Filter");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        btnClear.setBackground(new java.awt.Color(248, 248, 248));
        btnClear.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        btnClear.setText("Clear Filters");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, java.awt.BorderLayout.PAGE_END);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 699, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed

        try {

            if (cboPackage.getSelectedIndex() == 0
                    && cboCustomer.getSelectedIndex() == 0
                    && txtAmountFrom.getText().isBlank()
                    && txtAmountTo.getText().isBlank()
                    && dateFrom.getDate() == null
                    && dateTo.getDate() == null) {

                new DlgError(AppLayout.appLayout, true, "There is nothing to filter.", "Filter Error!", DialogTypes.WARNING).setVisible(true);
                return;
            }

            if (!txtAmountFrom.getText().isBlank()
                    && !txtAmountTo.getText().isBlank()
                    && Double.parseDouble(txtAmountFrom.getText()) >= Double.parseDouble(txtAmountTo.getText())) {

                new DlgError(AppLayout.appLayout, true, "Filter Error!", "Min price is greater than Max Price.").setVisible(true);
                return;
            }

            if (dateFrom.getDate() != null
                    && dateTo.getDate() != null
                    && !dateFrom.getDate().before(dateTo.getDate())) {

                new DlgError(AppLayout.appLayout, true, "Filter Error!", "From date is previous than To date.").setVisible(true);
                return;
            }

            generateQuery();
            this.setVisible(false);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }

    }//GEN-LAST:event_btnSubmitActionPerformed

    private void cboCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboCustomerActionPerformed

        txtCustomerId.setText(customersMap.get(String.valueOf(cboCustomer.getSelectedItem())));
    }//GEN-LAST:event_cboCustomerActionPerformed

    private void txtCustomerIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCustomerIdActionPerformed

        if (txtCustomerId.getText().isBlank()) {
            return;
        }

        if (!txtCustomerId.getText().startsWith("cus-")) {
            txtCustomerId.setText("cus-" + txtCustomerId.getText());
        }

        try {

            ResultSet rs = AppConnection.fetch("SELECT CONCAT(`first_name`, ' ', `last_name`) AS full_name FROM `customers` WHERE `id` = '" + txtCustomerId.getText() + "'");

            if (rs.next()) {
                cboCustomer.setSelectedItem(rs.getString("full_name"));
            } else {
                cboCustomer.setSelectedIndex(0);
                new DlgError(AppLayout.appLayout, true, "Not Found!", "There is no active customer with the same Id.").setVisible(true);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_txtCustomerIdActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed

        cboPackage.setSelectedIndex(0);
        cboCustomer.setSelectedIndex(0);
        txtCustomerId.setText("");
        txtAmountFrom.setText("");
        txtAmountTo.setText("");
        dateFrom.setDate(null);
        dateTo.setDate(null);

        this.setVisible(false);
    }//GEN-LAST:event_btnClearActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JComboBox<String> cboCustomer;
    private javax.swing.JComboBox<String> cboPackage;
    private com.toedter.calendar.JDateChooser dateFrom;
    private com.toedter.calendar.JDateChooser dateTo;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel lblHeading;
    private javax.swing.JFormattedTextField txtAmountFrom;
    private javax.swing.JFormattedTextField txtAmountTo;
    private javax.swing.JTextField txtCustomerId;
    // End of variables declaration//GEN-END:variables

    private void fetchData() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                loadPackages();
                loadCustomers();
            }
        }).start();
    }

    private void loadPackages() {
        try {
            ResultSet rs = AppConnection.fetch("SELECT `id`, CONCAT(`title`, ' (', `validity`, 'd)') AS `displayText` FROM `packages` ORDER BY `validity` ASC;");

            Vector<String> data = new Vector();
            data.add("Select a Package");

            while (rs.next()) {
                data.add(rs.getString("displayText"));
                packagesMap.put(rs.getString("displayText"), rs.getString("id"));
            }

            cboPackage.setModel(new DefaultComboBoxModel<>(data));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadCustomers() {
        try {

            ResultSet rs = AppConnection.fetch("SELECT CONCAT(`first_name`, ' ', `last_name`) AS full_name, `id` FROM customers ORDER BY `first_name` ASC;");

            Vector<String> data = new Vector();
            data.add("Select");

            while (rs.next()) {
                data.add(rs.getString("full_name"));
                customersMap.put(rs.getString("full_name"), rs.getString("id"));
            }

            cboCustomer.setModel(new DefaultComboBoxModel<>(data));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void generateQuery() {

        query.append("WHERE ");

        boolean hasAnd = false;

        if (cboPackage.getSelectedIndex() != 0) {

            String packageId = packagesMap.get(String.valueOf(cboPackage.getSelectedItem()));
            query.append(" `packages_id` = '")
                    .append(packageId)
                    .append("' ");

            reportData.put("packageData", "(Filter) Package Details: " + String.valueOf(cboPackage.getSelectedItem()));
            hasAnd = true;
        } else {
            reportData.put("packageData", "(Filter) Package Details: Not Applied");
        }

        if (cboCustomer.getSelectedIndex() != 0) {

            if (hasAnd) {
                query.append(" AND ");
            }

            String customerId = customersMap.get(String.valueOf(cboCustomer.getSelectedItem()));
            query.append(" `customers_id` = '")
                    .append(customerId)
                    .append("' ");

            reportData.put("customerData", "(Filter) Member Details: " + String.valueOf(cboCustomer.getSelectedItem()));
            hasAnd = true;
        } else {
            reportData.put("customerData", "(Filter) Member Details: Not Applied");
        }

        boolean hasFromPrice = !txtAmountFrom.getText().isBlank();
        if (hasFromPrice) {

            if (hasAnd) {
                query.append(" AND ");
            }

            String value = txtAmountFrom.getText();
            query.append(" `paid_amount` >= '")
                    .append(value)
                    .append("' ");

            hasAnd = true;

        }

        boolean hasToPrice = !txtAmountTo.getText().isBlank();
        if (hasToPrice) {

            if (hasAnd) {
                query.append(" AND ");
            }

            String value = txtAmountTo.getText();
            query.append(" `paid_amount` <= '")
                    .append(value)
                    .append("'");

            hasAnd = true;
        }

        if (hasFromPrice && hasToPrice) {
            reportData.put("priceDate", "(Filter) Paid amount: " + AppLayout.appData.getCurrencyValue() + txtAmountFrom.getText() + " to " + AppLayout.appData.getCurrencyValue() + txtAmountTo.getText());
        } else if (hasFromPrice && !hasToPrice) {
            reportData.put("priceDate", "(Filter) Paid amount: " + AppLayout.appData.getCurrencyValue() + txtAmountFrom.getText() + " to MAX");
        } else if (!hasFromPrice && hasToPrice) {
            reportData.put("priceDate", "(Filter) Paid amount: " + AppLayout.appData.getCurrencyValue() + "0.00 to " + AppLayout.appData.getCurrencyValue() + txtAmountTo.getText());
        } else {
            reportData.put("priceDate", "(Filter) Paid amount: Not Applied");
        }

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        boolean hasFromDate = dateFrom.getDate() != null;
        if (hasFromDate) {

            if (hasAnd) {
                query.append(" AND ");
            }

            Date value = dateFrom.getDate();
            query.append(" `created_at` >= '")
                    .append(formatter.format(value))
                    .append("'");

            hasAnd = true;
        }

        boolean hasToDate = dateTo.getDate() != null;
        if (hasToDate) {

            if (hasAnd) {
                query.append(" AND ");
            }

            Date value = dateTo.getDate();
            query.append(" `created_at` <= '")
                    .append(formatter.format(value))
                    .append("' ");
        }

        if (hasFromDate && hasToDate) {
            reportData.put("dateDate", "(Filter) Issued Date: From " + formatter.format(dateFrom.getDate()) + " to " + formatter.format(dateTo.getDate()));
        } else if (hasFromDate && !hasToDate) {
            reportData.put("dateDate", "(Filter) Issued Date: From " + formatter.format(dateFrom.getDate()));
        } else if (!hasFromDate && hasToDate) {
            reportData.put("dateDate", "(Filter) Issued Date: To " + formatter.format(dateTo.getDate()));
        } else {
            reportData.put("dateDate", "(Filter) Issued Date: Not Applied");
        }
    }

    public String getQuery() {

        return String.valueOf(this.query);
    }

    public void newQuery() {

        this.query = new StringBuilder("");
    }

    public HashMap<String, String> getReportData() {

        return reportData;
    }
}
