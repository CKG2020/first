package com.example.test;

import com.example.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import  org.hibernate.cfg.Configuration;

public class Test {
    public static void main(String[] args) {
        Configuration configuration=new Configuration();
        configuration.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory=configuration.buildSessionFactory();
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        Student student=new Student();
        student.setId(1);
        student.setName("chen");
        student.setStuNum("0304180216");
        session.save(student);
        transaction.commit();
        session.close();
        System.out.println("success");

    }
}
