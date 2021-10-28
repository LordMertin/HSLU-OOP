package ch.hslu.oop.SW06;

import ch.hslu.oop.SW04.isSwitchable;

public class Demo implements isSwitchable {
    private int x, y;
    private String name;
    boolean isOn;

    public Demo(int x, int y, String name){
        this.x = x;
        this.y = y;
        this.name = name;
        isOn = false;
    }

    public void switchOn(){
        isOn = true;
    }
    public void switchOff(){
        isOn = false;
    }
    public boolean isSwitchedOn(){
        return isOn;
    }
    public boolean isSwitchedOff(){
        return !isOn;
    }
    public String getDemoInfo(){
        return this.x + this.y + this.name + " Cool demo";
    }

    public static void main(String[] args) {
        Demo demo = new Demo(1,2, "Demo1");
        isSwitchable switchable = demo;

        switchable.switchOn();
        ((Demo)switchable).getDemoInfo();
    }

}
