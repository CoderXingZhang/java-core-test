package com.hello.world.javacore.classloaderTest;

import org.apache.commons.lang3.RandomStringUtils;

/**
 * Created by xing on 2018/2/27.
 */
public class test {
    public static void main(String[] args) {
        System.out.println(generateOrderNumber(10L));

        System.out.println((System.currentTimeMillis() + "").substring(4, 13));
        System.out.println(System.currentTimeMillis());
    }

    public static Long generateOrderNumber(Long itemId) {
        String orderIdFromItem = String.format("%04d", itemId).substring(0, 4);
        String orderIdFromRandom = RandomStringUtils.random(2, false, true);
        String orderIdFromTimeMills = (System.currentTimeMillis() + "").substring(3, 13);
        return Long.parseLong(orderIdFromTimeMills + orderIdFromItem + orderIdFromRandom);
    }
}
