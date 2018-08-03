package com.hello.world.javacore.InterviewNoteBook.foundation;


/**
 * from: https://github.com/CyC2018/Interview-Notebook/blob/master/notes/Java%20%E5%9F%BA%E7%A1%80.md
 */
public class InterviewNotebookCode {
    public static void main(String[] args) {
        // 1 缓存池
        // new Integer(123) 与 Integer.valueOf(123) 的区别在于，new Integer(123) 每次都会新建一个对象，而 Integer.valueOf(123) 可能会使用缓存对象，因此多次使用 Integer.valueOf(123) 会取得同一个对象的引用。
//        bufferTest();

        //2 参数传递
        paramTransf();

        //3
        float f = 1.1f;
        System.out.println(f);

    }

    private static void bufferTest(){
        Integer integer1 = new Integer(123);
        Integer integer2 = new Integer(123);
        System.out.println(integer1 == integer2);
        //false

        System.out.println(integer1.equals(integer2));
        //true

        Integer integer3 = Integer.valueOf(123);
        Integer integer4 = Integer.valueOf(123);
        System.out.println(integer3 == integer4);
        //true

        Integer integer5 = 555;
        Integer integer6 = 555;
        System.out.println(integer5 == integer6);
        //false

        Integer integer7 = 123;
        Integer integer8 = 123;
        System.out.println(integer7 == integer8);
        //true

        System.out.println(integer1 == integer7);

    }

    private static void paramTransf(){
        Dog dog = new Dog("A");
        System.out.println(dog.getObjectAddress());
        func(dog);
        System.out.println(dog.getObjectAddress());
        System.out.println(dog.getName());
    }

    private static void func(Dog dog) {
        System.out.println(dog.getObjectAddress());

        dog = new Dog("B");
        System.out.println(dog.getObjectAddress());
        System.out.println(dog.getName());
    }

}

class Dog{
    private String name ;

    public Dog(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public String getObjectAddress(){
        return super.toString();
    }
}