package com.redis.fakeRedis;


import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

//测试类，键盘输入消息
public class TestPubSub {
    public static void main( String[] args )
    {
        // 连接redis服务端
        JedisPool jedisPool;
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPool = new JedisPool(jedisPoolConfig, "127.0.0.1", 6379);

        Publisher publisher = new Publisher(jedisPool);    //发布者
        publisher.start();

        Subscriber subscriber = new Subscriber(jedisPool);    //订阅者
        subscriber.start();


    }
}
