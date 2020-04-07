package com.example.jdbc.demo;

import com.example.jdbc.demo.jdbclist.MydataSource;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class TestMyConnection {

    @Test
    public void testAddUser(){
        Connection conn=null;
        PreparedStatement pstmt=null;
        MydataSource mydataSource=new MydataSource();
        try{
            conn=mydataSource.getConnection();
            String sql="insert into User values(?,?,?)";
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1,3);
            pstmt.setString(2,"sss");
            pstmt.setString(3,"1234567");
            int rows=pstmt.executeUpdate();
            if (rows>0){
                System.out.println("添加成功");
            }
            else{
                System.out.println("添加失败");
            }

        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally {
            mydataSource.returnConnection(conn);
        }

    }
}
