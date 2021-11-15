package ch.hslu.oop.SW08;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
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

    //equalsVerifier
    @Test
    public void testEqualsVerifier(){
        EqualsVerifier.forClass(Temperature.class).suppress(Warning.NONFINAL_FIELDS).verify();
    }

    //equals
    @Test
    public void testEqualsTrue() {
        assertTrue(new Temperature(12.34f).equals(new Temperature(12.34f)));
    }

    @Test
    public void testEqualsFalse() {
        assertFalse(new Temperature(12.34f).equals(new Temperature(12.35f)));
    }

    //hashCode
    @Test
    public void testHashEquals() {
        assertEquals(new Temperature(24f).hashCode(), new Temperature(24f).hashCode());
    }

    @Test
    public void testHashNotEquals() {
        assertNotEquals(new Temperature(24.01f).hashCode(), new Temperature(24.009f).hashCode());
    }

    //compareTo
    @Test
    public void testCompareToTrue() {
        assertEquals(0, new Temperature(22f).compareTo(new Temperature(22f)));
    }

    @Test
    public void testCompareToHigher() {
        assertEquals(1, new Temperature(24f).compareTo(new Temperature(16f)));
    }

    @Test
    public void testCompareToLower() {
        assertEquals(-1, new Temperature(10f).compareTo(new Temperature(20f)));
    }

}