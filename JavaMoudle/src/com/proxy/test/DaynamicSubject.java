package com.proxy.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DaynamicSubject implements InvocationHandler {
    private Object sub;

    public DaynamicSubject(Object obj) {
        this.sub = obj;
    }

    @Override
    public Object invoke(Object o, Method method, Object[] args) throws Throwable {
//
        System.out.println("before calling " + method);
        method.invoke(sub, args);
        System.out.println(args == null);
        System.out.println("after calling" + method);
        return null;
    }
}
