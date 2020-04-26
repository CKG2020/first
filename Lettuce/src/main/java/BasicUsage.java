import io.lettuce.core.RedisClient;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisStringCommands;

public class BasicUsage {
    //同步的使用
    public static void main(String[] args) {
        // client
        RedisClient client = RedisClient.create("redis://localhost");
        // connection, 线程安全的长连接，连接丢失时会自动重连，直到调用 close 关闭连接。
        StatefulRedisConnection<String, String> connection = client.connect();
        // sync, 默认超时时间为 60s.
        RedisStringCommands<String, String> sync = connection.sync();
        sync.set("host", "note.abeffect.com");
        sync.append("host", "xxxx");
        //note.abeffect.comxxxx 追加
        sync.bitcount("host");
        //啥也没有打印出来
        String value = sync.get("host");
        System.out.println(value);
        System.out.println("------------------------------");
        long a = sync.getbit("host", 1l);
        System.out.println(a);

        // close connection
        connection.close();
        // shutdown
        client.shutdown();
    }
}
