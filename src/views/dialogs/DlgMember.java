/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package views.dialogs;

import com.formdev.flatlaf.FlatClientProperties;
import com.wishva.*;
import controllers.MemberController;
import enums.DialogActions;
import enums.DialogTypes;
import java.awt.Color;
import java.util.HashMap;
import models.Member;
import raven.toast.Notifications;
import utils.DBData;
import views.layouts.AppLayout;
import enums.LayoutPages;
import java.sql.ResultSet;
import java.sql.SQLException;
import utils.AppConnection;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author vishv
 */
public class DlgMember extends javax.swing.JDialog {

    HashMap<String, Integer> genderMap;
    HashMap<String, Integer> statusMap;

    private String memberId;

    private DialogTypes type;

    /**
     * Creates new form DlgMember
     *
     * @param parent
     * @param modal
     */
    public DlgMember(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        btnAllowEdit.setEnabled(false);
        btnCard.setEnabled(false);
        this.type = DialogTypes.CREATE;

        genderMap = DBData.getSubTableData("gender", cboGender);
        statusMap = DBData.getSubTableData("statuses", cboStatus);

        setDesign();

    }

    /**
     * Creates new form DlgMember
     *
     * @param parent
     * @param modal
     * @param member
     */
    public DlgMember(java.awt.Frame parent, boolean modal, Member member) {
        super(parent, modal);
        initComponents();

        this.type = DialogTypes.UPDATE;

        statusMap = DBData.getSubTableData("statuses", cboStatus);
        genderMap = DBData.getSubTableData("gender", cboGender);

        setDesign();

        this.memberId = member.getId();

        lblHeading.setText("Member Details");
        btnSubmit.setText("Save Changes");

        cboGender.setSelectedItem(member.getGenderValue());
        txtFName.setText(member.getFirstName());
        txtLName.setText(member.getLastName());
        txtMobile1.setText(member.getMobile1());
        cboStatus.setSelectedItem(member.getStatusValue());

        loadData();

        cboGender.setEnabled(false);
        txtFName.setEnabled(false);
        txtLName.setEnabled(false);
        txtMobile1.setEnabled(false);
        txtMobile2.setEnabled(false);
        txtNIC.setEnabled(false);
        txtEmail.setEnabled(false);
        cboStatus.setEnabled(false);

        btnSubmit.setEnabled(false);
        btnReset.setEnabled(false);
        btnCard.setEnabled(true);

        btnAllowEdit.grabFocus();

    }

    private void loadData() {
        try {
            ResultSet rs = AppConnection.fetch("SELECT `nic`, `mobile2`, `email` FROM `customers` WHERE `id` = '" + this.memberId + "'");
            rs.next();

            if (rs.getString("nic") != null && !rs.getString("nic").equals("")) {
                txtNIC.setText(rs.getString("nic"));
            }
            if (rs.getString("mobile2") != null && !rs.getString("mobile2").equals("")) {
                txtMobile2.setText(rs.getString("mobile2"));
            }
            if (rs.getString("email") != null && !rs.getString("email").equals("")) {
                txtEmail.setText(rs.getString("email"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setDesign() {

        cboGender.grabFocus();

        getRootPane().putClientProperty(FlatClientProperties.TITLE_BAR_BACKGROUND, new Color(255, 255, 255));
        getRootPane().putClientProperty(FlatClientProperties.TITLE_BAR_FOREGROUND, new Color(0, 0, 0));
        getRootPane().putClientProperty(FlatClientProperties.TITLE_BAR_SHOW_CLOSE, false);
        getRootPane().putClientProperty(FlatClientProperties.TITLE_BAR_SHOW_MAXIMIZE, false);
        getRootPane().putClientProperty(FlatClientProperties.TITLE_BAR_SHOW_ICONIFFY, false);

        btnClose.putClientProperty("JButton.buttonType", "borderless");
        btnSubmit.putClientProperty("JButton.buttonType", "borderless");

        txtFName.putClientProperty(FlatClientProperties.STYLE, "arc: 10");
        txtLName.putClientProperty(FlatClientProperties.STYLE, "arc: 10");
        txtNIC.putClientProperty(FlatClientProperties.STYLE, "arc: 10");
        txtMobile1.putClientProperty(FlatClientProperties.STYLE, "arc: 10");
        txtMobile2.putClientProperty(FlatClientProperties.STYLE, "arc: 10");
        txtEmail.putClientProperty(FlatClientProperties.STYLE, "arc: 10");
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
        btnClose = new javax.swing.JButton();
        lblHeading = new javax.swing.JLabel();
        pnlData = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtFName = new javax.swing.JTextField();
        cboGender = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtLName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtMobile1 = new javax.swing.JTextField();
        txtMobile2 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cboStatus = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        txtNIC = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        btnSubmit = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        btnAllowEdit = new javax.swing.JButton();
        btnCard = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(706, 556));
        setMinimumSize(new java.awt.Dimension(706, 556));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(706, 732));
        jPanel1.setMinimumSize(new java.awt.Dimension(706, 732));
        jPanel1.setPreferredSize(new java.awt.Dimension(706, 732));
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
        lblHeading.setText("New Member");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(lblHeading, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 311, Short.MAX_VALUE)
                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnClose, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                    .addComponent(lblHeading, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, java.awt.BorderLayout.NORTH);

        pnlData.setBackground(new java.awt.Color(204, 204, 255));
        pnlData.setPreferredSize(new java.awt.Dimension(0, 0));
        pnlData.setLayout(new java.awt.BorderLayout());

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setMaximumSize(new java.awt.Dimension(0, 0));

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Gender:");

        cboGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Male" }));

        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("First Name:");

        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Last Name:");

        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Mobile 1:");

        txtMobile1.setToolTipText("");

        jLabel6.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Mobile 2 (Optional):");

        jLabel7.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("Email (Optional):");

        txtEmail.setToolTipText("");

        jLabel8.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText("Status:");

        cboStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));

        jLabel12.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(102, 102, 102));
        jLabel12.setText("NIC (Optional):");

        txtNIC.setToolTipText("");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(cboGender, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFName, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtLName, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(txtNIC, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(23, 23, 23)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(txtMobile1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel7)
                            .addComponent(txtEmail))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMobile2)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel8))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(cboStatus, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMobile2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtFName, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtLName, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cboGender, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtMobile1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNIC, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(24, 24, 24)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                    .addComponent(cboStatus))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pnlData.add(jPanel5, java.awt.BorderLayout.CENTER);

        jPanel1.add(pnlData, java.awt.BorderLayout.CENTER);

        jPanel4.setBackground(new java.awt.Color(248, 248, 248));
        jPanel4.setPreferredSize(new java.awt.Dimension(695, 130));

        btnSubmit.setBackground(new java.awt.Color(77, 119, 255));
        btnSubmit.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        btnSubmit.setForeground(new java.awt.Color(255, 255, 255));
        btnSubmit.setText("Add Member");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        btnReset.setBackground(new java.awt.Color(250, 250, 250));
        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons/remove-formatting.png"))); // NOI18N
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnAllowEdit.setBackground(new java.awt.Color(250, 250, 250));
        btnAllowEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons/pen-line.png"))); // NOI18N
        btnAllowEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAllowEditActionPerformed(evt);
            }
        });

        btnCard.setBackground(new java.awt.Color(250, 250, 250));
        btnCard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons/id-card.png"))); // NOI18N
        btnCard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCardActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAllowEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCard, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 268, Short.MAX_VALUE)
                .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnReset, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                    .addComponent(btnAllowEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSubmit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(32, 32, 32))
        );

        jPanel1.add(jPanel4, java.awt.BorderLayout.PAGE_END);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 535, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed

        try {

            Member member = createMemberFromForm();

            if (type == DialogTypes.CREATE) {

                new MemberController().createMember(member);
                Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.BOTTOM_CENTER, "Member created success!");
            } else {

                member.setId(this.memberId);
                member.setStatusId(statusMap.get(String.valueOf(cboStatus.getSelectedItem())));
                new MemberController().updateMember(member);
                Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.BOTTOM_CENTER, "Member details updated success!");
            }

            this.dispose();
            AppLayout.appLayout.changeForm(LayoutPages.MEMBERS);

        } catch (SparkException e) {

            new DlgError(AppLayout.appLayout, true, "Validation Error", e.getMessage()).setVisible(true);
        } catch (SQLException e) {
            if (e.getSQLState().equals("45000")) {
                new DlgError(AppLayout.appLayout, true, "Validation Error", e.getMessage()).setVisible(true);
            } else {
                new DlgError(AppLayout.appLayout, true, e.getMessage()).setVisible(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
            new DlgError(AppLayout.appLayout, true, e.getMessage()).setVisible(true);
        }
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed

        DlgConfirm dlg = new DlgConfirm(AppLayout.appLayout, true, "Once you confirm, the fields will be cleared!");
        dlg.setVisible(true);

        if (dlg.getAction() != DialogActions.CONFIRM) {
            return;
        }

        if (cboGender.isEnabled()) {
            cboGender.setSelectedIndex(0);
        }

        txtFName.setText("");
        txtLName.setText("");

        if (txtNIC.isEnabled()) {
            txtNIC.setText("");
        }

        txtMobile1.setText("");
        txtMobile2.setText("");
        txtEmail.setText("");
        cboStatus.setSelectedIndex(0);
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnAllowEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAllowEditActionPerformed

        DlgConfirm dlg = new DlgConfirm(AppLayout.appLayout, true, "Once you confirm, the fields will be enabled!");
        dlg.setVisible(true);

        if (dlg.getAction() != DialogActions.CONFIRM) {
            return;
        }

        btnSubmit.setEnabled(true);
        btnReset.setEnabled(true);
        txtFName.setEnabled(true);
        txtLName.setEnabled(true);
        txtMobile1.setEnabled(true);
        txtMobile2.setEnabled(true);
        txtEmail.setEnabled(true);
        cboStatus.setEnabled(true);

        if (txtNIC.getText().isBlank()) {
            txtNIC.setEnabled(true);
        }

        btnAllowEdit.setEnabled(false);

        txtFName.grabFocus();
    }//GEN-LAST:event_btnAllowEditActionPerformed

    private void btnCardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCardActionPerformed

        HashMap<String, Object> params = new HashMap();
//        params.put("PARAM_NAME", txtFName.getName() + " " + txtLName.getName());
        params.put("PARAM_NAME", "Wishva Kalhara");
        params.put("PARAM_CODE", "cus-001");
//        params.put("PARAM_BAR_CODE", "cus-001");

        this.dispose();
        try {

            JREmptyDataSource source = new JREmptyDataSource();

            JasperPrint report = JasperFillManager.fillReport("src/reports/members_card_front_2.jasper", params, source);
            JasperViewer.viewReport(report, false);
        } catch (JRException e) {
            e.printStackTrace();
        }

//        HashMap<String, Object> params = new HashMap<>();
//        params.put("PARAM_NAME", "Wishva Kalhara Chandrasekara");
//        params.put("code", "456789");
//
//        JREmptyDataSource dataSource = new JREmptyDataSource();
//
//        try {
//            JasperPrint report = JasperFillManager.fillReport("src/reports/proect_13-3.jasper", params, dataSource);
//            JasperViewer.viewReport(report, false);
////            JasperPrintManager.printReport(report, false);
//        } catch (JRException e) {
//            e.printStackTrace();
//        }
    }//GEN-LAST:event_btnCardActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAllowEdit;
    private javax.swing.JButton btnCard;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JComboBox<String> cboGender;
    private javax.swing.JComboBox<String> cboStatus;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel lblHeading;
    private javax.swing.JPanel pnlData;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFName;
    private javax.swing.JTextField txtLName;
    private javax.swing.JTextField txtMobile1;
    private javax.swing.JTextField txtMobile2;
    private javax.swing.JTextField txtNIC;
    // End of variables declaration//GEN-END:variables

    private Member createMemberFromForm() throws SparkException {
        Member member = new Member();

        if (cboGender.getSelectedIndex() == 0) {
            throw new SparkException("Select a gender.");
        }
        member.setGenderId(genderMap.get(String.valueOf(cboGender.getSelectedItem())));

        member.setFirstName(new Spark("First Name", txtFName.getText())
                .required()
                .endString());

        member.setLastName(new Spark("Last Name", txtLName.getText())
                .required()
                .endString());

        if (!txtNIC.getText().isBlank()) {
            member.setNic(new Spark("NIC", txtNIC.getText())
                    .minLength(10)
                    .endString());
        }

        member.setMobile1(new Spark("Mobile-1", txtMobile1.getText())
                .required()
                .minLength(10)
                .maxLength(10)
                .regex("^07[01235678]{1}[0-9]{7}$")
                .endString());

        if (!txtMobile2.getText().isBlank()) {
            member.setMobile2(new Spark("Mobile-2", txtMobile2.getText())
                    .required()
                    .minLength(10)
                    .maxLength(10)
                    .regex("^07[01235678]{1}[0-9]{7}$")
                    .endString());

        }

        if (!txtEmail.getText().isBlank()) {
            member.setEmail(new Spark("Email", txtEmail.getText())
                    .email()
                    .endString());
        }

        if (cboStatus.getSelectedIndex() == 0) {
            throw new SparkException("Select a status.");
        }
        member.setStatusId(statusMap.get(String.valueOf(cboStatus.getSelectedItem())));

        return member;
    }

}
