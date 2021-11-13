package com.pe;

public class P20_FactorialDigitSum {

    public static void main(String[] args) {
        String num = "1";
        for (int i = 100; i >= 2; i--) {
            num = Util.multiply(num, String.valueOf(i));
        }
        long sum = 0;
        for (int i = 0; i < num.length(); i++) {
            sum += (num.charAt(i) - '0');
        }
        System.out.println(sum);
    }

}
