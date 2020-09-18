package com.basic;

import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisFuture;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.async.RedisStringAsyncCommands;
import io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

//异步调用，可以避免将 CPU 浪费在等待网络 IO 和磁盘 IO 时上，实现提高资源使用率。
public class AsynchronousAPI {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        // client
        RedisClient client = RedisClient.create("redis://localhost");
        // Creating futures using lettuce
//        // connect
//        StatefulRedisConnection<String, String> connection = client.connect();
//
//        // async
//        RedisStringAsyncCommands<String, String> async = connection.async();
//
//        RedisFuture<String> future = async.get("host");
//
//        try {
//            String value = future.get(60, TimeUnit.SECONDS);
//            System.out.println(value);
//        } catch (InterruptedException | ExecutionException | TimeoutException | java.util.concurrent.TimeoutException e) {
//            e.printStackTrace();
//        }


//RedisFuture的使用

        StatefulRedisConnection<String, String> connection = client.connect();
        RedisStringAsyncCommands<String, String> async = connection.async();
        RedisFuture<String> future1 = async.set("news", "abc");
        RedisFuture<String> future2 = async.get("news");

//        RedisFuture<String> future3=async.
        String value = future2.get(60, TimeUnit.SECONDS);
        System.out.println(value);


//CompletableFuture的使用  并且Using listeners with CompletableFuture
        System.out.println("Current state: " + future1.isDone());
        System.out.println("Current state: " + future2.isDone());
        System.out.println("Got value: " + future1.get());

        final CompletableFuture<String> future = new CompletableFuture<>();

        future.thenRun(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("Got value: " + future.get());
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });

        System.out.println("Current state: " + future.isDone());
        future.complete("my value");
        System.out.println("Current state: " + future.isDone());


    }
}
