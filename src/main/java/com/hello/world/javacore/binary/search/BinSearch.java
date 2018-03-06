package com.hello.world.javacore.binary.search;

/**
 * @author xing
 */
public class BinSearch {
    public static void main(String[] args) {
        int[] testArray = {1,2,3,4,5,6,7,8,11,33,55,77,88};
//        System.out.println(testArray[binSearch(testArray,77)]);
        System.out.println(binSearch(testArray,0,testArray.length,33));

    }

    /**
     * 普通实现
     * @param srcArray
     * @param key
     * @return
     */
    public static int binSearch(int[] srcArray, int key) {
        int mid;
        int start = 0;
        int end = srcArray.length - 1;
        while (start <= end) {
            mid = (end - start) / 2 + start;
            if (srcArray[mid] < key) {
                start =mid + 1;
            } else if (srcArray[mid] > key) {
                end = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * 二分查找 递归实现
     * @param scrArray
     * @param start
     * @param end
     * @param key
     * @return
     */
    public static int binSearch(int scrArray[], int start, int end, int key){
        int mid = (end - start)/2 + start;
        if (key == scrArray[mid]){
            return mid;
        }
        if (start >= end){
            return -1;
        }else if (key > scrArray[mid]) {
           return binSearch(scrArray,mid + 1,end, key);
        }else if (key < scrArray[mid]){
           return binSearch(scrArray,start,mid-1,key);
        }
        return -1;
    }
}
