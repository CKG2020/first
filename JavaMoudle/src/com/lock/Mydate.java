package com.lock;

import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class Mydate {

    //    private static int number;
    volatile int number = 0;
    // volatile 不保证原子性 这里可以加可以不加


    public void change() {
        this.number = 20;
        System.out.println(number);
    }

//    public synchronized void incr() {
public  void incr() {
        number++;
//锁太重le
    }


    AtomicInteger data = new AtomicInteger();

    public void incr1() {
        data.getAndIncrement();

    }

    public static void main(String[] args) {
        Mydate mydate = new Mydate();
        for (int i = 1; i <= 20; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
//                    mydate.change();
                    mydate.incr();
                    mydate.incr1();
                }
            }, String.valueOf(i)).start();
        }

        while (Thread.activeCount() > 2) {
            Thread.yield();
        }

        System.out.println("==============");
        System.out.println(mydate.number);
        System.out.println("===============");
        System.out.println(mydate.data);
    }
}
