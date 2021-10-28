package com.cp;

public class P12_HighlyDivibleTriangularNo {

    public static void main(String[] args) {

        long i = 1;
        while (true) {
            long tn = (i * (i + 1)) / 2;
            boolean res = isDivisor500(tn);
            if (res) {
                System.out.println(tn);
                break;
            }
            i++;
        }

    }

    static boolean isDivisor500(long x) {
        int c = 0;
        for (int i = 1; i*i <= x; i++) {
            if (x % i == 0) {
                c++;
                if (c * 2 >= 500) {
                    return true;
                }
            }
        }
        return false;
    }

}
