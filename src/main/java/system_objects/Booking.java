/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package system_objects;

/**
 *
 * @author hasan
 */
public interface Booking {
    public void createBooking(Object days, String[] car, String paidAmount);
    public String[] getDates(Object days);
}
