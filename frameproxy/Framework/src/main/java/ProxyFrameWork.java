import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.AbstractEventLoopGroup;
import io.netty.channel.Channel;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProxyFrameWork {
// private static ExecutorService executorService= Executors.newFixedThreadPool(20);

    //暴露服务
//    public static void export(final Object service, int port) throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
//        if (service == null) {
//            throw new IllegalArgumentException("argument");
//        }
//        if (port <= 0 || port > 65535) {
//            throw new IllegalArgumentException("Invalid port" + port);
//        }
//        System.out.println("Export service" + service.getClass().getName() + "port" + port);
//        ServerSocket serverSocket = new ServerSocket(port);
//        while (true) {
//            final Socket accept = serverSocket.accept();
//            executorService.submit(new Runnable() {
//                @Override
//                public void run() {
//                    ObjectInputStream objectInputStream = null;
//                    try {
//                        objectInputStream = new ObjectInputStream(accept.getInputStream());
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                    String methodName = null;
//                    try {
//                        methodName = objectInputStream.readUTF();
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                    Class<?>[] paramTypes = new Class[0];
//                    try {
//                        paramTypes = (Class<?>[]) objectInputStream.readObject();
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    } catch (ClassNotFoundException e) {
//                        e.printStackTrace();
//                    }
//                    Object[] args = new Object[0];
//                    try {
//                        args = (Object[]) objectInputStream.readObject();
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    } catch (ClassNotFoundException e) {
//                        e.printStackTrace();
//                    }
//                    ObjectOutputStream objectOutputStream = null;
//                    try {
//                        objectOutputStream = new ObjectOutputStream(accept.getOutputStream());
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                    try {
//                        Method method = service.getClass().getMethod(methodName, paramTypes);
//                        Object invoke = method.invoke(service, args);
//                        objectOutputStream.writeObject(invoke);
//                        objectOutputStream.flush();
//                    } catch (Throwable throwable) {
//                        try {
//                            objectOutputStream.close();
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }
//                    } finally {
//                        try {
//                            objectOutputStream.close();
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }
//                    }
//
//                }
//            });
    public static void export(final Object service, int port) throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        if (service == null) {
            throw new IllegalArgumentException("argument");
        }
        if (port <= 0 || port > 65535) {
            throw new IllegalArgumentException("Invalid port" + port);
        }
        System.out.println("Export service" + service.getClass().getName() + "port" + port);
//
//        EventLoopGroup bossGroup = new NioEventLoopGroup();
//        //负责处理客户端i/o事件、task任务、监听任务组
//        EventLoopGroup workerGroup = new NioEventLoopGroup();
//        //启动 NIO 服务的辅助启动类
//        ServerBootstrap bootstrap = new ServerBootstrap();
//        bootstrap.group(bossGroup, workerGroup);
//        //配置 Channel
//        bootstrap.channel(NioServerSocketChannel.class);
//        bootstrap.childHandler(new ServerIniterHandler());
//        //BACKLOG用于构造服务端套接字ServerSocket对象，
//        // 标识当服务器请求处理线程全满时，用于临时存放已完成三次握手的请求的队列的最大长度
//        bootstrap.option(ChannelOption.SO_BACKLOG, 1024);
//        //是否启用心跳保活机制
//        bootstrap.childOption(ChannelOption.SO_KEEPALIVE, true);
//        try {
//            //绑定服务端口监听
//            Channel channel = bootstrap.bind(port).sync().channel();
//            System.out.println("server run in port " + port);
//            //服务器关闭监听
//            /*channel.closeFuture().sync()实际是如何工作:
//            channel.closeFuture()不做任何操作，只是简单的返回channel对象中的closeFuture对象，对于每个Channel对象，都会有唯一的一个CloseFuture，用来表示关闭的Future，
//            所有执行channel.closeFuture().sync()就是执行的CloseFuturn的sync方法，从上面的解释可以知道，这步是会将当前线程阻塞在CloseFuture上*/
////            channel.closeFuture().sync();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } finally {
//            //关闭事件流组
//            bossGroup.shutdownGracefully();
//            workerGroup.shutdownGracefully();
//        }

        ServerSocket serverSocket = new ServerSocket(port);
        while (true) {
            Socket accept = serverSocket.accept();
            ObjectInputStream objectInputStream = new ObjectInputStream(accept.getInputStream());
            String methodName = objectInputStream.readUTF();

            System.out.println("xxxxxx" + methodName);

            Class<?>[] paramTypes = (Class<?>[]) objectInputStream.readObject();

            System.out.println("yyyyy" + paramTypes);
            Object[] args = (Object[]) objectInputStream.readObject();
            System.out.println("zzzzz" + args);

            ObjectOutputStream objectOutputStream = new ObjectOutputStream(accept.getOutputStream());
            try {
                Method method = service.getClass().getMethod(methodName, paramTypes);
                Object invoke = method.invoke(service, args);
                //讲的是Method类的invoke()方法。
//                //获取字节码对象
//                Class<Msym> clazz = (Class<Msym>) Class.forName("online.Msym");
//                //获取一个对象
//                Constructor con =  clazz.getConstructor();
//                Msym m = (Msym) con.newInstance();
//                String[] s = new String[]{"aa","bb"};
//                //获取Method对象
//                Method method = clazz.getMethod("test", String[].class);
//                //调用invoke方法来调用
//                method.invoke(m, s);
                objectOutputStream.writeObject(invoke);
                objectOutputStream.flush();
            } catch (Throwable throwable) {
                objectOutputStream.close();
            } finally {
                objectOutputStream.close();
            }

        }
    }

    @SuppressWarnings("unchecked")
    public static <T> T refer(final Class<T> interfaceClass, final String host, final int port) {
        if (interfaceClass == null) {
            throw new IllegalArgumentException("interface class == null");
        }
        if (!interfaceClass.isInterface()) {
            throw new IllegalArgumentException("The" + interfaceClass.getName() + "must be interface");
        }
        if (host == null || host.length() == 0) {
            throw new IllegalArgumentException("host==null!");
        }
        if (port <= 0 || port > 65535) {
            throw new IllegalArgumentException("Invalid port" + port);
        }
        System.out.println("Get remote service" + interfaceClass.getName());


        return (T) Proxy.newProxyInstance(interfaceClass.getClassLoader(), new Class<?>[]{interfaceClass}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Socket socket = new Socket(host, port);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                objectOutputStream.writeUTF(method.getName());
                objectOutputStream.writeObject(method.getParameterTypes());
                objectOutputStream.writeObject(args);
                objectOutputStream.flush();
                ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
                return objectInputStream.readObject();
            }
//                new NettyClient(host,port).run();
//                return

//                EventLoopGroup workerGroup = new NioEventLoopGroup();
//                //启动附注类
//                Bootstrap bootstrap = new Bootstrap();
//                bootstrap.group(workerGroup);
//                //指定所使用的NIO传输channel
//                bootstrap.channel(NioSocketChannel.class);
//                //指定客户端初始化处理
//                bootstrap.handler(new ClientIniterHandler());
//                try {
//                    //连接服务
//                    Channel channel = bootstrap.connect(host, port).sync().channel();
//                    while (true) {
//                        //向服务端发送内容
////                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
////                String content = reader.readLine();
////                if (StringUtils.isNotEmpty(content)) {
////                    if (StringUtils.equalsIgnoreCase(content, "q")) {
////                        System.exit(1);
////                    }
////
////                    channel.writeAndFlush(content);
////                }
//
//                        ObjectInputStream objectInputStream = new ObjectInputStream((InputStream) channel.read());
//
//
//                    }
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                    System.exit(1);
//                } finally {
//                    workerGroup.shutdownGracefully();
//                }
//            }
        });
    }
}
