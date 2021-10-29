package com.cp;

public class P16_PowerDigitSum {

    public static void main(String[] args) {
        String val = "1";
        int i = 1;
        while (i <= 1000) {
            val = multiplyBy2(val);
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

    static String multiplyBy2(String num) {
        StringBuilder sb = new StringBuilder();
        int i = num.length() - 1;
        int carry = 0;
        while (i >= 0) {
            int sum = ((num.charAt(i) - '0') * 2) + carry;
            sb.append(sum % 10);
            carry = sum / 10;
            i--;
        }
        if (carry > 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }

}
