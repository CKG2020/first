package com.example.jdbc.demo.poo2;

import com.sun.org.apache.regexp.internal.RE;
import org.omg.PortableInterceptor.INACTIVE;

import javax.annotation.Resource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.ResourceBundle;

public class MyDataSourceFactory {
//    String resourceFile = "Forum.CNS";
//    ResourceBundle rb = ResourceBundle.getBundle(resourceFile);

//
//    private static ResourceBundle bundle=null;
//    private static String driver =null;
//    private static String url =null;
//    private static  String username=null;
//    private static String password=null;
//    private  static  int initialSize;
//    private  static int maxActive;
//    private static  long maxWait;
//
//static {
//    bundle=ResourceBundle.getBundle("jdbc");
//    driver=bundle.getString("driver");
//    url=bundle.getString("url");
//    username=bundle.getString("username");
//    password=bundle.getString("password");
//    initialSize=Integer.parseInt(bundle.getString("initialSize"));
//    maxActive=Integer.parseInt(bundle.getString("maxActive"));
//    maxWait= Integer.parseInt(bundle.getString("maxWait"));
//
//    }
//
//
////    String resourceFile = "Forum.CNS";
////    //	        创建一个默认的ResourceBundle对象
//////	        ResourceBundle会查找包Forum下的CNS.properties的文件
//////	        Forum是资源的包名，它跟普通java类的命名规则完全一样：
//////	        - 区分大小写
//////	        - 扩展名 .properties 省略。就像对于类可以省略掉 .class扩展名一样
//////	        - 资源文件必须位于指定包的路径之下（位于所指定的classpath中）
//////            假如你是在非Web项目中使用，则一定要写资源文件的路径，也就是包路径必须存在。
//////            如果是Web项目，不写包路径可以，此时将资源文件放在WEB-INF\classes\目录下就可以。
////    ResourceBundle rb = ResourceBundle.getBundle(resourceFile);
////	System.out.println(rb.getString("DRIVER"));//这里是分大小写的，嘿嘿输出值为jdbc:mysql://localhost:3306/cns
// public static MyDataSource createDataSource(){
// MyDataSource dataSource=new MyDataSource();
// dataSource.setInitialSize(initialSize);
// dataSource.setMaxActive(maxActive);
// dataSource.setMaxWait(maxWait);
//     return dataSource;
// }
//
//
//    public static Connection getConnection() {
//    Connection conn=null;
//    try{
//        Class.forName(driver);
//        conn= DriverManager.getConnection(url,username,password);
//        return conn;
//    }
//    catch(Exception e){
//        e.printStackTrace();
//        return  null;
//    }
//    }



        private static String url = "jdbc:mysql://localhost:3306/db1";
        private static String user = "root";
        private static String password = "root";
        private static MyDataSource datasource = null;

    public static MyDataSource createDataSource() {
        MyDataSource dataSource=new MyDataSource();
        return  dataSource;
    }


        static {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                datasource = new MyDataSource();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        public static Connection getConnection() throws SQLException {
            return datasource.getConnection();
        }

        public static void free(Connection conn){
            datasource.free(conn);
        }
    }




