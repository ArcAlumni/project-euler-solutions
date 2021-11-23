package com.pe;

public class P7_10001Prime implements Solution {

    @Override
    public String solve() throws Exception {
        long i = 2, c = 0, nth = 10001;
        while (true) {
            if (Util.isPrime(i)) {
                c++;
                if (c == nth) 
                    return String.valueOf(i);
            }
            i++;
        }
    }

}
