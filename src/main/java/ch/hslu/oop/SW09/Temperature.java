package ch.hslu.oop.SW09;

import java.util.Objects;
import java.util.Scanner;

public final class Temperature implements Comparable<Temperature> {
    private float kelvin;
    private static final float kelvinOffset = 273.15f;

    private Temperature(float kelvin){
        this.kelvin = kelvin;
    }

    public Temperature(Temperature temperature){
        kelvin = temperature.getKelvin();
    }

    public static Temperature createFromCelsius(final float celsius){
        if (convertCelsiusToKelvin(celsius) < 0) {
            throw new IllegalArgumentException();
        }
        return new Temperature(convertCelsiusToKelvin(celsius));
    }

    public static Temperature createFromKelvin(final float kelvin){
        if (kelvin < 0) {
            throw new IllegalArgumentException();
        }
        return new Temperature(kelvin);
    }

    public float getCelsius(){
        return convertKelvinToCelsius(this.getKelvin());
    }

    public float getKelvin(){
        return this.kelvin;
    }

    public float getFahrenheit(){
        return convertKelvinToFahrenheit(this.getKelvin());
    }

    @Override
        public String toString() {
        return "Temperature{" +
                "kelvin=" + kelvin +
                ", celsius=" + getCelsius() +
                ", fahrenheit=" + getFahrenheit() +
                '}';
    }

    public int compareTo(Temperature other) {
        return Float.compare(this.kelvin, other.kelvin);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof final Temperature temperature)){
            return false;
        }

        return Float.compare(temperature.kelvin, this.kelvin) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(kelvin);
    }

    public static float convertKelvinToCelsius(float kelvin){
        return kelvin - kelvinOffset;
    }

    public static float convertCelsiusToKelvin(float celsius){
        return celsius + kelvinOffset;
    }

    public static float convertFahrenheitToKelvin(float fahrenheit){
        return (fahrenheit - 32) * 1.8f + kelvinOffset;
    }

    public static float convertKelvinToFahrenheit(float kelvin){
        return (kelvin - kelvinOffset) * 1.8f + 32;
    }

    public static void main(String[] args) {

        try {
            Temperature t = Temperature.createFromKelvin(-1);
            System.out.println(t);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}