package com.example.hsqTest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class TestMain {



    public static void main(String[] args) {


        Configuration config = new Configuration().configure("com/example/hsqTest/hibernate.cfg.xml");
        //创建服务注册对象
//        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
        //创建会话工厂对象
        SessionFactory    sessionFactory = config.buildSessionFactory();
        //会话对象
        Session      session = sessionFactory.openSession();

        Transaction     transaction = session.beginTransaction();
//        Transaction tx = null;
//        try {
//            tx = session.beginTransaction();
//            session.save(customer);
//            tx.commit();
//        } catch (Exception e) {
//            if (tx != null) {
//                tx.rollback();
//            }
//        } finally {
//            session.close();
//        }

        try {
//            session = HibernateSessionFactory.getSession();
//            transaction = session.beginTransaction();
            // 1.检索所有学生
            List<StudentEntity> list = session.createQuery("from StudentEntity ").list();
            transaction.commit();

            for (StudentEntity student : list) {
                int size = student.getStudcourse().size();
                if (size == 0) {
                    System.out.println(student.getSname() + "没有选课");
                }else{
                    System.out.println(student.getSname() + "选了" + size + "门课");
                    for (StudCourseEntity studCourse : student.getStudcourse()) {
                        CourseEntity course = studCourse.getCourse();
                        System.out.println(course.getCname()+ " ");
                    }
                    System.out.println();
                }
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException(e);
        }finally {
//            HibernateSessionFactory.closeSession();
            session.close();
        }
    }
}