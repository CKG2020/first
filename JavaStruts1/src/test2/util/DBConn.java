package test2.util;

import java.sql.*;

public class DBConn {
   public  static Connection getConnection()
    {
        Connection conn=null;
        final String dbDrive="com.mysql.jdbc.Driver";
        final String url = "jdbc:mysql://localhost:3306/db1";
        //与创建数据库的代码结合，保证访问数据库时不出现乱码
        //"jdbc:mysql://localhost:3306/db?useUnicode=true&characterEncoding=UTF-8";

        String username = "root";
        String password = "root";

        try {
            Class.forName("com.mysql.jdbc.Driver");
//        } catch (InstantiationException e1) {
//            // TODO Auto-generated catch block
//            e1.printStackTrace();
//            System.out.print("数据库加载驱动失败！");
//        } catch (IllegalAccessException e1) {
//            // TODO Auto-generated catch block
//            e1.printStackTrace();
//            System.out.print("数据库加载驱动失败！");
        } catch (ClassNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
            System.out.print("数据库加载驱动失败！");
        } // 加载数据库驱动

        try {
            conn = DriverManager.getConnection(url, username, password);//建立连接
        }
        catch (SQLException e) {
            e.printStackTrace();
            System.out.print("数据库连接失败！");
        }
        return conn;
    }
    //关闭与访问数据库有关连接
    public static void finalize(Connection con, Statement st, ResultSet rs)
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