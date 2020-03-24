import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

public class Inssert1 {
    private static Charset charset = Charset.forName("UTF-8");

    private static void scatter(final String fileName) throws IOException {
        RandomAccessFile accessFile = new RandomAccessFile(fileName, "r");
        //获取文件通道
        FileChannel channel = accessFile.getChannel();
        //创建两个缓冲区
        ByteBuffer headBuffer = ByteBuffer.allocate(3);
        ByteBuffer bodyBuffer = ByteBuffer.allocate(1024);

        ByteBuffer[] allBuffers = new ByteBuffer[]{headBuffer, bodyBuffer};
        // headBuffer 前10个字节
        // bodyBuffer 剩下的
        long n = channel.read(allBuffers);
        System.out.println("共读到多少字节:" + n);

        headBuffer.flip();
        //head缓冲区中的数据:qw
        System.out.println("head缓冲区中的数据:" + charset.decode(headBuffer));

        bodyBuffer.flip();
        //body缓冲区中的数据:ertyuiop
        System.out.println("body缓冲区中的数据:" + charset.decode(bodyBuffer));

        accessFile.close();
        channel.close();
    }
    private static void writeData(final String fileName, String data) throws IOException {
        RandomAccessFile accessFile = new RandomAccessFile(fileName, "rw");
        accessFile.writeBytes(data);
        accessFile.close();
    }

    public void test1() {

        String str = "abcde";
        ByteBuffer buf = ByteBuffer.allocate(1024);
        buf.put(str.getBytes());
        buf.rewind();
        byte[] dst = new byte[buf.limit()];
        buf.get(dst, 0, 5);
        System.out.println(new String(dst, 0, 5));
        buf.mark();
        String str1 = "ckg";
        buf.put(str.getBytes());
        buf.get(dst, 0, 55);
        System.out.println(new String(dst, 0, 55));

    }
    public static void main(String[] args) {
        Inssert1 a = new  Inssert1 ();
        a.test1();
}}