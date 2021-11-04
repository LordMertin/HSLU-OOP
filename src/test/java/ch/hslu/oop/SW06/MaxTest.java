package ch.hslu.oop.SW06;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxTest {

    @Test
    public void testMax() {
        assertEquals(1, new Max().returnMax(1,0));
    }

    @Test
    public void testFirst() {
        assertEquals(2, new Max().returnMax(2,0));
    }

    @Test
    public void testSecond() {
        assertEquals(3, new Max().returnMax(0,3));
    }

    @Test
    public void testSame() {
        assertEquals(4, new Max().returnMax(4,4));
    }

    @Test
    public void testMaxInteger(){
        assertEquals(Integer.MAX_VALUE, new Max().returnMax(Integer.MAX_VALUE,0));
    }
}