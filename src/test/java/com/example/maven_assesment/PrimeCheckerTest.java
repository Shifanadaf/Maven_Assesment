package com.example.maven_assesment;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

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
    public void testMissingApiKey() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            String apiKey = System.getenv("API_KEY");
            if (apiKey == null || apiKey.isEmpty()) {
                throw new IllegalArgumentException("API key is missing. Set it as an environment variable.");
            }
        });
        assertEquals("API key is missing. Set it as an environment variable.", exception.getMessage());
    }
}
