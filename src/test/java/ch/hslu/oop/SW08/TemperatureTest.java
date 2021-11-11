package ch.hslu.oop.SW08;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TemperatureTest {
    @Test
    public void testGetKelvin(){
        assertEquals(0, Float.compare(new Temperature(20).getKelvin(), 293.15f));
    }

    @Test
    public void testGetCelsius(){
        assertEquals(0, Float.compare(new Temperature(20).getCelsius(), 20f));
    }

    @Test
    public void testGetFahrenheit(){
        assertEquals(0, Float.compare(new Temperature(20).getFahrenheit(), 68f));
    }

}