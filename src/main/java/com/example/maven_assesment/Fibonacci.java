package com.example.maven_assesment;

import java.util.ArrayList;
import java.util.List;

class Fibonacci {

    // Method to generate Fibonacci sequence up to the specified number of terms
    static List<Integer> generateFibonacci(int termsCount) {
        List<Integer> fibonacciSequence = new ArrayList<>();
        
        // Validate input to ensure a positive integer is provided
        if (termsCount <= 0) {
            throw new IllegalArgumentException("Input must be a positive integer.");
        } 
        
        // Add the first term if only one term is requested
        if (termsCount == 1) {
            fibonacciSequence.add(0);
            return fibonacciSequence;
        }

        // Initialize the first two Fibonacci numbers
        int first = 0;
        int second = 1;

        // Populate the sequence using a loop
        for (int index = 0; index < termsCount; index++) {
            fibonacciSequence.add(first); // Add the current number to the sequence
            int nextTerm = first + second; // Calculate the next term
            first = second; // Update the first number
            second = nextTerm; // Update the second number
        }

        // Return the generated Fibonacci sequence
        return fibonacciSequence;
    }
