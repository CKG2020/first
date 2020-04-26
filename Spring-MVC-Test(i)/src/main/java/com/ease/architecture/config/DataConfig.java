package com.ease.architecture.config;
import com.zaxxer.hikari.HikariDataSource;

import com.alibaba.druid.pool.DruidDataSource;
import com.ease.architecture.config.info.JdbcInfo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
public class DataConfig {

    @Resource
    private JdbcInfo jdbcInfo;


    @Bean
    public DataSource getDataSource() throws SQLException {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setUrl(jdbcInfo.getUrl());
//        dataSource.setUsername(jdbcInfo.getUsername());
//        dataSource.setPassword(jdbcInfo.getPassword());
//        dataSource.setDriverClassName(jdbcInfo.getDriver());



//        DruidDataSource dataSource = new DruidDataSource();
//        dataSource.setUrl(jdbcInfo.getUrl());
//        dataSource.setUsername(jdbcInfo.getUsername());
//        dataSource.setPassword(jdbcInfo.getPassword());
//        dataSource.setDriverClassName(jdbcInfo.getDriver());
//


        HikariDataSource dataSource=new HikariDataSource();
        dataSource.setJdbcUrl(jdbcInfo.getUrl());
        dataSource.setUsername(jdbcInfo.getUsername());
        dataSource.setPassword(jdbcInfo.getPassword());
        dataSource.setDriverClassName(jdbcInfo.getDriver());



//        dataSource.setFilters(jdbcInfo.getFilters());
//        dataSource.setConnectionProperties(jdbcInfo.getConnectionProperties());
//        dataSource.setValidationQuery(jdbcInfo.getValidationQuery());
        return dataSource;
    }

    @Bean
    public JdbcTemplate getJdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
