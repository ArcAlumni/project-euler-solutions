package com.pe;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

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

    public static void printPrimes(boolean[] primes) {
        for (int i = 2; i < primes.length; i++) {
            if (primes[i]) {
                System.out.print(i + ", ");
            }
        }
        System.out.println();
    }

    public static Path getFile(String filename) {
        return Paths.get(System.getProperty("user.dir") + filename);
    }

    public static boolean[] sievesPrimeArray(int n) {
        if (n > 1000000)
            throw new IllegalArgumentException();
        boolean[] primes = new boolean[n];
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

    public static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

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

    public static <R> List<R> permutationsOf(int[] arr, Function<int[], R> function) {
        List<R> li = new ArrayList<>();
        Arrays.sort(arr);
        permute(arr, 0, li, function);
        return li;
    }

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

    public static int arrayToInt(int[] arr) {
        int n = 0;
        for (int i = 0; i < arr.length; i++) {
            n *= 10;
            n += arr[i];
        }
        return n;
    }

}
