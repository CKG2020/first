package com.lock;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.w3c.dom.ls.LSOutput;

import javax.jws.soap.SOAPBinding;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

class  User{

                 String Username;
                 int age;

                 public User(String s, int i) {
                     this.Username=s;
                     this.age=i;
                 }
             }
   ;




public class CASDemo {
//    CAS比较并交换
public static void main(String[] args) {
    User  z3=new User("z3",10);
    User l4=new User("l4",20);

    AtomicInteger atomicInteger=new AtomicInteger(5);
//期望值与物理内存是否一样,一样的话就变成第二个参数对应的值
    //期望值也就是我在改写automicInteger的值时候确保别的线程对着这个数没有进行修改
    System.out.println(atomicInteger.compareAndSet(5, 2020)
            + "\t current data:" + atomicInteger.get());
    System.out.println(atomicInteger.compareAndSet(5,2019)+"\t current data:"
            +atomicInteger.get());

    AtomicReference<User> atm=new AtomicReference<User>();
    atm.set(z3);
    System.out.println(atm.compareAndSet(z3,l4)+atm.get().toString());
    System.out.println(atm.compareAndSet(z3,l4)+atm.get().toString());
}

}
