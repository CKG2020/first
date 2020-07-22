package com;



import java.io.*;
import java.util.Map;
import java.util.Properties;

class Card  implements Serializable {
    int id;
//    private  void writeObject(ObjectOutputStream out) throws IOException {
//        out.writeInt(id);
//
//    }
//
//    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
//        this.id=in.readInt();
//
//    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                '}';
    }

    public Card(int id) {
        this.id = id;
    }
}

class Student implements Serializable {
    int id;
    String name;
    Card cards[];

    public Student(int id, String name, Card[] cards) {
        this.id = id;
        this.name = name;
        this.cards = cards;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Card[] getCards() {
        return cards;
    }

    public void setCards(Card[] cards) {
        this.cards = cards;
    }

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

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cards=" + cards +
                '}';
    }

}

public class MySqs1Test {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Properties pro = new Properties();
        try {
            pro.load(new FileReader(MySqs1Test.class.getClassLoader()
                    .getResource("xxxx.properties").getPath()));
        } catch (IOException e) {
            e.printStackTrace();
        }

//        String[] cards = pro.getProperty("Card").split("");
//        System.out.println(cards[0]);

        Card a= new Card(Integer.parseInt(pro.getProperty("Card.a.cid")));
        Card b = new Card(Integer.parseInt(pro.getProperty("Card.b.cid")));
        Card card[]={a,b};
//        System.out.println(pro.getProperty("Stu.s1.card").getClass().getName());

//        String s = pro.getProperty("Stu.s1.card");


        Student student = new Student
                (Integer.parseInt(pro.getProperty("Stu.s1.id")),pro.getProperty("Stu.s1.name"),
                       card);

        System.out.println(student);
        System.out.println(student.id);
        System.out.println(student.name);
        System.out.println(student.cards);

//        MySqs1 mySqs1 = new MySqs1("xxxx.properties");
//        try {
//            Map<String, String> stringStringMap = mySqs1.readAllProperties();
//
//
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        MySqs1 mySqs1 = new MySqs1();
        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream("template1"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            mySqs1.writeObject1(objectOutputStream,a);
        } catch (IOException e) {
            e.printStackTrace();
        }
        File file = new File("template1");
//        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
        mySqs1.readObject1(objectInputStream,a);


    }
}
