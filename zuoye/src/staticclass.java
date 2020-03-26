public class staticclass{
    public static void main(String[] args){
        //第一次调用StaticClass2中的值a
        System.out.println("StaticClass2中a的值为： " + TestStaticClass.b);

        //通过另外一个类来修改StaticClass2中a的值
        TestStaticClass1 testStaticClass1 = new TestStaticClass1();
        testStaticClass1.test();

        //第二次调用StaticClass2中的值a
        System.out.println("StaticClass2中a的值为： " + TestStaticClass.a);
    }
}

    class TestStaticClass{

        static int a = 3;
         static int b;

        static{
            System.out.println("inti data2");
            b = a * 3;
        }
    }

    class TestStaticClass1 {

        public void test() {
            TestStaticClass.a = 6;

        }

    }