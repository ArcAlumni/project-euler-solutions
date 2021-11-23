package com.pe;

import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class P67_MaxPathSum2 implements Solution {

    @Override
    public String solve() throws Exception {
        List<String> lines = Files.readAllLines(Util.getFile("p067_triangle.txt"));
        List<Integer> calcLine = Arrays.stream(lines.get(lines.size() - 1).split(" ")).map(x -> Integer.parseInt(x))
                .collect(Collectors.toList());

        for (int i = lines.size() - 2; i >= 0; i--) {
            int j = 0;
            List<Integer> li = new ArrayList<>();
            for (String num : lines.get(i).split(" "))
                li.add(Math.max(Integer.parseInt(num) + calcLine.get(j),
                        Integer.parseInt(num) + calcLine.get(j++ + 1)));
            calcLine = li;
        }
        return calcLine.get(0).toString();
    }

}
