package com.redis;


//import org.apache.commons.pool.impl.GenericObjectPool.Config;

//import org.classpath.icedtea.Config;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

import java.util.ArrayList;
import java.util.List;

public class TestShard {
//
//    public static void main(String[] args) {
//        List<JedisShardInfo> shards = new ArrayList<JedisShardInfo>();
//        JedisShardInfo si = new JedisShardInfo("192.168.137.18", 6379, "N1");
//        shards.add(si);
//        si = new JedisShardInfo("192.168.137.19", 6379, "N2");
//        shards.add(si);
//        ShardedJedisPool pool = new ShardedJedisPool(new Config(), shards);
//        ShardedJedis jedis = pool.getResource();
//        JedisShardInfo jsi = jedis.getShardInfo("b1");//a1会hash到N2上
//        System.out.println(jsi.getHost() + "\t" + jsi.getPort() + "\t" + jsi.getName());
//        jedis.set("b1", "foo");
//
//
//        pool.returnResource(jedis);
//        ShardedJedis jedis2 = pool.getResource();
//        System.out.println(jedis2.get("b1"));
//        pool.returnResource(jedis);
//        pool.destroy();
//
//    }


}