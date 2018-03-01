package com.hello.world.javacore.classloaderTest;

import java.util.Date;
import java.util.List;

/**
 * @author xing
 */
public class ClassLoaderTest {
    public static void main(String[] args) {
        System.out.println("ClassLoaderText类的加载器的名称： " +ClassLoaderTest.class.getClassLoader().getClass().getName());
        System.out.println("System类的加载器的名称：" + System.class.getClassLoader());
        System.out.println("List 类的加载器的名称：" + List.class.getClassLoader());

        System.out.println("-----------");
        ClassLoader c1 = ClassLoaderTest.class.getClassLoader();
        while (c1 != null){
            System.out.println(c1.getClass().getName() + "->");
            c1 = c1.getParent();
        }

        System.out.println("===========");
        System.out.println(c1);



        try {
            Class classDate = new MyClasserLoader("class_temp").loadClass("ClassLoaderAttachment");
            Date date = (Date) classDate.newInstance();
            System.out.println("classloader : " + date.getClass().getClassLoader().getClass().getName());
            System.out.println(date);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
