package com.pe;

public class P1_MultiplesOf3or5 {

    public static void main(String[] args) {
        int res = 0;
        for (int i = 0; i < 10; i++) {
            if (i % 3 == 0 || i % 5 == 0)
                res += i;
        }
        System.out.println(res);
    }

}
