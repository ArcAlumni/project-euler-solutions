package com.pe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P119_DigitPowerSum implements Solution {

    public static void main(String[] args) throws Exception {
        System.out.println(new P119_DigitPowerSum().solve());
    }

    @Override
    public String solve() throws Exception {
        List<String> li = new ArrayList<>();
        mLoop:
        for (int i = 2; i < 100; i++) {
            String num = Integer.toString(i);
            String pow = num;
            for (int j = 2; j < 10; j++) {
                pow = Util.multiply(pow, num);
                String digitSum = Util.digitsSumOf(pow);
                if (num.equals(digitSum)) {
                    li.add(pow);
                    if (li.size() == 40)
                        break mLoop;
                }
            }
        }
        Collections.sort(li, (x1, x2) -> Util.compare(x1, x2));
        return li.get(29);
    }
}
