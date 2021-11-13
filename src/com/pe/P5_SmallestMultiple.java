package com.pe;

public class P5_SmallestMultiple {

    public static void main(String[] args) {

        int i = 1;
        while (true) {
            if (isMultiple(i)) {
                System.out.println(i);
                break;
            }
            i++;
        }

    }

    private static boolean isMultiple(int x) {
        for (int i = 20; i >= 1; i--) {
            if (x % i != 0) {
                return false;
            }
        }
        return true;
    }

}
