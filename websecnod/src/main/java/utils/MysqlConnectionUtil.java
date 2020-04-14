package utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class MysqlConnectionUtil {


    public static  String  DRIVER;
    public static  String  URL;
    public  static  String USERNAME;
    public  static  String PASSWORD;
    private static MysqlConnectionUtil util;

    static {
        try{
            ClassLoader classLoader=MysqlConnectionUtil.class.getClassLoader();
            InputStream in=classLoader.getResourceAsStream("jdbc.properties");
            Properties pro=new Properties();
            pro.load(in);
            DRIVER=pro.getProperty("DRIVER");
            URL =pro.getProperty("URL");
            USERNAME=pro.getProperty("USERNAME");
            PASSWORD=pro.getProperty("PASSWORD");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private MysqlConnectionUtil (){
    }

     public static MysqlConnectionUtil getInstance(){
        if(util==null){
        util=new MysqlConnectionUtil();}
        return util;
     }


    public static Connection getConnection(){
        Connection conn=null;
        try{
            Class.forName(DRIVER);
            conn= DriverManager.getConnection(URL,USERNAME,PASSWORD);

        }catch(Exception e){
            e.printStackTrace();
        }
        return  conn;
    }

    public static void realease(Connection conn, PreparedStatement pstmt, ResultSet rs)
    {
        if(rs!=null){
            try{
                rs.close();
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }

        if (pstmt!=null){
            try{
                conn.close();
            }
            catch(Exception e){
                e.printStackTrace();

            }
        }
    }

}
