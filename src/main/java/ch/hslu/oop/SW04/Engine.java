package ch.hslu.oop.SW04;

public class Engine implements isSwitchable{
    private boolean runningState = false;
    private int rpm = 0;

    @Override
    public void switchOn(){
        if(isSwitchedOff()){
            this.rpm = 800;
            this.runningState = true;
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
            this.runningState = false;
            System.out.println("Engine turned OFF.");
        } else {
            System.out.println("Engine is already OFF");
        }
    }
    @Override
    public boolean isSwitchedOff(){
        return !this.runningState;
    }
    @Override
    public boolean isSwitchedOn(){
        return this.runningState;
    }
}