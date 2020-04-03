import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class SerializeUtil {
    // 保存对象，序列化
    public static void saveObject(Object object) throws Exception {

        try {
            RandomAccessFile aFile = new RandomAccessFile("/home/ckg/Documents/text2.txt", "rw");
            //   fout = new FileOutputStream("/home//Videos/1.txt",true);
            FileChannel fileChannel = aFile.getChannel();
            ByteBuffer xxx = ByteBuffer.allocate(10);
            ByteBuffer xxxx = ByteBuffer.allocate(64);
            byte[] bytes = null;
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            try {
                ObjectOutputStream oos = new ObjectOutputStream(bos);
                oos.writeObject(object);
                oos.flush();
                bytes = bos.toByteArray();
                oos.close();
                bos.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            System.out.println(bytes.length);
//            out = new ObjectOutputStream(fout);
//            out.writeObject(object);
            xxx.put(bytes, 0, 10);
            xxx.mark();
            xxxx.put(bytes, 10, 58);
            System.out.println(xxx);
//            ByteBuffer[] byteBuffers ={xxx,xxxx};
//            fileChannel.write(byteBuffers);
//            fileChannel.close();
            xxx.flip();
            xxxx.flip();
            ByteBuffer[] bufferArray = {xxx, xxxx};
            fileChannel.write(bufferArray);
            //out = new ObjectOutputStream(fout);
            // out.writeObject(object);

            fileChannel.close();
            aFile.close();
        } finally {
            // fout.close();
            // out.close();
        }
    }

    // 读取对象，反序列化
    public static Object readObject() throws Exception {
        ObjectInputStream in = null;
        FileInputStream fin = null;
        try {
            fin = new FileInputStream("/home/ckg/Documents/text2.txt");
            in = new ObjectInputStream(fin);
            Object object = in.readObject();
            return object;
        } finally {
            fin.close();
            in.close();
        }
    }

    public static void main(String[] args) {
        User user = new User();
        user.setName("ckg");
        user.setAge(33);
        User user1 = new User();
        user1.setName("yyy");
        user1.setAge(20);

        // 保存
        try {
            SerializeUtil.saveObject(user);
        } catch (Exception e) {
            System.out.println(e);
        }
        // 读取
        User userObject;
        try {
            userObject = (User) SerializeUtil.readObject();
            System.out.println(userObject);
        } catch (Exception e) {
            System.out.println("读取时异常：" + e.getMessage());
        }
    }

}
