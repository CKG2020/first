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
import java.util.function.Consumer;

//   在CompleteFuture中  Using a Consumer future listener
public class AsynchronousAPI1 implements Consumer<String> {

    @Override
    public void accept(String s) {
//        System.out.println("Got value: " + s);
    }

    @Override
    public Consumer<String> andThen(Consumer<? super String> consumer) {
        return null;
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {

        RedisClient client = RedisClient.create("redis://localhost");
        StatefulRedisConnection<String, String> connection = client.connect();
        RedisStringAsyncCommands<String, String> async = connection.async();
//添加上面的三行代码可打印下面的的日志  神奇!!!   //主要是第一句话的作用才打出下面的日志
//[DEBUG] (main) Using Console logging
//[DEBUG] (main) Starting UnsafeSupport init in Java 1.8
//                [TRACE] (main) sun.misc.Unsafe.theUnsafe ok
//                [TRACE] (main) sun.misc.Unsafe.copyMemory ok
//                [TRACE] (main) java.nio.Buffer.address ok
//                [DEBUG] (main) Unsafe is available
//        四月 01, 2020 9:22:51 下午 io.lettuce.core.EpollProvider <clinit>
//        信息: Starting without optional epoll library
//        四月 01, 2020 9:22:51 下午 io.lettuce.core.KqueueProvider <clinit>
//        信息: Starting without optional kqueue library
        final CompletableFuture<String> future = new CompletableFuture<>();
        future.thenAccept(new Consumer<String>() {
            @Override
            public void accept(String value) {
                System.out.println("Got value: " + value);
                System.out.println("cccccc");
            }
        });

        System.out.println("Current state: " + future.isDone());
        System.out.println("-----------------");
        future.complete("my value");
        System.out.println("-----------------");
        System.out.println("Current state: " + future.isDone());
        System.out.println(future.get());

    }

}