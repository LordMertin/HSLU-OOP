package ch.hslu.oop.SW09;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TemperatureTest {
    @Test
    public void testGetKelvin(){
        assertEquals(0, Float.compare(Temperature.createFromCelsius(20).getKelvin(), 293.15f));
    }

    @Test
    public void testGetCelsius(){
        assertEquals(0, Float.compare(Temperature.createFromCelsius(20).getCelsius(), 20f));
    }

    @Test
    public void testGetFahrenheit(){
        assertEquals(0, Float.compare(Temperature.createFromCelsius(20).getFahrenheit(), 68f));
    }

    //equalsVerifier
    @Test
    public void testEqualsVerifier(){
        EqualsVerifier.forClass(Temperature.class).suppress(Warning.NONFINAL_FIELDS).verify();
    }

    //equals
    @Test
    public void testEqualsTrue() {
        assertTrue(Temperature.createFromCelsius(12.34f).equals(Temperature.createFromCelsius(12.34f)));
    }

    @Test
    public void testEqualsFalse() {
        assertFalse(Temperature.createFromCelsius(12.34f).equals(Temperature.createFromCelsius(12.35f)));
    }

    //hashCode
    @Test
    public void testHashEquals() {
        assertEquals(Temperature.createFromCelsius(24f).hashCode(), Temperature.createFromCelsius(24f).hashCode());
    }

    @Test
    public void testHashNotEquals() {
        assertNotEquals(Temperature.createFromCelsius(24.01f).hashCode(), Temperature.createFromCelsius(24.009f).hashCode());
    }

    //compareTo
    @Test
    public void testCompareToTrue() {
        assertEquals(0, Temperature.createFromCelsius(22f).compareTo(Temperature.createFromCelsius(22f)));
    }

    @Test
    public void testCompareToHigher() {
        assertEquals(1, Temperature.createFromCelsius(24f).compareTo(Temperature.createFromCelsius(16f)));
    }

    @Test
    public void testCompareToLower() {
        assertEquals(-1, Temperature.createFromCelsius(10f).compareTo(Temperature.createFromCelsius(20f)));
    }

    @Test
    public void testToString(){
        Temperature temp = Temperature.createFromCelsius(20f);
        assertEquals("Temperature{kelvin=" + temp.getKelvin()+ ", celsius=" + temp.getCelsius() + ", fahrenheit=" + temp.getFahrenheit() + "}", temp.toString());
    }
    @Test
    public void testTooLowTemp(){
        assertThrows(IllegalArgumentException.class, () -> {
            Temperature.createFromKelvin(-1);
        });
    }

}