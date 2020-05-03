package com.ease.architecture.config;

import com.ease.architecture.config.info.RedisInfo;
import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisURI;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;
import io.lettuce.core.protocol.RedisCommand;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

@Configuration
public class LettuceConfig {
    @Resource
    RedisInfo redisInfo;

    @Bean
    public RedisClient getRedisClient() {
//        return RedisClient.create(redisInfo.getUri());

        RedisURI uri = RedisURI.builder()
                .withHost(redisInfo.getHost())
                .withPort(redisInfo.getPort())
                .withTimeout(Duration.of(10, ChronoUnit.SECONDS))
                .build();                                         //创建单机连接信息

        RedisClient redisClient = RedisClient.create(uri);
        return redisClient;
    }

    @Bean
    public StatefulRedisConnection<String, String> getStatefulRedisConnection(RedisClient redisClient){
        return redisClient.connect();
    }


    @Bean
    public   RedisCommands<String,String> getConnection(StatefulRedisConnection<String,String> connection){
        return connection.sync();


    }




}
