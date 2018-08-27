package com.hello.world.javacore.swordToOffer.listnode;

/**
 * Created by xing on 2018/8/27.
 */
public class reverList {
    public static void main(String[] args) {
        ListNode listNode = ListInit.initedList();

        ListNode head = reverseList(listNode);
        int listSize = 0;
        //除去链表头指针
        head = head.getNext();
        while (head !=null) {
            System.out.println(" 第 " + listSize + " 个元素为：" + head.getValue());
            listSize++;
            head = head.getNext();
        }
        System.out.println("链表的长度为:" + (listSize));

    }

    public static ListNode reverseList(ListNode head){
        ListNode newHead = new ListNode(-1);
        while (head != null){
            //获取头结点的下一个结点
            ListNode next = head.getNext();

            /* ++++head的next做临时改变，保存newHead的next信息+++++++*/
            head.setNext(newHead.getNext());
            // 每次改变newHead的next，将新的head的值及next保存到newHead
            newHead.setNext(head);
            // 将下一个结点赋值给头结点.
            head = next;
        }
        return newHead.getNext();
    }
}
