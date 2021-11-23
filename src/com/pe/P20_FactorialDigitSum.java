package com.pe;

public class P20_FactorialDigitSum implements Solution {

    @Override
    public String solve() throws Exception {
        String num = "1";
        for (int i = 100; i >= 2; i--) {
            num = Util.multiply(num, String.valueOf(i));
        }
        long sum = 0;
        for (int i = 0; i < num.length(); i++) {
            sum += (num.charAt(i) - '0');
        }
        return String.valueOf(sum);
    }

}
