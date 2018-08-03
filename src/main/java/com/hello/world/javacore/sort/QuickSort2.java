package com.hello.world.javacore.sort;

/**
 * Created by xing on 2018/6/26.
 */
public class QuickSort2 {
    public static void main(String[] args) {
        int[] arr = {3,2,12,123,3,122,3455,644,23,355,21,1,2};
        System.out.println("before sort");
        for (int i:arr) {
            System.out.print(i + "  ");
        }
        sort2(arr);

        System.out.println("after sort ");
        for (int i:arr) {
            System.out.print(i +"   ");
        }
    }

    private static void sort2(int[] arr) {
        qSort(arr,0,arr.length-1);
    }

    private static void qSort(int[] arr, int low, int high) {
        if (low < high){
            int pivot = partition(arr,low,high);
            qSort(arr,low,pivot-1);
            qSort(arr,pivot+1,high);
        }
    }

    private static int partition(int[] arr,int low,int high){
        int pivot = arr[low];
        while (low < high){
            while (low < high && arr[high] >= pivot){
                --high;
            }
            arr[low] = arr[high];
            while (low < high && arr[low] <= pivot){
                ++low;
            }
            arr[high] = arr[low];
        }
        arr[low] = pivot;
        return low;
    }
}
