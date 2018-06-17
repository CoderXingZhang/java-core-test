package com.hello.world.javacore.swordToOffer.listnode;

/**
 * @author xing
 */
public class ListInit {
    public static void main(String[] args) {
       ListNode head = initedList();

        int listSize = 0;
        //除去链表头指针
        head = head.getNext();
        while (head.hasNext()) {
            System.out.println(" 第 " + listSize + "个元素为：" + head.getValue());
            listSize++;
            head = head.getNext();
        }
        System.out.println("最后一个元素为: "+head.getValue());
        System.out.println("链表的长度为:" + (listSize + 1));
    }

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
