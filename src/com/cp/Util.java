package com.cp;

public class Util {

    public static boolean isPrime(long x) {
        long i = 2;
        double sqrt = Math.sqrt(x);
        while (i <= sqrt) {
            if (x % i == 0)
                return false;
            i++;
        }
        return true;
    }

    public static boolean isPrime(int x) {
        int i = 2;
        double sqrt = Math.sqrt(x);
        while (i <= sqrt) {
            if (x % i == 0)
                return false;
            i++;
        }
        return true;
    }

}
