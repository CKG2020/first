package com.redis;

import redis.clients.jedis.Jedis;

public class Pub {
    public static void main(String[] args) {
        Jedis  jedis=new Jedis("localhost",6379);
        jedis.connect();
        jedis.publish("news","hehe");
        jedis.publish("news","hahha");
        jedis.disconnect();
    }
}
