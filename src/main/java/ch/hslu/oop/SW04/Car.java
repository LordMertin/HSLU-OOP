package ch.hslu.oop.SW04;

public class Car implements isSwitchable{
    private Engine engine;
    private boolean runningState;
    private Light light;
    private String name;

    public Car(String carName) {
        engine = new Engine();
        light = new Light();
        name = carName;
    }

    @Override
    public void switchOn(){
        if(isSwitchedOff()){
            this.runningState = true;
            System.out.println("Car is turned ON");
        } else{
            System.out.println("Car already turned ON");
        }
    }
    @Override
    public void switchOff(){
        if(isSwitchedOn()){
            this.runningState = false;
            System.out.println("Car turned OFF");
        } else{
            System.out.println("Car already turned OFF");
        }

    }
    @Override
    public boolean isSwitchedOff(){
        return !runningState;
    }
    @Override
    public boolean isSwitchedOn(){
        return runningState;
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
