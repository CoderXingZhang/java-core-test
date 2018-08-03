package com.hello.world.javacore.rpc.socket1.consumer;

import com.hello.world.javacore.rpc.socket1.provider.BatterCakeService;

public class RpcTest {
    public static void main(String[] args) {
        BatterCakeService batterCakeService = RpcConsumer.getService(BatterCakeService.class,"127.0.0.1",20006);
        String res = batterCakeService.sellBatterCake("双蛋");
        System.out.println(res);
    }
}
