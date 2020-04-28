import mapper.PersonMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import pojo.Person;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

public class Test {

    @org.junit.Test
    public void testInsertPerson() throws IOException {
        //获取mybatis全局配置文件
        String resource = "mybatis-config.xml";
         InputStream inputStream = Resources.getResourceAsStream(resource);
        //读取配置文件的配置信息，利用SqlSessionFactoryBuilder创建sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //利用sqlSessionFactory打开与数据库的会话
        SqlSession sqlSession = sqlSessionFactory.openSession();

        try {
            PersonMapper personMapper = sqlSession.getMapper(PersonMapper.class);//通过sqlSession得到mapper

            Person person = new Person();
            person.setId(1);
            person.setAge(1);
            person.setMobilePhone("13937535413");
            person.setUserName("ckg");

            personMapper.insertPerson(person);//调用mapper的方法
            sqlSession.commit();//若是增、删、改操作，不添加此语句则数据库不更改
        } finally {
            sqlSession.close();
        }
    }

    @org.junit.Test
    public void testQueryById() throws IOException {
        //获取mybatis全局配置文件
        String resouces = "mybatis-config.xml";
        InputStream in = Resources.getResourceAsStream(resouces);
        //读取配置文件的配置信息，利用SqlSessionFactoryBuilder创建sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        //利用sqlSessionFactory打开与数据库的会话
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            PersonMapper personMapper = sqlSession.getMapper(PersonMapper.class);//通过sqlSession得到mapper
            Person person = personMapper.queryById(1);//调用mapper的方法
            //只读操作不需要sqlSession.commit()
            System.out.println(person);
        } finally {
            sqlSession.close();
        }

    }

}
