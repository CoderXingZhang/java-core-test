package com.hello.world.javacore.swordToOffer;

/**
 *
 * 求 1+2+3+...+n，要求不能使用
 * 乘除法、for、while、if、else、switch、case 等关键字及条件判断语句（A?B:C）
 */
public class Sum64 {
    public static void main(String[] args) {
        int n = 10;
        System.out.println(sum_soluation(n));

    }

    public static int sum_soluation(int n){
        int sum = n;
        boolean b = (n > 0) && ((sum += sum_soluation(n-1)) > 0);
        return sum;
    }
}
