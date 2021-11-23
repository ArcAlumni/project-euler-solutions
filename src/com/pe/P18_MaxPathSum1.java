package com.pe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P18_MaxPathSum1 implements Solution {

    @Override
    public String solve() throws Exception {
        List<List<Integer>> li = new ArrayList<>();
        li.add(Arrays.asList(75));
        li.add(Arrays.asList(95, 64));
        li.add(Arrays.asList(17, 47, 82));
        li.add(Arrays.asList(18, 35, 87, 10));
        li.add(Arrays.asList(20, 4, 82, 47, 65));
        li.add(Arrays.asList(19, 1, 23, 75, 3, 34));
        li.add(Arrays.asList(88, 2, 77, 73, 7, 63, 67));
        li.add(Arrays.asList(99, 65, 4, 28, 6, 16, 70, 92));
        li.add(Arrays.asList(41, 41, 26, 56, 83, 40, 80, 70, 33));
        li.add(Arrays.asList(41, 48, 72, 33, 47, 32, 37, 16, 94, 29));
        li.add(Arrays.asList(53, 71, 44, 65, 25, 43, 91, 52, 97, 51, 14));
        li.add(Arrays.asList(70, 11, 33, 28, 77, 73, 17, 78, 39, 68, 17, 57));
        li.add(Arrays.asList(91, 71, 52, 38, 17, 14, 91, 43, 58, 50, 27, 29, 48));
        li.add(Arrays.asList(63, 66, 4, 68, 89, 53, 67, 30, 73, 16, 69, 87, 40, 31));
        li.add(Arrays.asList(4, 62, 98, 27, 23, 9, 70, 98, 73, 93, 38, 53, 60, 4, 23));

        // li = new ArrayList<>();
        // li.add(Arrays.asList(3));
        // li.add(Arrays.asList(7, 4));
        // li.add(Arrays.asList(2, 4, 6));
        // li.add(Arrays.asList(8, 5, 9, 3));

        dfs(li, 0, 0, 0);
        return String.valueOf(max);
    }

    int max = 0;

    void dfs(List<List<Integer>> li, int idx, int inIdx, int sum) {
        if (idx == li.size() - 1) {
            int val = li.get(idx).get(inIdx);
            if (max < sum + val)
                max = sum + val;
            return;
        }
        int val = li.get(idx).get(inIdx);
        dfs(li, idx + 1, inIdx, sum + val);
        if (inIdx + 1 < li.get(idx + 1).size())
            dfs(li, idx + 1, inIdx + 1, sum + val);
    }

}
