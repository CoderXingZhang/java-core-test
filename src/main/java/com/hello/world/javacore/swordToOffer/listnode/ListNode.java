package com.hello.world.javacore.swordToOffer.listnode;

/**
 * @author xing
 */
public class ListNode {
    private int value;
    private ListNode next;

    public ListNode(int value) {
        this.value = value;
        this.next = null;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public boolean hasNext(){
        return this.getNext() !=null ;
    }
}
