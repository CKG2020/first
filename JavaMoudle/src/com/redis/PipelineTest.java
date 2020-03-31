package com.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;
import redis.clients.jedis.Response;

import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.ScatteringByteChannel;
import java.util.Properties;
import java.util.Set;

public class PipelineTest {


    //    Properties properties = new Properties();
//     // 使用ClassLoader加载properties配置文件生成对应的输入流
//           InputStream in = PropertiesTest.class.getClassLoader().getResourceAsStream("config/config.properties");
//     // 使用properties对象加载输入流
//        properties.load(in);
//    //获取key对应的value值
//            properties.getProperty(String key);
    private static final String SERVER_ADDRESS = "127.0.0.1"; // 服务器地址
    private static final Integer SERVER_PORT = 6379; // 端口

//    static {
//        Properties properties = new Properties();
//        // 使用ClassLoader加载properties配置文件生成对应的输入流
//        InputStream in = PipelineTest.class.getClassLoader().getResourceAsStream("resources.properties");
//        // 使用properties对象加载输入流
//        try {
//            properties.load(in);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        //获取key对应的value值
//        properties.getProperty(SERVER_ADDRESS);
//        properties.getProperty(String.valueOf(SERVER_PORT));
//    }

    public static void main(String[] args) {
        Jedis jedis = new Jedis(SERVER_ADDRESS, SERVER_PORT);
        Pipeline p = jedis.pipelined();
//        利用pipeline的方式从client打包多条命令一起发出，
//        不需要等待单条命令的响应返回，而redis服务端会处理完多条命令后会将多条命令的处理结果打包到一起返回给客户端。

        p.set("r1", "xxxxx");
        p.zadd("r2", 1, "barowitch");
        p.zadd("r2", 9, "barinsky");
        p.zadd("r2", 55, "barikoviev");
        Response<String> pipeString = p.get("r1");
        System.out.println(pipeString);
        Response<Set<String>> sose = p.zrange("r2", 0, -1);
        p.sync();
        int soseSize = sose.get().size();
        Set<String> setBack = sose.get();

        System.out.println(soseSize);
        for (String str : setBack) {
            System.out.println(str);
        }
        jedis.disconnect();


    }


}

