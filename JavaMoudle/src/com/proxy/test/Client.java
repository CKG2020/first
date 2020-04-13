package com.proxy.test;

import com.redis.Sub;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Client {
    public static void main(String[] args) {

        RealSubject realSubject=new RealSubject();
        InvocationHandler handler=new DaynamicSubject(realSubject);
        Class<? extends InvocationHandler> classType = handler.getClass();
//        Subject  subject=(Subject) Proxy.newProxyInstance
//                (classType.getClassLoader(),realSubject.getClass().getInterfaces(),handler);

        Subject subject= (Subject) Proxy.newProxyInstance(realSubject.getClass().getClassLoader(),realSubject.getClass().getInterfaces(),handler);
        subject.request();
        System.out.println(classType.getClassLoader());

        System.out.println("---------------");
        System.out.println(realSubject.getClass().getClassLoader());
        System.out.println(subject.getClass());
    }
}


