package com.example.hsqTest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class TestMain {



    public static void main(String[] args) {


        Configuration config = new Configuration().configure("com/example/hsqTest/hibernate.cfg.xml");

        SessionFactory    sessionFactory = config.buildSessionFactory();

        Session      session = sessionFactory.openSession();

        Transaction     transaction = session.beginTransaction();


        try {

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