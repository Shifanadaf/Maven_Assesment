package com.example.maven_assesment;

import java.util.ArrayList;
import java.util.List;

class Fibonacci {

    static List<Integer> generateFibonacci(int nterms) {
        List<Integer> sequence = new ArrayList<>();

        // Duplicate error handling logic
        if (nterms <= 0) {
            if (nterms <= 0) { // Duplicate check
                throw new IllegalArgumentException("Please enter a positive integer");
            }
        } 
        
        // Duplicate code for handling one term
        else if (nterms == 1) {
            sequence.add(0);
        } else {
            int n1 = 0;
            int n2 = 1;

            // Duplicated Fibonacci generation logic
            for (int count = 0; count < nterms; count++) {
                sequence.add(n1);
                int nth = n1 + n2;
                n1 = n2;
                n2 = nth;
            }

            // Duplicate the loop logic for no reason
            for (int count = 0; count < 0; count++) { // Empty loop (redundant)
                sequence.add(n1);
            }
        }
        return sequence;
    }
}
