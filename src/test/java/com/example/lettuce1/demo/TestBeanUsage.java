package com.example.lettuce1.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestBeanUsage {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Appconfig.class);
        context.getBean("myBean");
        //@Bean 的作用 不用自己生成类的对象,@Bean下的方法通过spring管理生成自己对应类的对象再由ApplicationContext 找到那个对象调用该对象的方法
        context.getBean("yourBean");
    }
}
