/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swimtrack;

import java.awt.Color;
import java.awt.Graphics;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Matt
 */
public class Graph extends javax.swing.JPanel{
    private String event;
    private Map<Long, Time> savedData;
    
   
    
 
    public Graph(String event){
        setBounds(390, 50, 50, 50);
        setBackground(Color.white);
        
        this.event = event;
        
        
        setVisible(true);
    }
    
    public void drawData(Map<Long, Time> data){
        savedData = data;
        
        
    }
    
    public void printXAxisScale(Graphics g){
        Set xValues = savedData.keySet();
        long min = getMin(xValues);
        long max = getMax(xValues);
        
        Date minDate = new Date(min);
        Date maxDate = new Date(max);
        //g.drawString(minDate.toString(), 800, 900);
        
        
        String dateFormat = "MM/dd/yyyy";
        DateFormat form = new SimpleDateFormat(dateFormat);
        String minDateString = form.format(minDate);
        String maxDateString = form.format(maxDate);
        g.drawString(minDateString,500,950);
        g.drawString(maxDateString,1300,950);
    }
    
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        if(savedData != null){
            printXAxisScale(g);
            drawXAxis(g);
            drawYAxis(g);
        }
    }
    
    
    public void drawXAxis(Graphics g){
        g.drawLine(450, 900,1700,900);
        

    }
    
    public void drawYAxis(Graphics g){
        g.drawLine(450, 900, 450, 100);
        
    }
    
    public void drawY(){
        
        
    }
    
    public long getMax(Set<Long> data){
        long max = Long.MIN_VALUE;
        for(long date : data){
            if (date> max){
                max = date;
            }
        }
        
        return max;
    }
    
     public long getMin(Set<Long> data){
        long min = Long.MAX_VALUE;
        for(long date : data){
            if (date < min){
                min = date;
            }
        }
         
        return min;
    }
    
    
    
    
    
    
    
    
    
    
    
    
}
