import io.lettuce.core.RedisFuture;
import io.lettuce.core.api.async.RedisAsyncCommands;

import java.util.concurrent.ExecutionException;

public class ListCommand {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        RedisAsyncCommands command1 = RedisConnectionUtilPool.getConnection().async();// 创建操作命令
//增
//        LPUSH key value1 [value2]
//        将一个或多个值插入到列表头部
//        LPUSHX key value
//                将一个值插入到已存在的列表头部
//删
//        LREM key count value
//        移除列表元素
//        RPOP key
//        移除列表的最后一个元素，返回值为移除的元素。
//        LPOP key
//        移出并获取列表的第一个元素
//改

//        LSET key index value
//        通过索引设置列表元素的值

// 查
//        LLEN key
//        获取列表长度

//        LINDEX key index
//                通过索引获取列表中的元素
//    Long  a= (long) command1.lpush("x2","name","id","sex").get();
//        System.out.println(a);
        command1.lpush("x2", "name", "id", "sex");
        //获取列表长度
        Long b = (Long) command1.llen("x2").get();
        System.out.println(b);
        //查找元素
        String c = (String) command1.lindex("x2", 1l).get();
        System.out.println(c);
        //修改指定索引的数据
        command1.lset("x2", 0l, "stuid");
        String d = (String) command1.lindex("x2", 0l).get();
        System.out.println(d);
        //添加元素
        //头插
        command1.lpushx("x2", "xxixi");
        String e = (String) command1.lindex("x2", 0l).get();
        System.out.println(e);

        //删除元素
        command1.lrem("x2", 0l, "xxixi");
        String f = (String) command1.lindex("x2", 0l).get();
        System.out.println(f);
//        System.out.println("【获取Hash数据】" + command1.lpop().get());
        RedisConnectionUtilPool.close();

//  command1.keys("x2");
//  command1.lpushx("x2","hobby");
//command1.lp


    }

}
