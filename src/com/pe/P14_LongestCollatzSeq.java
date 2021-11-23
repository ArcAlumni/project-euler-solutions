package com.pe;

public class P14_LongestCollatzSeq implements Solution {

    int count(long n) {
        return n == 1 ? 1 : (n % 2 == 0 ? count(n / 2) : count(3 * n + 1)) + 1;
    }

    @Override
    public String solve() throws Exception {
        int max = 1;
        long res = 1;
        for (long i = 2; i < 1000000; i++) {
            int c = count(i);
            if (c > max) {
                max = c;
                res = i;
            }
        }

        return String.valueOf(res);
    }

}
