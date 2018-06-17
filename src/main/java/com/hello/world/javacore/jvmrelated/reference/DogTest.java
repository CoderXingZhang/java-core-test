package com.hello.world.javacore.jvmrelated.reference;

/**
 * @author xing
 */
public class DogTest {
    public static void main(String[] args) {
        Dog dog = new Dog("旺财");
        changeName(dog);
        System.out.println(dog.getName());
    }

    private static void changeName(Dog dog) {
        dog = new Dog();
        dog.setName("阿狗");
    }

}
