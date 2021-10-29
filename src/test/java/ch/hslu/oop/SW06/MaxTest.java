package ch.hslu.oop.SW06;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxTest {

    @Test
    void returnMax() {
        assertEquals(10, new Max().returnMax(1, 0));
    }
}