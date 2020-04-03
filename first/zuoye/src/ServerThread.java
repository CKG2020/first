import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class ServerThread implements Runnable {
    Socket socket;
    BufferedReader br = null;

    PrintStream printStream = null;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }


    @Override
    public void run() {
        try {
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            printStream = new PrintStream(socket.getOutputStream());
            String line = null;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                if (line.startsWith(ChatProtocol.USER_ROND) && line.endsWith(ChatProtocol.USER_ROND)) {
                    String userName = getRealMsg(line);
                    if (Server111.clients.map.containsKey(line)) {
                        System.out.println("用户名重复");
                        printStream.println(ChatProtocol.NAME_REP);
                    } else {
                        System.out.println(line + "登录成功可以开始聊天");
                        printStream.println(ChatProtocol.LOGIN_SUCCESS);
                        Server111.clients.map.put(line, printStream);
                    }

                    if (line.startsWith(ChatProtocol.PRIVATE_ROND) && line.endsWith(ChatProtocol.PRIVATE_ROND)) {
                        String userAndMsg = getRealMsg(line);
                        String user = userAndMsg.split(ChatProtocol.SPLIT_SIGN)[0];
                        System.out.println("你好" + user);
                        String msg = userAndMsg.split(ChatProtocol.SPLIT_SIGN)[9];
                        System.out.println("测试msg" + msg);
                        Server111.clients.map.get(user).println("[私聊信息][来自" + Server111.clients.getKeyByValue(printStream) + "]:" + msg);

                    } else {
                        String msg = getRealMsg(line);
                        for (PrintStream clientPs : Server111.clients.valueSet()) {
                            clientPs.println("[群发信息] [来自 " + Server111.clients.getKeyByValue(printStream) + "] : " + msg);
                        }
                    }


                }
            }
        } catch (IOException e) {
            Server111.clients.removeByValue(printStream);
            System.out.println(Server111.clients.map.size());
            try {
                if (br != null) {
                    br.close();
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
    }

    String getRealMsg(String line) {
        return line.substring(2,
                line.length() - 2);
    }
}



