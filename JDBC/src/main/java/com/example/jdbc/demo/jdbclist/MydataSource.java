package com.example.jdbc.demo.jdbclist;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.LinkedList;
import java.util.logging.Logger;

public class MydataSource implements DataSource {
 private static LinkedList<Connection> pool=new LinkedList<Connection>();

 static {
     for (int i = 0; i < 5; i++) {
         Connection conn = JdbcUtil1.getConnection();
         MyConnection myconn = new MyConnection(conn, pool);
         pool.add(myconn);
     }
 }
 //获取连接
    @Override
    public Connection getConnection() throws SQLException {
        Connection conn=null;
        if(pool.size()==0){
            for(int i=0;i<5;i++){
                conn=JdbcUtil1.getConnection();
                MyConnection myconn=new MyConnection(conn,pool);
                pool.add(myconn);
            }
        }
        conn=pool.remove(0);
      return conn;
    }
//归还连接
    public void  returnConnection(Connection conn){
     pool.add(conn);

    }

    @Override
    public Connection getConnection(String s, String s1) throws SQLException {
        return null;
    }

    @Override
    public <T> T unwrap(Class<T> aClass) throws SQLException {
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> aClass) throws SQLException {
        return false;
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        return null;
    }

    @Override
    public void setLogWriter(PrintWriter printWriter) throws SQLException {

    }

    @Override
    public void setLoginTimeout(int i) throws SQLException {

    }

    @Override
    public int getLoginTimeout() throws SQLException {
        return 0;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }
}
