package com.pe;

public class P2_EvenFibonacciSum implements Solution {

    public static void main(String[] args) {
        System.out.println(new P2_EvenFibonacciSum().solve());
    }

    @Override
    public String solve() {
        int max = 4_000_000, prev1 = 1, prev2 = 2, current = 2, sum = 0;
        while (current <= max) {
            if (current % 2 == 0)
                sum += current;
            current = prev1 + prev2;
            prev1 = prev2;
            prev2 = current;
        }
        return String.valueOf(sum);
    }

}
