package ch.hslu.oop.SW10;

import java.beans.PropertyChangeEvent;

public class Engine implements Switchable {
    private boolean isOn = false;
    private int rpm = 0;

    @Override
    public void switchOn(){
        if(isSwitchedOff()){
            this.rpm = 800;
            this.isOn = true;
            System.out.println("Engine turned ON. Engine is now idling at " + this.rpm + " rpm");
        } 
        else{ 
            System.out.println("Engine is already ON");
        }
        
    }
    @Override
    public void switchOff(){
        if(isSwitchedOn()){
            this.rpm = 0;
            this.isOn = false;
            System.out.println("Engine turned OFF.");
        } else {
            System.out.println("Engine is already OFF");
        }
    }
    @Override
    public boolean isSwitchedOff(){
        return !this.isOn;
    }
    @Override
    public boolean isSwitchedOn(){
        return this.isOn;
    }
}