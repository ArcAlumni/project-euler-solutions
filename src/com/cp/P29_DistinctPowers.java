package com.cp;

import java.util.HashSet;

public class P29_DistinctPowers {

    public static void main(String[] args) {

        HashSet<String> set = new HashSet<>();

        for (int i = 2; i <= 100; i++) {
            String s = String.valueOf(i);
            String ss = s;
            for (int j = 2; j <= 100; j++) {
                s = Util.multiply(s, ss);
                set.add(s);
            }
        }

        System.out.println(set.size());

    }

}
