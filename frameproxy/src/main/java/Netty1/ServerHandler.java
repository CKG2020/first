package Netty1;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ServerHandler extends SimpleChannelInboundHandler {
//    protected void channelRead0(ChannelHandlerContext channelHandlerContext, Object s) throws Exception {
//        RpcRequest rpcRequest= (RpcRequest) s;
//        if (null!=rpcRequest){
//            System.out.println("cxl  "+rpcRequest.toString());
//            channelHandlerContext.writeAndFlush(resp(rpcRequest.getRequestId(),rpcRequest));
//        }
//    }

    private Object resp(String id,RpcRequest rpcRequest) throws IOException, ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        HelloServiceImpl service=new HelloServiceImpl();

        String methodName = rpcRequest.getMethodName();
            Class<?>[] paramTypes = rpcRequest.getParameterTypes();
            Object[] args = rpcRequest.getParameters();

                Method method = service.getClass().getMethod(methodName, paramTypes);
                Object invoke = method.invoke(service, args);

        RpcResponse rpcResponse=new RpcResponse();
        rpcResponse.setRequestId(id);
        rpcResponse.setResult(invoke);
        rpcResponse.setErrorMsg("xxxx");
        return rpcResponse;
    }

    protected void messageReceived(ChannelHandlerContext ctx, Object msg) throws Exception {
        RpcRequest rpcRequest= (RpcRequest) msg;
        if (null!=rpcRequest){
//            System.out.println("cxl  "+rpcRequest.toString());
            System.out.println("xxxxxxxxxxxxx"+rpcRequest.toString());
            ctx.writeAndFlush(resp(rpcRequest.getRequestId(),rpcRequest));
        }
    }
}
