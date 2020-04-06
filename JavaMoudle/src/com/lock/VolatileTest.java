package com.lock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class VolatileTest {

    static AtomicInteger data = new AtomicInteger();

    public static void main(String[] args) {
        int num = 10;

        long time = System.currentTimeMillis();
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        final CountDownLatch latch = new CountDownLatch(num);
        for (int i = 0; i < 10; i++) {
            cachedThreadPool.execute(new Runnable() {
                public void run() {
                    try {
                        Thread.sleep(1000);
                        data.getAndIncrement();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(" End=== Thread："+Thread.currentThread().getId());
                    latch.countDown();
                }
            });
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("总共耗时:" + (System.currentTimeMillis()-time)+" data="+data.get());
        cachedThreadPool.shutdown();
    }
}