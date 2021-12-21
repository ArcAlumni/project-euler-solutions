package com.pe;

public class P48_SelfPowers implements Solution {

    public static void main(String[] args) throws Exception {
        System.out.println(new P48_SelfPowers().solve());
    }

    @Override
    public String solve() throws Exception {
        long pow = 0, mod = 10000000000l;
        for (long i = 1; i <= 1000; ++i) {
            long temp = i;
            for (long j = 1; j < i; ++j) {
                temp *= i;
                temp = temp % mod;
            }
            pow += temp;
            pow %= mod;
        }
        return String.valueOf(pow);
    }

}
