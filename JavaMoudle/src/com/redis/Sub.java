package com.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

public class Sub extends JedisPubSub {

    //取得订阅的消息后的处理
    public void onMessage(String channel, String message) {
        System.out.println("===============onMessage=================");
        System.out.println(channel + "=" + message);
    }

    //取得按表达式的方式订阅的消息后的处理
    public void onPMessage(String pattern, String channel, String message) {
        System.out.println("===============onPMessage=================");
        System.out.println(channel + "=" + message);
    }

    //初始化订阅时候的处理
    public void onSubscribe(String channel, int subscribedChannels) {
        System.out.println("===============onSubscribe=================");
        System.out.println(channel + "=" + subscribedChannels);
    }

    //取消订阅时候的处理
    public void onUnsubscribe(String channel, int subscribedChannels) {
        System.out.println("===============onUnsubscribe=================");
        System.out.println(channel + "=" + subscribedChannels);
    }

    //取消按表达式的方式订阅时候的处理
    public void onPUnsubscribe(String pattern, int subscribedChannels) {
        System.out.println("===============onUnsubscribe=================");
        System.out.println(pattern + "=" + subscribedChannels);
    }

    //初始化按表达式的方式订阅时候的处理
    public void onPSubscribe(String pattern, int subscribedChannels) {
    }

    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost", 6379);
        jedis.connect();
        Sub client1 = new Sub();
        jedis.subscribe(client1, "news");
        jedis.subscribe(client1, "milk");
        System.out.println("----------------");
        String message = null;
        client1.onMessage("news", "message");
        client1.onMessage("milk", "message");

        client1.onPMessage("news","news","message");

        jedis.disconnect();
    }
}