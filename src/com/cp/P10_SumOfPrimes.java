package com.cp;

public class P10_SumOfPrimes {

    public static void main(String[] args) {
        long sum = 0;
        for (int i = 2; i < 2000000; i++) {
            if (Util.isPrime(i)) {
                sum += i;
            }
        }
        System.out.println(sum);
    }

}
