package RPCServer;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.ProtocolSignature;
import org.apache.hadoop.ipc.RPC;
import org.apache.hadoop.ipc.RPC.Server;

import java.io.IOException;

class Biz implements Bizable{
	@Override
	public String hello(String name){
		System.out.println("被调用了");
		return "hello "+name;
	}

	@Override
	public long getProtocolVersion(String protocol, long clientVersion)
			throws IOException {
		System.out.println("Biz.getProtocalVersion()="+ MyServer.VERSION);
		return MyServer.VERSION;
	}

	@Override
	public ProtocolSignature getProtocolSignature(String s, long l, int i) throws IOException {
		System.out.println("lalallalllalaalal");
		return null;
	}
}

public class MyServer {
	public static int PORT = 3242;
	public static long VERSION = 23234l;
	
	public static void main(String[] args) throws IOException {
		final Server server = RPC.getServer(new Biz(), "127.0.0.1", PORT, new Configuration());
		server.start();
	}

}
