package com.pe;

public class P48_SelfPowers implements Solution {

    public static void main(String[] args) throws Exception {
        System.out.println(new P48_SelfPowers().solve());
    }

    @Override
    public String solve() throws Exception {
        String res = "0";
        for (int i = 1; i <= 1000; i++) {
            if (i % 10 != 0)
                res = Util.add(res, Util.pow(String.valueOf(i), i));
        }
        return res.substring(res.length() - 10);
    }

}
