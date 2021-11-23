package com.pe;

public class P5_SmallestMultiple implements Solution {

    private boolean isMultiple(int x) {
        for (int i = 20; i >= 1; i--) {
            if (x % i != 0)
                return false;
        }
        return true;
    }

    @Override
    public String solve() {
        int i = 1;
        while (true) {
            if (isMultiple(i))
                return String.valueOf(i);
            i++;
        }
    }

}
