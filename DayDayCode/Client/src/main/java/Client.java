
import sun.awt.HeadlessToolkit;

public class Client {

    public static void main(String[] args) {
//        HelloService helloService = new HelloServiceImpl();
        HelloService helloService = ProxyFrameWork.refer(HelloService.class, "localhost", 9999);
        helloService.hello("hello");
    }
}
