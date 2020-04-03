package com.example.lettuce1.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import java.net.URL;

public class TestList1 {

    // inject the actual template
    @Autowired
    private RedisTemplate<String, String> template;

    // inject the template as ListOperations
    // can also inject as Value, Set, ZSet, and HashOperations
    @Resource(name = "redisTemplate")
    private ListOperations<String, String> listOps;

    public void addLink(String userId, URL url) {
        listOps.leftPush(userId, url.toExternalForm());
        // or use template directly
        template.boundListOps(userId).leftPush(url.toExternalForm());
    }


//    Bound系列操作示例，Bound系列操作的优势在于只需要绑定一次，然后可以进行一个系列的操作，代码十分精炼。

//    BoundListOperations<String, Product> mangoOps = redis.boundListOps("solidmango");
//    Product popped = mangoOps.rightPop();
//    mangoOps.rightPush(product1);
//    mangoOps.rightPush(product2);
//    mangoOps.rightPush(product3);
}