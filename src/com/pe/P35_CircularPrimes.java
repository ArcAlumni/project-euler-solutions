package com.pe;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class P35_CircularPrimes {

    private static boolean[] primes;

    public static void main(String[] args) {

        primes = Util.sievesPrimeArray(1000000);

        int res = 0;

        for (int i = 2; i < primes.length; i++) {
            if (primes[i]) {
                if (hasAllRotations(i)) {
                    res++;
                }
            }
        }

        System.out.println(res);

    }

    static boolean hasAllRotations(int i) {
        if (i < 10) {
            return true;
        }
        List<Integer> li = intToList(i);
        int idx = 0;
        while (idx < li.size()) {
            int el = li.remove(li.size() - 1);
            li.add(0, el);
            if (!primes[listToInt(li)]) {
                return false;
            }
            idx++;
        }
        return true;
    }

    static List<Integer> intToList(int i) {
        List<Integer> li = new LinkedList<>();
        while (i != 0) {
            li.add(i % 10);
            i /= 10;
        }
        Collections.reverse(li);
        return li;
    }

    static int listToInt(List<Integer> li) {
        int val = 0;
        for (int x : li) {
            val *= 10;
            val += x;
        }
        return val;
    }

}
