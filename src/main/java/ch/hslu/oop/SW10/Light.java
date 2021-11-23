package ch.hslu.oop.SW10;

public class Light implements Switchable {
    private boolean isOn = false;
    
    @Override
    public void switchOn(){
        if(isSwitchedOff()){
            isOn = true;
            System.out.println("Light is now turned ON");
        }
        else{
            System.out.println("Light is already turned ON");
        }
    }
    @Override
    public void switchOff(){
        if(isSwitchedOn()){
            isOn = true;
            System.out.println("Light is now turned OFF");
        }
        else{
            System.out.println("Light is already turned OFF");
        }
    }
    @Override
    public boolean isSwitchedOff(){
        return !isOn;
    }
    @Override
    public boolean isSwitchedOn(){
        return isOn;
    }
}
