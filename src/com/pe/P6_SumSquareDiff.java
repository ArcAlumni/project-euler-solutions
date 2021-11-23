package com.pe;

public class P6_SumSquareDiff implements Solution {

    @Override
    public String solve() {
        int n = 100;
        long x = ((n) * (n + 1) * ((2 * n) + 1)) / 6;
        long y = ((n) * (n + 1)) / 2;
        y = y * y;
        return String.valueOf(y - x);
    }

}
