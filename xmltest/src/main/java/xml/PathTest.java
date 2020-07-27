package xml;

import java.io.BufferedInputStream;
import java.io.InputStream;

public class PathTest {
    public static void main(String[] args) {
        PathTest pathTest = new PathTest();
//        第一种方式会从当前类的目录下去找，这个文件如果不和该类在一个目录下，就找不到。
//        第二种方式会从编译后的整个classes目录下去找，maven也会把资源文件打包进classes文件夹，所以可以找到。
//        第三种方式中ClassLoader就是从整个classes目录找的，所以前面无需再加/。

//        InputStream is = pathTest.getClass().getResourceAsStream("admin.xml");  //拿不到资源
//        InputStream is = pathTest.getClass().getResourceAsStream("/" +"admin.xml"); // 拿到资源
//        InputStream bufferedInputStream = new BufferedInputStream(is);
        InputStream is = pathTest.getClass().getClassLoader().getResourceAsStream("admin.xml"); //拿到资源

        System.out.println(is);
//              /home/ckg/secnod/secnod/HomeWork/src/main/resources/admin.xml
//    }

                System.out.println(PathTest.class.getClassLoader()
                .getResource("admin.xml").getPath());
//                /home/ckg/first/xmltest/target/classes/admin.xml
    }
}