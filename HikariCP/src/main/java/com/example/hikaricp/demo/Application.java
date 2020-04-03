package com.example.hikaricp.demo;

import com.hzcominfo.hik.hikbigscreen.common.HikariPoolManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.solr.SolrAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.boot.context.web.SpringBootServletInitializer;

import java.io.IOException;
import java.sql.SQLException;

@SpringBootApplication(exclude = {SolrAutoConfiguration.class})
public class Application extends SpringBootServletInitializer {

    public static void main(String[] args) throws IOException, SQLException {
        SpringApplication app = new SpringApplication(Application.class);
        app.setWebEnvironment(true);
        HikariPoolManager.start();
        app.run(args);

    }
}