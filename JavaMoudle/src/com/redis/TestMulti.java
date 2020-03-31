package com.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Response;
import redis.clients.jedis.Transaction;

import java.util.Set;

public class TestMulti {


    private static final String SERVER_ADDRESS = "127.0.0.1"; // 服务器地址
    private static final Integer SERVER_PORT = 6379; // 端口

    public static void main(String[] args) {
        String foolbar = "";
        int soseSize = 0;
        Jedis jedis = new Jedis(SERVER_ADDRESS, SERVER_PORT);
        jedis.watch("f2");
        jedis.set("f2", "aaa");
        jedis.unwatch();


        Transaction t = jedis.multi();
        t.set("f2", "bar");
        Response<String> result1 = t.get("f2");
        // foolbar = result1.get();
        // System.out.println(foolbar);


        t.zadd("f1", 1, "barowitch");
        t.zadd("f1", 0, "barinsky");
        t.zadd("f1", 0, "barikoviev");
        Response<Set<String>> sose = t.zrange("f1", 0, -1);
        // soseSize= sose.get().size();
        // System.out.println(soseSize);
        t.exec();

        foolbar = result1.get();
        soseSize = sose.get().size();
        System.out.println(foolbar);
        System.out.println(soseSize);
        jedis.disconnect();
    }
}
