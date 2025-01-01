package com.example.maven_assesment;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrimeChecker {

    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static List<Integer> findPrimesUpTo(int limit) {
        List<Integer> primes = new ArrayList<>();
        for (int num = 2; num <= limit; num++) {
            if (isPrime(num)) {
                primes.add(num);
            }
        }
        return primes;
    }

    public static List<Integer> listPrimesInRange(int start, int end) {
        List<Integer> primes = new ArrayList<>();
        for (int num = start; num <= end; num++) {
            if (isPrime(num)) {
                primes.add(num);
            }
        }
        return primes;
    }

    public static String processPrimeCheck(int number) {
        return isPrime(number) 
            ? number + " is a prime number." 
            : number + " is not a prime number.";
    }

    public static double safeDivision(int divisor) {
        if (divisor == 0) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        return 100.0 / divisor;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number to check if it's prime: ");
        int number = scanner.nextInt();
        System.out.println(processPrimeCheck(number));

        System.out.print("Enter a divisor for calculation: ");
        try {
            int divisor = scanner.nextInt();
            System.out.println("Result: " + safeDivision(divisor));
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }

        String apiKey = System.getenv("API_KEY");
        if (apiKey == null || apiKey.isEmpty()) {
            throw new IllegalArgumentException("API key is missing. Set it as an environment variable.");
        }

        scanner.close();
    }
}
