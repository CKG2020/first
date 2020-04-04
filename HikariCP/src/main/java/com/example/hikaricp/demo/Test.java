package com.example.hikaricp.demo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;


public class Test {

    public static void main(String[] args) {

        //配置文件
        HikariConfig hikariConfig = new HikariConfig();
//        hikariConfig.setJdbcUrl("jdbc:mysql://localhost:3306/mydata");//mysql
        hikariConfig.setJdbcUrl("jdbc:mysql://localhost:3306/db1");//oracle
        hikariConfig.setDriverClassName("com.mysql.jdbc.Driver");
        hikariConfig.setUsername("root");
        hikariConfig.setPassword("root");
        hikariConfig.addDataSourceProperty("cachePrepStmts", "true");
        hikariConfig.addDataSourceProperty("prepStmtCacheSize", "250");
        hikariConfig.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

        HikariDataSource ds = new HikariDataSource(hikariConfig);
        Connection conn = null;
        Statement statement = null;
        ResultSet rs = null;
        try{

            //创建connection
            conn = ds.getConnection();
            statement = conn.createStatement();

            //执行sql
            rs = statement.executeQuery("select *  from User");

            //取数据
            System.out.println("Results:");
            int numcols = rs.getMetaData().getColumnCount();
            while(rs.next()) {
                for(int i=1;i<=numcols;i++) {
                    System.out.print("\t" + rs.getString(i));
                }
                System.out.println("");
            }

            //关闭connection
            conn.close();
        }
        catch (SQLException e){
            e.printStackTrace();
        }

    }

}