package com.proxy;

import java.sql.SQLOutput;

public class proxyHello implements IHello {

    private IHello iHello;

    public void setImpl(IHello impl){

        this.iHello = impl;

    }

    @Override
    public void sayHello(String name) {
        System.out.println("日志打印前:");
        iHello.sayHello(name);
    }

    @Override
    public void sayGoodBye(String name) {
        System.out.println("日志打印前:");
        iHello.sayGoodBye(name);
    }


    static public void main(String[] arg) {

        Hello hello = new Hello();

       proxyHello  proxy = new proxyHello();

        proxy.setImpl(hello);

        proxy.sayHello("Jerry");
        proxy.sayGoodBye("Jerry");

    }


}
