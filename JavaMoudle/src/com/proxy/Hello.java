package com.proxy;

interface IHello {

    void sayHello(String name);

    void sayGoodBye(String name);


}

public class Hello implements IHello {
    @Override
    public void sayHello(String name) {
        System.out.println("Hello::" + name);

    }

    @Override
    public void sayGoodBye(String name) {
        System.out.println("goodbye::" + name);
    }

    //    static public <StaticProxy> void main(String[] arg) {
//
//        Hello hello = new Hello();
//
//        StaticProxy proxy = new StaticProxy();
//
//        proxy.(hello);
//
//        proxy.sayHello("Jerry");
//
//    }
    public static void main(String[] args) {
        Hello hello = new Hello();
        hello.sayGoodBye("张三");
        hello.sayHello("李四");
    }
}
