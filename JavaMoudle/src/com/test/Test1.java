package com.test;

public class Test1 {
    private static int x = 100;

    public static void main(String args[]) {
        Test1 hs1 = new Test1();
        hs1.x++;
        Test1 hs2 = new Test1();
        hs2.x++;
//            hs1=new Test1();
        hs1.x++;
        Test1.x--;
        System.out.println("x=" + x);
//         System.out.println();
    }
}
//当static作用于某个字段时，肯定会改变数据创建的方式
//（因为一个static字段对每个类来说都只有一份储存空间，而非static字段则是对每个对象有一个储存空间）；
//        所以无论是HasStatic类的对象hs1,hs2，或是直接通过类名修改static作用的字段，都是一个，因此选择D