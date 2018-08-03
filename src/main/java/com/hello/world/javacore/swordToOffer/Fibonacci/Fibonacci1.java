package com.hello.world.javacore.swordToOffer.Fibonacci;

/**
 * @author zhangxing
 */
public class Fibonacci1 {
    public static void main(String[] args) {
        for (int i = 1; i < 10; i++) {
            System.out.println(Fibonacci2(i));
        }

    }

    public static int Fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        int[] fib = new int[n + 1];
        fib[1] = 1;
        for (int i = 2; i <= n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
            System.out.println(fib[i]);
        }
        return fib[n];
    }

    public static int Fibonacci2(int n) {
        if (n <= 1)
            return n;
        int pre2 = 0, pre1 = 1;
        int fib = 0;
        for (int i = 2; i <= n; i++) {
            fib = pre1 + pre2;
            pre2 = pre1;
            pre1 = fib;
        }
        return fib;
    }

    public static int Fibonacci3(int n) {
        int[] fib = new int[40];
        fib[1] = 1;
        fib[2] = 2;
        for (int i = 2; i < fib.length; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        return fib[n];
    }
}
