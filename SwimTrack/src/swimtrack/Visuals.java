/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swimtrack;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Matt
 */
public class Visuals extends javax.swing.JPanel{
    private EventTabs tabs[];
    
    private SwimTrack parent;
    
    public Visuals(SwimTrack parental){
        parent = parental;
        
       //this.setBackground(Color.gray);
       Dimension fullScreen = Toolkit.getDefaultToolkit().getScreenSize();
       this.setPreferredSize(fullScreen);
       this.setLayout(null);
       addGraph();
       
       
    }
    
    public void addButtons(){
        
        int events = parent.getEventList().length;
        
        
        tabs = new EventTabs[events];
        
        for (int i = 0; i < events ; i++) {
            tabs[i] = new EventTabs();
            
            tabs[i].setBackground(Color.white);
            tabs[i].setEvent(parent.getEventList()[i]);
            
            tabs[i].setBounds(300, 50*i + 50, 80, 50);
            
            add(tabs[i]);
            
        }
        
        validate();
        
    }
    
    public void addGraph(){
        
        Graph g = new Graph();
        
        this.add(g);
        
    }
    
    
    public void paint(Graphics g){
        super.paint(g);
//        g.setColor(Color.white);
//        g.fillRect(380, 50, 1300, 900);
        
    }

    public SwimTrack getParent() {
        return parent;
    }

    public void setParent(SwimTrack parent) {
        this.parent = parent;
    }
    
    
    
    
    
    
}
