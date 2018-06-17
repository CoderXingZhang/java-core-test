package com.hello.world.javacore.algorithm.discover;

/**
 * Created by xing on 2018/6/17.
 */
public class multiplyExceptSelf {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4,5,6};
     /*   long start1 = System.currentTimeMillis();
        int[] res = multiplyESelf(array);
        long end1 = System.currentTimeMillis();
        System.out.println("method 1 times used : "  + (end1-start1) + " s");
        for (int i : res) {
            System.out.print(i + "      |");
        }*/

        long start2 = System.currentTimeMillis();
        int[] res2 = method2(array);
        long end2 = System.currentTimeMillis();
        System.out.println("method2 times used : " + (end2 - start2) +" s");
        for (int i : res2) {
            System.out.print(i + "      |");
        }
    }

    private static int[] method2(int[] array) {
        int i;
        int n = array.length;
        int[] res = new int[n];
        res[0] = 1;
        for (i =1;i< n ;++i){
            res[i] =res[i-1] * array[i-1];
        }
        res[0] = array[n-1];
        //从倒数第二个元素开始
        for (i = n-2;i > 0;i--){
            System.out.println(i);
            res[i] *= res[0];
            res[0] *= array[i];
        }
        return res;
    }





    private static int[] multiplyESelf(int[] array) {
        int[] p = new int[array.length];
        int[] s = new int[array.length];

        p[0] = 1;
        s[0] = 1;
        int la = array.length;

        for (int i = 1; i < la; i++) {
            p[i] = p[i - 1] * array[i - 1];
            s[i] = s[i - 1] * array[la - i];
        }

        for (int i = 0; i < la; i++) {
            p[i] = p[i] * s[la - i - 1];
        }

        return p;
    }
}
