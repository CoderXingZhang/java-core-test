package com.hello.world.javacore.swordToOffer;

/**
 * 对于一个给定的字符序列 S，请你把其循环左移 K 位后的序列输出。
 * 例如，字符序列 S=”abcXYZdef”, 要求输出循环左移 3 位后的结果，即“XYZdefabc”。
 */
public class LeftRotateString58_2 {
    public static void main(String[] args) {
        String str = "12AAAEFcds";
        int n = 5;
        System.out.println(LeftRotateString(str,n));

    }
    public static String LeftRotateString(String str,int n){
        if (n >= str.length())
            return str;

        char[] chars = str.toCharArray();
        reverse(chars,0,n-1);
        reverse(chars,n,chars.length-1);
        reverse(chars,0,chars.length-1);

        return new String(chars);
    }

    public static void reverse(char[] chars,int i, int j){
        while (i< j){
            swap(chars,i++,j--);
        }
    }

    public static void swap(char[] chars, int i,int j){
        char temp = chars[i];
        chars[i]  = chars[j];
        chars[j] = temp;
    }
}
