package com.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy implements InvocationHandler {
    private Object delegate;


    public Object bind(Object delegate) {
        this.delegate = delegate;
        return Proxy.newProxyInstance(
                this.delegate.getClass().getClassLoader(), this.delegate
                        .getClass().getInterfaces(), this);
    }


    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        Object result = null;
        try {
            System.out.println("问候之前的日志记录...");
            // JVM通过这条语句执行原来的方法(反射机制)
            result = method.invoke(this.delegate, args);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;

    }

    public static void main(String[] args) {
        DynamicProxy helloproxy = new DynamicProxy();
        Hello hello = new Hello();
//        Hello ihello = (Hello) helloproxy.bind(hello); 不行
//        java.lang.ClassCastException: com.proxy.$Proxy0 cannot be cast to com.proxy.Hello
        //也就是说 生成的代理对象只能是接口类型的
        IHello ihello = (IHello) helloproxy.bind(hello);
        ihello.sayHello("Jerry");
        System.out.println("=============================");
        ihello.sayGoodBye("tom");
    }

}