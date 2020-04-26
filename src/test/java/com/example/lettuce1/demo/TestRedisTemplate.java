package com.example.lettuce1.demo;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestRedisTemplate {
    //  这个是spring自带的redis操作
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void redisTest() {
        // redis存储数据
        String key = "name";
        redisTemplate.opsForValue().set(key, "ckg");
        // 获取数据
        String value = (String) redisTemplate.opsForValue().get(key);
        System.out.println("获取缓存中key为" + key + "的值为：" + value);

//        redisTemplate.opsForList().
//        User user = new User();
//        user.setUsername("ckg");
//        user.setSex(18);
//        user.setId(1l);
//        user.setPassword("123");
//
//        String userKey = "ck";
//        redisTemplate.opsForValue().set(userKey, user);
//        User newUser = (User) redisTemplate.opsForValue().get(userKey);
//        System.out.println("获取缓存中key为" + userKey + "的值为：" + newUser);

    }

}
