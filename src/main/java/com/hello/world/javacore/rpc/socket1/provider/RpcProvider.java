package com.hello.world.javacore.rpc.socket1.provider;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.List;

public class RpcProvider {
    private static List<Object> serviceList;
    public static void export(int port,Object... services) throws Exception{
        serviceList = Arrays.asList(services);
        ServerSocket socket = new ServerSocket(port);
        Socket client = null;
        while (true){
            client = socket.accept();
            new Thread(new ServerThread(client,serviceList)).start();
        }
    }
}
