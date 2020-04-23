package test2.util;

import java.sql.*;

public class DBConn {
   public  static Connection getConnection() throws ClassNotFoundException {
        Connection conn=null;
        //tmd  Driver后面多一个空格就害我检查了折磨长时间
        final String dbDriver="com.mysql.jdbc.Driver";
        final String url = "jdbc:mysql://47.94.21.104:3306/db1";
        //与创建数据库的代码结合，保证访问数据库时不出现乱码
        //"jdbc:mysql://localhost:3306/db?useUnicode=true&characterEncoding=UTF-8";

        String username1 = "root";
        String password1 = "root";
//
//        try {

//        } catch (InstantiationException e1) {
//            // TODO Auto-generated catch block
//            e1.printStackTrace();
//            System.out.print("数据库加载驱动失败！");
//        } catch (IllegalAccessException e1) {
//            // TODO Auto-generated catch block
//            e1.printStackTrace();
//            System.out.print("数据库加载驱动失败！");
//        } catch (ClassNotFoundException e1) {
//            // TODO Auto-generated catch block
//            e1.printStackTrace();
//            System.out.print("数据库加载驱动失败！");
//        } // 加载数据库驱动
        Class.forName(dbDriver);
        try {
            conn = DriverManager.getConnection(url, username1, password1);//建立连接
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