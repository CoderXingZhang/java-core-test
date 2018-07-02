package com.hello.world.javacore.swordToOffer;

public class Add65 {
    public static void main(String[] args) {
        int a = 9 , b = 19;
        System.out.println(add(a,b));
    }

    public static int add(int a,int b){
        return b ==0 ?a : add(a ^ b, (a & b ) << 1);
    }
}
