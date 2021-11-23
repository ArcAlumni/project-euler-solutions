package com.pe;

public class P4_LongestPalindrome implements Solution {

    private boolean isPalindrome(int x) {
        int i = x, y = 0;
        while (i != 0) {
            y *= 10;
            y += i % 10;
            i /= 10;
        }
        return x == y;
    }

    @Override
    public String solve() {
        int max = 0;
        for (int i = 999; i >= 100; i--) {
            for (int j = 999; j >= 100; j--) {
                if (isPalindrome(i * j)) {
                    max = Math.max(i * j, max);
                }
            }
        }
        return String.valueOf(max);
    }

}
