package com.proxy.jgproxy;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class Server {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, IOException, NoSuchFieldException {
        HelloService service=new HelloServiceimpl();
        ProxyFrameWork.export(service,6666);
    }
}
