package com.pe;

public class P1_MultiplesOf3or5 implements Solution {

    public static void main(String[] args) {
        System.out.println(new P1_MultiplesOf3or5().solve());
    }

    @Override
    public String solve() {
        int res = 0;
        for (int i = 0; i < 1000; i++) {
            if (i % 3 == 0 || i % 5 == 0)
                res += i;
        }
        return String.valueOf(res);
    }

}
