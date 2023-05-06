/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package system_objects;

import system_objects.user;
import java.io.*;
import java.util.*;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author hasan
 */
public class dataHandling {
    private user newCus;
    ArrayList<String[]> importedDataList = new ArrayList<String[]>();
    
    public dataHandling() {}
    
    public ArrayList<String[]> getData() { return this.importedDataList; }
    
    public void addUser (user objUser)
    {
        try {
            String fn = objUser.userType + ".txt";
            File file = new File(fn);
            FileWriter fw = new FileWriter(file, true);
            fw.write(objUser.userData());
            fw.write("\n");
            fw.close();
        }
        
        catch(IOException Ex) {}
    }
    
    public void addCarorBooking (String record, String specifier)
    {
        try {;
            File file = new File(specifier);
            FileWriter fw = new FileWriter(file, true);
            fw.write(record);
            fw.write("\n");
            fw.close();
        }
        
        catch(IOException Ex) {}
    }
    
    public ArrayList<String[]> ReadFromFile (String fname) 
    {
        ArrayList<String[]> records = new ArrayList<String[]>();
        try {
            Scanner SC = new Scanner(System.in);
            File file = new File (fname);
            SC = new Scanner(file);
            while(SC.hasNextLine())
            {
                String Line = SC.nextLine();
                String[] values = Line.split(",");
                records.add(values);
            }
        }
        
        catch (IOException ex) {}
        
        return records;
    }
    
    public void editFile(ArrayList<String[]> contents, String fname)
    {
        try
        {
            File file = new File(fname);
            FileWriter fw = new FileWriter(file, false); 
            for(int i = 0; i < contents.size(); i++)
            {
                String line = String.join(",", contents.get(i));
                fw.write(line);
                fw.write("\n");
            }
            fw.close();
        }
        catch(Exception e) {}
    }
    public void listRows(DefaultTableModel table, String fname, int columns)
    {
        Object[] row = new Object[columns];
        this.importedDataList = ReadFromFile(fname);
        for(int a = 0; a < this.importedDataList.size(); a++)
        {
            String[] record = this.importedDataList.get(a);
            for(int b = 0; b < row.length; b++)
            {
                row[b] = record[b];
            }
            table.addRow(row);
        }
    }
    
    public int countRows(String fname)
    {
        int rows = 0;
        try(BufferedReader reader = new BufferedReader(new FileReader(fname))) 
        {
            while(reader.readLine()!= null)
                rows++;
        }
        catch (IOException ex) {}
        return rows;
    }
}
