package com.example.lettuce1.demo;

import com.example.lettuce1.demo.model.User;
import org.junit.Test;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.ArrayList;
import java.util.List;

public class TestList {
    private RedisTemplate<Object, Object> template;

    @Test
    public void leftPushAll() {
        List<User> list = new ArrayList<User>();

        User user = new User();
        user.setId("0304180216");
        user.setAge(11);
        user.setUsername("张三1");

        User user1 = new User();
        user1.setId("2");
        user1.setAge(12);
        user1.setUsername("张三2");

        User user2 = new User();
        user2.setId("3");
        user2.setAge(13);
        user2.setUsername("张三3");

        list.add(user);
        list.add(user1);
        list.add(user2);
        String[] strings =new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            strings[i]=list.get(i).toString();
        }
        System.out.println(JsonUtil.toJson(strings));
        ListOperations<Object, Object> operations =  this.template.opsForList();
        operations.leftPushAll("users",strings);
        operations.leftPushAll("users1", JsonUtil.toJson(user),JsonUtil.toJson(user1),JsonUtil.toJson(user2));
        System.out.println(operations.size("users"));
    }
}
