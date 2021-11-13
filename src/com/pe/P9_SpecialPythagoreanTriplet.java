package com.pe;

public class P9_SpecialPythagoreanTriplet {

    public static void main(String[] args) {
        for (int i = 1; i < 995; i++) {
            for (int j = i + 1; j < 1000; j++) {
                if (i + j > 999)
                    break;
                int k = 1000 - (i + j);
                long prod = i * j * k;
                if ((i * i) + (j * j) == (k * k) && i + j + k == 1000) {
                    System.out.println(i + " " + j + " " + k + " " + prod);
                    break;
                }
            }
        }
    }

}
