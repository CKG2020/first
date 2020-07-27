package com.propertiesTest;

import java.io.*;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class MySqs1 {

    private Properties props=null;


//    public MySqs1(String fileName){
//        String filePath=getPath(MySqs1.class) + fileName;
////        String filePath=fileName;
//        System.out.println(filePath);
//        props = new Properties();
//        try {
//            InputStream in = new BufferedInputStream(new FileInputStream(filePath));
//            props.load(in);
//            //关闭资源
//            in.close();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

  public  MySqs1(){

  }


    private String getPath(Class name) {
        String strResult = null;
        if (System.getProperty("os.name").toLowerCase().indexOf("window") > -1) {
            System.out.println("xxxxxxxxxxxxxxx");
            strResult = name.getResource("/").toString().replace("file:/", "")
                    .replace("%20", " ");
        } else {
            System.out.println("yyyyyyyyyyyyyyyyy");
            strResult = name.getResource("/").toString().replace("file:", "")
                    .replace("%20", " ");
        }
        return strResult;
    }

    public Map<String,String> readAllProperties() throws FileNotFoundException,IOException  {
        //保存所有的键值
        Map<String,String> map=new HashMap<String,String>();
        Enumeration en = props.propertyNames();
        while (en.hasMoreElements()) {
            String key = (String) en.nextElement();
            String Property = props.getProperty(key);
            map.put(key, Property);
        }
        return map;
    }


    public   void writeObject1(ObjectOutputStream out,Object obj) throws IOException {

        out.writeObject(obj);
        System.out.println("序列化完成");

    }

    public void readObject1(ObjectInputStream in,Object obj1) throws IOException, ClassNotFoundException {

        obj1=in.readObject();
        System.out.println("反序列化完成");
        obj1.toString();
    }











}
