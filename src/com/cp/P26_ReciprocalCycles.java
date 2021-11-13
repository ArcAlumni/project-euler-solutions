package com.cp;

public class P26_ReciprocalCycles {

    public static void main(String[] args) {

        String res = "";
        int reccurringCycle = 0;
        int var = 0;

        for (int i = 2; i < 1000; i++) {
            StringBuilder sb = new StringBuilder();
            int j = i, k = 1;
            while (true) {
                boolean f = false;
                while (k < j) {
                    if (f)
                        sb.append("0");
                    f = true;
                    k *= 10;
                }
                int v = k / j;
                sb.append(v);
                if (sb.length() > 5000) {
                    String dup = hasDup(sb.toString());
                    if (dup != null) {
                        res = dup;
                        if (reccurringCycle < dup.length()) {
                            reccurringCycle = dup.length();
                            var = i;
                        }
                        break;
                    }
                }
                k %= j;
                if (k == 0) {
                    res = sb.toString();
                    break;
                }
            }
            System.out.println(i + " = " + res);
        }

        System.out.println(reccurringCycle + " " + var);

    }

    static String hasDup(String s) {
        while (!s.isEmpty()) {
            StringBuilder sb1 = new StringBuilder(s);
            StringBuilder sb2 = new StringBuilder();
            xx: while (sb1.length() >= sb2.length() * 2) {
                sb2.append(sb1.charAt(0));
                sb1.deleteCharAt(0);
                if (sb1.length() < sb2.length() * 2) {
                    break;
                }
                for (int i = 0; i < sb2.length(); i++) {
                    if (sb1.charAt(i) != sb2.charAt(i)) {
                        continue xx;
                    }
                }
                for (int i = 0; i < sb2.length(); i++) {
                    if (sb2.charAt(i) != sb1.charAt(i + sb2.length())) {
                        continue xx;
                    }
                }
                return sb2.toString();
            }
            s = s.substring(1);
        }
        return null;
    }

}
