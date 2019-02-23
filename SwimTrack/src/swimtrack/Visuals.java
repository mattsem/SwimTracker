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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Matt
 */
public class Visuals extends javax.swing.JPanel implements ActionListener {
    private EventTabs tabs[];
    
    private SwimTrack parent;
    
    public Visuals(SwimTrack parental){
        parent = parental;
        
       this.setBackground(Color.gray);
       
       this.setBounds(0, 0, 390, parent.getHeight());
       
       setLayout(null);
       
       
       
    }
    
    public void addButtons(){
        
        int events = parent.getEventList().length;
        
        
        tabs = new EventTabs[events];
        
        for (int i = 0; i < events ; i++) {
            tabs[i] = new EventTabs();
            
            tabs[i].setBackground(Color.white);
            tabs[i].setEvent(parent.getEventList()[i]);
            tabs[i].setBounds(290, 50*i + 50, 100, 50);
            
            add(tabs[i]);
            tabs[i].addActionListener(this);
            
            
            
        }
        
        validate();
        
    }
    
    /**
     *
     * @param g
     */
    @Override
    public void paint(Graphics g){
        super.paint(g);

        
    }

    
    public void setParent(SwimTrack parent) {
        this.parent = parent;
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        EventTabs btn = (EventTabs) evt.getSource();
        String event = btn.getEvent();
        parent.drawGraph(event);
    }
    
    
    
    
    
    
}
