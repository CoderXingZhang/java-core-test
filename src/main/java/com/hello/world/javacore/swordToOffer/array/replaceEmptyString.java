package com.hello.world.javacore.swordToOffer.array;

/**
 * @author xing
 */
public class replaceEmptyString {
    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer("we are happy");
        String replaceString = replaceSpace(stringBuffer);
        System.out.println(replaceString);
    }

    private static String replaceSpace(StringBuffer str) {
        int oldLen = str.length();
        for (int i = 0; i < oldLen; i++) {
            if (str.charAt(i) == ' ') {
                str.append("  ");
            }
        }

        int P1 = oldLen - 1;
        int P2 = str.length() - 1;
        while (P1 > 0 && P2 > P1) {
            char c = str.charAt(P1--);
            if (c == ' ') {
                str.setCharAt(P2--, '0');
                str.setCharAt(P2--, '2');
                str.setCharAt(P2--, '%');
            } else {
                str.setCharAt(P2--, c);
            }
        }
        return str.toString();
    }

}
