/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swimtrack;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Matt
 */
public class Visuals {
    private EventTabs tabs[];
    
    public Visuals(){
        JFrame mainDisplay = new JFrame();
        mainDisplay.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel view = new JPanel();
        
        mainDisplay.add(view);
        
        mainDisplay.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        //mainDisplay.setUndecorated(true);
        mainDisplay.setVisible(true);
        
        addButtons(view);
            
    }
    
    public void addButtons(JPanel j){
        int events = SwimTrack.this_instance.getEventList().length;
        
        tabs = new EventTabs[events];
        
        for (int i = 0; i < events - 1; i++) {
            tabs[i] = new EventTabs();
            tabs[i].setBackground(Color.white);
            tabs[i].setEvent(SwimTrack.this_instance.getEventList()[i]);
            tabs[i].setBounds(300, 40*i + 200, 40, 40);
            j.add(tabs[i]);
        }
        
    }
    
    
}
