import io.lettuce.core.RedisClient;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.async.RedisAsyncCommands;
import io.lettuce.core.api.sync.RedisStringCommands;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.ExecutionException;

public class SingelTest {

 private  RedisClient redisClient;
   private  StatefulRedisConnection<String, String> connect;

    @Before
    public void beforeTest () {
        redisClient = RedisClient.create("redis://localhost");
        System.out.println("init");
    }

    @Test
    public void test() throws ExecutionException, InterruptedException {

        connect = redisClient.connect();
        RedisAsyncCommands command = (RedisAsyncCommands) connect.sync();


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


    @After
    public void afterTest() {
        connect.close();
        redisClient.shutdown();
        System.out.println("finish");
    }

}