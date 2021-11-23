package com.pe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P24_LexicoPermutations implements Solution {

    public static void main(String[] args) throws Exception {
        System.out.println(new P24_LexicoPermutations().solve());
    }

    private void rec(List<Integer> num, int n, List<Integer> res) {
        if (num.size() == 1) {
            res.add(num.get(0));
            return;
        }
        int fact = (int) Util.factorialOf(num.size() - 1);
        int group = n / fact;
        int mod = n % fact;
        if (mod == 0) {
            if (group > 0)
                group--;
            mod = fact;
        }
        res.add(num.get(group));
        num.remove(group);
        rec(num, mod, res);
    }

    @Override
    public String solve() throws Exception {
        int n = 1_000_000;
        List<Integer> li = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
        List<Integer> res = new ArrayList<>();
        rec(li, n, res);
        return String.valueOf(Util.listToLong(res));
    }

}
