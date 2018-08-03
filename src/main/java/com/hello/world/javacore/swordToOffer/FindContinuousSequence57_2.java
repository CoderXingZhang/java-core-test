package com.hello.world.javacore.swordToOffer;

import java.util.ArrayList;

/**
 *  难度  *****
 */

/**
 *  输出所有和为 S 的连续正数序列。

    例如和为 100 的连续序列有：

    [9, 10, 11, 12, 13, 14, 15, 16]
    [18, 19, 20, 21, 22]。
 */
public class FindContinuousSequence57_2 {
    public static void main(String[] args) {
        ArrayList arrayList = FindContinuousSequence(90);
        arrayList.stream().forEach(
                p -> System.out.println(p)
        );
    }

    public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();

        int start = 1, end = 2;
        int curSum = 3;
        while (end < sum) {
            if (curSum > sum) {
                curSum -= start;
                start++;
            } else if (curSum < sum) {
                end++;
                curSum += end;
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = start; i <= end; i++) {
                    list.add(i);
                }
                ret.add(list);
                curSum -= start;
                start++;
                end++;
                curSum += end;
            }
        }
        return ret;
    }

}
