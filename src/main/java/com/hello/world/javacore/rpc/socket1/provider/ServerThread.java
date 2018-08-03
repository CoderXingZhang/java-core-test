package com.hello.world.javacore.rpc.socket1.provider;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.Socket;
import java.util.List;

public class ServerThread implements Runnable {
    private Socket client = null;
    private List<Object> serviceList = null;

    public ServerThread(Socket client, List<Object> serviceList) {
        this.client = client;
        this.serviceList = serviceList;
    }


    @Override
    public void run() {
        ObjectInputStream inputStream = null;
        ObjectOutputStream outputStream = null;
        try {
            inputStream = new ObjectInputStream(client.getInputStream());
            outputStream = new ObjectOutputStream(client.getOutputStream());
            Class serviceClass = (Class) inputStream.readObject();
            Object obj = findService(serviceClass);
            if (obj == null) {
                outputStream.writeObject(serviceClass.getName() + "服务未发现！");
            } else {
                try {
                    String methodName = inputStream.readUTF();
                    Class<?>[] parameterTypes = (Class<?>[]) inputStream.readObject();
                    Object[] arguments = (Object[]) inputStream.readObject();
                    Method method = obj.getClass().getMethod(methodName, parameterTypes);
                    Object result = method.invoke(obj, arguments);
                    outputStream.writeObject(result);
                    System.out.println(serviceClass.getName()+"service ");
                } catch (Throwable e) {
                    outputStream.writeObject(e);
                }
            }


        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                client.close();
                inputStream.close();
                outputStream.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Object findService(Class serviceClass) {
        for (Object obj : serviceList) {
            boolean isFather = serviceClass.isAssignableFrom(obj.getClass());
            if (isFather) {
                return obj;
            }
        }
        return null;
    }
}
