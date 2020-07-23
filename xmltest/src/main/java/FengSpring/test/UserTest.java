package com.FengSpring.test;

import com.FengSpring.achievement.BeanFactory;
import com.FengSpring.achievement.ClassPathXmlApplicationContext;
import com.FengSpring.using.User;
import org.jdom.JDOMException;
import org.junit.Test;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class UserTest {
    @Test
    public void test() throws IllegalAccessException, InvocationTargetException, IOException, InstantiationException, JDOMException, NoSuchMethodException, ClassNotFoundException {
       BeanFactory   factory = new ClassPathXmlApplicationContext();
        User  me =(User) factory.getBean("me");
      me.print();

    }
}
