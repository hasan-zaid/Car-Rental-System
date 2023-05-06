/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.car_rental_system;

import system_objects.Booking;
import system_objects.inputValidator;
import system_objects.dataHandling;
import system_objects.car;
import java.util.*;
import javax.swing.JFormattedTextField;
import javax.swing.JSpinner;
import java.text.SimpleDateFormat;  
import java.text.ParseException;



/**
 *
 * @author danie
 */
public class Create_Booking extends javax.swing.JFrame implements Booking {
    private dataHandling files = new dataHandling();
    private ArrayList<String[]> cars = new ArrayList<String[]>();
    private String ID;
    private String fileName = "Car.txt";
    private int[] carIndex;
    
    public String[] getDates(Object days){
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date date = new Date();
        int daysNum = (Integer)days;
        String dateStr = formatter.format(date);
        
          
        Calendar today = Calendar.getInstance();  
        try{  
           today.setTime(formatter.parse(dateStr));  
        }catch(ParseException e){  
            e.printStackTrace();  
         }  
             
        today.add(Calendar.DAY_OF_MONTH, daysNum);  
        String returnDate = formatter.format(today.getTime());
        
        String[] dates = {dateStr, returnDate};
                  
        return dates;
    }
    
    public void createBooking(Object days, String[] car, String paidAmount)
    {
        String file = "Booking.txt";
        String[] dates = getDates(days);
        int daysNum = (Integer)days;
        int recordNum = this.files.countRows(file);
        String bookingID = "BK" + recordNum;
        String rentPaid = this.paidTxt.getText();
        String rentDue = String.valueOf(Integer.parseInt(car[3]) * daysNum);
        
        String bookingRecord = bookingID + "," + this.ID + "," + car[0] + "," + rentDue + ","  + rentPaid + "," + dates[0] + "," + dates[1] + "," + "pending" + "," ;
        
        files.addCarorBooking(bookingRecord, file);
        
        for(int j = 0; j < cars.size(); j++)
        {
            if(cars.get(j)[0].equals(car[0]))
            {
                this.cars.get(j)[4] = "rented";
                this.cars.get(j)[5] = dates[1];
                files.editFile(cars, this.fileName);
                break;
            }
        }
        
        new Customer_Home(this.ID).setVisible(true);
        this.setVisible(false);
    }
    /**
     * Creates new form BookingForm
     */
    public Create_Booking() {
        initComponents();
}
    
    public Create_Booking(String id) {
        initComponents();
        this.ID = id.toUpperCase();
        
        JFormattedTextField formatter = ((JSpinner.DefaultEditor) this.daySpinner.getEditor()).getTextField();
        formatter.setEditable(false);
        
        this.cars = car.listCars();
        this.carIndex = new int[cars.size()];
        
        int carIndexCounter = 0;
        for(int i = 0; i < cars.size(); i++)
        {
            if(cars.get(i)[4].equals("available"))
            {
                this.carNamesCombo.addItem(cars.get(i)[1]);
                this.carIndex[carIndexCounter] = i;
                carIndexCounter++;
            }
        }
        this.engineLbl.setText(cars.get(this.carIndex[this.carNamesCombo.getSelectedIndex()])[2]);
        this.rentLbl.setText(this.cars.get(this.carIndex[this.carNamesCombo.getSelectedIndex()])[3]);
        
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        carNamesCombo = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        rentLbl = new javax.swing.JTextField();
        engineLbl = new javax.swing.JTextField();
        bookBtn = new javax.swing.JButton();
        backBtn = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        daySpinner = new javax.swing.JSpinner();
        jLabel6 = new javax.swing.JLabel();
        paidTxt = new javax.swing.JTextField();
        warningMessageLbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setText("Select Car");

        carNamesCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carNamesComboActionPerformed(evt);
            }
        });

        jLabel3.setText("Rent length");

        jLabel4.setText("Rent Price");

        rentLbl.setEditable(false);
        rentLbl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rentLblActionPerformed(evt);
            }
        });

        engineLbl.setEditable(false);
        engineLbl.setToolTipText("Engine");

        bookBtn.setText("Confirm Booking");
        bookBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookBtnActionPerformed(evt);
            }
        });

        backBtn.setText("Go Back");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        jLabel5.setText("Days");

        daySpinner.setModel(new javax.swing.SpinnerNumberModel(1, 1, 30, 1));
        daySpinner.setEditor(new javax.swing.JSpinner.NumberEditor(daySpinner, ""));
        daySpinner.setValue(1);
        daySpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                daySpinnerStateChanged(evt);
            }
        });

        jLabel6.setText("Enter Payment");

        warningMessageLbl.setForeground(new java.awt.Color(255, 0, 102));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(daySpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(carNamesCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(engineLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(paidTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(rentLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 57, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bookBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(backBtn)
                        .addGap(24, 24, 24))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(warningMessageLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(carNamesCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(engineLbl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(daySpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rentLbl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(backBtn)
                            .addComponent(bookBtn))
                        .addGap(20, 20, 20))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(paidTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(warningMessageLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 76, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void carNamesComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carNamesComboActionPerformed
        this.engineLbl.setText(cars.get(this.carIndex[this.carNamesCombo.getSelectedIndex()])[2]);
        this.calculateRent(this.daySpinner.getValue());
    }//GEN-LAST:event_carNamesComboActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        new Customer_Home(this.ID).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_backBtnActionPerformed

    private void rentLblActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rentLblActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rentLblActionPerformed

    private void daySpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_daySpinnerStateChanged
        this.calculateRent(this.daySpinner.getValue());
    }//GEN-LAST:event_daySpinnerStateChanged

    private void bookBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookBtnActionPerformed
        inputValidator validate = new inputValidator();
        if(!validate.isNullorEmpty(this.paidTxt.getText()) && validate.isValidNumber(this.paidTxt.getText()))
        {
            this.createBooking(this.daySpinner.getValue(), this.cars.get(this.carIndex[this.carNamesCombo.getSelectedIndex()]), this.paidTxt.getText());
        }
        else
            this.warningMessageLbl.setText("Enter a valid payment value !");
    }//GEN-LAST:event_bookBtnActionPerformed
    
    private void calculateRent(Object days)
    {
        String dayRent = this.cars.get(this.carIndex[this.carNamesCombo.getSelectedIndex()])[3];
        int daysNum = (Integer)days;
        int rent = Integer.valueOf(dayRent) *  daysNum;
        String rentStr = String.valueOf(rent);
        this.rentLbl.setText(rentStr);
    }
    
    
    
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
            java.util.logging.Logger.getLogger(Create_Booking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Create_Booking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Create_Booking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Create_Booking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Create_Booking().setVisible(true);
            }
        });
    }
    
   
        
        
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JButton bookBtn;
    private javax.swing.JComboBox<String> carNamesCombo;
    private javax.swing.JSpinner daySpinner;
    private javax.swing.JTextField engineLbl;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField paidTxt;
    private javax.swing.JTextField rentLbl;
    private javax.swing.JLabel warningMessageLbl;
    // End of variables declaration//GEN-END:variables
}
