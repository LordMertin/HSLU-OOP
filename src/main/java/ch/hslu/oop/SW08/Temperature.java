package ch.hslu.oop.SW08;

import java.util.Objects;

public final class Temperature implements Comparable<Temperature> {
    private float kelvin;
    private static final float kelvinOffset = 273.15f;

    public Temperature(float celsius){
        kelvin = convertCelsiusToKelvin(celsius);
    }

    public Temperature(Temperature temperature){
        kelvin = temperature.getKelvin();
    }

    public void setCelsius(float celsius){
        kelvin = convertCelsiusToKelvin(celsius);
    }

    public void setKelvin(float kelvin){
        this.kelvin = kelvin;
    }

    public void setFahrenheit(float fahrenheit){
        kelvin = convertFahrenheitToKelvin(fahrenheit);
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
        Temperature temperature = new Temperature(20);
        System.out.println(temperature);
    }
}