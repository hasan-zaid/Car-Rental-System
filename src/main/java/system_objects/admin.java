/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package system_objects;
import java.util.*;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author hasan
 */
public class admin extends user{
    
    public admin() {}
    
    public void setID(String id) { this.ID = id; }
    public String getID() { return this.ID.toUpperCase(); }
    
    public static boolean managePayment(boolean state, DefaultTableModel table, ArrayList<String[]> rows, String fileName, int selectedIndex)
    {
        String status;
        dataHandling files = new dataHandling();
        if(state)
            status = "approved";
        else
        {
            status = "rejected";
            car.updateStatus(table.getValueAt(selectedIndex, 2));
        }
        
        Object bookingID = table.getValueAt(selectedIndex, 0);
        for(int a = 0; a < rows.size(); a++)
             {
                 if(rows.get(a)[0].equals(bookingID))
                 {
                    rows.get(a)[7] = status;
                    files.editFile(rows, fileName);
                    table.removeRow(selectedIndex);
                    return true;
                 }
             }
        return false;
    }
}
