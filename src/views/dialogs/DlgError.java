/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package views.dialogs;

import com.formdev.flatlaf.FlatClientProperties;
import java.awt.Color;

/**
 *
 * @author vishv
 */
public class DlgError extends javax.swing.JDialog {

    /**
     * Creates new form DlgError
     *
     * @param parent
     * @param modal
     * @param msg
     */
    public DlgError(java.awt.Frame parent, boolean modal, String msg) {
        super(parent, modal);
        initComponents();

        setDesign();

        lblMessage.setText("<HTML>" + msg + "</HTML>");
    }

    /**
     * Creates new form DlgError
     *
     * @param parent
     * @param modal
     * @param title
     * @param msg
     */
    public DlgError(java.awt.Frame parent, boolean modal, String title, String msg) {
        super(parent, modal);
        initComponents();

        setDesign();

        lblTitle.setText(title);
        lblMessage.setText("<HTML>" + msg + "</HTML>");

    }

    private void setDesign() {
        getRootPane().putClientProperty(FlatClientProperties.TITLE_BAR_BACKGROUND, new Color(255, 66, 66));
        getRootPane().putClientProperty(FlatClientProperties.TITLE_BAR_FOREGROUND, new Color(0, 0, 0));
        getRootPane().putClientProperty(FlatClientProperties.TITLE_BAR_SHOW_CLOSE, false);
        getRootPane().putClientProperty(FlatClientProperties.TITLE_BAR_SHOW_MAXIMIZE, false);
        getRootPane().putClientProperty(FlatClientProperties.TITLE_BAR_SHOW_ICONIFFY, false);

        btnClose.putClientProperty("JButton.buttonType", "roundRect");
        btnClose.putClientProperty("JButton.buttonType", "borderless");
//        btnClose.putClientProperty("Button.border", com.formdev.flatlaf.ui.FlatButtonBorder);
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
        lblTitle = new javax.swing.JLabel();
        lblMessage = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnClose = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(413, 102));
        setMinimumSize(new java.awt.Dimension(413, 102));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(525, 150));

        lblTitle.setFont(new java.awt.Font("Segoe UI Semibold", 0, 20)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Unknown Error Occured");

        lblMessage.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        lblMessage.setForeground(new java.awt.Color(153, 153, 153));
        lblMessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMessage.setText("Please try again later.");
        lblMessage.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        btnClose.setBackground(new java.awt.Color(0, 0, 0));
        btnClose.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        btnClose.setForeground(new java.awt.Color(255, 255, 255));
        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(btnClose, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(41, 41, 41))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)
                    .addComponent(lblMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(36, 36, 36))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(lblTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 399, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCloseActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblMessage;
    private javax.swing.JLabel lblTitle;
    // End of variables declaration//GEN-END:variables
}
