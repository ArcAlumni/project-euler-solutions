package com.pe;

public class P25_1000DigitFibonacci implements Solution {

    @Override
    public String solve() throws Exception {
        String prev1 = "1", prev2 = "1", next = "2";
        int idx = 3;
        while (true) {
            next = Util.add(prev1, prev2);
            if (next.length() >= 1000) {
                break;
            }
            prev1 = prev2;
            prev2 = next;
            idx++;
        }
        return String.valueOf(idx);
    }

}
