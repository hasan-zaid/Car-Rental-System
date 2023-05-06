/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package system_objects;
import java.util.*;
import java.text.*;

/**
 *
 * @author hasan
 */
public class car {
    protected String carID, engine, model, rent;
    private int carIDNum;
    private static String fileName = "Car.txt";
    public car() {}
    
    public car(String eng, String Model, String Rent)
    {
        this.engine = eng;
        this.model = Model.toUpperCase();
        this.rent = Rent;
        this.carIDNum = new dataHandling().countRows(fileName);
        this.carID = "CAR" + String.valueOf(carIDNum);
    }
    
    public boolean addCar()
    {
        String carInfo = this.carID + "," + this.model + "," + this.engine + "," + this.rent + "," + "available" + "," + " " + ",";
        try{
            new dataHandling().addCarorBooking(carInfo, fileName);
            return true;
        }
        catch(Exception e) {
            return false;
        }
    }
    
    public static ArrayList<String[]> listCars()
    {
        ArrayList<String[]> cars = car.updateStatus();
        return cars;
    }
    
    public static boolean isDateOver(String bookingDate)
    {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date date;
        Date today = new Date();
        inputValidator validate = new inputValidator();
        try{
            date = formatter.parse(bookingDate);
            int dateOccurance = today.compareTo(date);
        
            if(dateOccurance > 0)
                return  true;
            else
                return false;
        }
        catch(Exception e) {return false;}
    }
    
    public static ArrayList<String[]> updateStatus()
    {
        dataHandling files = new dataHandling();
        ArrayList<String[]> cars = files.ReadFromFile(fileName);
        
        for(int a = 0; a < cars.size(); a++)
        {
            if(isDateOver(cars.get(a)[5]))
            {
                cars.get(a)[4] = "available";
                cars.get(a)[5] = " ";
            }
        }
        
       files.editFile(cars, fileName);
       return cars;
    }
    
    public static void updateStatus(Object carID)
    {
        dataHandling files = new dataHandling();
        ArrayList<String[]> cars = files.ReadFromFile(fileName);
        
        for(int a = 0; a < cars.size(); a++)
        {
            if(carID.equals(cars.get(a)[0]))
            {
                cars.get(a)[4] = "available";
                cars.get(a)[5] = " ";
            }
        }
        
       files.editFile(cars, fileName);
    }
}
