package com.example.maven_assesment;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

public class PrimeCheckerTest {

    @Test
    public void testIsPrime() {
        assertTrue(PrimeChecker.isPrime(2));
        assertTrue(PrimeChecker.isPrime(3));
        assertFalse(PrimeChecker.isPrime(4));
        assertTrue(PrimeChecker.isPrime(5));
        assertFalse(PrimeChecker.isPrime(1));
    }

    @Test
    public void testFindPrimesUpTo() {
        List<Integer> primes = PrimeChecker.findPrimesUpTo(10);
        assertEquals(List.of(2, 3, 5, 7), primes);
    }

    @Test
    public void testListPrimesInRange() {
        List<Integer> primes = PrimeChecker.listPrimesInRange(5, 15);
        assertEquals(List.of(5, 7, 11, 13), primes);
    }

    @Test
    public void testProcessPrimeCheck() {
        assertEquals("7 is a prime number.", PrimeChecker.processPrimeCheck(7));
        assertEquals("9 is not a prime number.", PrimeChecker.processPrimeCheck(9));
    }

    @Test
    public void testSafeDivision() {
        assertEquals(20.0, PrimeChecker.safeDivision(5));
        Exception exception = assertThrows(ArithmeticException.class, () -> {
            PrimeChecker.safeDivision(0);
        });
        assertEquals("Division by zero is not allowed.", exception.getMessage());
    }

    @Test
    public void testMissingApiKey() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            String apiKey = System.getenv("API_KEY");
            if (apiKey == null || apiKey.isEmpty()) {
                throw new IllegalArgumentException("API key is missing. Set it as an environment variable.");
            }
        });
        assertEquals("API key is missing. Set it as an environment variable.", exception.getMessage());
    }

    @Test
    public void testMainFunction() {
        // Mock user input
        String input = "7\n5\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // Capture console output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Run the main function
        PrimeChecker.main(new String[]{});

        String output = outputStream.toString();

        // Verify output
        assertTrue(output.contains("7 is a prime number."));
        assertTrue(output.contains("Result: 20.0"));
    }
}
