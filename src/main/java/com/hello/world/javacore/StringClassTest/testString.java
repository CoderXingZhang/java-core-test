package com.hello.world.javacore.StringClassTest;

/**
 * @author xing
 */
public class testString {
    public static void main(String[] args) {
        //那么 s 所指向的那个对象是否发生了改变呢？答案是没有。
        //这时， s 不指向原来那个对象了，而指向了另一个 String 对象，
        String s = "hello";
        s = s + "World";
        System.out.println(s);
    }
}
