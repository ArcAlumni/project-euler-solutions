package com.pe;

import java.util.Arrays;

public class P15_LatticePaths implements Solution {

    public static void main(String[] args) throws Exception {
        System.out.println(new P15_LatticePaths().solve());
    }

    String dp(int n) {
        dp = new long[n][n];
        Arrays.fill(dp[0], 1);
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return String.valueOf(dp[n - 1][n - 1]);
    }

    long[][] dp;

    long dfs(int i, int j, int n) {
        if (i == n || j == n || i < 0 || j < 0) {
            return 0;
        }
        if (i == n - 1 && j == n - 1) {
            return 1;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        long r1 = dfs(i + 1, j, n);
        long r2 = dfs(i, j + 1, n);
        return dp[i][j] = r1 + r2;
    }

    @Override
    public String solve() throws Exception {
        int n = 21;
        return dp(n);
        // dp = new long[n][n];
        // for (long[] aa : dp)
        // Arrays.fill(aa, -1);
        // long res = dfs(0, 0, n);
        // return String.valueOf(res);
    }

}
