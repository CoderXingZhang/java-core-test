package com.hello.world.javacore.swordToOffer.listnode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

/**
 * @author xing
 */
public class printNodeReverse {
    public static void main(String[] args) {
        ListNode listNode = ListInit.initedList();

        //借助栈实现
       /* ArrayList<Integer> reversedList = printListFromTailToHead(listNode);
        reversedList.stream().forEach(p->
                System.out.print(p + "   "));*/

       //递归实现
        ArrayList<Integer> res = printListFromTailToHead2(listNode);
        res.stream().forEach(p->
                System.out.print(p + "   "));

        //借助java的 Collections.reverse()
      /*  ArrayList<Integer> collRes = printListFromTailToHead3(listNode);
        collRes.stream().forEach(p->
                System.out.print(p + "   "));*/
    }

    private static ArrayList<Integer> printListFromTailToHead3(ListNode listNode) {
        ArrayList<Integer> ret = new ArrayList<>();
        while (listNode!=null){
            ret.add(listNode.getValue());
            listNode = listNode.getNext();
        }
        Collections.reverse(ret);
        return ret;
    }

    private static ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        ArrayList<Integer> ret =new ArrayList<>();
        if (listNode!=null){
            ret.addAll(printListFromTailToHead2(listNode.getNext()));
            ret.add(listNode.getValue());
        }
        return ret;
    }

    //借助栈倒序打印链表
    private static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        listNode= listNode.getNext();
        while (listNode!=null){
            stack.add(listNode.getValue());
            listNode = listNode.getNext();
        }

        ArrayList<Integer> ret = new ArrayList<>();
        while(!stack.isEmpty()){
            ret.add(stack.pop());
        }
        return ret;
    }
}
