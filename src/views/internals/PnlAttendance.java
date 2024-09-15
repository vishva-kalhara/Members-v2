/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package views.internals;

import config.AppConfig;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.view.JasperViewer;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperFillManager;
import utils.AppConnection;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import views.layouts.AppLayout;

/**
 *
 * @author vishv
 */
public class PnlAttendance extends javax.swing.JPanel {

    HashMap<String, String> customerMap = new HashMap();
    HashMap<String, String> packagesMap = new HashMap();

    /**
     * Creates new form PnlAttendance
     */
    public PnlAttendance() {
        initComponents();

        setDesign();
        fetchData();
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
        cboSort = new javax.swing.JComboBox<>();
        btnPrint = new javax.swing.JButton();
        btnClearFilters = new javax.swing.JButton();
        btnView = new javax.swing.JButton();
        cboPackage = new javax.swing.JComboBox<>();
        cboCustomer = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        scrollPane = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

        setMaximumSize(new java.awt.Dimension(1160, 900));
        setMinimumSize(new java.awt.Dimension(1160, 900));
        setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1160, 100));

        cboSort.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Marked At DESC", "Marked At ASC" }));
        cboSort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboSortActionPerformed(evt);
            }
        });

        btnPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons/printer_20.png"))); // NOI18N
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });

        btnClearFilters.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons/filter-x.png"))); // NOI18N
        btnClearFilters.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearFiltersActionPerformed(evt);
            }
        });

        btnView.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons/file-text.png"))); // NOI18N
        btnView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewActionPerformed(evt);
            }
        });

        cboPackage.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Loading" }));
        cboPackage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboPackageActionPerformed(evt);
            }
        });

        cboCustomer.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Loading" }));
        cboCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboCustomerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(cboSort, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboPackage, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnClearFilters, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 236, Short.MAX_VALUE)
                .addComponent(btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnView, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(cboSort)
                    .addComponent(btnPrint, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnClearFilters, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                    .addComponent(btnView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cboPackage)
                    .addComponent(cboCustomer))
                .addGap(19, 19, 19))
        );

        add(jPanel1, java.awt.BorderLayout.NORTH);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        scrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Marked At", "Member Id", "Member Name", "Package"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.getTableHeader().setReorderingAllowed(false);
        scrollPane.setViewportView(table);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 1102, Short.MAX_VALUE)
                .addGap(26, 26, 26))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 705, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(jPanel2, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void cboSortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboSortActionPerformed
        loadTableData();
    }//GEN-LAST:event_cboSortActionPerformed

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed

        try {

            JasperPrintManager.printReport(generateReport(), true);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnPrintActionPerformed

    private void btnClearFiltersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearFiltersActionPerformed

        cboSort.setSelectedIndex(0);
        cboPackage.setSelectedIndex(0);
        cboCustomer.setSelectedIndex(0);
        loadTableData();
    }//GEN-LAST:event_btnClearFiltersActionPerformed

    private void btnViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewActionPerformed

        try {

            JasperViewer.viewReport(generateReport(), false);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnViewActionPerformed

    private void cboPackageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboPackageActionPerformed

        loadTableData();
    }//GEN-LAST:event_cboPackageActionPerformed

    private void cboCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboCustomerActionPerformed

        loadTableData();
    }//GEN-LAST:event_cboCustomerActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClearFilters;
    private javax.swing.JButton btnPrint;
    private javax.swing.JButton btnView;
    private javax.swing.JComboBox<String> cboCustomer;
    private javax.swing.JComboBox<String> cboPackage;
    private javax.swing.JComboBox<String> cboSort;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables

    private void setDesign() {

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        table.setDefaultRenderer(Object.class, centerRenderer);

        javax.swing.JScrollPane scroll = (javax.swing.JScrollPane) table.getParent().getParent();
        scroll.setBorder(BorderFactory.createEmptyBorder());
    }

    private void fetchData() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                loadCustomers();
                loadPackageData();
                loadTableData();
            }
        }).start();
    }

    private void loadPackageData() {
        try {
            ResultSet rs = AppConnection.fetch("SELECT `id`, CONCAT(`title`, ' (', `validity`, 'd)') AS `displayText` FROM `packages` ORDER BY `validity` ASC;");

            Vector<String> data = new Vector();
            data.add("Filter by Package");

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

            ResultSet rs = AppConnection.fetch("SELECT CONCAT(`first_name`, ' ', `last_name`) AS `full_name`, `id` FROM `customers` ORDER BY `first_name` ASC");

            Vector<String> data = new Vector();
            data.add("Filter by Member");

            while (rs.next()) {

                data.add(rs.getString("full_name"));
                customerMap.put(rs.getString("full_name"), rs.getString("id"));
            }

            cboCustomer.setModel(new DefaultComboBoxModel<>(data));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String getWhereClause() {

        StringBuilder clause = new StringBuilder(" WHERE ");

        if (cboCustomer.getSelectedIndex() == 0 && cboPackage.getSelectedIndex() == 0) {
            return "";
        }

        boolean hasPackage = cboPackage.getSelectedIndex() != 0;
        if (hasPackage) {

            clause.append(" `packages_id` = '")
                    .append(packagesMap.get(String.valueOf(cboPackage.getSelectedItem())))
                    .append("'");
        }

        if (cboCustomer.getSelectedIndex() != 0) {

            if (hasPackage) {
                clause.append(" AND ");
            }

            clause.append(" `customers_id` = '")
                    .append(customerMap.get(String.valueOf(cboCustomer.getSelectedItem())))
                    .append("'");
        }

        return String.valueOf(clause);
    }

    private String getSortClause() {

        StringBuilder clause = new StringBuilder(" ORDER BY `marked_at` ");

        if (String.valueOf(cboSort.getSelectedItem()).equals("Marked At DESC")) {
            clause.append("DESC");
        } else {
            clause.append("ASC");
        }

        return String.valueOf(clause);
    }

    private void loadTableData() {

        scrollPane.setViewportView(new PnlFetching());
        btnView.setEnabled(false);
        btnPrint.setEnabled(false);

        try {

            ResultSet rs = AppConnection.fetch("SELECT `marked_at`, `customers_id`, CONCAT(`customers`.`first_name`, ' ', `customers`.`last_name`) AS full_name, `packages`.`title` "
                    + "FROM `attendance` "
                    + "INNER JOIN `subscriptions` ON `attendance`.`subscriptions_id` = `subscriptions`.`id` "
                    + "INNER JOIN `customers` ON `customers_id` = `customers`.`id` INNER JOIN `packages` ON `packages_id` = `packages`.`id` "
                    + getWhereClause()
                    + getSortClause()
                    + ";");

            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0);
            
            while (rs.next()) {
                Vector<String> data = new Vector();

                data.add(rs.getString("marked_at"));
                data.add(rs.getString("customers_id"));
                data.add(rs.getString("full_name"));
                data.add(rs.getString("packages.title"));

                model.addRow(data);
            }
            
            if (table.getRowCount() == 0) {
                scrollPane.setViewportView(new PnlNoData());
            } else {
                scrollPane.setViewportView(table);
                btnView.setEnabled(true);
                btnPrint.setEnabled(true);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private JasperPrint generateReport() {

        try {

            String now = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date());

            String packageFilter = (cboPackage.getSelectedIndex() == 0) ? "All Data" : String.valueOf(cboPackage.getSelectedItem());
            String customerFilter = (cboCustomer.getSelectedIndex() == 0) ? "All Data" : String.valueOf(cboCustomer.getSelectedItem());

            HashMap<String, Object> params = new HashMap();

            params.put("PARAM_TITLE", "Attendance Report");
            params.put("PARAM_PROP_1", "(Sort) :" + String.valueOf(cboSort.getSelectedItem()));
            params.put("PARAM_PROP_2", "(Filter) Package Details: " + packageFilter);
            params.put("PARAM_PROP_3", "(Filter) Member Details: " + customerFilter);

            params.put("PARAM_GENERATED_BY", "Generated by " + AppLayout.employeeData.getId());
            params.put("PARAM_GENERATED_AT", now);

            params.put("PARAM_HEADER_0", "Marked At");
            params.put("PARAM_HEADER_1", "Member Id");
            params.put("PARAM_HEADER_2", "Member Name");
            params.put("PARAM_HEADER_3", "Package");
            
            JRTableModelDataSource source = new JRTableModelDataSource(table.getModel());
            
            return JasperFillManager.fillReport(AppConfig.getReportPath("members_attendance.jasper"), params, source);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
