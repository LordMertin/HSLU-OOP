package ch.hslu.oop.SW04;

public class Light implements isSwitchable {
    private boolean lightState = false;
    
    @Override
    public void switchOn(){
        if(isSwitchedOff()){
            lightState = true;
            System.out.println("Light is now turned ON");
        }
        else{
            System.out.println("Light is already turned ON");
        }
    }
    @Override
    public void switchOff(){
        if(isSwitchedOn()){
            lightState = true;
            System.out.println("Light is now turned OFF");
        }
        else{
            System.out.println("Light is already turned OFF");
        }
    }
    @Override
    public boolean isSwitchedOff(){
        return !lightState;
    }
    @Override
    public boolean isSwitchedOn(){
        return lightState;
    }
}
