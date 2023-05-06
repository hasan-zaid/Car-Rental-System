/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package system_objects;

/**
 *
 * @author hasan
 */
public class inputValidator {
    public inputValidator() {}
    
    public boolean isNullorEmpty(String ... values) {
        boolean valid = false;
        for(String value : values)
        {
            if(value == null || value.length() == 0 || value.trim().length() == 0)
            {
                valid = valid || true;
            }
            else {
                valid = valid || false;
            }
        }
        return valid;
    }
    
    public boolean isValidNumber(String number)
    {
        try {
            Long.parseLong(number);
            return true;
        }
        catch(Exception ex){ return false; }
    }
}
