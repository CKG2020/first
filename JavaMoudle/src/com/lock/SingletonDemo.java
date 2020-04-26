package com.lock;

public class SingletonDemo {

    private static SingletonDemo instance = null;

    private SingletonDemo() {
        System.out.println(Thread.currentThread().getName() + "\t" + "我是构造方法");
    }

    //此处添加synchronized
    public static SingletonDemo getInstance() {
        //或者dcl双端锁机制但不保证线程安全  因为会引发指令重排  地址为空和地址所在的内容为空是里两种情况
        //此时需要在单例对象前面加volatile禁止指令重排 不会引发线程安全
        if (instance == null) {
            synchronized (SingletonDemo.class) {
                if (instance == null) {
                    instance = new SingletonDemo();

                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
//        System.out.println(SingletonDemo.getInstance() == SingletonDemo.getInstance());
//        System.out.println(SingletonDemo.getInstance() == SingletonDemo.getInstance());
//        System.out.println(SingletonDemo.getInstance() == SingletonDemo.getInstance());

        for (int i = 0; i <= 10; i++) {
            new Thread(() -> {
                SingletonDemo.getInstance();
            },
                    String.valueOf(i)).start();
        }
    }
}
