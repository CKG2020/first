package com.proxy.xxx.tools;


class YourThread implements IRunanble {

    @Override
    public void run() {
        System.out.println("adfadfadsfasdf");
    }
}

public class MyThread implements IRunanble {
    @Override
    public void run() {
        System.out.println("aaaa");
    }

    public static void main(String[] args) throws Exception {
        Tools.start("com.proxy.easyarch.tools.YourThread");
    }
}
