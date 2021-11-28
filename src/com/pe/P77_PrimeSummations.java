package com.pe;

import java.util.Arrays;
import java.util.List;

public class P77_PrimeSummations implements Solution {

    @Override
    public String solve() throws Exception {
        List<Integer> primes = Util.getPrimesLessThan(100);
        int start = 1, end = 100, res = -1;
        while (start <= end) {
            int x = (start + end) / 2;
            int[][] dp = new int[x + 1][x + 1];
            for (int[] arr : dp)
                Arrays.fill(arr, -1);
            if (rec(x, primes, 0, dp) <= 5000) {
                start = x + 1;
            } else {
                res = x;
                end = x - 1;
            }
        }
        return String.valueOf(res);
    }

    private int rec(int n, List<Integer> primes, int idx, int[][] dp) {
        if (n <= 0)
            return n == 0 ? 1 : 0;
        if (dp[n][idx] != -1)
            return dp[n][idx];
        int ways = 0;
        for (int i = idx; i < primes.size(); i++) {
            if (primes.get(i) > n)
                return ways;
            ways += rec(n - primes.get(i), primes, i, dp);
        }
        dp[n][idx] = ways;
        return ways;
    }

}
