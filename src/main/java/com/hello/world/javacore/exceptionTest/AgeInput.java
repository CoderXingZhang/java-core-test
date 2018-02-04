package com.hello.world.javacore.exceptionTest;

/**
 * @author xing
 * 定义一个方法，根据参数值决定是否抛出异常
 */
public class AgeInput {
    public static void checkAage(int age) throws AgeOutOfBound {
        if (age > 0 && age < 200){
            System.out.println("right");
        }else {
            System.out.println("___________");
            throw new AgeOutOfBound();
        }
    }
}
