package com.pe;

import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class P67_MaxPathSum2 {

    public static void main(String[] args) throws IOException {

        List<String> lines = Files.readAllLines(Util.getFile("/src/resources/p067_triangle.txt"));
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

        System.out.println(calcLine);

    }

}
