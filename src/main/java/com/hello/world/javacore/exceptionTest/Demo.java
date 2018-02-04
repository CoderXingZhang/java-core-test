package com.hello.world.javacore.exceptionTest;

/**
 * @author xing
 * 测试类，如果有异常则捕获异常
 */
public class Demo {
    public static void main(String[] args) {
        int age =300;
        try{
            AgeInput.checkAage(age);
        }catch (AgeOutOfBound e){
//            System.out.print(e.printStackTrace());
//            e.printStackTrace();
            System.out.println(e.toString());
            System.out.println("Are you rellly : " + age + "years old ? ");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
