package com.example.lettuce1.demo;

import io.lettuce.core.RedisClient;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.pubsub.RedisPubSubListener;
import io.lettuce.core.pubsub.StatefulRedisPubSubConnection;
import io.lettuce.core.pubsub.api.sync.RedisPubSubCommands;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestLettuce {


    private RedisClient redisClient;
    private StatefulRedisConnection<String, String> connect;

    @Before
    public void beforeTest() {
        redisClient = RedisClient.create("redis://localhost");
        System.out.println("init");
    }

    @Test
    public void test() {
        connect = redisClient.connect();
        String value = connect.sync().get("key");
        System.out.println("value is:" + value);
//        int i = 1; //某数据库查询结果
        Assert.assertEquals("aaaaaaaaa", value);
        String value2 = connect.sync().hget("key1", "aaaa");
        System.out.println("value2 is:" + value2);

//        String value3=connect.sync().getset()
    }

//    @Test
//    public void pubsubTest() {
//        RedisPubSubListener<String, String> listener = new RedisPubSubListener<String, String>() {
//            @Override
//            public void message(String value, String channel) {
//                System.out.println("message is" + value + "--" + channel);
//            }
//
//            @Override
//            public void message(String s, String k1, String s2) {
//                System.out.println("message is" + s + "--" + k1 + "--" + s2);
//            }
//
//            @Override
//            public void subscribed(String s, long l) {
//                System.out.println("sub is" + s + "--" + l);
//            }
//
//            @Override
//            public void psubscribed(String s, long l) {
//                System.out.println("psub is" + s + "--" + l);
//            }
//
//            @Override
//            public void unsubscribed(String s, long l) {
//                System.out.println("unsub is" + s + "--" + l);
//            }
//
//            @Override
//            public void punsubscribed(String s, long l) {
//                System.out.println("pusub is" + s + "--" + l);
//            }
//        };
//
//        StatefulRedisPubSubConnection<String, String> pubsubConnection = redisClient.connectPubSub();
//        pubsubConnection.addListener(listener);
//        RedisPubSubCommands<String, String> sync = pubsubConnection.sync();
//        sync.subscribe("channel");
//
//
//        try {
//            Thread.sleep(100000L);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }


    @After
    public void afterTest() {
        connect.close();
        redisClient.shutdown();
        System.out.println("finish");
    }
}
