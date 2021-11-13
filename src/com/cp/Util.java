package com.cp;

public class Util {

    public static boolean isPrime(long x) {
        long i = 2;
        double sqrt = Math.sqrt(x);
        while (i <= sqrt) {
            if (x % i == 0)
                return false;
            i++;
        }
        return true;
    }

    public static boolean isPrime(int x) {
        return isPrime((long) x);
    }

    private static StringBuilder multiplyBy(String num, char n) {
        StringBuilder sb = new StringBuilder();
        int m = n - '0';
        int i = num.length() - 1;
        int carry = 0;
        while (i >= 0) {
            int sum = ((num.charAt(i) - '0') * m) + carry;
            sb.append(sum % 10);
            carry = sum / 10;
            i--;
        }
        if (carry > 0)
            sb.append(carry);
        return sb.reverse();
    }

    public static String add(String x, String y) {
        int len = Math.max(x.length(), y.length());
        if (x.length() < len) {
            x = new StringBuilder().append("0".repeat(len - x.length())).append(x).toString();
        } else if (y.length() < len) {
            y = new StringBuilder().append("0".repeat(len - y.length())).append(y).toString();
        }
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for (int i = len - 1; i >= 0; i--) {
            int sum = (x.charAt(i) - '0') + (y.charAt(i) - '0') + carry;
            sb.append(sum % 10);
            carry = sum / 10;
        }
        if (carry > 0)
            sb.append(carry);
        return sb.reverse().toString();
    }

    public static String multiply(String x, String y) {
        String res = "0";
        StringBuilder pow = new StringBuilder();
        for (int j = y.length() - 1; j >= 0; j--) {
            res = add(multiplyBy(x, y.charAt(j)).append(pow).toString(), res);
            pow.append("0");
        }
        return res;
    }

    public static long factorialOf(int n) {
        long res = 1;
        for (int i = 2; i <= n; i++) {
            res *= i;
        }
        return res;
    }

    public static void printPrimes(boolean[] nonPrimes) {
        for (int i = 2; i < nonPrimes.length; i++) {
            if (!nonPrimes[i]) {
                System.out.print(i + ", ");
            }
        }
        System.out.println();
    }

}
