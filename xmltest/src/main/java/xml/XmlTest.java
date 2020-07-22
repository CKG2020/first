package com.FourDataFormat.xml;

//import org.apache.ibatis.io.Resources;
import org.apache.ibatis.io.Resources;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;


public class XmlTest {

    public static void main(String[] args) throws Exception {

        // 待填充user对象
        User user = new User();
        // 获得User的class对象，后续要使用反射
        Class clazz = user.getClass();
//Resources.getResourceAsStream("config/mybatis.xml")
//        File file = new File(XmlTest.class.getClassLoader()
//                .getResource("admin.xml").getPath());



//        private static ClassLoader loder=ClassLoader.getSystemClassLoader();
//        public Connection build(String resource) {
//            try {
//                InputStream stream = loder.getResourceAsStream(resource);


        InputStream resourceAsStream1 =Thread.currentThread().getContextClassLoader().getResourceAsStream("admin.xml");
//        InputStream resourceAsStream = Resources.getResourceAsStream("admin.xml");




//        System.out.println(XmlTest.class.getClassLoader()
//                .getResource("admin.xml").getPath());








//
//            String strResult = null;
//            if (System.getProperty("os.name").toLowerCase().indexOf("window") > -1) {
//                System.out.println("xxxxxxxxxxxxxxx");
//                strResult = XmlTest.class.getResource("/").toString().replace("file:/", "")
//                        .replace("%20", " ");
//            } else {
//                System.out.println("yyyyyyyyyyyyyyyyy");
//                strResult = XmlTest.class.getResource("/").toString().replace("file:", "")
//                        .replace("%20", " ");
//            }
//
//           String filePath=strResult + "admin.xml";
//
//
//        File file = new File(filePath);



        SAXReader reader = new SAXReader();
        // 读取xml文件到Document中
        Document doc = reader.read(resourceAsStream1);
        // 获取xml文件的根节点
        Element rootElement = doc.getRootElement();
        System.out.println("根节点:" + rootElement.getName());

        // 获得根节点的所有属性
        List<Attribute> attrList = rootElement.attributes();
        for (Attribute attribute : attrList) {
            // 根节点某个属性名
            String attrName = attribute.getName();
            System.out.println("当前节点属性名：" + attrName);
            // 根节点某个属性值
            String attrValue = attribute.getValue();
            // 通过属性名定位user对象中对应属性的setter方法
            Field filed = clazz.getDeclaredField(attrName);
            Class cla = filed.getType();// 属性类型
            System.out.println("当前属性类型名称：" + cla.getName());
            Object val = typeTransfer(cla.getName(), attrValue);
            String methodName = "set" + attrName.substring(0, 1).toUpperCase() + attrName.substring(1);
            System.out.println("当前节点属性对应方法名：" + methodName);
            Method method = clazz.getDeclaredMethod(methodName, cla);
            method.invoke(user, val);
        }

        // 获取子节点
        List<Element> elements = rootElement.elements();
        for (Element element : elements) {
            // 根节点某个节点名
            String elemName = element.getName();
            System.out.println("当前节点属性名：" + elemName);
            // 根节点某个节点值
            String elemValue = element.getText();
            // 通过节点名定位user对象中对应属性的setter方法
            Field filed = clazz.getDeclaredField(elemName);
            Class cla = filed.getType();// 属性类型
            System.out.println("当前属性类型名称：" + cla.getName());
            Object val = typeTransfer(cla.getName(), elemValue);
            String methodName = "set" + elemName.substring(0, 1).toUpperCase() + elemName.substring(1);
            System.out.println("当前节点属性对应方法名：" + methodName);
            Method method = clazz.getDeclaredMethod(methodName, cla);
            method.invoke(user, val);
        }
        System.out.println(user);
    }

    private static Object typeTransfer(String typeName, String vlaue) throws ParseException {
        switch (typeName) {
            case "java.lang.Integer":
                return Integer.valueOf(vlaue);
            case "java.lang.String":
                return vlaue;
            case "java.util.Date":
                return new SimpleDateFormat("yyyy-MM-dd").parse(vlaue);
        }
        return null;
    }
}