package com.hello.world.javacore.swordToOffer;

public class LastRemaining62 {
    public static void main(String[] args) {
        int n = 10, m = 3;

        System.out.println(LastRemaining_solution(n,m));

    }

    public static int LastRemaining_solution(int n , int m){
        if (n == 0)
            return -1;

        if (n == 1)
            return 0;

        return (LastRemaining_solution(n -1 ,m) + m ) % n;
    }
}
