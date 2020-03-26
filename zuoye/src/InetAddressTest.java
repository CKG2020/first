import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest{
    public static  void main (String[]args)throws UnknownHostException {
        InetAddress a= InetAddress.getLocalHost();
       System.out.println(a);
       String b=a.getHostName();
        System.out.println(b);
        String ip=a.getHostAddress();
        System.out.println(ip);
    }
}
