/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.car_rental_system;

import system_objects.user;
import system_objects.customer;

/**
 *
 * @author danie
 */
public class Customer_Home extends javax.swing.JFrame {
    private customer customer = new customer();
    /**
     * Creates new form CustomerMenu
     */
    public Customer_Home() {
        initComponents();
    }
    
    public Customer_Home(user info)
    {
        initComponents();
        this.customer.setID(info.getID());
        this.headerLbl.setText("Hey " + customer.getID().toUpperCase());
    }
    
    public Customer_Home(String id)
    {
        initComponents();
        this.customer.setID(id);
        this.headerLbl.setText("Hey " + customer.getID().toUpperCase());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        createBookingBtn = new javax.swing.JButton();
        manageBookingBtn = new javax.swing.JButton();
        headerLbl = new javax.swing.JLabel();
        logoutBtn = new javax.swing.JButton();
        changeNumberBtn = new javax.swing.JButton();
        deleteAccountBtn = new javax.swing.JButton();
        changePassBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        createBookingBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        createBookingBtn.setText("Create a Booking");
        createBookingBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createBookingBtnActionPerformed(evt);
            }
        });

        manageBookingBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        manageBookingBtn.setText("Manage bookings");
        manageBookingBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageBookingBtnActionPerformed(evt);
            }
        });

        headerLbl.setFont(new java.awt.Font("Segoe UI Black", 2, 36)); // NOI18N

        logoutBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        logoutBtn.setText("Logout");
        logoutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutBtnActionPerformed(evt);
            }
        });

        changeNumberBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        changeNumberBtn.setText("Change Phone Number");
        changeNumberBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeNumberBtnActionPerformed(evt);
            }
        });

        deleteAccountBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        deleteAccountBtn.setText("Delete Account");
        deleteAccountBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteAccountBtnActionPerformed(evt);
            }
        });

        changePassBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        changePassBtn.setText("Change Password");
        changePassBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changePassBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(headerLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(290, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(logoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(deleteAccountBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(changePassBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(changeNumberBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                                .addComponent(manageBookingBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(createBookingBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(251, 251, 251))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(headerLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(createBookingBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(manageBookingBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(changePassBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(changeNumberBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(deleteAccountBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(logoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void createBookingBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createBookingBtnActionPerformed
        new Create_Booking(customer.getID()).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_createBookingBtnActionPerformed

    private void manageBookingBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageBookingBtnActionPerformed
            new Booking_History(customer.getID(), true).setVisible(true);
    }//GEN-LAST:event_manageBookingBtnActionPerformed

    private void logoutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutBtnActionPerformed
        new Login().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_logoutBtnActionPerformed

    private void changeNumberBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeNumberBtnActionPerformed
        new Change_Number(this.customer.getID(), "Customer").setVisible(true);
    }//GEN-LAST:event_changeNumberBtnActionPerformed

    private void deleteAccountBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteAccountBtnActionPerformed
        new Delete_Account(customer.getID()).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_deleteAccountBtnActionPerformed

    private void changePassBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changePassBtnActionPerformed
        new Change_Password(this.customer.getID(), "Customer").setVisible(true);
    }//GEN-LAST:event_changePassBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Customer_Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Customer_Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Customer_Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Customer_Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Customer_Home().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton changeNumberBtn;
    private javax.swing.JButton changePassBtn;
    private javax.swing.JButton createBookingBtn;
    private javax.swing.JButton deleteAccountBtn;
    private javax.swing.JLabel headerLbl;
    private javax.swing.JButton logoutBtn;
    private javax.swing.JButton manageBookingBtn;
    // End of variables declaration//GEN-END:variables
}