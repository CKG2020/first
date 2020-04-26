package com.ease.architecture.config;

import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisURI;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.resource.ClientResources;
import io.lettuce.core.resource.DefaultClientResources;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import javax.swing.plaf.basic.BasicTextUI;

@Configuration
public class RedisConfig {



    @Bean
    public ClientResources clientResources() {


        return DefaultClientResources.create();
    }

    @Bean
    public RedisClient redisClient(ClientResources clientResources) {
        return RedisClient.create(clientResources, io.lettuce.core.RedisURI.create("localhost", 6379));
    }

    @Bean
    public StatefulRedisConnection<String,String> connection(RedisClient redisClient) {
        return redisClient.connect();
    }

    @Bean
    public RedisTemplate<String,Object> getRedisTemplate() {
        RedisTemplate redisTemplate = new RedisTemplate();
        LettuceConnectionFactory lcf = (LettuceConnectionFactory) redisTemplate.getConnectionFactory();
        redisTemplate.setConnectionFactory(lcf);
        return redisTemplate;

    }



//
//    @Bean
//    RedisConnectionFactory lettuceConnectionFactory() {
//        return new LettuceConnectionFactory();
//    }

//    @Bean
//    public RedisTemplate<String, User> redisTemplate(RedisConnectionFactory factory) {
//        RedisTemplate<String, User> template = new RedisTemplate<String, User>();
//        template.setConnectionFactory(lettuceConnectionFactory());
//        template.setKeySerializer(new StringRedisSerializer());
//        template.setValueSerializer(new RedisObjectSerializer());
//        return template;
//    }
}
