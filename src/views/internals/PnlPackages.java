/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package views.internals;

import com.formdev.flatlaf.FlatClientProperties;
import java.awt.Insets;
import java.util.HashMap;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;
import utils.AppConnection;
import utils.DBData;
import views.dialogs.DlgPackage;
import views.layouts.AppLayout;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import models.PaymentPlan;

/**
 *
 * @author vishv
 */
public class PnlPackages extends javax.swing.JPanel {

    HashMap<String, Integer> statusMap = new HashMap();

    /**
     * Creates new form PnlPackages
     */
    public PnlPackages() {
        initComponents();

        setDesign();

        scrollPane.setViewportView(new PnlFetching());
        scrollPane.repaint();
        scrollPane.revalidate();
        lazyLoad();

        this.statusMap = DBData.getSubTableData("statuses", "Packages", cboStatus);
    }

    private void setDesign() {
        txtSearch.putClientProperty("JTextField.padding", new Insets(7, 8, 7, 10));
        txtSearch.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Search by title");
        txtSearch.putClientProperty(FlatClientProperties.STYLE, "arc: 10");

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        tblPacakges.setDefaultRenderer(Object.class, centerRenderer);

        javax.swing.JScrollPane scroll = (javax.swing.JScrollPane) tblPacakges.getParent().getParent();
        scroll.setBorder(BorderFactory.createEmptyBorder());
    }

    private void lazyLoad() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                fetchTableData("");
            }
        }).start();
    }

    private void fetchTableData(String constraints) {

        btnClearFilters.setEnabled(false);
        btnPrint.setEnabled(false);
        btnView.setEnabled(false);

        try {
            
            DefaultTableModel model = (DefaultTableModel) tblPacakges.getModel();
            model.setRowCount(0);

            ResultSet rs = AppConnection.fetch("SELECT * FROM packages "
                    + "INNER JOIN `statuses` ON `packages`.`statuses_id` = `statuses`.`id` " + constraints);

            while (rs.next()) {
                Vector<String> data = new Vector();
                data.add(rs.getString("id"));
                data.add(rs.getString("title"));
                data.add(rs.getString("validity"));
                data.add(rs.getString("price"));
                data.add(rs.getString("statuses.value"));

                ResultSet rsTotal = AppConnection.fetch("SELECT COUNT(*) as total FROM subscriptions WHERE `packages_id` = '" + rs.getString("id") + "'");
                rsTotal.next();

                data.add(rsTotal.getString("total"));

                model.addRow(data);
            }

            tblPacakges.setModel(model);

            if (model.getRowCount() != 0) {
                scrollPane.setViewportView(tblPacakges);
                btnPrint.setEnabled(true);
                btnView.setEnabled(true);
            } else {
                scrollPane.setViewportView(new PnlNoData());
            }
            scrollPane.repaint();
            scrollPane.revalidate();
            btnClearFilters.setEnabled(true);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void filterTable() {

        boolean isStatusSelected = cboStatus.getSelectedIndex() != 0;
        boolean isSearchPresent = !txtSearch.getText().isBlank();

        if (!isSearchPresent && !isStatusSelected) {

            fetchTableData("");
            return;
        }

        StringBuilder constraints = new StringBuilder(" WHERE ");

        if (isStatusSelected) {
            constraints.append("statuses_id = '")
                    .append(statusMap.get(String.valueOf(cboStatus.getSelectedItem())))
                    .append("'");
        }

        if (isSearchPresent) {
            if (isStatusSelected) {
                constraints.append(" AND ");
            }

            constraints.append(" `title` LIKE '%")
                    .append(txtSearch.getText())
                    .append("%'");
        }
        
        fetchTableData(String.valueOf(constraints));
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
        tblPacakges = new javax.swing.JTable();

        setMaximumSize(new java.awt.Dimension(1160, 900));
        setMinimumSize(new java.awt.Dimension(1160, 900));
        setPreferredSize(new java.awt.Dimension(1160, 900));
        setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1160, 100));

        btnNew.setBackground(new java.awt.Color(77, 119, 255));
        btnNew.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        btnNew.setForeground(new java.awt.Color(255, 255, 255));
        btnNew.setText("New Package");
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

        btnView.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons/file-text.png"))); // NOI18N

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

        tblPacakges.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Title", "Validity", "Price", "Status", "Total Purchased"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPacakges.getTableHeader().setReorderingAllowed(false);
        tblPacakges.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPacakgesMouseClicked(evt);
            }
        });
        scrollPane.setViewportView(tblPacakges);
        if (tblPacakges.getColumnModel().getColumnCount() > 0) {
            tblPacakges.getColumnModel().getColumn(0).setMaxWidth(75);
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
        new DlgPackage(AppLayout.appLayout, true).setVisible(true);
    }//GEN-LAST:event_btnNewActionPerformed

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

    private void tblPacakgesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPacakgesMouseClicked

        if (evt.getClickCount() != 2) {
            return;
        }
        
        int row = tblPacakges.getSelectedRow();

        PaymentPlan plan = new PaymentPlan();
        plan.setId(String.valueOf(tblPacakges.getValueAt(row, 0)));
        plan.setTitle(String.valueOf(tblPacakges.getValueAt(row, 1)));
        plan.setValidity(Integer.parseInt(String.valueOf(tblPacakges.getValueAt(row, 2))));
        plan.setPrice(Double.parseDouble(String.valueOf(tblPacakges.getValueAt(row, 3))));
        plan.setStatusValue(String.valueOf(tblPacakges.getValueAt(row, 4)));
        
        new DlgPackage(AppLayout.appLayout, true, plan).setVisible(true);
    }//GEN-LAST:event_tblPacakgesMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClearFilters;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnPrint;
    private javax.swing.JButton btnView;
    private javax.swing.JComboBox<String> cboStatus;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JTable tblPacakges;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
