package com.cp;

import java.util.Arrays;
import java.util.List;

public class P34_DigitFactorials {

    public static void main(String[] args) {

        factArr = new int[10];
        factArr[0] = 1;
        for (int i = 1; i < 10; i++) {
            factArr[i] = (int) Util.factorialOf(i);
        }

        System.out.println(Arrays.toString(factArr));
        int i = 11;
        int sum = 0;
        while (i < 9999999) {
            if (isFactDigitsSumEqual(i)) {
                sum += i;
            }
            i++;
        }

        System.out.println(sum);
        // rec(factArr, 1, new ArrayList<>(), "0");
    }

    static int[] bArr = new int[10];
    static int maxDigit = 100;

    static void rec(int[] arr, int idx, List<Integer> li, String sum) {
        if (isContentEqual(sum)) {
            System.out.println(sum);
        }
        if (idx == arr.length) {
            return;
        }
        if (li.size() > maxDigit) {
            return;
        }
        for (int i = idx; i < arr.length; i++) {
            li.add(i);
            bArr[i]++;
            rec(arr, i, li, Util.add(sum, String.valueOf(arr[i])));
            li.remove(li.size() - 1);
            bArr[i]--;
        }
    }

    static int[] factArr;

    static boolean isContentEqual(String s) {
        if (s.length() < 2) {
            return false;
        }
        int[] arr = Arrays.copyOf(bArr, bArr.length);
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - '0']--;
            if (arr[s.charAt(i) - '0'] < 0) {
                return false;
            }
        }
        for (int x : arr) {
            if (x != 0) {
                return false;
            }
        }
        return true;
    }

    static boolean isFactDigitsSumEqual(int n) {
        int i = n;
        int sum = 0;
        while (n != 0) {
            sum += factArr[n % 10];
            n /= 10;
        }
        return i == sum;
    }

}
