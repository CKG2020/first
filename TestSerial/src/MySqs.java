package com.FourDataFormat;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
//import java.io.Serializable;
////
//class Card  implements Serializable {
//    int id;
//    private  void writeObject(ObjectOutputStream out) throws IOException {
//        out.writeInt(id);
//
//    }
//
//    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
//        this.id=in.readInt();
//
//    }
//}
//
//class Student implements Serializable {
//    int id;
//    String name;
//    Card cards;
//
//    public Student(int id, String name, Card cards) {
//        this.id = id;
//        this.name = name;
//        this.cards = cards;
//    }
//
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public Card getCards() {
//        return cards;
//    }
//
//    public void setCards(Card cards) {
//        this.cards = cards;
//    }
//
//    private  void writeObject(ObjectOutputStream out) throws IOException {
//        out.writeInt(id);
//        out.writeObject(name);
//        out.writeObject(cards);
////        out.writeObject(new StringBuffer(cards));
//    }
//
//    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
//        this.id=in.readInt();
//        this.name=in.readObject().toString();
//        Object cards = in.readObject();
//        this.cards= (Card) cards;
//    }
//}





public class MySqs {
    Object obj;
    private  void writeObject(ObjectOutputStream out) throws IOException {
//        out.writeInt(id);
//        out.writeObject(name);
        out.writeObject(obj);
        System.out.println("序列化完成");
//        out.writeObject(new StringBuffer(cards));
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
//        this.id=in.readInt();
        this.obj=in.readObject();
//        Object cards = in.readObject();
//        this.cards= (Card) cards;
        System.out.println("反序列化完成");
        obj.toString();
    }
}
