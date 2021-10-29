package com.cp;

public class P14_LongestCollatzSeq {

    public static void main(String[] args) {

        int max = 1;
        long res = 1;
        long time = System.currentTimeMillis();
        for (long i = 2; i < 1000000; i++) {
            int c = count(i);
            if (c > max) {
                max = c;
                res = i;
            }
        }

        System.out.println(res + " time taken " + (System.currentTimeMillis() - time));
    }

    static int count(long n) {
        return n == 1 ? 1 : (n % 2 == 0 ? count(n / 2) : count(3 * n + 1)) + 1;
    }

}
