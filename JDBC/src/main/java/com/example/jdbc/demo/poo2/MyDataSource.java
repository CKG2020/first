package com.example.jdbc.demo.poo2;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import javax.swing.*;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.jar.JarOutputStream;

public class MyDataSource {
//    private  int initialSize;
//    private  int maxActive;
//    private  static int count=10;
//    private long  maxWait;
//
//    public int getInitialSize() {
//        return initialSize;
//    }
//
//    public void setInitialSize(int initialSize) {
//        this.initialSize = initialSize;
//    }
//
//    public int getMaxActive() {
//        return maxActive;
//    }
//
//    public void setMaxActive(int maxActive) {
//        this.maxActive = maxActive;
//    }
//
//
//    public long getMaxWait() {
//        return maxWait;
//    }
//
//    public void setMaxWait(long maxWait) {
//        this.maxWait = maxWait;
//    }
//    private  static List<Connection> pool = Collections.synchronizedList(new LinkedList<Connection>());
//    //初始化连接池
//    public void createPool(int initialSize){
//        for(int i=0;i<initialSize;i++){
//            addConnection();
//        }
//    }
//
//    //动态添加连接
//    public  synchronized  void  dynamicLink(){
//        if(pool.size()<=0){
//            if(count==maxActive){
//                System.out.println("达到最大连接数");
//                long future =System.currentTimeMillis()+maxWait;
//                long remaining=maxWait;
//
//                while(pool.size()<=0&&remaining>0){
//                    try{
//                        this.wait(remaining);
//                        remaining=future-System.currentTimeMillis();
//
//                        if(remaining<0){
//                            throw new RuntimeException( "连接超时");
//                        }
//                    }
//                    catch ( InterruptedException e){
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }
//
//        else{
//            addConnection();
//        }
//    }
//
//    //添加连接
//    public  void addConnection(){
//        Connection conn =MyDataSourceFactory.getConnection();
// pool.add(conn);
// count++;
//
//    }
//    //获取单个连接
//    public  synchronized  Connection getConnection(){
//        dynamicLink();
//        System.out.println("连接总数"+count+"剩余连接数"+pool.size());
//        Connection conn=pool.remove(0);
//         Connection proxyConn= (Connection) Proxy.newProxyInstance(conn.getClass().getClassLoader(), new Class[]{Connection.class}, new InvocationHandler() {
//            @Override
//            public synchronized   Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                Object rtValue=null;
//
//                if("close".equals(method.getName())){
//                    Thread.sleep(5000);
//                    pool.add(conn);
//                    this.notifyAll();
//                }
//                else {
//
//                    rtValue=method.invoke(conn,args);
//                }
//
//                return  rtValue;
//            }
//        });
//        System.out.println(Thread.currentThread().getName()+"获取的"+proxyConn);
//     return proxyConn;
//    }
//
//    public synchronized  int getSize(){
//        return pool.size();
//    }
//
//

//    }

    private static String url = "jdbc:mysql://localhost:3306/db1";
    private static String user = "root";
    private static String password = "root";

    private static int initCount = 5;//初始化连接数
    private static int maxCount = 10;//最大连接数
    private static int currentCount = 5;//当前连接数

    private static LinkedList<Connection> connectionsPoll = new LinkedList<Connection>();

    public MyDataSource() {
        try {
            for (int i = 0; i <= initCount; i++) {//初始化生成5个数据库连接
                connectionsPoll.addLast(this.createConnection());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Connection createConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public void free(Connection conn) {
        connectionsPoll.addLast(conn);//将连接放回连接池
    }

    public Connection getConnection() throws SQLException {
        synchronized (connectionsPoll) {//多线程并发处理
            if (connectionsPoll.size() > 0) {
                return connectionsPoll.removeFirst();
            } else if (currentCount < maxCount) {
                //未超过最大连接数，则新建连接
                Connection conn = createConnection();
                connectionsPoll.add(conn);
                currentCount++;
                return conn;
            } else {
                throw new SQLException("连接已经用完");
            }
        }
    }
}




