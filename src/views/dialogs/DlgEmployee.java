/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package views.dialogs;

import com.formdev.flatlaf.FlatClientProperties;
import com.wishva.Spark;
import com.wishva.SparkException;
import controllers.EmployeeController;
import enums.DialogTypes;
import enums.LayoutPages;
import java.awt.Color;
import java.util.HashMap;
import javax.swing.JTextField;
import models.Employee;
import utils.AppConnection;
import utils.DBData;
import views.layouts.AppLayout;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author vishv
 */
public class DlgEmployee extends javax.swing.JDialog {

    HashMap<String, Integer> gendersMap = new HashMap<>();
    HashMap<String, Integer> userRolesMap = new HashMap<>();
    HashMap<String, Integer> statusesMap = new HashMap<>();

    private DialogTypes type;

    /**
     * Creates new form DlgEmployee
     *
     * @param parent
     * @param modal
     */
    public DlgEmployee(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        setDesign();

        this.type = DialogTypes.CREATE;

        this.gendersMap = DBData.getSubTableData("gender", cboGender);
        this.userRolesMap = DBData.getSubTableData("user_roles", cboRole);
        this.statusesMap = DBData.getSubTableData("statuses", cboStatus);

        txtUsername.setEnabled(false);
        txtPassword.setEnabled(false);
        cboRole.setEnabled(false);
    }

    /**
     * Creates new form DlgEmployee
     *
     * @param parent
     * @param modal
     */
    public DlgEmployee(java.awt.Frame parent, boolean modal, Employee employee) {
        super(parent, modal);
        initComponents();

        setDesign();

        this.type = DialogTypes.UPDATE;

        lazyLoadFields(employee.getId());

        cboGender.setSelectedItem(employee.getGenderValue());
        cboGender.setEnabled(false);
        txtFName.setText(employee.getFName());
        txtFName.setEnabled(false);
        txtLName.setText(employee.getLName());
        txtLName.setEnabled(false);
        txtMobile1.setText(employee.getMobile1());
        txtMobile1.setEnabled(false);

        this.statusesMap = DBData.getSubTableData("statuses", cboStatus);
        cboStatus.setSelectedItem(employee.getStatusValue());
        cboStatus.setEnabled(false);
        this.userRolesMap = DBData.getSubTableData("user_roles", cboRole);

        lblHeading.setText("Employee Details");
        btnSubmit.setText("Save Changes");
    }

    private void lazyLoadFields(String empId) {
        new Thread(new Runnable() {

            @Override
            public void run() {

                System.out.println("SELECT "
                        + "`nic`, `mobile2`, `address1`, `username`, `password`, `user_roles_id` "
                        + "FROM `employees` WHERE id = '" + empId + "'");
                ResultSet rs = AppConnection.execute("SELECT "
                        + "`nic`, `mobile2`, `address1`, `username`, `password`, `user_roles_id` "
                        + "FROM `employees` WHERE id = '" + empId + "'");

                try {

                    rs.next();
                    txtNIC.setEnabled(false);
                    txtNIC.setText(rs.getString("nic"));
                    txtMobile2.setText(rs.getString("mobile2"));
                    txtAddress.setText(rs.getString("address1"));

                    txtMobile2.setEnabled(false);
                    txtAddress.setEnabled(false);

                    if (!rs.getString("user_roles_id").equals("null")) {
                        ResultSet rsRole = AppConnection.execute("SELECT value FROM user_roles WHERE id = " + rs.getInt("user_roles_id"));
                        rsRole.next();

                        checkCredentials.setSelected(true);
                        txtUsername.setText(rs.getString("username"));
                        txtPassword.setText(rs.getString("password"));

                        cboRole.setSelectedItem(rsRole.getString("value"));
                    }

                    checkCredentials.setEnabled(false);
                    txtUsername.setEnabled(false);
                    txtPassword.setEnabled(false);
                    cboRole.setEnabled(false);

                } catch (SQLException e) {
                    e.printStackTrace();
                    dispose();
                }
            }
        }).start();
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
        txtAddress.putClientProperty(FlatClientProperties.STYLE, "arc: 10");
        txtUsername.putClientProperty(FlatClientProperties.STYLE, "arc: 10");
        txtPassword.putClientProperty(FlatClientProperties.STYLE, "arc: 10");
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
        txtAddress = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cboStatus = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        txtNIC = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        txtUsername = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        checkCredentials = new javax.swing.JCheckBox();
        jLabel9 = new javax.swing.JLabel();
        cboRole = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        btnSubmit = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        btnAllowEdit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(706, 732));
        setMinimumSize(new java.awt.Dimension(706, 732));
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
        lblHeading.setText("New Employee");

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
        jPanel5.setPreferredSize(new java.awt.Dimension(0, 0));

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
        jLabel5.setText("Mobile:");

        txtMobile1.setToolTipText("");

        jLabel6.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Mobile 2 (Optional):");

        jLabel7.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("Address:");

        txtAddress.setToolTipText("");

        jLabel8.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText("Status:");

        cboStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));

        jLabel12.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(102, 102, 102));
        jLabel12.setText("NIC:");

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
                            .addComponent(txtAddress))
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
                    .addComponent(txtAddress, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                    .addComponent(cboStatus))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        pnlData.add(jPanel5, java.awt.BorderLayout.CENTER);

        jPanel6.setBackground(new java.awt.Color(250, 250, 250));
        jPanel6.setPreferredSize(new java.awt.Dimension(695, 190));

        txtUsername.setToolTipText("");

        jLabel10.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 102, 102));
        jLabel10.setText("Username:");

        jLabel11.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 102, 102));
        jLabel11.setText("Password:");

        checkCredentials.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        checkCredentials.setText("System Login Credentials");
        checkCredentials.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                checkCredentialsStateChanged(evt);
            }
        });
        checkCredentials.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkCredentialsActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setText("Access Role:");

        cboRole.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Manager" }));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(cboRole, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(checkCredentials))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboRole, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(checkCredentials, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtUsername, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                            .addComponent(txtPassword))))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        pnlData.add(jPanel6, java.awt.BorderLayout.PAGE_END);

        jPanel1.add(pnlData, java.awt.BorderLayout.CENTER);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setPreferredSize(new java.awt.Dimension(695, 130));

        btnSubmit.setBackground(new java.awt.Color(77, 119, 255));
        btnSubmit.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        btnSubmit.setForeground(new java.awt.Color(255, 255, 255));
        btnSubmit.setText("Add Employee");
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

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAllowEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 328, Short.MAX_VALUE)
                .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnReset, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                    .addComponent(btnSubmit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAllowEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(35, 35, 35))
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
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void checkCredentialsStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_checkCredentialsStateChanged


    }//GEN-LAST:event_checkCredentialsStateChanged

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed

        cboGender.setSelectedIndex(0);
        txtFName.setText("");
        txtLName.setText("");
        txtNIC.setText("");
        txtMobile1.setText("");
        txtMobile2.setText("");
        txtAddress.setText("");
        cboStatus.setSelectedIndex(0);
        txtUsername.setText("");
        txtPassword.setText("");
        cboRole.setSelectedIndex(0);
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed

        Employee employee = new Employee();

        try {

            if (cboGender.getSelectedIndex() == 0) {
                throw new SparkException("Select a gender!");
            }

            employee.setFName(new Spark("First Name", txtFName.getText())
                    .required()
                    .endString());
            employee.setLName(new Spark("Last Name", txtLName.getText())
                    .required()
                    .endString());
            employee.setNIC(new Spark("NIC", txtNIC.getText())
                    .required()
                    .minLength(10)
                    .endString());
            employee.setMobile1(new Spark("Mobile-1", txtMobile1.getText())
                    .required()
                    .minLength(10, "Required 10 characters for mobile-1")
                    .maxLength(10)
                    .regex("^07[01235678]{1}[0-9]{7}$")
                    .endString());
            employee.setMobile2(new Spark("Mobile-2", txtMobile2.getText())
                    .minLength(10, "Required 10 characters for mobile-2")
                    .maxLength(10)
                    .regex("^07[01235678]{1}[0-9]{7}$")
                    .endString());
            employee.setAddress1(new Spark("Address", txtAddress.getText())
                    .required()
                    .maxLength(100)
                    .endString());

            if (cboStatus.getSelectedIndex() == 0) {
                throw new SparkException("Select a status!");
            }

            employee.setGenderId(gendersMap.get(String.valueOf(cboGender.getSelectedItem())));
            employee.setStatusId(statusesMap.get(String.valueOf(cboStatus.getSelectedItem())));

            if (checkCredentials.isSelected()) {
                employee.setUsername(new Spark("Username", txtUsername.getText())
                        .required()
                        .minLength(5)
                        .maxLength(25)
                        .endString());
                employee.setPassword(new Spark("Password", txtPassword.getPassword())
                        .required()
                        .minLength(8)
                        .maxLength(15)
                        .endString());

                if (cboRole.getSelectedIndex() == 0) {
                    throw new SparkException("Select the Access Role!");
                }

                employee.setRoleId(userRolesMap.get(String.valueOf(cboRole.getSelectedItem())));
            }

            new EmployeeController().createEmployee(employee);

            AppLayout.appLayout.changeForm(LayoutPages.EMPLOYEES);

        } catch (SparkException e) {
            new DlgError(AppLayout.appLayout, true, e.title, e.getMessage()).setVisible(true);
        } catch (Exception e) {
            new DlgError(AppLayout.appLayout, true, e.getMessage()).setVisible(true);
        }
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void checkCredentialsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkCredentialsActionPerformed
//        if (this.type == DialogTypes.CREATE) {

        boolean state = checkCredentials.isSelected();
        txtUsername.setEnabled(state);
        txtPassword.setEnabled(state);
        cboRole.setEnabled(state);
//        }
    }//GEN-LAST:event_checkCredentialsActionPerformed

    private void btnAllowEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAllowEditActionPerformed

        txtFName.setEnabled(true);
        txtLName.setEnabled(true);
        txtMobile1.setEnabled(true);
        txtMobile2.setEnabled(true);
        txtAddress.setEnabled(true);
        cboStatus.setEnabled(true);
        checkCredentials.setEnabled(true);

        if (checkCredentials.isSelected()) {

            txtUsername.setEnabled(true);
            txtPassword.setEnabled(true);
            cboRole.setEnabled(true);
        }
    }//GEN-LAST:event_btnAllowEditActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAllowEdit;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JComboBox<String> cboGender;
    private javax.swing.JComboBox<String> cboRole;
    private javax.swing.JComboBox<String> cboStatus;
    private javax.swing.JCheckBox checkCredentials;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JLabel lblHeading;
    private javax.swing.JPanel pnlData;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtFName;
    private javax.swing.JTextField txtLName;
    private javax.swing.JTextField txtMobile1;
    private javax.swing.JTextField txtMobile2;
    private javax.swing.JTextField txtNIC;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
