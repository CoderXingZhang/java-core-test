package com.hello.world.javacore.baseNumber.arrayObject;


/**
 * 数组对象
 *
 * https://blog.csdn.net/qq_28205153/article/details/51701752
 */
public class ArrayTest {
    public static void main(String[] args) {

        B[] ba = new B[2];
        B b = new B();
        B[] ba1 = new B[2];
        //测试数组的class对象是共享的
        System.out.println(ba == ba1);
        System.out.println(ba.getClass() == ba1.getClass());

        //测试ba和b的class对象是否一样
        System.out.println(ba.getClass() + " | " + b.getClass());


        //测试数组ba和b的超类是否一样
        System.out.println(ba.getClass().getSuperclass() +" | " + b.getClass().getSimpleName());

        for (Class<?> c:ba.getClass().getInterfaces()){
            System.out.println("superInterfaces " + c);
        }

        System.out.println("------------");
        for (Class<?> c: b.getClass().getInterfaces()){
            System.out.println("superInterfaces " + c);
        }
    }
}

class A{

}

class B extends A implements Comparable<B>{
    @Override
    public int compareTo(B o) {
        return 0;
    }
}

