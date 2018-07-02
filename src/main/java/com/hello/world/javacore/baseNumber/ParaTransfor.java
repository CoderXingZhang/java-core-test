package com.hello.world.javacore.baseNumber;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.IntPredicate;

/**
 * java 参数传递
 * 基本类型参数  值的复制 传值
 * 对象数据类型 传地址的复制，都指向同一个对象
 */
public class ParaTransfor {
    public static void main(String[] args) {
        int n = 10;
        changeNum(n);
        System.out.println(n);

        Map<String, String> map = new HashMap<>();
        map.put("aa", "A");
        map.put("bb", "B");
        changeMap(map);
        map.entrySet().stream().forEach(
                p -> System.out.println("key : " + p.getKey() + " value: " + p.getValue())
        );


        String s = "abc";
        changeString(s);
        System.out.println(s);

        int[] arr = new int[10];
        arr[3] = 10;
        arr[1] = 8;
        arr[2] = 9;
        arr[5] = 77;

        System.out.println("before change");
        int[] res = Arrays.stream(arr).filter(new IntPredicate() {
            @Override
            public boolean test(int value) {
                return value >= 9;
            }
        }).toArray();
        //.forEach(i -> System.out.print(" " + i));

        Arrays.stream(res).forEach(i -> System.out.println(" " + i));
        // 9 10 77
        changeArr(arr);

        System.out.println("after change");
        Arrays.stream(arr).forEach(i -> System.out.print(" " + i));
        //0 8 9 10 0 77 0 0 999 0

    }

    private static void changeArr(int[] arr) {
        arr[8] = 999;

    }

    public static void changeNum(int n) {
        n = 99;
    }

    public static void changeMap(Map map) {
        map.put("aa", "111");
        map.put("cc", "C");
    }

    public static void changeString(String s) {
        s = "ccc";
    }
}
