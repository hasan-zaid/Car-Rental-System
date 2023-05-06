/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package system_objects;
import system_objects.car;
import javax.swing.table.DefaultTableModel;
import java.util.*;

/**
 *
 * @author hasan
 */
public class customer extends user {
    
    public customer(){}
    
    public void setID(String id) { this.ID = id; }
    public String getID() { return this.ID.toUpperCase(); }
    
    public static boolean cancelBooking(DefaultTableModel table, int row){
        Object status = table.getValueAt(row, 7);
        Object bookingID = table.getValueAt(row, 0);
        String fname = "Booking.txt";
        car.updateStatus(table.getValueAt(row, 2));
        
        if("pending".equals(status))
        {
            table.setValueAt("canceled", row, 7);
            dataHandling files = new dataHandling();
            ArrayList<String[]> bookings = files.ReadFromFile(fname);
            
            for(int a = 0; a < bookings.size(); a++)
            {
                if(bookings.get(a)[0].equals(bookingID))
                {
                    bookings.get(a)[7] = "canceled";
                    break;
                }
            }
            
            files.editFile(bookings, fname);
            return true;
        }
        else{
            return false;
        }
    }
}
