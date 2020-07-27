import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;



public class MySqs {
    Object obj;

    public MySqs(Object obj) {
        this.obj = obj;
    }

    private  void writeObject(ObjectOutputStream out) throws IOException {

        out.writeObject(obj);
        System.out.println("序列化完成");

    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        this.obj=in.readObject();
        System.out.println("反序列化完成");
        obj.toString();
    }
}
