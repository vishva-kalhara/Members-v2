/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package views.internals;

import com.formdev.flatlaf.FlatClientProperties;
import java.awt.Insets;
import javax.swing.BorderFactory;
import utils.AppConnection;
import views.dialogs.DlgEmployee;
import views.layouts.AppLayout;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import models.Employee;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.view.JasperViewer;
import utils.DBData;

/**
 *
 * @author vishv
 */
public class PnlEmployees extends javax.swing.JPanel {

    HashMap<String, Integer> statusMap = new HashMap<>();

    /**
     * Creates new form PnlEmployees
     */
    public PnlEmployees() {
        initComponents();

        setDesign();

        fetchData();

        scrollPane.setViewportView(new PnlFetching());
        scrollPane.repaint();
        scrollPane.revalidate();
        btnPrint.setEnabled(false);
        btnView.setEnabled(false);

//        loadTableData("");
    }

    private void fetchData() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                statusMap = DBData.getSubTableData("statuses", "Employees", cboStatus);
                loadTableData("");
            }
        });
        thread.start();
    }

    private void loadTableData(String contraints) {

        btnView.setEnabled(false);
        btnPrint.setEnabled(false);

        ResultSet rs = AppConnection.fetch("SELECT * FROM employees "
                + "INNER JOIN gender ON employees.gender_id = gender.id "
                //                + "INNER JOIN user_roles ON employees.user_roles_id = user_roles.id "
                + "INNER JOIN statuses ON employees.statuses_id = statuses.id "
                + contraints);

        DefaultTableModel model = (DefaultTableModel) tblEmployees.getModel();
        model.setRowCount(0);

        try {

            while (rs.next()) {
                Vector<Object> data = new Vector();
                data.add(rs.getString("id"));
                data.add(rs.getString("first_name"));
                data.add(rs.getString("last_name"));
                data.add(rs.getString("gender.value"));
                data.add(rs.getString("mobile1"));
//                data.add(rs.getString("user_roles.value"));
                data.add(rs.getString("statuses.value"));

                model.addRow(data);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (tblEmployees.getModel().getRowCount() == 0) {
            scrollPane.setViewportView(new PnlNoData());

        } else {
            scrollPane.setViewportView(tblEmployees);
            btnView.setEnabled(true);
            btnPrint.setEnabled(true);
        }
        scrollPane.repaint();
        scrollPane.revalidate();

    }

    private void setDesign() {
        txtSearch.putClientProperty("JTextField.padding", new Insets(7, 8, 7, 10));
        txtSearch.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Search by name");
        txtSearch.putClientProperty(FlatClientProperties.STYLE, "arc: 10");

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        tblEmployees.setDefaultRenderer(Object.class, centerRenderer);

        javax.swing.JScrollPane scroll = (javax.swing.JScrollPane) tblEmployees.getParent().getParent();
        scroll.setBorder(BorderFactory.createEmptyBorder());
    }

    private void filterTable() {
        if (txtSearch.getText().isBlank() && cboStatus.getSelectedIndex() == 0) {
            loadTableData("");
            return;
        }

        StringBuilder constraints = new StringBuilder(" WHERE ");

        boolean isStatusSelected = cboStatus.getSelectedIndex() != 0;
        boolean isSearchTextPresent = !txtSearch.getText().isBlank();

        if (isStatusSelected) {
            constraints.append("`statuses_id` = '")
                    .append(statusMap.get(String.valueOf(cboStatus.getSelectedItem())))
                    .append("'");
        }

        if (isSearchTextPresent) {
            if (isStatusSelected) {
                constraints.append(" AND ");
            }
            constraints.append("`first_name` LIKE '%")
                    .append(txtSearch.getText())
                    .append("%' OR `last_name` LIKE '%")
                    .append(txtSearch.getText())
                    .append("%'");
        }

        loadTableData(constraints.toString());
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
        btnNew = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        cboStatus = new javax.swing.JComboBox<>();
        btnPrint = new javax.swing.JButton();
        btnView = new javax.swing.JButton();
        btnClearFilters = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        scrollPane = new javax.swing.JScrollPane();
        tblEmployees = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(1160, 900));
        setMinimumSize(new java.awt.Dimension(1160, 900));
        setPreferredSize(new java.awt.Dimension(1160, 900));
        setRequestFocusEnabled(false);
        setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1160, 100));

        btnNew.setBackground(new java.awt.Color(77, 119, 255));
        btnNew.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        btnNew.setForeground(new java.awt.Color(255, 255, 255));
        btnNew.setText("New Employee");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });

        cboStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Loading" }));
        cboStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboStatusActionPerformed(evt);
            }
        });

        btnPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons/printer_20.png"))); // NOI18N
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });

        btnView.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons/file-text.png"))); // NOI18N
        btnView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewActionPerformed(evt);
            }
        });

        btnClearFilters.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons/filter-x.png"))); // NOI18N
        btnClearFilters.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearFiltersActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnClearFilters, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 286, Short.MAX_VALUE)
                .addComponent(btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnView, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(cboStatus)
                    .addComponent(btnNew, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPrint, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnView, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                    .addComponent(btnClearFilters, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(19, 19, 19))
        );

        add(jPanel1, java.awt.BorderLayout.NORTH);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        tblEmployees.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Id", "First Name", "Last Name", "Gender", "Mobile 1", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblEmployees.getTableHeader().setReorderingAllowed(false);
        tblEmployees.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEmployeesMouseClicked(evt);
            }
        });
        scrollPane.setViewportView(tblEmployees);
        if (tblEmployees.getColumnModel().getColumnCount() > 0) {
            tblEmployees.getColumnModel().getColumn(0).setMaxWidth(75);
        }

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

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        new DlgEmployee(AppLayout.appLayout, true).setVisible(true);
    }//GEN-LAST:event_btnNewActionPerformed

    private void tblEmployeesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEmployeesMouseClicked

        if (evt.getClickCount() != 2) {
            return;
        }

        int selectedRow = tblEmployees.getSelectedRow();

        Employee employee = new Employee();
        employee.setId(String.valueOf(tblEmployees.getValueAt(selectedRow, 0)));
        employee.setFName(String.valueOf(tblEmployees.getValueAt(selectedRow, 1)));
        employee.setLName(String.valueOf(tblEmployees.getValueAt(selectedRow, 2)));
        employee.setGenderValue(String.valueOf(tblEmployees.getValueAt(selectedRow, 3)));
        employee.setMobile1(String.valueOf(tblEmployees.getValueAt(selectedRow, 4)));
        employee.setStatusValue(String.valueOf(tblEmployees.getValueAt(selectedRow, 5)));

        new DlgEmployee(AppLayout.appLayout, true, employee).setVisible(true);
    }//GEN-LAST:event_tblEmployeesMouseClicked

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed

        filterTable();
    }//GEN-LAST:event_txtSearchActionPerformed

    private void cboStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboStatusActionPerformed
        filterTable();
    }//GEN-LAST:event_cboStatusActionPerformed

    private void btnClearFiltersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearFiltersActionPerformed

        txtSearch.setText("");
        cboStatus.setSelectedIndex(0);
        filterTable();
    }//GEN-LAST:event_btnClearFiltersActionPerformed

    private void btnViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewActionPerformed
        
        try {
            
            JasperPrintManager.printReport(makePrint(), false);
            JasperViewer.viewReport(makePrint(), false);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnViewActionPerformed

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        
        try {
            
            JasperPrintManager.printReport(makePrint(), true);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnPrintActionPerformed

    private JasperPrint makePrint() throws Exception {
        
        String prop2 = "Search: ";
        if (txtSearch.getText().isBlank()) {
            prop2 += "null";
        } else {
            prop2 += "'" + txtSearch.getText() + "'";
        }

        String dateTime = new SimpleDateFormat("dd-MM-yyyy HH:mm").format(new Date());

        HashMap<String, Object> params = new HashMap();

        params.put("PARAM_TITLE", "Employees");
        params.put("PARAM_PROP_1", "Filters: '" + String.valueOf(cboStatus.getSelectedItem()) + "'");
        params.put("PARAM_PROP_2", prop2);
        params.put("PARAM_PROP_3", "Count: " + tblEmployees.getModel().getRowCount());
        params.put("PARAM_GENERATED_BY", "Generated by " + AppLayout.employeeData.get("id"));
        params.put("PARAM_GENERATED_AT", dateTime);

        params.put("PARAM_HEADER_0", "Id");
        params.put("PARAM_HEADER_1", "First Name");
        params.put("PARAM_HEADER_2", "Last Name");
        params.put("PARAM_HEADER_3", "Gender");
        params.put("PARAM_HEADER_4", "Mobile-1");
        params.put("PARAM_HEADER_5", "Status");

        JRTableModelDataSource dataSource = new JRTableModelDataSource(tblEmployees.getModel());

        JasperPrint report = JasperFillManager.fillReport("src/reports/members_general_report.jasper", params, dataSource);
        

        return report;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClearFilters;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnPrint;
    private javax.swing.JButton btnView;
    private javax.swing.JComboBox<String> cboStatus;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JTable tblEmployees;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
