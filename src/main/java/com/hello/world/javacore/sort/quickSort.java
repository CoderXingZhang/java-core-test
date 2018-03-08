package com.hello.world.javacore.sort;

/**
 * @author xing
 */
public class quickSort {
    public static void main(String[] args) {
        int test[] = {1,2,3,21231,43,42,54,654,3,656,456,5};
        System.out.println("before sort");
        for (int a:test) {
            System.out.print(" " + a);
        }
        quickSort(test,0,test.length-1);
        System.out.println("\n after sort");
        for (int a:test) {
            System.out.print(" " + a);
        }
    }

    public static void quickSort(int n[], int left,int right){
        int dp;
        if (left < right){
            dp = partition(n,left,right);
            quickSort(n,left,dp -1);
            quickSort(n,dp+1,right);
        }
    }

    static int partition(int n[] , int left, int right){
        //最左的第一个关键字为控制字
        int pivot = n[left];
        while (left < right){
            while (left < right && n[right] >= pivot){
                right--;
            }
            if (left < right){
                n[left++] = n[right];
            }
            while (left < right && n[left] <=pivot){
                left++;
            }
            if (left < right){
                n[right --] = n[left];
            }
        }

        n[left] = pivot;
        return left;
    }
}
