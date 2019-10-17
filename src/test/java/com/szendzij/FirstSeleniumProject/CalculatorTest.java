package com.szendzij.FirstSeleniumProject;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {

    @Test
    public void simpleTest() throws InterruptedException {

//      Given
        int x = 2;
        int y = 2;
        Calculator calc = new Calculator();
//      When
        int result = calc.multiply(x, y);
//      Then
        assertEquals(4, result);
    }
}
