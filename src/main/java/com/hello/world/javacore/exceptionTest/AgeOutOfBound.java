package com.hello.world.javacore.exceptionTest;

/**
 * @author zhangxing
 */
public class AgeOutOfBound extends Exception {

    public AgeOutOfBound() {
        System.out.println("Sorry,age out of bound ! ");
    }

    @Override
    public String toString() {
        return "AgeOutOfBoundException";
    }
}
