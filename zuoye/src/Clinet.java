import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class Clinet {
    private Socket socket;
    private PrintStream printStream;
    private BufferedReader keybr;
    private  BufferedReader brserver;
    public void  inti(){
        keybr=new BufferedReader(new InputStreamReader(System.in));
        try {
            socket=new Socket("127.0.0.1",4569);
            printStream=new PrintStream(socket.getOutputStream());
            brserver=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String tip="";
            while (true){
                String userName= JOptionPane.showInputDialog(tip+"输入用户名");
                printStream.println(ChatProtocol.USER_ROND+userName+ChatProtocol.USER_ROND);
            String result=brserver.readLine();
            if (result.equals(ChatProtocol.NAME_REP)){
                tip="用户名重复,请重新输入";
                continue;
            }
            if (result.equals(ChatProtocol.LOGIN_SUCCESS)){
                System.out.println("登录成功:"+userName);
                break;
            }
            }
        } catch (IOException e) {
            e.printStackTrace();

        }
        new ClientThread(brserver).start();

    }
    public  void readAndsend() throws IOException {
     String line=null;
     while ((line=keybr.readLine())!=null){
         System.out.println(line);
         if (line.indexOf(":")>0&&line.startsWith(ChatProtocol.PRIVATE_ROND)){
             line=line.substring(2);
             printStream.println(ChatProtocol.PRIVATE_ROND+line.split(":")[0]+ChatProtocol.SPLIT_SIGN+line.split(":")[1]+ChatProtocol.PRIVATE_ROND);
        }else if (line.indexOf(":")>0&&line.startsWith(ChatProtocol.USER_ROND)){
             line=line.substring(2);
            printStream.println(ChatProtocol.MSG_ROND+ line.split(":")[0]+ChatProtocol.SPLIT_SIGN+line.split(":")+ChatProtocol.MSG_ROND);
         }
         new ClientThread(brserver).start();
     }
    }
    private void closeRs() {
                try {
                    if (keybr != null) {
                                keybr.close();
                    }if (brserver != null) {
                                 brserver.close();
                    }

                    if (printStream != null) {
                        printStream.close();
                    }

                    if (socket != null) {
                        socket.close();
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
           }

    public static void main(String[] args) {
        Clinet clinet=new Clinet();
        clinet.inti();
        try {
            clinet.readAndsend();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
