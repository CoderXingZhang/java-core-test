package com.hello.world.javacore.rpc.socket1.provider;

public class RpcBootStrap {
    public static void main(String[] args) throws Exception{
        BatterCakeService batterCakeService = new BatterCakeServiceImpl();

        //
        RpcProvider.export(20006,batterCakeService);
    }
}
