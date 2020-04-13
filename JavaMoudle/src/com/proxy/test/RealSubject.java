package com.proxy.test;

public class RealSubject implements  Subject{
    @Override
    public void request() {
        System.out.println("realSubject");
    }
}
