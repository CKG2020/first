package com.redis;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

public class PropertiesTest {

    public static boolean DEBUG = false;

    private final static String SYSTEM_CONFIG = "resources.properties";


    private Map<String, String> params;


    private static PropertiesTest config;


    private PropertiesTest() {
        load();
    }


    public static PropertiesTest instance() {
        if (null == config) {
            config = new PropertiesTest();
        }
        return config;
    }


    /*
     * 载入properties资源文件
     */
    @SuppressWarnings({"unchecked"})
    private void load() {
        if (null == this.params) {
            this.params = new HashMap<String, String>();
        } else {
            this.params.clear();
        }
        Properties properties = new Properties();
        InputStream inputStream = this.getClass().getClassLoader()
                .getResourceAsStream(SYSTEM_CONFIG);
        try {
            properties.load(inputStream);
            Iterator it = properties.keySet().iterator();
            while (it.hasNext()) {
                Object key = it.next();
                if (null != key && !key.toString().equals("")) {
                    String value = properties.getProperty(key.toString());
                    params.put(key.toString().trim(), value.trim());
                }
            }
        } catch (IOException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 获得资源文件中指定key的的value值
     */
    public void getValue(String key) {
        System.out.println(this.params.get(key));
    }


    public static void main(String[] args) {

//        System.out.println( PropertiesTest.instance().getValue("TEST_KEY"));
        PropertiesTest test = PropertiesTest.instance();
        test.getValue("SERVER_ADDRESS");
        test.getValue("SERVER_PORT");
    }


//    Properties properties = new Properties();
//     // 使用ClassLoader加载properties配置文件生成对应的输入流
//           InputStream in = PropertiesTest.class.getClassLoader().getResourceAsStream("config/config.properties");
//     // 使用properties对象加载输入流
//        properties.load(in);
//    //获取key对应的value值
//            properties.getProperty(String key);

}











