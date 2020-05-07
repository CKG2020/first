package com.example.customerAndAddress;

import com.example.AddressEntity;
import com.example.CustomerEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class CustomerAndAddressDAO {

    private SessionFactory sessionFactory;
    private Session session;
    private Transaction transaction;

    /**
     * 案例模拟保存客户操作  级联插入相关联的Address
     *
     * @param customer
     */
    public void save(Object customer) {
        Configuration config = new Configuration().configure("hibernate.cfg.xml");
        //创建服务注册对象
//        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
        //创建会话工厂对象
        sessionFactory = config.buildSessionFactory();
        //会话对象
        session = sessionFactory.openSession();

        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(customer);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
    }

    public CustomerEntity findCustomerById(Integer id) {
        CustomerEntity customer = null;
        Configuration config = new Configuration().configure("hibernate.cfg.xml");
        sessionFactory = config.buildSessionFactory();
        //会话对象
        session = sessionFactory.openSession();

        customer = (CustomerEntity) session.get(CustomerEntity.class, id);
        session.close();
        return customer;
    }

    public static void main(String[] args) {
        CustomerAndAddressDAO dao = new CustomerAndAddressDAO();
        //创建一个Customer对象
        CustomerEntity customer = new CustomerEntity();
        //创建一个Address对象
        AddressEntity address = new AddressEntity();
//        address.setId(1);
//        address.setProvice("province1");
        address.setCity("city3");
        address.setStreet("street3");
//        address.setZipcode("100085");
        //设置Address对象和Customer对象关系
//        address.setCustomer(customer);
        customer.setName("ckg");
        customer.setId(3);
        //设置Customer对象和Address对象关系
        customer.setAddress(address);
        //测试保存Customer对象
        dao.save(address);
        dao.save(customer);

        //测试根据id查询Customer方法
//        CustomerEntity c = dao.findCustomerById(1);
//        //打印Customer信息及一一对应的Address对象信息
//        System.out.println("Customer ID:" + c.getId());
//        System.out.println("Customer Name:" + c.getName());
//        System.out.println("Customer Address'id:" + c.getAddress().getId());
//        System.out.println("Customer Address'street:" + c.getAddress().getStreet());
////        System.out.println("Customer Address'province:" + c.getAddress().getProvice());
//        System.out.println("Customer Address'city:" + c.getAddress().getCity());
    }


}
