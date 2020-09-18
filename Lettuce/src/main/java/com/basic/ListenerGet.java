package com.basic;

import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisFuture;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.async.RedisStringAsyncCommands;
import io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue;

import java.util.concurrent.ExecutionException;
import java.util.function.Consumer;

public class ListenerGet implements Consumer<String> {
    @Override
    public void accept(String s) {

    }

    @Override
    public Consumer<String> andThen(Consumer<? super String> consumer) {
        return null;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        RedisClient client = RedisClient.create("redis://localhost");
        StatefulRedisConnection<String, String> connection = client.connect();
        RedisStringAsyncCommands<String, String> async = connection.async();
        RedisFuture<String> future = async.get("news");
        System.out.println(future.get());
//就是用来监听future 判断isDone
        future.thenAccept(new Consumer<String>() {
            @Override
            public void accept(String value) {
                System.out.println(value);
                System.out.println("xxxxx");
            }
        });
    }
}
