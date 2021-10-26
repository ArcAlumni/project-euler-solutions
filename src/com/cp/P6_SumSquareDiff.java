package com.cp;

public class P6_SumSquareDiff {

    public static void main(String[] args) {

        int n = 100;
        long x = ((n) * (n + 1) * ((2 * n) + 1)) / 6;
        long y = ((n) * (n + 1)) / 2;
        y = y * y;
        System.out.println(y - x);
    }

}
