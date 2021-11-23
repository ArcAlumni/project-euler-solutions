package com.pe;

import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class P22_Names implements Solution {

    @Override
    public String solve() throws Exception {
        List<String> names = Files.readAllLines(Util.getFile("p022_names.txt")).stream()
                .flatMap((l) -> Arrays.stream(l.split(",")).map(s -> s.substring(1, s.length() - 1))).sorted()
                .collect(Collectors.toList());
        return String.valueOf(IntStream.range(0, names.size())
                .mapToLong(idx -> (long) (names.get(idx).chars().map(x -> x - 'A' + 1).sum() * (idx + 1))).sum());
    }

}
