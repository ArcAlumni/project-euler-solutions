package com.pe;

import java.util.HashSet;

public class P29_DistinctPowers implements Solution {

    @Override
    public String solve() throws Exception {
        HashSet<String> set = new HashSet<>();

        for (int i = 2; i <= 100; i++) {
            String s = String.valueOf(i);
            String ss = s;
            for (int j = 2; j <= 100; j++) {
                s = Util.multiply(s, ss);
                set.add(s);
            }
        }

        return String.valueOf(set.size());
    }

}
