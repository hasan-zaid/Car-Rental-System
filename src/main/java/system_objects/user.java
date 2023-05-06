/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package system_objects;
import java.awt.Color;
import java.util.*;

/**
 *
 * @author hasan
 */
public class user {
    
    protected String name, phoneNumber, password, ID, userType;
    private int IDNum;
    
    public String getID() { return this.ID; } 
    
    public user() {}
    
    public user(String pass, String id)
    {
        this.password = pass;
        this.ID = id;
    }
    
    public user(String Password, String Name, String PhoneNumber, String type)
    {
        password = Password;
        this.name = Name.toUpperCase();
        this.phoneNumber = PhoneNumber;
        this.IDNum = new dataHandling().countRows(type + ".txt");
        userType = type;
        if(userType.equals("Customer"))
            ID = "CUS" + String.valueOf(IDNum);
        else
            ID = "ADM" + String.valueOf(IDNum);
    }
    
    public String authorizeUser() {
            inputValidator validate = new inputValidator();
            if(!validate.isNullorEmpty(this.ID, this.password))
            {
                dataHandling loginData = new dataHandling();
                String fname  = "Customer";
                for(int r = 0; r < 2; r++)
                {
                    ArrayList<String[]> loginRecords = loginData.ReadFromFile(fname + ".txt");
                    for(int i = 0; i < loginRecords.size(); i++)
                        {
                            String[] record = loginRecords.get(i);
                            if(record[0].equals(this.ID.toUpperCase()) && record[3].equals(this.password))
                            {
                                if(r == 0 && record[4].equals("banned"))
                                    return "Your account is banned";
                                
                                if(r == 0 && record[4].equals("deleted"))
                                    return "Login credential are incorrect, please try again!";
                                    // represents user type
                                   return fname;
                            }
                        }
                    fname = "Admin";
                    }
                return "Login credential are incorrect, please try again!";
            }
            else 
                return "Please enter valid login details !";
    }
    
    public String[][] searchForRecord(ArrayList<String[]> contents, String searchTerm)
    {
           String[][] results = {{""} , {""}};
           String search = searchTerm.toUpperCase();
           for(int j = 0; j < contents.size(); j++)
            {
                String[] record = contents.get(j);
               if(record[0].equals(search) || record[1].equals(search))
               {
                   results[0] = record;
                   String[] index = {String.valueOf(j)};
                   results[1] = index;
                   return results;
               }
            }           
           return results;
    }
    
    public String changeUserInfo(String fileName, String oldData, String newData, String userID, int dataIndex)
    {
        if(oldData.equals(newData))
            return "Current and old data cannot be the same";
        
        dataHandling files = new dataHandling();
        ArrayList<String[]> users = files.ReadFromFile(fileName);
        String[][] results = this.searchForRecord(users, userID);
        int recordIndex = Integer.parseInt(results[1][0]);
        if(results[0][dataIndex].equals(oldData))
        {
            users.get(recordIndex)[dataIndex] = newData;
            files.editFile(users, fileName);
            return  "The information has been updated successfully !";
        }
        return "Current data doesn't match, try again";
    }
    
    
        
    public String userData() {
        if(userType.equals("Customer"))
            return this.ID + "," + this.name + "," + this.phoneNumber + "," + password + "," + "active" + ",";
        return this.ID + "," + this.name + "," + this.phoneNumber + "," + password + ",";
    }
}
