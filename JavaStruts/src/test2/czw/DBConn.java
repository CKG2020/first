package test2.czw;

import java.sql.*;

public class DBConn {
    static Connection getConnection()
    {/*
     *0232陈志威
     */
        Connection conn=null;
        final String dbDrive="com.mysql.jdbc.Driver";
        final String url = "jdbc:mysql://localhost:3306/db1?useUnicode=true&characterEncoding=UTF-8";
        String username = "root";
        String password = "root";

        try {
            Class.forName(dbDrive).newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
            System.out.print("数据库加载驱动失败！");
        }  // 加载数据库驱动

        try {
            conn = DriverManager.getConnection(url, username, password);//建立连接
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.print("数据库连接失败！");
        }
        return conn;
    }
    //关闭与访问数据库有关连接
    static void finalize(Connection con, Statement st, ResultSet rs)
    {
        try {
            if(rs!=null)
                rs.close();
            if(st!=null)
                st.close();
            if(con!=null)
                con.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
