package com.pe;

public class P21_AmicableNumbers implements Solution {

    @Override
    public String solve() throws Exception {
        boolean[] divisorSums = new boolean[10000];
        long res = 0;
        for (int n = 1; n < 10000; n++) {
            if (divisorSums[n]) {
                continue;
            }
            int sum = getDivisorSum(n);
            if (sum == n || sum >= 10000 || sum == 1) {
                continue;
            }
            divisorSums[n] = true;
            int nextSum = getDivisorSum(sum);
            divisorSums[sum] = true;
            if (n == nextSum) {
                res += sum;
                res += n;
            }
        }
        return String.valueOf(res);
    }

    int getDivisorSum(int n) {
        int sum = 1;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                sum += i;
                sum += (n / i);
            }
        }
        return sum;
    }

}
