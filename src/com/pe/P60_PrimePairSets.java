package com.pe;

import java.util.*;

public class P60_PrimePairSets implements Solution {

    public static void main(String[] args) throws Exception {
        new P60_PrimePairSets().solve();
    }

    @Override
    public String solve() throws Exception {
        boolean[] primeArr = Util.sievesPrimeArray(100000000);
        List<Integer> primes = Util.getPrimesLessThan(10000);
        List<Integer> validPrimes = new ArrayList<>();
        combi(primes, validPrimes, 5, 0, primeArr);
        return String.valueOf(validPrimes.stream().mapToInt(x -> x).sum());
    }

    private boolean combi(List<Integer> primes, List<Integer> li, int n, int idx, boolean[] primeArr) {
        if (li.size() == n) {
            return true;
        }
        for (int i = idx; i < primes.size(); i++) {
            li.add(primes.get(i));
            if (isAllPairPrimes(li, primeArr)) {
                if (combi(primes, li, n, i + 1, primeArr)) {
                    return true;
                }
            }
            li.remove(li.size() - 1);
        }
        return false;
    }

    private boolean isAllPairPrimes(List<Integer> li, boolean[] primeArr) {
        for (int i = 0; i < li.size(); i++) {
            for (int j = i + 1; j < li.size(); j++) {
                int c = (li.get(i) * (int) Math.pow(10, Util.lenOf(li.get(j)))) + li.get(j);
                if (!primeArr[c]) {
                    return false;
                }
                c = (li.get(j) * (int) Math.pow(10, Util.lenOf(li.get(i)))) + li.get(i);
                if (!primeArr[c]) {
                    return false;
                }
            }
        }
        return true;
    }

}
