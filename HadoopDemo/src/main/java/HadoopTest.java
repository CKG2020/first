import org.apache.hadoop.conf.Configuration;

import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.io.IOUtils;
import sun.nio.ch.IOUtil;

import java.io.*;
import java.net.URI;


public class HadoopTest {


    public static void main(String[] args) throws IOException {
        //读取hdfs已经存在的文件
        System.out.println();
        Configuration configuration1 = new Configuration();
        Configuration configuration = configuration1;
        System.out.println("xxxxxx");
        URI uri = URI.create("hdfs://172.17.205.61:9000/usr/tmp/flag.txt");
        FileSystem fs = FileSystem.get(uri, configuration);
        InputStream inputStream = null;
        try {
            inputStream = fs.open(new Path(uri));
            IOUtils.copyBytes(inputStream, System.out, 2048, false);
        } catch (Exception e) {
            IOUtils.closeStream(inputStream);
        }

        System.out.println("===============================");

////        System.out.println("Java接口上传文件");
////        File file = new File("~/test.txt");
//        String hdfsPath = "hdfs://172.17.205.61:9000/usr/tmp/test.txt";
////        InputStream in = new BufferedInputStream(new FileInputStream(file));
////        FileSystem fileSystem = FileSystem.get(URI.create(hdfsPath, configuration));
//        FileSystem  fs1 = FileSystem.get(URI.create(hdfsPath), configuration);
//        FileStatus fileStatus=fs1.getFileStatus(new Path(hdfsPath));
//        if (!fileStatus)


    }
}
