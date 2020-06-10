package com.example.hsqTest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Test1 {

    Configuration config = new Configuration().configure("com/example/hsqTest/hibernate.cfg.xml");

    SessionFactory sessionFactory = config.buildSessionFactory();

    Session session = sessionFactory.openSession();

    Transaction transaction = session.beginTransaction();
    public  void querySome(){


        try {


            // 1.检索学生的名字和所在系
            // JDBC是要查询什么字段就查询什么字段，而不要select * from 表
            // 但Hibernate建议我们把对象的所有属性都查询出来，这样才能封装成一个完整的对象
            // 这里进行演示查询部分属性
            List<Object[]> list = session.createQuery("select sname, sdept from StudentEntity ").list();
            for (Object[] objects: list) {
                System.out.println(objects[0] + " " + objects[1]);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException(e);
        }finally {
            session.close();
        }
    }

    public  void queryOne() {

        try {

            StudentEntity student = (StudentEntity) session.createQuery("from StudentEntity where sid = " + 20050003).uniqueResult();
            System.out.println("student = " + student.toString());
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }finally {
          session.close();
        }
    }
    public static void main(String[] args) {
        Test1 test1 = new Test1();
       test1.queryOne();
    }




}
