package com.basic;

import io.lettuce.core.api.async.RedisAsyncCommands;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class SortedSetCommand {
//增
//
//    ZADD key score1 member1 [score2 member2]
//    向有序集合添加一个或多个成员，或者更新已存在成员的分数

    //删
//    ZREM key member [member ...]
//    移除有序集合中的一个或多个成员


    //改


    //查
//    ZCARD key
//    获取有序集合的成员数


//    ZRANGE key start stop [WITHSCORES]
//    通过索引区间返回有序集合指定区间内的成员


//    ZRANK key member
//            返回有序集合中指定成员的索引


//    ZSCORE key member
//    返回有序集中，成员的分数值


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        RedisAsyncCommands command3 = RedisConnectionUtilPool.getConnection().async();
        command3.zadd("x4", 34, "name");
        command3.zadd("x4", 2, "sex");
        command3.zadd("x4", 23, "id");
        ArrayList a = (ArrayList) command3.zrange("x4", 0l, 10l).get();
        //结果按照从小到大排列[sex, id, name]
        System.out.println(a);
        command3.zrem("x4", "name");

        ArrayList b = (ArrayList) command3.zrange("x4", 0l, 10l).get();

        System.out.println(b);

        double c = (double) command3.zscore("x4", "sex").get();
        System.out.println(c);


    }
}