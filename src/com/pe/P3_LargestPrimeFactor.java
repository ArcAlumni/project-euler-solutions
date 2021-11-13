package com.pe;

public class P3_LargestPrimeFactor {

    public static void main(String[] args) {
        long val = 600851475143l;
        long i = sqrt(val);
        while (i > 1) {
            if (val % i == 0 && Util.isPrime(i))
                break;
            i--;
        }
        System.out.println(i);
    }

    public static long sqrt(long num) {
        long t, sqrt = num / 2;
        do {
            t = sqrt;
            sqrt = (t + (num / t)) / 2;
        }
        while (t != sqrt);
        return sqrt;
    }

}
