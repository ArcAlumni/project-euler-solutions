package com.pe;

import java.util.Collections;
import java.util.List;

public class P49_PrimePermutations implements Solution {

    @Override
    public String solve() throws Exception {

        boolean[] primes = Util.sievesPrimeArray(10000);
        boolean occured = false;

        for (int i = 1000; i < primes.length; i++) {

            if (!primes[i] || numContainsZero(i))
                continue;

            List<Integer> li = Util.permutationsOf(Util.intToArray(i, -1), (a) -> Util.arrayToInt(a));
            Collections.sort(li);
            int idx = Collections.binarySearch(li, i) + 1;
            int idx1 = -1, idx2 = -1;
            while (idx < li.size()) {
                if (primes[li.get(idx)]) {
                    if (idx1 == -1 && li.contains(li.get(idx) + (li.get(idx) - i))
                            && primes[li.get(idx) + (li.get(idx) - i)]) {
                        idx1 = idx;
                        idx2 = Collections.binarySearch(li, li.get(idx) + (li.get(idx) - i));
                        break;
                    }
                }
                idx++;
            }
            if (idx1 != -1 && idx2 != -1 && (li.get(idx1) - i == li.get(idx2) - li.get(idx1))) {
                if (occured)
                    return String.valueOf(i + "" + li.get(idx1) + "" + li.get(idx2));
                occured = true;

            }

        }

        return null;
    }

    boolean numContainsZero(int n) {
        while (n != 0) {
            if (n % 10 == 0) {
                return true;
            }
            n /= 10;
        }
        return false;
    }

}
