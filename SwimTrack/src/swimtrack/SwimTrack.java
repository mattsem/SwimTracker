/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swimtrack;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Toolkit;
import java.io.FileNotFoundException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
/**
 *
 * @author Matt
 */
public class SwimTrack extends javax.swing.JFrame{
    private String[] eventList;
    private static SwimTrack this_instance;
    private static Visuals display;
    
    
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
       this_instance = new SwimTrack();   
       run();
    }
    
    
    public SwimTrack() throws FileNotFoundException{
        String eventList[] = {"50 Fr","100 Fr","200 Fr","500 Fr","1000 Fr","1650 Fr","50 Bk","100 Bk","200 Bk","50 Br", "100 Br","200 Br", "50 Fl", "100 Fl", "200 Fl", "100 IM", "200 IM", "400 IM"};
        setEventList(eventList);
        
        FileManagement data =  new FileManagement();
       
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setExtendedState(JFrame.MAXIMIZED_BOTH); 
        
        setVisible(true);
        
    }

   
    
    
    public static void run(){
        display = new Visuals(this_instance);
        this_instance.add(display);
        display.addButtons();
        
        display.addGraph();
        while(true){
            
        }
        
        
        
    }
    
    
    

    public String[] getEventList() {
        return eventList;
    }

    public void setEventList(String[] eventList) {
        this.eventList = eventList;
    }
    
    public static SwimTrack getThis_instance() {
        return this_instance;
    }

    public static void setThis_instance(SwimTrack this_instance) {
        SwimTrack.this_instance = this_instance;
    }

    public static Visuals getDisplay() {
        return display;
    }

    public static void setDisplay(Visuals display) {
        SwimTrack.display = display;
    }
    
}
