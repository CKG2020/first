import io.lettuce.core.api.async.RedisAsyncCommands;

import java.util.concurrent.ExecutionException;

public class StringCommand {
    //增
//    SET key value
//    设置指定 key 的值

    //删


    //改


    //查

//    GET key
//    获取指定 key 的值。
//    STRLEN key
//    返回 key 所储存的字符串值的长度。



    public static void main(String[] args) throws ExecutionException, InterruptedException {
        RedisAsyncCommands command4 = RedisConnectionUtilPool.getConnection().async();
//        command4.set()
}}
