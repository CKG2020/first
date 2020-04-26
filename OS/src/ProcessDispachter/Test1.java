package ProcessDispachter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test1 {
    public static void main(String[] args) throws IOException {
        System.out.println("请输入进程数：");
        FCFSBean cok = new FCFSBean();
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        String str1 = buf.readLine();
        //   数字类型的String字符串转换为浮点数通常采用parseDouble()和valueOf()方法
        int a = (int) Double.parseDouble(str1);
        cok.setProcess_num(a);
        cok.setArival_time();
        cok.setService_time();
        cok.setStart_time();


        cok.getArival_time();
        cok.getService_time();
        cok.getStart_time();
        cok.getComplete_time();


    }
}
