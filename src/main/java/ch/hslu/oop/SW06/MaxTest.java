package ch.hslu.oop.SW06;

import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxTest {

    @Test
    public static aBigger(){
        Max max = new Max();
        int a = 10;
        int b = 5;
        max.returnMax(a, b);
    }
}