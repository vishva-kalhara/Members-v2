/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package views.internals;

import config.AppConfig;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;
import views.dialogs.DlgSubscription;
import views.dialogs.DlgSubscriptionFilters;
import views.layouts.AppLayout;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.view.JasperViewer;
import utils.AppConnection;
import utils.Formatter;
import views.forms.FrmSplashScreen;

/**
 *
 * @author vishv
 */
public class PnlSubscriptions extends javax.swing.JPanel {

    private String whereQuery = "";
    DlgSubscriptionFilters dialog;

    private HashMap<String, String> reportData = new HashMap();

    /**
     * Creates new form PnlSubscriptions
     */
    public PnlSubscriptions() {
        initComponents();

        setDesign();

        scrollPane.setViewportView(new PnlFetching());

        cboSort.setSelectedItem("Issued At DESC");
//        fetchData();

        reportData.put("packageData", "(Filter) Package Details: Not Applied");
        reportData.put("customerData", "(Filter) Member Details: Not Applied");
        reportData.put("priceDate", "(Filter) Paid amount: Not Applied");
        reportData.put("dateDate", "(Filter) Issued Date: Not Applied");
    }

    private void setDesign() {

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        tblSubcriptions.setDefaultRenderer(Object.class, centerRenderer);

        javax.swing.JScrollPane scroll = (javax.swing.JScrollPane) tblSubcriptions.getParent().getParent();
        scroll.setBorder(BorderFactory.createEmptyBorder());
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
        cboSort = new javax.swing.JComboBox<>();
        btnPrint = new javax.swing.JButton();
        btnView = new javax.swing.JButton();
        btnClearFilters = new javax.swing.JButton();
        btnFilter = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        scrollPane = new javax.swing.JScrollPane();
        tblSubcriptions = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(1160, 900));
        setMinimumSize(new java.awt.Dimension(1160, 900));
        setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1160, 100));

        btnNew.setBackground(new java.awt.Color(77, 119, 255));
        btnNew.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        btnNew.setForeground(new java.awt.Color(255, 255, 255));
        btnNew.setText("New Subscription");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        cboSort.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Issued At ASC", "Issued At DESC", "Package Name ASC", "Package Name DESC", "Paid Amount ASC", "Paid Amount DESC" }));
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

        btnFilter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons/filter.png"))); // NOI18N
        btnFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFilterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(cboSort, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnClearFilters, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 422, Short.MAX_VALUE)
                .addComponent(btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnView, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(cboSort)
                    .addComponent(btnNew, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnPrint, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnView, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                    .addComponent(btnClearFilters, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnFilter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(19, 19, 19))
        );

        add(jPanel1, java.awt.BorderLayout.NORTH);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        tblSubcriptions.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Issued At", "Package", "Customer Id", "Starts At", "Ends At", "Paid "
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSubcriptions.getTableHeader().setReorderingAllowed(false);
        scrollPane.setViewportView(tblSubcriptions);

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
        fetchData();
    }//GEN-LAST:event_cboSortActionPerformed

    private void btnClearFiltersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearFiltersActionPerformed

        cboSort.setSelectedIndex(1);
        whereQuery = "";
        dialog = null;
//        loadSubscriptionData();
    }//GEN-LAST:event_btnClearFiltersActionPerformed

    private void btnFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFilterActionPerformed

        try {

            if (dialog == null) {
                this.dialog = new DlgSubscriptionFilters(AppLayout.appLayout, true, reportData);
            }

            this.dialog.setVisible(true);
            this.whereQuery = this.dialog.getQuery();
//            System.out.println(this.whereQuery);

            loadSubscriptionData();
            this.dialog.newQuery();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
            FrmSplashScreen.logger.log(Level.WARNING, e.getMessage() ,e);
        }
    }//GEN-LAST:event_btnFilterActionPerformed

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed

        new DlgSubscription(AppLayout.appLayout, true).setVisible(true);
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewActionPerformed

        try {

            JasperViewer.viewReport(makePrint(), false);

        } catch (Exception e) {
            FrmSplashScreen.logger.log(Level.WARNING, e.getMessage() ,e);
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btnViewActionPerformed

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed

        try {

            JasperPrintManager.printReport(makePrint(), true);

        } catch (Exception e) {
            FrmSplashScreen.logger.log(Level.WARNING, e.getMessage() ,e);
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btnPrintActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClearFilters;
    private javax.swing.JButton btnFilter;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnPrint;
    private javax.swing.JButton btnView;
    private javax.swing.JComboBox<String> cboSort;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JTable tblSubcriptions;
    // End of variables declaration//GEN-END:variables

    private String generateSortQuery() {

        String sortVal = String.valueOf(cboSort.getSelectedItem());

        String sortQuery = "";

        switch (sortVal) {
            case "Issued At ASC":
                sortQuery = "ORDER BY `created_at` ASC";
                break;
            case "Issued At DESC":
                sortQuery = "ORDER BY `created_at` DESC";
                break;
            case "Package Name ASC":
                sortQuery = "ORDER BY `title` ASC";
                break;
            case "Package Name DESC":
                sortQuery = "ORDER BY `title` DESC";
                break;
            case "Paid Amount ASC":
                sortQuery = "ORDER BY `paid_amount` ASC";

                break;
            case "Paid Amount DESC":
                sortQuery = "ORDER BY `paid_amount` DESC";
                break;
            default:
                sortQuery = "ORDER BY `created_at` ASC";
        }

        return sortQuery;
    }

    private void fetchData() {
        new Thread(new Runnable() {
            @Override
            public void run() {

                loadSubscriptionData();

            }
        }).start();
    }

    private void loadSubscriptionData() {

        btnView.setEnabled(false);
        btnPrint.setEnabled(false);

        try {

            DefaultTableModel model = (DefaultTableModel) tblSubcriptions.getModel();
            model.setRowCount(0);

            String sortQuery = generateSortQuery();

            ResultSet rs = AppConnection.fetch("SELECT DATE_FORMAT(`created_at`, '%Y-%m-%d %H:%i') AS formatted_date , `customers_id`, `title`, `start`, `end`, `paid_amount` "
                    + "FROM members_v2.subscriptions "
                    + "INNER JOIN packages ON subscriptions.packages_id = packages.id " + this.whereQuery + " " + sortQuery + ";");

            Formatter formatter = new Formatter();

            while (rs.next()) {
                Vector data = new Vector();
                data.add(rs.getString("formatted_date"));
                data.add(rs.getString("title"));
                data.add(rs.getString("customers_id"));
                data.add(rs.getString("start"));
                data.add(rs.getString("end"));
                data.add(formatter.addZeroToDouble(rs.getDouble("paid_amount")));

                model.addRow(data);
            }

            if (model.getRowCount() == 0) {
                scrollPane.setViewportView(new PnlNoData());
            } else {
                btnView.setEnabled(true);
                btnPrint.setEnabled(true);
                scrollPane.setViewportView(tblSubcriptions);
            }

        } catch (Exception e) {
            FrmSplashScreen.logger.log(Level.WARNING, e.getMessage() ,e);
        }
    }

    private JasperPrint makePrint() throws Exception {

        String dateTime = new SimpleDateFormat("dd-MM-yyyy HH:mm").format(new Date());

        HashMap<String, Object> params = new HashMap();

        params.put("PARAM_TITLE", "Subscriptions");
        params.put("PARAM_PROP_1", "(Sort): " + String.valueOf(cboSort.getSelectedItem()));
        params.put("PARAM_PROP_2", reportData.get("packageData"));
        params.put("PARAM_PROP_3", reportData.get("customerData"));
        params.put("PARAM_PRICE", reportData.get("priceDate"));
        params.put("PARAM_ISSUED_DATE", reportData.get("dateDate"));
        params.put("PARAM_GENERATED_BY", "Generated by " + AppLayout.employeeData.getId());
        params.put("PARAM_GENERATED_AT", dateTime);

        params.put("PARAM_HEADER_0", "Issued At");
        params.put("PARAM_HEADER_1", "Package");
        params.put("PARAM_HEADER_2", "Customer Id");
        params.put("PARAM_HEADER_3", "Starts At");
        params.put("PARAM_HEADER_4", "Ends At");
        params.put("PARAM_HEADER_5", "Amount");

        JRTableModelDataSource dataSource = new JRTableModelDataSource(tblSubcriptions.getModel());

        JasperPrint report = JasperFillManager.fillReport(AppConfig.getReportPath("members_advanced_subscriptions.jasper"), params, dataSource);

        return report;
    }
}
