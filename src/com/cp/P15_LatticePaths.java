package com.cp;

import java.util.Arrays;

public class P15_LatticePaths {

    public static void main(String[] args) {
        int n = 10;
        P15_LatticePaths p = new P15_LatticePaths();
        dp(n);
        dp = new long[n][n];
        for (long[] aa : dp)
            Arrays.fill(aa, -1);
        long res = p.dfs(0, 0, n);
        System.out.println(res);
    }

    static void dp(int n) {
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
        System.out.println(dp[n - 1][n - 1]);
    }

    static long[][] dp;

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

}
