/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swimtrack;

/**
 *
 * @author Matt
 */
public class EventTabs extends javax.swing.JButton {
    private String event;
    private boolean used;
    
    public EventTabs(){
        setUsed(false);
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
        this.setText(event);
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }
    
    
    
    
    
    
    
    
}
