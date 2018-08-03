package com.hello.world.javacore.swordToOffer;


/**
 * 给定一个数组 A[0, 1,..., n-1], 请构建一个数组 B[0, 1,..., n-1],
 * 其中 B 中的元素 B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 */
public class ArrayMultiply {

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5, 1};
        int[] res = multiply(A);

        System.out.println();
        for (int i : res) {
            System.out.print(" " + i);
        }
    }

    public static int[] multiply(int[] A) {
        int n = A.length;
        int[] B = new int[n];

        //从左向右乘
        for (int i = 0, product = 1; i < n; product *= A[i], i++) {
            B[i] = product;
        }

        //从右向左乘
        for (int i = n - 1, product = 1; i >= 0; product *= A[i], i--) {
            B[i] *= product;
        }

        return B;
    }
}
