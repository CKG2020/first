package com.example.DepartmentAndUsr;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class UserAndDeptDAOImpl {

    public void saveObject(DepartmentEntity deptObj, List userObj) throws Exception {

        Configuration config = new Configuration().configure("hibernate.cfg.xml");
        //创建服务注册对象
//        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
        //创建会话工厂对象
        SessionFactory sessionFactory = config.buildSessionFactory();
        //会话对象
        Session session = sessionFactory.openSession();

//        Session session = HibernateSessionFactory.getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            for (int i = 0; i < userObj.size(); i++) {
                UsrEntity user = (UsrEntity) userObj.get(i);
                user.setDepartmentEntity(deptObj);
                deptObj.getUsrs().add(user);
            }
            session.save(deptObj);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            // No matter what, close the session
            session.close();
        }
    }

    public static void main(String args[]) throws Exception {
        DepartmentEntity pt = new DepartmentEntity();
        List list = new ArrayList();




        pt.setId(1);
        pt.setName("测试部");
        pt.setDescription("市场调查人员");
        pt.setStatus("1");
        pt.setGoal("xxx");
        pt.setUsrs(new HashSet());





        UsrEntity user1 = new UsrEntity();
//        user1.setId(1);
        user1.setName("admin");
        user1.setPassword("123");
        user1.setAddress("北京");
        user1.setNickname("管理员");
        user1.setPhone(10);
        user1.setPower("strong");
        user1.setAuth("xxx");
        user1.setBirthdate("xxx");
        user1.setEmail("xxx");
        user1.setDeptid(1);
        user1.setGender("man");
        user1.setGroupid(10);
        user1.setHomephone(10);
        user1.setSuperauth("xxx");
        user1.setTitle("xxx");
        user1.setDepartmentEntity(pt);
        list.add(user1);




        UsrEntity user2 = new UsrEntity();
//        user2.setId(1);
        user2.setName("user_1");
        user2.setPassword("123");
        user2.setAddress("秦皇岛");
        user2.setNickname("李明");
        user1.setPhone(10);
        user1.setPower("strong");
        user1.setAuth("xxx");
        user1.setBirthdate("xxx");
        user1.setEmail("xxx");
        user1.setDeptid(1);
        user1.setGender("man");
        user1.setGroupid(10);
        user1.setHomephone(10);
        user1.setSuperauth("xxx");
        user1.setTitle("xxx");
        user1.setDepartmentEntity(pt);







        list.add(user2);
        new UserAndDeptDAOImpl().saveObject(pt, list);
    }
}
