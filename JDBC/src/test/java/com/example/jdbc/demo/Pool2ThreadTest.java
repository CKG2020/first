package com.example.jdbc.demo;

import com.example.jdbc.demo.poo2.MyDataSource;
import com.example.jdbc.demo.poo2.MyDataSourceFactory;
import com.example.jdbc.demo.poo2.Threadone;
import org.omg.PortableServer.THREAD_POLICY_ID;

public class Pool2ThreadTest {
    public static void main(String[] args) {
        MyDataSource dataSource = MyDataSourceFactory.createDataSource();
        Threadone one = new Threadone(dataSource);

        Thread t1 = new Thread(one);
        t1.start();
    }

}
