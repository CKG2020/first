import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.*;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.net.UnknownHostException;

public class URLTest1 {
    public static void main(String[]args){
    StringBuilder sb=new StringBuilder("http://www.baidu.com/s?wd=");
    try{
        sb.append(URLEncoder.encode("java","gb2312"));
//        sb.append("")

    }catch(UnsupportedEncodingException ex){
        ex.printStackTrace();
    }
        System.out.println(sb);
        URLConnection conn =null;
        BufferedReader in=null;
        try{
            conn=new URL(sb.toString()).openConnection();
            in =new BufferedReader(new InputStreamReader(conn.getInputStream(),"gb2312"));
            for(String str=null;(str=in.readLine())!=null;){
                System.out.println(str);
            }}
        catch(IOException ex)  {
                ex.printStackTrace();
            }
        finally{
            if(null!=in){
                try{in.close();
            }catch(IOException ex){
                    ex.printStackTrace();
                }
        }
    }
}
}