package com.pe;

public class P7_10001Prime {

    public static void main(String[] args) {

        long i = 2, c = 0, nth = 10001;
        while (true) {
            if (Util.isPrime(i)) {
                c++;
                if (c == nth) {
                    System.out.println(i);
                    break;
                }
            }
            i++;
        }

    }

}
