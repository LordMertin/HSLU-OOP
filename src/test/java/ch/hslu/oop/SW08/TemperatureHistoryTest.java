package ch.hslu.oop.SW08;

import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TemperatureHistoryTest {
    private TemperatureHistory temperatureHistory;

    @BeforeEach
    public void setup() {
        temperatureHistory = new TemperatureHistory();
        temperatureHistory.add(new Temperature(0f));
    }

    @Test
    public void testAdd() {
        temperatureHistory.add(new Temperature(1f));
        assertEquals(2, temperatureHistory.getCount());
    }

    @Test
    public void testClear() {
        temperatureHistory.clear();
        assertEquals(0, temperatureHistory.getCount());
    }

    @Test
    public void testGetCount() {
        temperatureHistory.add(new Temperature(40f));
        assertEquals(2, temperatureHistory.getCount(), 0);
    }

    @Test
    public void testGetMax() {
        temperatureHistory.add(new Temperature(2f));
        assertEquals(2f, temperatureHistory.getHighest(), 0);
    }


    @Test
    public void testGetFloatMax() {
        temperatureHistory.add(new Temperature(Float.MAX_VALUE));
        assertEquals(Float.MAX_VALUE, temperatureHistory.getHighest(), 0);
    }

    @Test
    public void testGetMaxNoValues() {
        temperatureHistory.clear();
        assertEquals(-Float.MAX_VALUE, temperatureHistory.getHighest(), 0);
    }

    @Test
    public void testGetMin() {
        temperatureHistory.add(new Temperature(-1f));
        assertEquals(-1f, temperatureHistory.getLowest(), 0);
    }

    @Test
    public void testCalcAverageTemperature() {
        temperatureHistory.add(new Temperature(100f));
        assertEquals(50f, temperatureHistory.getAverage(), 0);
    }

}