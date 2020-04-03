package com.example.lettuce1.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootApplication
public class DemoApplication {

//    private static RedisTemplate redisTemplate;
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
//        String key = "name";
//        redisTemplate.opsForValue().set(key, "ckg");
//        // 获取数据
//        String value = (String) redisTemplate.opsForValue().get(key);
//        System.out.println("获取缓存中key为" + key + "的值为：" + value);
    }

}
