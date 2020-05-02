package ProcessDispachter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LinkedListTest {
    public static void main(String[] args) {

        LinkedList<String> emps = new LinkedList<>();
        emps.add("Zhang San");
        emps.add("Li Si");
        emps.add("Wang Wu");

        emps.add(2, "Zhao Liu");  //在指定位置（索引）添加元素

        emps.add(null);   //可以包含空值

        emps.addFirst("Ma Yi");  //在begin添加元素

        emps.addLast("Ye gu");     //在end添加元素
        System.out.println(emps); //[Ma Yi, Zhang San, Li Si, Zhao Liu, Wang Wu, null, Ye gu]

//添加List
        List<String> newEmp = new ArrayList<>();
        newEmp.add("Xu Qian");
        emps.addAll(newEmp);
        System.out.println(emps);    //[Ma Yi, Zhang San, Li Si, Zhao Liu, Wang Wu, null, Ye gu, Xu Qian]


        Iterator<String> iterator = emps.iterator();
        while (iterator.hasNext()) {
            String name = iterator.next();
            System.out.println(name);
        }
    }
}