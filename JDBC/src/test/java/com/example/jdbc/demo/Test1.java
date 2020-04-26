package com.example.jdbc.demo;

import com.example.jdbc.demo.poo2.MyDataSourceFactory;

import java.sql.Connection;
import java.sql.SQLException;

public class Test1 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        try {
            for (int i = 0; i <= 10; i++) {
                Connection conn = MyDataSourceFactory.getConnection();
                System.out.println(conn);
                MyDataSourceFactory.free(conn);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
