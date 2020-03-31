package com.example.test;

import com.example.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
//import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

/**
 * Created by DreamBoy on 2016/5/15.
 */
//测试类
public class StudentTest {
    private SessionFactory sessionFactory;
    private Session session;
    private Transaction transaction;

    @Before
    public void init() {

        //创建配置对象
        Configuration config = new Configuration().configure("hibernate.cfg.xml");
        //创建服务注册对象
//        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
        //创建会话工厂对象
        sessionFactory = config.buildSessionFactory();
        //会话对象
        session = sessionFactory.openSession();
        //开启事务
        transaction = session.beginTransaction();
    }

    @After
    public void destory() {
        transaction.commit(); //提交事务
        session.close(); //关闭会话
        sessionFactory.close(); //关闭会话工厂
    }

    @Test
    public void testSaveStudents() {
        //生成学生对象
        Student s = new Student( "张三丰", "0304180215", 2);
        session.save(s); //保存对象进入数据库
    }
}