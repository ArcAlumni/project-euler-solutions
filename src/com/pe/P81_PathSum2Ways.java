package com.pe;

import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class P81_PathSum2Ways implements Solution {

    @Override
    public String solve() throws Exception {
        List<List<Integer>> dp = Files.lines(Util.getFile("p081_matrix.txt"))
                .map(l -> Arrays.stream(l.split(",")).map(x -> Integer.parseInt(x)).collect(Collectors.toList()))
                .collect(Collectors.toList());

        for (int i = 0; i < dp.size(); i++) {
            for (int j = 0; j < dp.get(0).size(); j++) {
                if (i == 0 && j == 0)
                    continue;
                int min1 = Integer.MAX_VALUE;
                if (j - 1 >= 0)
                    min1 = dp.get(i).get(j - 1);
                int min2 = Integer.MAX_VALUE;
                if (i - 1 >= 0)
                    min2 = dp.get(i - 1).get(j);
                int min = Math.min(min1, min2);
                dp.get(i).set(j, dp.get(i).get(j) + min);
            }
        }

        return String.valueOf(dp.get(dp.size() - 1).get(dp.size() - 1));
    }

}