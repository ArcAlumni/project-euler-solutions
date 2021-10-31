package com.cp;

public class P16_PowerDigitSum {

    public static void main(String[] args) {
        String val = "1";
        int i = 1;
        while (i <= 1000) {
            val = Util.multiply(val, "2");
            i++;
        }
        int sum = 0;
        i = 0;
        while (i < val.length()) {
            sum += val.charAt(i) - '0';
            i++;
        }
        System.out.println(sum);
    }

}
