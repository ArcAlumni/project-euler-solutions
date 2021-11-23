package com.pe;

import java.util.Arrays;

public class P76_CountingSummations implements Solution {

    private int ways(int n, int idx, int[][] dp) {
        if (n <= 0)
            return n == 0 ? 1 : 0;
        if (dp[n][idx] != -1)
            return dp[n][idx];
        int res = 0;
        for (int i = idx; i <= n; i++)
            res += ways(n - i, i, dp);
        return dp[n][idx] = res;
    }

    @Override
    public String solve() throws Exception {
        int n = 100;
        int[][] dp = new int[n + 1][n + 1];
        for (int[] arr : dp)
            Arrays.fill(arr, -1);
        return String.valueOf(ways(n, 1, dp) - 1);
    }

}
