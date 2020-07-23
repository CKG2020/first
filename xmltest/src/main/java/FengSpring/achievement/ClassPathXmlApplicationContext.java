package com.FengSpring.achievement;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClassPathXmlApplicationContext implements  BeanFactory {
 private Map<String,Object> beans=new HashMap<>();

public ClassPathXmlApplicationContext() throws JDOMException, IOException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
//   使用JDOM首先要指定使用什么解析器
    SAXBuilder saxBuilder = new SAXBuilder();
    Document document = saxBuilder.build(this.getClass().getClassLoader().getResourceAsStream("user.xml"));
    Element root = document.getRootElement();
    List list = root.getChildren("bean");
    for (int i = 0; i <list.size() ; i++) {
        Element element= (Element)list.get(i);
        String id = element.getAttributeValue("id");
        String clazz = element.getAttributeValue("class");

            Object sbean = Class.forName(clazz).newInstance();
            beans.put(id,sbean);


for (Element propertyElement:(List<Element>)element.getChildren("property")){

    String name = propertyElement.getAttributeValue("name");
    String bean = propertyElement.getAttributeValue("bean");
    Object mbean = beans.get(bean);
    String methodName = "set"+name.substring(0,1).toUpperCase()+name.substring(1);
    System.out.println("method name="+methodName);
    Method method = mbean.getClass().getMethod(methodName, mbean.getClass().getInterfaces()[0]);
    method.invoke(sbean,mbean);





}




    }

}


    @Override
    public Object getBean(String name) {
        return beans.get(name);
    }
}
