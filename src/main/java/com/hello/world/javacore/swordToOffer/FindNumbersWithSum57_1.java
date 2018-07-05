package com.hello.world.javacore.swordToOffer;


import java.util.Arrays;
import java.util.HashMap;


/**
 * 如果数组无序，则先对数组排序，然后再进行下面的操作
 */
public class FindNumbersWithSum57_1 {
    public static void main(String[] args) {

        int[] arr = {22,1,3,90,10,8,92,34,35,66,78};
        int[] sorted =  Arrays.stream(arr).sorted().toArray();
        Arrays.stream(sorted).forEach(p-> System.out.print(" " + p));
        int sum = 100;

        HashMap<Integer,Integer> res = FindNumbersWithSum(sorted,sum);
        res.entrySet().stream().forEach(p -> System.out.println(p.getKey() + " : " + p.getValue()));

    }

    private static HashMap<Integer,Integer> FindNumbersWithSum(int[] array, int sum){
        HashMap<Integer,Integer> map = new HashMap<>();

        int i = 0, j = array.length - 1;
        while (i< j){
            int cur = array[i] + array[j];
            if (cur == sum){
                System.out.println(array[i]+" - "+array[j]);
                map.put(array[i],array[j]);
            }
            if (cur < sum){
                i++;
            }else {
                j--;
            }
        }
        return map;
    }
}
