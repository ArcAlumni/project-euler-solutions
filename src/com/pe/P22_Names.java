package com.pe;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class P22_Names {

    public static void main(String[] args) throws IOException {
        List<String> names = Files
                .readAllLines(Paths.get(System.getProperty("user.dir") + "/src/resources/p022_names.txt")).stream()
                .flatMap((l) -> Arrays.stream(l.split(",")).map(s -> s.substring(1, s.length() - 1))).sorted()
                .collect(Collectors.toList());
        System.out.println(IntStream.range(0, names.size())
                .mapToLong(idx -> (long) (names.get(idx).chars().map(x -> x - 'A' + 1).sum() * (idx + 1))).sum());
    }

}
