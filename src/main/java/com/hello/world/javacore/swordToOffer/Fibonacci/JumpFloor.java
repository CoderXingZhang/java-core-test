package com.hello.world.javacore.swordToOffer.Fibonacci;

/**
 * @author zhangxing
 * @apiNote   跳台阶
 */

public class JumpFloor {
    public static void main(String[] args) {
        System.out.println(JumpFloor1(9));
    }

    public static int JumpFloor1(int n){
        if (n<=1)
            return n;
        int pre2 = 0,pre1 = 1;
        int result = 0;
        for (int i= 1;i<= n;i++){
            result = pre1 + pre2;
            pre2 = pre1;
            pre1 = result;
        }
        return result;
    }
}
