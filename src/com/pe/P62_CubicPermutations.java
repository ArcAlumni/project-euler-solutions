package com.pe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class P62_CubicPermutations implements Solution {

    public static void main(String[] args) throws Exception {
        new P62_CubicPermutations().solve();
    }

    @Override
    public String solve() throws Exception {

        HashMap<String, List<String>> map = new HashMap<>();

        for (int i = 1; i < 10000; i++) {
            String strI = String.valueOf(i);
            String pow3 = Util.multiply(Util.multiply(strI, strI), strI);
            int[] freq = countInts(pow3);
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < freq.length; j++) {
                if (freq[j] > 0) {
                    sb.append(j).append("-").append(freq[j]).append(",");
                }
            }
            String key = sb.toString();
            List<String> li = map.getOrDefault(key, new ArrayList<>());
            li.add(pow3);
            if (li.size() == 5) {
                return String.valueOf(li.get(0));
            }
            map.put(key, li);
        }

        return null;
    }

    private int[] countInts(String s) {
        int[] freq = new int[10];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - '0']++;
        }
        return freq;
    }

}
