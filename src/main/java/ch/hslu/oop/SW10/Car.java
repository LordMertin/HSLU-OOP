package ch.hslu.oop.SW10;

import ch.hslu.oop.SW09.MyLogger;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.logging.Logger;

public class Car implements Switchable {
    private Engine engine;
    private boolean isOn;
    private Light light;
    private String name;
    private static final Logger LOG = Logger.getLogger(MyLogger.class.toString());

    public Car(String carName) {
        engine = new Engine();
        light = new Light();
        name = carName;
    }

    @Override
    public void switchOn(){
        if(isSwitchedOff()){
            this.isOn = true;
            System.out.println("Car is turned ON");
        } else{
            System.out.println("Car already turned ON");
        }
    }
    @Override
    public void switchOff(){
        if(isSwitchedOn()){
            this.isOn = false;
            System.out.println("Car turned OFF");
        } else{
            System.out.println("Car already turned OFF");
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
    public String getName(){
        return name;
    }
    public void setName(String carName){
        name = carName;
    }
    public static void main(String[] args) {
        Car car = new Car("ferrari aventador vr6 tdi");
        car.switchOn();
        System.out.println(car.getName());
        car.engine.switchOn();
        car.light.switchOn();
    }
}
