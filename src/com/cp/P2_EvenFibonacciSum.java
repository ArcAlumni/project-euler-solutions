package com.cp;

public class P2_EvenFibonacciSum {

    public static void main(String[] args) {
        int max = 4_000_000, prev1 = 1, prev2 = 2, current = 2, sum = 0;
        while (current <= max) {
            if (current % 2 == 0)
                sum += current;
            current = prev1 + prev2;
            prev1 = prev2;
            prev2 = current;
        }
        System.out.println(sum);
    }

}
