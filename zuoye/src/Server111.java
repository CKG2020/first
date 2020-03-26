import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
public class Server111 {
    public static  ClientMap<String,PrintStream> clients= new ClientMap();
    public void init(){
        ServerSocket serverSocket=null;
        Socket socket=null;
        try {
             serverSocket=new ServerSocket(4569);
             while(true){
             socket=serverSocket.accept();
           new Thread(new ServerThread(socket)).start();
             }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Server111 server=new Server111();
        server.init();
    }
}
