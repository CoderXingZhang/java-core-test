package com.hello.world.javacore.swordToOffer.fibonacci;

/**
 * Created by xing on 2018/6/25.
 */
public class FibonacciArray {
    public static void main(String[] args) {
        int n = 4;
        int fib = fibonacci(n);
        System.out.println(fib);
    }

    private static int fibonacci(int n) {
        if (n <=1 ){
            return n;
        }
        int pre2 = 0, pre1 = 1;
        int fib = 0;
        for (int i = 2;i<= n;i++){
            fib = pre1 + pre2;
            pre2 = pre1;
            pre1 = fib;
        }
        return fib;
    }
}
