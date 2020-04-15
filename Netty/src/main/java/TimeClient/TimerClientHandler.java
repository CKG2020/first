package TimeClient;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.io.UnsupportedEncodingException;

public class TimerClientHandler   extends ChannelInboundHandlerAdapter {
    private  final ByteBuf buf;

    public TimerClientHandler() {
        byte[] req="abc\r\n".getBytes();
//        建buffer的方式是使用Pooled或Unpooled类静态方法
        this.buf = Unpooled.buffer(req.length);
       buf.writeBytes(req);
    }

    public void  channelActive(ChannelHandlerContext ctx) {
        ctx.writeAndFlush(buf);
    }

    public  void channelRead(ChannelHandlerContext ctx,Object msg) throws UnsupportedEncodingException {
//        ByeBuf是netty采用来替代ByeBuffer的，但是会在最终发送的时候还是把它ByeBuf转化成ByeBuffer。
        ByteBuf buf = (ByteBuf) msg;

        byte[] req=new byte[buf.readableBytes()];

//  readBytes（ByteBuf）,将数据读取到目标ByteBuf
        buf.readBytes(req);
        String body=new String(req,"UTF-8");
        System.out.println("now is:"+body);

    }
    public  void exceptionCaught(ChannelHandlerContext ctx,Throwable cause){
        cause.printStackTrace();
        ctx.close();
    }
}
