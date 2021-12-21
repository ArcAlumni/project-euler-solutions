package com.pe;

import java.util.Arrays;

public class P117_RGBTiles implements Solution {

    @Override
    public String solve() throws Exception {
        int n = 4, target = 50;
        long[][] mem = new long[n + 1][target + 1];
        for (long[] m : mem)
            Arrays.fill(m, -1);
        return String.valueOf(calc(n, target, mem));
    }

    private long calc(int n, int target, long[][] mem) {
        if (target < 0)
            return Integer.MAX_VALUE;
        if (target == 0)
            return 1;
        if (mem[n][target] == -1) {
            long res = 0;
            for (int i = 1; i <= n; i++) {
                long r = calc(n, target - i, mem);
                if (r != Integer.MAX_VALUE)
                    res += r;
            }
            mem[n][target] = res;
        }
        return mem[n][target];
    }

}
