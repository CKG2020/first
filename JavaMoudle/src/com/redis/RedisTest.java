package com.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class RedisTest {

    public static void main(String[] args) {
//        Jedis jedis = new Jedis("localhost", 6379);  //指定Redis服务Host和port
////        jedis.auth("xxxx"); //如果Redis服务连接需要密码，制定密码
//        jedis.set("key", "aaa");
//        String value = jedis.get("key");//访问Redis服务
//        System.out.println(value);
//        jedis.zadd("aaaaaa", 1, "bbbb");
//        jedis.zadd("aaaaaa",5,"ccccc");
//        Set<String> set = jedis.zrangeByScore("aaaaaa", 0, 3);
//        System.out.println(set);
//        jedis.close(); //使用完关闭连接
//
//
//        JedisPoolConfig config = new JedisPoolConfig();
//        config.setMaxIdle(8);
////        config.setMaxTotal(18);
//        JedisPool pool = new JedisPool(config, "127.0.0.1", 6379, 2000);
//        Jedis jedispool = pool.getResource();
//        System.out.println(jedispool);
//        jedispool.set("key", "aaaa");
//        String value1 = jedispool.get("key");
//        System.out.println(value1);
//        jedispool.close();
//        pool.close();
//        Jedis jedis = new Jedis("localhost");
//        System.out.println("Connection to server sucessfully");
//
//        Set<String> set = jedis.keys("*");
//
//        Iterator<String> stringIterator = set.iterator();
//
//        while (stringIterator.hasNext()) {
//            System.out.printf("String Value :%s\n", stringIterator.next());
//        }
//
    }


}

