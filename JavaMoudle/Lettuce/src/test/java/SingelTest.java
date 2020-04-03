import io.lettuce.core.RedisClient;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.async.RedisAsyncCommands;
import io.lettuce.core.api.sync.RedisStringCommands;
import org.junit.Test;

import java.util.concurrent.ExecutionException;

public class SingelTest {

@Test
public void test() throws ExecutionException, InterruptedException {

    RedisClient client = RedisClient.create("redis://localhost");
    // connection, 线程安全的长连接，连接丢失时会自动重连，直到调用 close 关闭连接。
    StatefulRedisConnection<String, String> connection = client.connect();
    // sync, 默认超时时间为 60s.
    RedisAsyncCommands<String, String> command = connection.async();
        //获取列表长度
//    command.
        Long b = (Long) command.llen("x2").get();
        System.out.println(b);
        //查找元素
        String c = (String) command.lindex("x2", 1l).get();
        System.out.println(c);
        //修改指定索引的数据
        command.lset("x2", 0l, "stuid");
        String d = (String) command.lindex("x2", 0l).get();
        System.out.println(d);
        //添加元素
        //头插
        command.lpushx("x2", "xxixi");
        String e = (String) command.lindex("x2", 0l).get();
        System.out.println(e);

        //删除元素
        command.lrem("x2", 0l, "xxixi");
        String f = (String) command.lindex("x2", 0l).get();
        System.out.println(f);
    }
}