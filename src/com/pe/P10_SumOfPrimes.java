package com.pe;

public class P10_SumOfPrimes implements Solution {

    @Override
    public String solve() throws Exception {
        long sum = 0;
        for (int i = 2; i < 2000000; i++) {
            if (Util.isPrime(i)) {
                sum += i;
            }
        }
        return String.valueOf(sum);
    }

}
