package com.hello.world.javacore.swordToOffer.listnode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author xing
 */
public class printNodeReverse {
    public static void main(String[] args) {
        ListNode listNode = ListInit.initedList();
        ArrayList<Integer> reversedList = printListFromTailToHead(listNode);
        reversedList.stream().forEach(p->
                System.out.print(p + "   "));
    }

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
