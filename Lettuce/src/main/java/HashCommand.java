import io.lettuce.core.RedisFuture;
import io.lettuce.core.api.async.RedisAsyncCommands;

import java.util.HashMap;
import java.util.Map;

public class HashCommand {

    public static void main(String[] args) throws Exception {
        RedisAsyncCommands commands = RedisConnectionUtilPool.getConnection().async();// 创建操作命令
//        commands.hset("member-lee", "name", "小李老师").get();
        commands.hset("x1","name","ckg").get();
        commands.hset("x1","id","0304180216").get();
        System.out.println("-------------------");
        System.out.println( commands.get("x1"));
        //AsyncCommand [type=GET, output=ValueOutput [output=null, error='null'], commandType=io.lettuce.core.protocol.Command] 打印出来的这都是嘛呀
        // 在进行Hash内容设置的时候还可以将内容保存在Map集合里面，进行整体的内容定义
        Map<String, String> map = new HashMap<>();
        map.put("age", String.valueOf(18));
        map.put("salar", String.valueOf(1.1));
        //删除对应的hash下的某一个map的key
        commands.hdel("x1","id");
//         map.remove("x1","salar"); 删除不掉
       Boolean b= (Boolean) commands.hexists("x1","name").get();
        System.out.println("================");
        System.out.println(b);
       String  c= (String) commands.hget("x1","name").get();

        System.out.println(c);



//        commands.hmset("x1", map);
         commands.hmset("x1", map).get();
//        不加.get的话就会出现这样的情况,打印不出来具体的值,加的话就会     【获取Hash数据】{name=ckg, id=0304180216, salar=1.1, age=18}
//AsyncCommand [type=GET, output=ValueOutput [output=null, error='null'], commandType=io.lettuce.core.protocol.Command]
//【获取Hash数据】AsyncCommand [type=HGETALL, output=MapOutput [output=null, error='null'], commandType=io.lettuce.core.protocol.Command]
        System.out.println("【获取Hash数据】" + commands.hgetall("x1").get());
        RedisConnectionUtilPool.close();
    }
}