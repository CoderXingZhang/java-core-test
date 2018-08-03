package com.hello.world.javacore.swordToOffer;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class maxInWindows59 {
    public static void main(String[] args) {
        int[] num = {1,2,3,9,5,4,6,4,2,1,5};
        int size = 4;
        ArrayList res = maxInWindows(num,size);
        res.stream().forEach(
                p -> System.out.print( " "  + p)
        );
    }

    public static ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> ret = new ArrayList<>();
        if (size > num.length || size < 1)
            return ret;
        PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < size; i++)
            heap.add(num[i]);
        ret.add(heap.peek());
        for (int i = 1, j = i + size - 1; j < num.length; i++, j++) {
            heap.remove(num[i - 1]);
            heap.add(num[j]);
            ret.add(heap.peek());
        }
        return ret;
    }
}
