package com.hello.world.javacore.swordToOffer;

import static com.hello.world.javacore.swordToOffer.LeftRotateString58_2.reverse;

/**
 * 输入："I am a student."
 *
 * 输出："student. a am I"
 */
public class ReverseSentence58_1 {
    public static void main(String[] args) {
        String str = "haa you are world";
        System.out.println(ReverseSentence(str));

    }
    public static String ReverseSentence(String str){
        int n = str.length();
        char[] chars = str.toCharArray();
        int i = 0, j =  0;
        while (j <= n){
            if (j == n || chars[j] == ' '){
                reverse(chars,i,j-1);
                i = j +1 ;
            }
            j++;
        }

        reverse(chars,0,n-1);
        return new String(chars);
    }

}
