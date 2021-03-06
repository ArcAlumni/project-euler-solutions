package com.pe;

import java.util.Arrays;

public class P31_CoinSums implements Solution {

    private int[][] dp;

    private int rec(int[] coins, int target, int idx) {
        if (target == 0) {
            return 1;
        }
        if (target < 0) {
            return -1;
        }
        if (dp[target][idx] != Integer.MAX_VALUE) {
            return dp[target][idx];
        }
        int res = 0;
        for (int i = idx; i < coins.length; i++) {
            int r = rec(coins, target - coins[i], i);
            if (r != -1) {
                res += r;
            }
        }
        return dp[target][idx] = res;
    }

    @Override
    public String solve() throws Exception {
        int[] coins = new int[] { 1, 2, 5, 10, 20, 50, 100, 200 };
        int target = 200;
        dp = new int[target + 1][coins.length];
        for (int[] a : dp)
            Arrays.fill(a, Integer.MAX_VALUE);
        long c = rec(coins, target, 0);
        return String.valueOf(c);
    }

}
