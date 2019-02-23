/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swimtrack;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Toolkit;
import java.io.FileNotFoundException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Matt
 */
public class SwimTrack extends javax.swing.JFrame{
    private String[] eventList;
    private static SwimTrack this_instance;
    private static Visuals display;
    private Graph g;
    private FileManagement data;
    
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, ParseException {
       this_instance = new SwimTrack();
       Dimension fullScreen = Toolkit.getDefaultToolkit().getScreenSize();
       this_instance.setSize(fullScreen);
       this_instance.run();
    }
    
    
    public SwimTrack() throws FileNotFoundException, ParseException{
        String eventList[] = {"50 Free","100 Free","200 Free","500 Free","1000 Free","1650 Free","50 Back","100 Back","200 Back","50 Breast", "100 Breast","200 Breast", "50 Fly", "100 Fly", "200 Fly", "100 IM", "200 IM", "400 IM"};
        setEventList(eventList);
        
        data =  new FileManagement();
       
        setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        
        
        
        
        
    }

   
    
    
    public void run(){
        display = new Visuals(this);
        display.addButtons();
        
        
        add(display);
        
        
        
        g = new Graph("50 Free");
        
        add(g);
        
        
        
        
        
        
        
        setVisible(true);
        
        
        while(true){
            
        }
        
        
        
    }
    
    public void drawGraph(String eventName){
        //find data for event
        Map<String, Map> allData = data.getEventData();
        Map<Long, Time> eventData = allData.get(eventName);
        //tell the graph to draw data
        g.drawData(eventData);
        repaint();
        
        
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
