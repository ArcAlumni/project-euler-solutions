package com.pe;

public class P3_LargestPrimeFactor implements Solution {

    public static void main(String[] args) {
        System.out.println(new P3_LargestPrimeFactor().solve());
    }

    @Override
    public String solve() {
        long val = 600851475143l;
        long i = Util.sqrt(val);
        while (i > 1) {
            if (val % i == 0 && Util.isPrime(i))
                break;
            i--;
        }
        return String.valueOf(i);
    }

}
