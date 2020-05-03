package com.ease.architecture.config.info;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:redis.properties")
public class RedisInfo {



//    @Value("${redis.uri}")
//    private String uri;


    @Value("${server.ip}")
    private String host;

    @Value("${redis.port}")
    private  int port;

//    public RedisUtil(){
//
//    }
//
//
//
//
//
//
//
//
//
//    public String getUri() {
//        return uri;
//    }
//
//    public void setUri(String uri) {
//        this.uri = uri;
//    }


    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }


}
