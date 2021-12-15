package com.pe;

import java.util.*;

public class P92_SquareDigitChains implements Solution {

    public static void main(String[] args) throws Exception {
        new P92_SquareDigitChains().solve();
    }

    @Override
    public String solve() throws Exception {
        HashMap<Integer, Boolean> map = new HashMap<>();
        int c = 0;
        for (int i = 2; i < 10000000; i++) {
            if (map.containsKey(i)) {
                if (map.get(i))
                    c++;
                continue;
            }
            Set<Integer> li = new HashSet<>();
            int j = i;
            while (j != 89 && j != 1 && !li.contains(j)) {
                if (map.containsKey(j)) {
                    j = map.get(j) ? 89 : 1;
                    break;
                }
                li.add(j);
                j = sqSum(j);
            }
            if (j == 89)
                c++;
            for (int x : li) {
                map.put(x, j == 89);
            }
        }
        return String.valueOf(c);
    }

    int sqSum(int i) {
        int sum = 0;
        while (i != 0) {
            int v = i % 10;
            sum += v * v;
            i /= 10;
        }
        return sum;
    }

}
