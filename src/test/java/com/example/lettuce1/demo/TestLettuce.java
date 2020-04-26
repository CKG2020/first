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
//        String value = connect.sync().get("key");
//        System.out.println("value is:" + value);
////        int i = 1; //某数据库查询结果
//        Assert.assertEquals("aaaaaaaaa", value);
//        String value2 = connect.sync().hget("key1", "aaaa");
//        System.out.println("value2 is:" + value2);
    }


    @After
    public void afterTest() {
        connect.close();
        redisClient.shutdown();
        System.out.println("finish");
    }
}

