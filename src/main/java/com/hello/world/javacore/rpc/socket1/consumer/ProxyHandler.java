package com.hello.world.javacore.rpc.socket1.consumer;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.net.Socket;

public class ProxyHandler implements InvocationHandler {
    private String ip;
    private int port;

    public ProxyHandler(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Socket socket = new Socket(this.ip,this.port);
        ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
        try {
            outputStream.writeObject(proxy.getClass().getInterfaces()[0]);
            outputStream.writeUTF(method.getName());
            outputStream.writeObject(method.getParameterTypes());
            outputStream.writeObject(args);
            outputStream.flush();
            Object result = inputStream.readObject();
            if (result instanceof Throwable){
                throw (Throwable) result;
            }
            return result;
        }finally {
            socket.shutdownOutput();
        }

    }
}
