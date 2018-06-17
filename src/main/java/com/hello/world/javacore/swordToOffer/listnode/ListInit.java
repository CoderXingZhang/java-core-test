package com.hello.world.javacore.swordToOffer.listnode;

import java.lang.reflect.Field;

/**
 * @author xing
 */
public class ListInit {
    public static void main(String[] args) {
       ListNode head = initedList();

        int listSize = 0;
        //除去链表头指针
        head = head.getNext();
        while (head !=null) {
            System.out.println(" 第 " + listSize + " 个元素为：" + head.getValue());
            listSize++;
            head = head.getNext();
        }
        System.out.println("链表的长度为:" + (listSize));


        //JVM 累加载相关
       /* System.out.println(head.getClass().getClassLoader());
        System.out.println(head.getClass().getName());
        Field[] fields = head.getClass().getDeclaredFields();
        for (Field field:fields) {
            System.out.println(field.getName());
        }*/
    }

    //链表初始化 长度外为10
    public static ListNode initedList(){
        ListNode head = new ListNode(-1);
        ListNode current = head;
        for (int i = 1; i <= 10; i++) {
            ListNode next = new ListNode(i);
            current.setNext(next);
            current = next;
        }
        return head;
    }
}
