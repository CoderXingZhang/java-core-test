package com.hello.world.javacore.swordToOffer;

public class StringToNum67 {
    public static void main(String[] args) {
        String s = "-19282122";
        System.out.println(strToInt(s));
    }
    public static int strToInt(String str) {
        if (str.length() == 0 || str.trim().equals("")) {
            return 0;
        }
        int length = str.length();
        int res = 0;

        boolean ngflag = str.charAt(0) == '-';
        for (int i = 0; i < length; i++) {
            char c = str.charAt(i);
            if (i == 0 && (c == '+' || c == '-')) {
                continue;
            }
            if (c > '9' || c < '0') {
                return -1;
            }
            res = res * 10 + (c - '0');
        }

        return ngflag ? -res : res;
    }
}
