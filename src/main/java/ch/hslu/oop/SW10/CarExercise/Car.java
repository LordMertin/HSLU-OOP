package ch.hslu.oop.SW10.CarExercise;

import ch.hslu.oop.SW09.MyLogger;

import java.util.logging.Logger;

public class Car implements Switchable {
    private Engine engine;
    private Status status;
    private Light light;

    private static final Logger LOG = Logger.getLogger(MyLogger.class.toString());


    public Car() {
        engine = new Engine();
        light = new Light();

        this.engine.addPropertyChangeListener(e -> LOG.info("Car: Engine changed"));
        this.light.addPropertyChangeListener(e -> LOG.info("Car: Light changed"));

    }

    @Override
    public void switchOn(){
        if(isSwitchedOff()){
            this.status = Status.ON;
            LOG.info("Car is turned ON");
        } else{
            LOG.info("Car already turned ON");
        }
    }
    @Override
    public void switchOff(){
        if(isSwitchedOn()){
            this.status = Status.OFF;
            LOG.info("Car turned OFF");
        } else{
            LOG.info("Car already turned OFF");
        }

    }
    @Override
    public boolean isSwitchedOff(){
        return !(this.status == Status.ON);
    }
    @Override
    public boolean isSwitchedOn(){
        return (this.status == Status.ON);
    }

    public static void main(String[] args) {
        Car car = new Car();
        car.engine.switchOn();
        car.light.switchOn();
    }
}
