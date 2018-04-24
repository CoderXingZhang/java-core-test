package com.hello.world.javacore.collections.transfor;

import java.util.*;

/**
 * @author xing
 */
public class testCollectionsTransfor {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("xxx");
        list.add("www");
        list.add("pp1");
        list.add("www");
        // List 转化为Set
        Set set = new HashSet(list);

        System.out.println(set);


        //set 转化为list
        List list1 = new ArrayList(new HashSet());

        //数组转list
        List arr = Arrays.asList("1","2","3");
        String[] arr1 = {"1","2"};
        List list2 = Arrays.asList(arr1);

        //数组转set
        int[] arrs = {1,2,3,4};
        Set set1 = new HashSet(Arrays.asList(arrs));








    }
}
