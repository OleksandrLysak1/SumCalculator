package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class SumCalculatorTest {

    private SumCalculator sumCalculator;

    @BeforeEach
    void setUp() {
        sumCalculator = new SumCalculator();
    }

    @Test
    void testSumWithPositiveInteger() {
        assertEquals(1, sumCalculator.sum(1));
        assertEquals(6, sumCalculator.sum(3));
    }

    @Test
    void testSumWithInvalidInput() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            sumCalculator.sum(0);
        });
        assertEquals("n must be greater than or equal to 1", exception.getMessage());
    }

    @Test
    void testMainWithValidInput() {
        String input = "5\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        SumCalculator.main(null);

        String expectedOutput = "Enter a positive integer: The sum from 1 to 5 is: 15";
        assertTrue(out.toString().trim().contains(expectedOutput));
    }

    @Test
    void testMainWithInvalidInput() {
        String input = "0\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        SumCalculator.main(null);

        String expectedOutput = "Enter a positive integer: n must be greater than or equal to 1";
        assertTrue(out.toString().trim().contains(expectedOutput));
    }
}
