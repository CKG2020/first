package com.example.hikaricp.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.solr.SolrAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import java.io.IOException;
import java.sql.SQLException;

@SpringBootApplication(exclude = {SolrAutoConfiguration.class})
public class DemoApplication extends SpringBootServletInitializer {

    public static void main(String[] args) throws IOException, SQLException {


        SpringApplication app = new SpringApplication(DemoApplication.class);
        app.setWebApplicationType(WebApplicationType.NONE);

        HikariPoolManager.start();
        app.run(args);

//            SpringApplication.run(DemoApplication.class, args);
    }

}
