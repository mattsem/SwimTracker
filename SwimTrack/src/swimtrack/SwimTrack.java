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
public class SwimTrack {
    private String[] eventList;
    public static SwimTrack this_instance;
    
    
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
       this_instance = new SwimTrack();       
    }
    
    
    public SwimTrack() throws FileNotFoundException{
        String eventList[] = {"50 Fr","100 Fr","200 Fr","500 Fr","1000 Fr","1650 Fr","50 Bk","100 Bk","200 Bk","50 Br", "100 Br","200 Br", "50 Fl", "100 Fl", "200 Fl", "100 IM", "200 IM", "400 IM"};
        setEventList(eventList);
        
        FileManagement data =  new FileManagement();
       
        Visuals display = new Visuals();
        
        
         
    }
    
    
    
    

    public String[] getEventList() {
        return eventList;
    }

    public void setEventList(String[] eventList) {
        this.eventList = eventList;
    }
    

    
}
