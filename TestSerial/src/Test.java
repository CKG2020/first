import java.io.IOException;
import java.util.Map;

public class Test {
    public static void main(String[] args) throws IOException {
        PropertiesUtil propertiesUtil = new PropertiesUtil("xxxx.properties");
//        System.out.println(propertiesUtil.readValue());


        Map<String, String> stringStringMap = propertiesUtil.readAllProperties();
        for (String key : stringStringMap.keySet()) {
                System.out.println("key= "+ key + " and value= " + stringStringMap.get(key));
        }
//         Test t = new Test();
//         Class clazz = t.getClass();
//         System.out.println(clazz.getCanonicalName());
//         System.out.println(clazz.getSimpleName());


    }
}
