/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swimtrack;

import java.util.Scanner;

/**
 *
 * @author Matt
 */
public class Time {
    private double time;    
    
    public Time(String inputTime){
        if(inputTime.contains("r")){
            inputTime = inputTime.replace("r", "0");
        }
        
        if(inputTime.contains(":")){
            double minutes = Double.parseDouble(inputTime.split(":")[0]);
            double seconds = Double.parseDouble(inputTime.split(":")[1]);
            setTime(60*minutes + seconds);
        }
        else{
            setTime(Double.parseDouble(inputTime));
        }
        
        
        
    }
    
    public double getTime(){
        return time;
    }
    
    public void setTime(double convertedTime){
        time = convertedTime;
    }
    
    
    
}
