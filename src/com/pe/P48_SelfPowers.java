package com.pe;

public class P48_SelfPowers implements Solution {

    @Override
    public String solve() throws Exception {
        String res = "0";

        for (int i = 1; i <= 1000; i++) {
            String powered = "1";
            String num = String.valueOf(i);
            int pow = Integer.parseInt(num);
            for (int j = 0; j < pow; j++) {
                powered = Util.multiply(powered, num);
            }
            res = Util.add(res, powered);
        }

        return String.valueOf(res.substring(res.length() - 10));
    }

}
