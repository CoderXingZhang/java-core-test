package com.hello.world.javacore.swordToOffer;

import java.util.Arrays;

/**
 * @author xing
 */
public class MergeTwoSortedArray {
    public static void main(String[] args) {
        int[] a = {1, 3, 5, 6, 8, 9};
        int[] b = {2, 4, 5, 6, 10, 11, 11, 13, 33};
        int[] res = merge(a, b);
        Arrays.stream(res).forEach(p -> System.out.println(p));
    }

    private static int[] merge(int[] a, int[] b) {
        int lengthA = a.length;
        int lengthB = b.length;
        int[] res = new int[lengthA + lengthB];
        int i = 0, j = 0, k = 0;
        while (i < lengthA && j < lengthB) {
            if (a[i] < b[j]) {
                res[k++] = a[i++];
            } else if (a[i] == b[j]) {
                res[k++] = a[i];
                i++;
                j++;
            } else {
                res[k++] = b[j++];
            }
        }
        while (i < lengthA) {
            res[k++] = a[i++];
        }
        while (j < lengthB) {
            res[k++] = b[j++];
        }
        return res;
    }
}
