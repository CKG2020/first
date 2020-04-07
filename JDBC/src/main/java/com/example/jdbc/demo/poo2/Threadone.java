package com.example.jdbc.demo.poo2;

import java.sql.Connection;
import java.sql.SQLException;

public class Threadone implements Runnable {

    private MyDataSource dataSource;
    public Threadone(MyDataSource dataSource) {
        this.dataSource=dataSource;
    }

    @Override
    public void run() {
        for(int i=0;i<10;i++){
            Connection connection= null;
            try {
                connection = dataSource.getConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try{
                connection.close();
            }
            catch (Exception e)
            {
            e.printStackTrace();
            }
        }
    }
}


//public class App
//{
//    public static void main( String[] args )
//    {
//        ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
//        String driver = bundle.getString("driver");
//        String url = bundle.getString("url");
//        String username = bundle.getString("username");
//        String password = bundle.getString("password");
//        System.out.println(driver+","+url+","+username+","+password);
//
//        System.out.println( "Hello World!" );
//    }
//}
