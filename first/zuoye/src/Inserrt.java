import java.io.*;

public class Inserrt {
    public static void insert(String fileName, long pos
            , String insertContent) throws IOException {
        File tmp = File.createTempFile("tmp1111", null);
        tmp.deleteOnExit();

        RandomAccessFile raf = new RandomAccessFile(fileName, "rw");
        FileOutputStream tmpOut = new FileOutputStream(tmp);
        FileInputStream tmpIn = new FileInputStream(tmp);
        raf.seek(pos);
        byte[] bbuf = new byte[64];
        int hasRead = 0;
        while ((hasRead = raf.read(bbuf)) > 0) {
            tmpOut.write(bbuf, 0, hasRead);
        }
        raf.seek(pos);
        raf.write(insertContent.getBytes());
        while ((hasRead = tmpIn.read(bbuf)) > 0) {
            raf.write(bbuf, 0, hasRead);
        }
        tmpIn.close();
        tmpOut.close();
        raf.close();

    }

    public static void main(String[] args)
            throws IOException {
        insert("Insert.java", 5, "ckg");
        System.in.read();
    }
}


