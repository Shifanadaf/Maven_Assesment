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
    public void testDivisionByNonZero() {
        double result = 100.0 / 5;
        assertEquals(20.0, result);
    }

    @Test
    public void testDivisionByZero() {
        Exception exception = assertThrows(ArithmeticException.class, () -> {
            double result = 100.0 / 0; // Force division by zero
        });
        assertEquals("/ by zero", exception.getMessage());
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
    public void testMainMethod() {
        // Simulate user input for prime check and divisor
        String input = "7\n2\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // Capture output
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        // Run main method
        PrimeChecker.main(new String[]{});

        // Validate output
        String output = out.toString();
        assertTrue(output.contains("7 is a prime number."));
        assertTrue(output.contains("Result: 50.0"));
    }

    @Test
    public void testMainMethodDivisionByZero() {
        // Simulate user input for prime check and divisor
        String input = "7\n0\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // Capture output
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        // Run main method
        PrimeChecker.main(new String[]{});

        // Validate output
        String output = out.toString();
        assertTrue(output.contains("7 is a prime number."));
        assertTrue(output.contains("Division by zero is not allowed."));
    }

    @Test
    public void testMainMethodNonPrimeNumber() {
        // Simulate user input for prime check and divisor
        String input = "4\n2\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // Capture output
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        // Run main method
        PrimeChecker.main(new String[]{});

        // Validate output
        String output = out.toString();
        assertTrue(output.contains("4 is not a prime number."));
        assertTrue(output.contains("Result: 50.0"));
    }
}
