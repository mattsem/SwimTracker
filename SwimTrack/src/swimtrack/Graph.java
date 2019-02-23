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
import java.util.ArrayList;
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
    private double fast;
    private double slow;
    private Long minDate;
    private Long maxDate;
    
   
    
 
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
        minDate = getMin(xValues);
        maxDate = getMax(xValues);
        
        Date minimumDate = new Date(minDate);
        Date maximumDate = new Date(maxDate);
        
        
        
        String dateFormat = "MM/dd/yyyy";
        DateFormat form = new SimpleDateFormat(dateFormat);
        String minDateString = form.format(minimumDate);
        String maxDateString = form.format(maximumDate);
        g.drawString(minDateString,550,950);
        g.drawString(maxDateString,1300,950);
    }
    
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        if(savedData != null){
            printXAxisScale(g);
            printYAxisScale(g);
            drawXAxis(g);
            drawYAxis(g);
            graphPoint(g);
        }
        else{
            g.drawString("NO DATA", 1000, 500);
        }
    }
    
    
    public void drawXAxis(Graphics g){
        g.drawLine(500, 900,1700,900);
        

    }
    
    public void drawYAxis(Graphics g){
        g.drawLine(500, 900, 500, 100);
        
    }
    
    public void printYAxisScale(Graphics g){
        ArrayList<Double> arr = new ArrayList<>();
        
        for(Long keys: savedData.keySet()){
            Time t = savedData.get(keys);
            arr.add(t.getTime());
        }
        fast = getFastestTime(arr);
        slow = getSlowestTime(arr);
        double drop = getFastestTime(arr) * 0.95;
        
        drop = (double) Math.round(drop * 100) / 100;
        g.drawString(convertDoubleTime(slow), 450, 200);
        g.drawString(convertDoubleTime(drop),450, 200 + findSpacingTime(slow, drop));
        
        
        
    }
    
    
    
    
    public void graphPoint(Graphics g){
        g.setColor(Color.blue);
        for(Long keys: savedData.keySet()){
            Time t = savedData.get(keys);
            
            
            
            g.fillOval(findSpacingX(keys) + 550, findSpacingTime(slow,t.getTime() ) + 200, 5, 5);
        }
        
        
        
    }
    
    
    public int findSpacingX(Long date){
        Long range = maxDate - date;
        
        
        int spacing =  (int) (range / (1000*60*60*24)) *2;
        return spacing;
    }
    
    
   
    
    public int findSpacingTime(double maxTime, double time){
        int spacing = (int) ((1 - time/maxTime) * 1700);
        return spacing;
    }
    
    public String convertDoubleTime(double d){
        String time = "";
        if(d < 60){
            time+= d;
            
        }
        else{
        
            
            time += (int)(d/60) % 60;
            time += ":";
            int seconds = (int) (d%60);
            if(seconds < 10){
                time += "0";

            }
            time += seconds;
            
        }
        return time;
    }
    
    
    
    public double getFastestTime(ArrayList<Double> times){
        double min = Double.MAX_VALUE;
        for(double finishedIn : times){
            if(finishedIn < min){
                min = finishedIn;
            }
        }
        return min;
    }
    
    
    public double getSlowestTime(ArrayList<Double> times){
        double max = Double.MIN_VALUE;
        for(double finishedIn : times){
            if(finishedIn > max){
                max = finishedIn;
            }
        }
        return max;
        
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
