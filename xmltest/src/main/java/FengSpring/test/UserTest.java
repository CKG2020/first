package FengSpring.test;

import FengSpring.achievement.BeanFactory;
import FengSpring.achievement.ClassPathXmlApplicationContext;
import FengSpring.using.User;
import FengSpring.using.UserService;
import org.jdom.JDOMException;
import org.junit.Test;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class UserTest {
    @Test
    public void test() throws IllegalAccessException, InvocationTargetException, IOException, InstantiationException, JDOMException, NoSuchMethodException, ClassNotFoundException {
       BeanFactory   factory = new ClassPathXmlApplicationContext();
//        User  me =(User) factory.getBean("me");
//      me.print();
        UserService service = (UserService) factory.getBean("userService");
        User u = new User();
        service.addUser(u);

    }
}
