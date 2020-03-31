package com.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCommands;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.exceptions.JedisConnectionException;

import java.util.logging.Logger;

public class TestPool {
//    private static final String SERVER_ADDRESS = "127.0.0.1"; // 服务器地址
//    private static final Integer SERVER_PORT = 6379; // 端口
//    private static JedisPool jp = null;
//
//    public static void initpool() {
//        JedisPoolConfig jpc = new JedisPoolConfig();
//        jpc.setMaxActive(100);
//
////        jp = new JedisPool(jpc, SERVER_ADDRESS, SERVER_PORT, 2000);
//    }
//
//    public static void dispool() {
//        jp.destroy();
//    }
//
//    public static void main(String[] args) {
//        initpool();
//        Jedis jedis = jp.getResource();
//        try {
//            jedis.set("foo", "bar");
//            String foobar = jedis.get("foo");
//            System.out.println(foobar);
//        } catch (JedisConnectionException e) {
//            if (null != jedis) {
//                jp.returnBrokenResource(jedis);
//                jedis = null;
//            }
//        } finally {
//            if (null != jedis)
//                jp.returnResource(jedis);n
//        }
//        dispool();
    }






