package com.hello.world.javacore.swordToOffer.array;

import java.util.Stack;

/**
 * @author xing
 */
public class StackTurnToQueue {
    public static void main(String[] args) throws Exception {
        Queue queuetest = new Queue();
        queuetest.push(1);
        queuetest.push(33);
        queuetest.push(22);

        System.out.println(queuetest.pop());
        System.out.println(queuetest.pop());

        queuetest.push(11);
        System.out.println(queuetest.pop());


    }

}

class Queue{
    Stack<Integer> in = new Stack<>();
    Stack<Integer> out = new Stack<>();
    public void push(int node){
        in.push(node);
    }
    public int pop() throws Exception{
        if (out.isEmpty()){
            while (!in.isEmpty()){
                out.push(in.pop());
            }
        }
        if (out.isEmpty()){
            throw new Exception("queue is empty");
        }

        return out.pop();
    }

}