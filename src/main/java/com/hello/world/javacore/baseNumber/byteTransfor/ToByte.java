package com.hello.world.javacore.baseNumber.byteTransfor;

public class ToByte  {
    public static void main(String[] args) {
        Boolean b = false;
        System.out.println(b.booleanValue());



        String name = "张兴";
        byte[] bytes = name.getBytes();

        for (byte bi:bytes) {
            System.out.print(bi +"  ");
        }
    }
}
