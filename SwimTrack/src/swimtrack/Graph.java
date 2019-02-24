/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swimtrack;

import java.awt.Color;
import java.awt.Font;
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
    private Font f;
    private double projected;
    private double slope;
    private double intercept;
   
    
 
    public Graph(String event){
        setBounds(390, 50, 50, 50);
        setBackground(Color.white);
        f = new Font("serif", 15, 30);
        
        
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
        g.setFont(f);
        if(savedData != null){
            g.setColor(Color.black);
            writeKey(g);
            writeTitle(g);
            
            printXAxisScale(g);
            printYAxisScale(g);
            drawXAxis(g);
            drawYAxis(g);
            g.setColor(Color.blue);
            graphPoint(g);
            g.setColor(Color.red);
            lineOfBestFit(g);
            g.setColor(Color.black);
            writeProjectedTime(g);
        }
        else{
            g.drawString("NO DATA", 1000, 500);
        }
    }
    
    public void writeKey(Graphics g){
        g.setColor(Color.blue);
        g.drawString("Progression", 1500, 300);
        g.fillRect(1650, 280, 100, 20);
        g.setColor(Color.red);
        g.drawString("Trend", 1500, 350);
        g.fillRect(1600, 330, 100, 20);
        g.setColor(Color.black);
        
    }
    
    public void projectedTime(){
        projected = (slope * (maxDate + (1000 * 60 * 60 * 24 * 365 * 10) )) + intercept;
        
    }
    
    public void writeProjectedTime(Graphics g){
        projectedTime();
        String timePrint = convertDoubleTime(Math.floor(projected*100) / 100);
        g.drawString("Projected time in a year" + " " + timePrint , 1300, 100);
        
    }
    
    
    public ArrayList<Point> dataToArray(){
        ArrayList<Point> dataPoints= new ArrayList<>();
        for(Long keys: savedData.keySet()){
            Point p = new Point(keys, savedData.get(keys).getTime());
            dataPoints.add(p);
        }
        return dataPoints;
    }
    
    
    public void writeTitle(Graphics g){
        
        g.drawString(event, 1100, 100);
        
    }
    
    
    public void lineOfBestFit(Graphics g){
        ArrayList<Point> dataPoints = dataToArray();
        double x = findAverageX(dataPoints);
        double y = findAverageY(dataPoints);
        slope = findSlopeBestFit(dataPoints,x,y);
        intercept = findInterceptBestFit(slope,x,y);
        
        
        double yBestBeg = findSpacingTime(bestFitStart(slope, intercept)) + 200;
        double yBestEnd = findSpacingTime(bestFitEnd(slope, intercept)) + 200;
        
        g.drawLine(findSpacingX(maxDate) + 550,(int) yBestEnd, findSpacingX(minDate) + 550,(int) yBestBeg);
        
        
    }
    
    public double bestFitEnd(double slope, double intercept){
        double pointAsTime = (slope * maxDate) + intercept;
        return pointAsTime;
    }
    
    public double bestFitStart(double slope, double intercept){
        double pointAsTime = (slope * minDate) + intercept;
        return pointAsTime;
    }
    
    
    
    public double findInterceptBestFit(double slope,double avgX, double avgY){
        double intercept = avgY - slope*avgX;
        return intercept;
    }
    
    public double findSlopeBestFit(ArrayList<Point> dataPoints, double avgX, double avgY){
        double top = 0;
        for(Point data: dataPoints) {
            long x = data.getX();
            top += (data.getX() - avgX)*(data.getY() - avgY);
        }
        
        double bottom = 0;
        
        for(Point datas: dataPoints){
            double toBeSquared = (datas.getX() - avgX);
            bottom += Math.pow(toBeSquared, 2); 
            
        }
        
        double slope = top/bottom;
        return slope;
    }
    
    public long findAverageX(ArrayList<Point> dataPoints){
        long total= 0;
        
        for(Point p :dataPoints){
            total += p.getX();
            
        }
        
        long avg = total / dataPoints.size();
        
        return avg;
    }
    
    public double findAverageY(ArrayList<Point> dataPoints){
        double total= 0;
        
        for(Point p :dataPoints){
            total += p.getY();
            
        }
        
        double avg = total / dataPoints.size();
        return avg;
    }
    
    
    
    
    public void drawXAxis(Graphics g){
        g.drawLine(500, 900,1700,900);
        for (int i = 0; i < 3; i++) {
            g.drawLine(200*i + 800, 890, 200 * i + 800, 910);
        }
        

    }
    
    public void drawYAxis(Graphics g){
        g.drawLine(500, 900, 500, 100);
        for (int i = 0; i < 3; i++) {
            g.drawLine(490, 100 * i + 300, 510, 100 * i + 300);
        }
        
    }
    
    public void printYAxisScale(Graphics g){
        ArrayList<Double> arr = new ArrayList<>();
        
        for(Long keys: savedData.keySet()){
            Time t = savedData.get(keys);
            arr.add(t.getTime());
        }
        fast = getFastestTime(arr);
        slow = getSlowestTime(arr);
        //double drop = getFastestTime(arr) * 0.95;
        
        //drop = (double) Math.round(drop * 100) / 100;
        g.drawString(convertDoubleTime(slow), 430, 200);
        g.drawString(convertDoubleTime(fast),430, 600);
        
        
        
    }
    
    
    
    
    public void graphPoint(Graphics g){
        g.setColor(Color.blue);
        int index = 0;
        int xPos = 0;
        int yPos = 0;
        
        for(Long keys: savedData.keySet()){
            Time t = savedData.get(keys);
            
            
            if(index != 0){
                g.drawLine(xPos + 5, yPos + 5,findSpacingX(keys) + 550 + 5,(int) findSpacingTime(t.getTime()) + 200 + 5);
            }
             index++;   
                
            xPos = findSpacingX(keys) + 550;
            yPos = (int) findSpacingTime(t.getTime()) + 200;
            
            g.fillOval(xPos, yPos,10, 10);
            
        }
        
        
        
    }
    
    
    
    
    public int findSpacingX(Long date){
        Long range = maxDate - date;
        
        
        int spacing =  (int) (range / (1000*60*60*24)) *2;
        return spacing;
    }
    
    
   
    
    public double findSpacingTime(double time){
        double range = slow - fast;
        
        
        double spacing = (400/range * (slow-time));
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

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public Map<Long, Time> getSavedData() {
        return savedData;
    }

    public void setSavedData(Map<Long, Time> savedData) {
        this.savedData = savedData;
    }

    public double getFast() {
        return fast;
    }

    public void setFast(double fast) {
        this.fast = fast;
    }

    public double getSlow() {
        return slow;
    }

    public void setSlow(double slow) {
        this.slow = slow;
    }

    public Long getMinDate() {
        return minDate;
    }

    public void setMinDate(Long minDate) {
        this.minDate = minDate;
    }

    public Long getMaxDate() {
        return maxDate;
    }

    public void setMaxDate(Long maxDate) {
        this.maxDate = maxDate;
    }
    
    
    
    
    
    
    
    
    
    
    
    
}
