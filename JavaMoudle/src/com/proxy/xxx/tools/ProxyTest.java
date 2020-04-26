package com.proxy.xxx.tools;

import java.lang.reflect.*;

interface Person {
    void walk();

    void sayHello(String name);
}

class MyInvokationHandler implements InvocationHandler {
    /*
    proxy：代表动态代理对象
    method：代表正在执行的方法
    args：代表调用目标方法时传入的实参。
    */
    public Object invoke(Object proxy, Method method, Object[] args) {
        System.out.println("----正在执行的方法:" + method);
        if (args != null) {
            System.out.println("下面是执行该方法时传入的实参为：");
            for (Object val : args) {
                System.out.println(val);
            }
        } else {
            System.out.println("调用该方法没有实参！");
        }
        return null;
    }

    public static void main(String[] args)
            throws Exception {
        // 创建一个InvocationHandler对象
        InvocationHandler handler = new MyInvokationHandler();
        // 使用指定的InvocationHandler来生成一个动态代理对象
        Person p = (Person) Proxy.newProxyInstance(Person.class.getClassLoader()
                , new Class[]{Person.class}, handler);
        //p并非为Person的实例而是一个代理类的对象
        // 调用动态代理对象的walk()和sayHello()方法
        p.walk();
        p.sayHello("xxx");
        //调用的上面的两个方法其实是在调用 proxy的invoke()方法
    }
}
