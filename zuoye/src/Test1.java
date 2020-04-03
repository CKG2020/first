/**
 * 一、缓冲区（Buffer）:在java NIO中负责数据的存取。缓冲区就是数组。用于存储
 * 不同数据类型的数据
 * <p>
 * 根据数据类型的不同（boolean除外），提供对应类型的缓冲区：
 * ByteBuffer - 最常用的
 * CharBuffer
 * ShortBuffer
 * IntBuffer
 * LongBuffer
 * FloatBuffer
 * DoubleBuffer
 * <p>
 * 上述的缓冲区的管理方式几乎是一致的 ，通过allocate()获取缓冲区
 * <p>
 * 二、缓冲区里面的存取数据的两个核心方法：
 * put()：存入数据到缓冲区中
 * get()：获取缓冲区中的数据
 * <p>
 * 四 、缓冲区中的核心属性
 * capacity：容量，表示缓冲区中最大存储数据的容量，一旦声明了则不能改变。
 * limit：表示缓冲区中可0以操作数据的大小。（limit后数据是不可以进行读写的）
 * position：位置，表示缓冲区正在操作数据的位置。
 * mark：标记，表示记录当前position的位置，可以通过reset()恢复到mark的位置
 * <p>
 * 0 <= mark <= position <= limit <= capacity
 */

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

public class Test1 {
    public void test2() {
        String str = "ab57854545";
        ByteBuffer buf = ByteBuffer.allocate(1024);
        buf.put(str.getBytes());

        buf.flip();

        byte[] dst = new byte[buf.limit()];
        buf.get(dst, 0, 3);
        System.out.println(new String(dst, 0, 2));

        System.out.println(buf.position());

        //mark()：标记
        buf.mark();
        buf.get(dst, 3, 2);
        System.out.println(new String(dst, 0, 3) + "---------");
        System.out.println(buf.position());

        //reset()
        buf.reset();
        System.out.println(buf.position());

        //判断缓冲区中是否还有剩余数据
        if (buf.hasRemaining()) {
            //如果有的话，那么获取缓冲区中可以操作的数量
            System.out.println(buf.remaining());
        }
    }


    public void test1() {
        String str = "abcde";
        //1.分配一个指定大小的缓冲区
        ByteBuffer buf = ByteBuffer.allocate(1024);
        System.out.println("-------allocate()-------");
        System.out.println("正在操作的位置 " + buf.position());
        System.out.println("缓冲区中可操作数据的大小 " + buf.limit());
        System.out.println("容量 " + buf.capacity());

        //2.利用put()方法存入数据到缓冲区
        buf.put(str.getBytes());
        System.out.println("-------put()-------");
        System.out.println("正在操作的位置 " + buf.position());
        System.out.println("缓冲区中可操作数据的大小 " + buf.limit());
        System.out.println("容量 " + buf.capacity());
        //3.切换成读取数据的模式,利用flip()方法来进行读取数据
        buf.flip();
        System.out.println("-------flip()-------");
        System.out.println("正在操作的位置 " + buf.position());
        System.out.println("缓冲区中可操作数据的大小 " + buf.limit());
        System.out.println("容量 " + buf.capacity());
        //4.利用get()读取缓冲区中的数据
        byte[] dst = new byte[buf.limit()];
        buf.get(dst);
        System.out.println(new String(dst, 0, dst.length));
        System.out.println("-------get()-------");
        System.out.println("正在操作的位置 " + buf.position());
        System.out.println("缓冲区中可操作数据的大小 " + buf.limit());
        System.out.println("容量 " + buf.capacity());
        //5.rewind():表示可以重复读取
        buf.rewind();
        System.out.println("-------rewind()-------");
        System.out.println("正在操作的位置 " + buf.position());
        System.out.println("缓冲区中可操作数据的大小 " + buf.limit());
        System.out.println("容量 " + buf.capacity());
        //6.清空缓冲区,但是缓冲区中的数据依然存在，只不过数据是处于被遗望的状态
        buf.clear();
        System.out.println("-------clear()-------");
        System.out.println("正在操作的位置 " + buf.position());
        System.out.println("缓冲区中可操作数据的大小 " + buf.limit());
        System.out.println("容量 " + buf.capacity());

    }

    public static void main(String[] args) {
        Test1 a = new Test1();
        a.test2();
    }
}