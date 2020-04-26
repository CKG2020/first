package Netty1;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.UUID;


public class ClientHandler extends SimpleChannelInboundHandler {
    //    protected void channelRead0(ChannelHandlerContext channelHandlerContext, Object o) throws Exception {
//        System.out.println(o);
//    }
    HelloService helloService;

//    public ClientHandler(HelloService helloService) {
//        this.helloService = helloService;
//    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        RpcRequest r = (RpcRequest) requests(HelloService.class);

        ctx.writeAndFlush(r);
    }


    private Object requests(Class inface) {

        final RpcRequest rpcRequest = new RpcRequest();

        helloService = (HelloService) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{inface}, new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                rpcRequest.setRequestId(UUID.randomUUID().toString());
                rpcRequest.setMethodName(method.getName());
                Class<?>[] parameterTypes = method.getParameterTypes();
                rpcRequest.setClassName(parameterTypes);
                rpcRequest.setParameters(args);
                return rpcRequest;
            }
        });
        return rpcRequest;
    }


    protected void messageReceived(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("------------------");
        helloService.hello("hello");
        System.out.println(msg);

    }


//    public static void main(String[] args) {
//        ClientHandler clientHandler=new ClientHandler();
//           RpcRequest    rpcRequest= (RpcRequest) clientHandler.requests(HelloService.class);
//        System.out.println(rpcRequest.getClassName());


//    }
}
