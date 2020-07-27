import java.io.*;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 读取Properties综合类
 * @author
 */
public class PropertiesUtil {
//    Object obj;
    /**
     * 配置文件对象
     */
    private Properties props=null;

    /**
     * 构造函数
     * @param fileName 配置文件名称
     */
    public PropertiesUtil(String fileName){
        String filePath=getPath(PropertiesUtil.class) + fileName;
//        String filePath=fileName;
        System.out.println(filePath);
        props = new Properties();
        try {
            InputStream in = new BufferedInputStream(new FileInputStream(filePath));
            props.load(in);
            //关闭资源
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据key值读取配置的值

     * @param key key值
     * @return key 键对应的值
     * @throws IOException
     */
    public String readValue(String key) throws IOException {
        return  props.getProperty(key);
    }

    /**
     * 读取properties的全部信息
     * @throws FileNotFoundException 配置文件没有找到
     * @throws IOException 关闭资源文件，或者加载配置文件错误
     *
     */
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

    /**
     * 得到某一个类的路径
     * @param name
     * @return
     */
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




    private  void writeObject(ObjectOutputStream out,Object obj) throws IOException {

        out.writeObject(obj);
        System.out.println("序列化完成");

    }

    private void readObject(ObjectInputStream in,Object obj1) throws IOException, ClassNotFoundException {


        obj1=in.readObject();
        System.out.println("反序列化完成");
        obj1.toString();
    }









}