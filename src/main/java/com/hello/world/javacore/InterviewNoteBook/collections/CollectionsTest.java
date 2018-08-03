package com.hello.world.javacore.InterviewNoteBook.collections;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 集合相关测试
 */
public class CollectionsTest  {
    public static void main(String[] args) {

        HashSetTest();

    }

    private static void HashSetTest() {
        HashSet<String> set = new HashSet();
        set.add("C");
        set.add("A");
        set.add("D");
        set.add("B");
        set.add("A");

        for (String item: set) {
            System.out.println(item);
        }

        List<String> strings = new LinkedList<>();
        ((LinkedList<String>) strings).addFirst("as");

        strings.add("www");

        List<String> list = new ArrayList<>();
        list.add("ASAS");

        ConcurrentHashMap<String,String> concurrentHashMap = new ConcurrentHashMap<String, String>(1,0.5f,2);
        concurrentHashMap.size();

    }
}
