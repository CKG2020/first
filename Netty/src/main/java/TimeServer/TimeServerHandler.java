package TimeServer;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.concurrent.EventExecutorGroup;


import java.util.Date;

public class TimeServerHandler  extends ChannelInboundHandlerAdapter {

public  void channelRead(ChannelHandlerContext ctx ,Object msg) {

    String body= (String) msg;
    System.out.println("The time server received order:"+body);
    String currentTime="ERROR";
    if (body.equals("abc")){
//       new  Date().getTime() 获取时间，以毫秒为单位； 这样子不好看时间
//        currentTime=String.valueOf(new Date().getTime());
        Date d=new Date();
        long time=d.getTime();
        d.setTime(1000);
        currentTime=String.valueOf(d.getTime());
        System.out.println(currentTime);
    }
    ByteBuf byteBuf = Unpooled.copiedBuffer(currentTime.getBytes());
    ctx.write(byteBuf);
    ctx.flush();

}


}
