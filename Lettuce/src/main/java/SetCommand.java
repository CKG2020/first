import io.lettuce.core.api.async.RedisAsyncCommands;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ExecutionException;

public class SetCommand {
//添
//    SADD key member1 [member2]
//    向集合添加一个或多个成员
//删
//    SPOP key
//    移除并返回集合中的一个随机元素
//
//    SREM key member1 [member2]
//    移除集合中一个或多个成员

// 改


//查
//    SCARD key
//    获取集合的成员数
//
//    SISMEMBER key member
//    判断 member 元素是否是集合 key 的成员
//
//    SMEMBERS key
//    返回集合中的所有成员
//
//    SSCAN key cursor [MATCH pattern] [COUNT count]
//    迭代集合中的元素

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        RedisAsyncCommands command2 = RedisConnectionUtilPool.getConnection().async();
        command2.sadd("x3", "xxx", 0l, 123);

//      Long a=  (Long) command2.scard("x3").get();
//        System.out.println(a);
        Set set = (Set) command2.smembers("x3").get();
        //两种迭代方式
//        Iterator it=set.iterator();
//        while(it.hasNext()){
//            System.out.println(it.next());
//            System.out.println("xxxx");
//        }
        for (Object object : set) {
            System.out.println(object);
        }
        System.out.println(set);

    }
}