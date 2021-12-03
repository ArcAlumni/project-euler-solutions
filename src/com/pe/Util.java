package com.pe;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Util {

    /**
     * Primality of number
     *
     * @param x
     * @return boolean true when number is prime
     */
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

    /**
     * Square root of a number
     *
     * @param num
     * @return
     */
    public static long sqrt(long num) {
        long t, sqrt = num / 2;
        do {
            t = sqrt;
            sqrt = (t + (num / t)) / 2;
        } while (t != sqrt);
        return sqrt;
    }

    /**
     * Primality of number
     *
     * @param x
     * @return boolean true when number is prime
     */
    public static boolean isPrime(int x) {
        return isPrime((long) x);
    }

    /**
     * Multiply two number strings
     *
     * @param num
     * @param n
     * @return product {@link StringBuilder}
     */
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

    /**
     * To add number two strings
     *
     * @param x
     * @param y
     * @return sum string
     */
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

    /**
     * To multiply two number strings
     *
     * @param x
     * @param y
     * @return product string
     */
    public static String multiply(String x, String y) {
        String res = "0";
        StringBuilder pow = new StringBuilder();
        for (int j = y.length() - 1; j >= 0; j--) {
            res = add(multiplyBy(x, y.charAt(j)).append(pow).toString(), res);
            pow.append("0");
        }
        return res;
    }

    /**
     * To get factorial of number
     *
     * @param n
     * @return
     */
    public static long factorialOf(int n) {
        long res = 1;
        for (int i = 2; i <= n; i++) {
            res *= i;
        }
        return res;
    }

    public static void printPrimes(boolean[] primes) {
        for (int i = 2; i < primes.length; i++) {
            if (primes[i]) {
                System.out.print(i + ", ");
            }
        }
        System.out.println();
    }

    public static Path getFile(String filename) {
        return Paths.get(System.getProperty("user.dir") + "/src/resources/" + filename);
    }

    /**
     * To get prime numbers less than or equal to n using Sieve of eratosthenes
     *
     * @param n
     * @return boolean array where true index represents the index is prime
     */
    public static boolean[] sievesPrimeArray(int n) {
        boolean[] primes = new boolean[n + 1];
        Arrays.fill(primes, true);
        primes[0] = false;
        primes[1] = false;
        for (int i = 2; i * i < primes.length; i++) {
            if (!primes[i])
                continue;
            for (int j = 2; i * j < primes.length; j++)
                primes[i * j] = false;
        }
        return primes;
    }

    /**
     * To get all prime numbers less than n
     *
     * @param n
     * @return
     */
    public static List<Integer> getPrimesLessThan(int n) {
        boolean[] primes = Util.sievesPrimeArray(n);
        List<Integer> li = new ArrayList<>();
        for (int i = 2; i < n; i++) {
            if (primes[i])
                li.add(i);
        }
        return li;
    }

    /**
     * To get length of integer
     *
     * @param n
     * @return
     */
    public static int lenOf(int n) {
        int len = 0;
        while (n != 0) {
            len++;
            n /= 10;
        }
        return len;
    }

    public static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    /**
     * To permute integers in array arr
     *
     * @param arr
     * @param idx
     * @param li
     * @param function
     * @param <T>
     * @param <R>
     */
    private static <T, R> void permute(int[] arr, int idx, List<R> li, Function<int[], R> function) {
        if (idx == arr.length) {
            li.add(function.apply(Arrays.copyOf(arr, arr.length)));
            return;
        }
        for (int i = idx; i < arr.length; i++) {
            if (i < arr.length - 1 && arr[i + 1] == arr[i])
                continue;
            Util.swap(arr, i, idx);
            permute(arr, idx + 1, li, function);
            Util.swap(arr, i, idx);
        }
    }

    /**
     * To permute integers in array
     *
     * @param arr
     * @param function
     * @param <R>
     * @return
     */
    public static <R> List<R> permutationsOf(int[] arr, Function<int[], R> function) {
        List<R> li = new ArrayList<>();
        Arrays.sort(arr);
        permute(arr, 0, li, function);
        return li;
    }

    /**
     * To convert integer to array
     *
     * @param n
     * @param len
     * @return
     */
    public static int[] intToArray(int n, int len) {
        if (len == -1) {
            len = 0;
            int i = n;
            while (i != 0) {
                len++;
                i /= 10;
            }
        }
        int[] arr = new int[len];
        int idx = 0;
        while (n != 0) {
            arr[idx++] = n % 10;
            n /= 10;
        }
        return arr;
    }

    /**
     * To convert array to integer
     *
     * @param arr
     * @return
     */
    public static int arrayToInt(int[] arr) {
        int n = 0;
        for (int i = 0; i < arr.length; i++) {
            n *= 10;
            n += arr[i];
        }
        return n;
    }

    /**
     * To convert list to integer
     *
     * @param li
     * @return
     */
    public static long listToLong(List<Integer> li) {
        long n = 0;
        for (int i = 0; i < li.size(); i++) {
            n *= 10;
            n += li.get(i);
        }
        return n;
    }

    /**
     * To get power of number string using binary exponentiation
     *
     * @param baseStr
     * @param exp
     * @return
     */
    public static String pow(String baseStr, int exp) {
        if (exp == 0 || baseStr.equals("1"))
            return "1";
        if (exp == 1)
            return baseStr;
        if (exp == 2)
            return Util.multiply(baseStr, baseStr);
        String res = pow(baseStr, exp / 2);
        res = Util.multiply(res, res);
        if (exp % 2 != 0)
            res = Util.multiply(res, baseStr);
        return res;
    }

    /**
     * To get sum of digits of number string
     *
     * @param num
     * @return
     */
    public static String digitsSumOf(String num) {
        String res = "0";
        for (int i = 0; i < num.length(); i++)
            res = Util.add(res, String.valueOf(num.charAt(i)));
        return res;
    }

    public static int compare(String num1, String num2) {
        if (num1.length() > num2.length()) {
            return 1;
        } else if (num2.length() > num1.length()) {
            return -1;
        } else {
            return num1.compareTo(num2);
        }
    }

}
