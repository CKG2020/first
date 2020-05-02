package ProcessDispachter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Test {

    private static double[] array;

    //测试这种从控制台获取字符的方法
    public static void main(String[] args) throws IOException {
//        Test test;
//        test = new Test();
//        test.array = new double[3];
//        System.out.println("输入每个元素:/n");
//
//
//        for (int i = 0; i < 3; i++) {
//            //一次只能从控制台读取一个字符
//            BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
//            String str1 = buf.readLine();
//            double a = Double.parseDouble(str1);
//            test.array[i] = a;
//        }
//
//
//        for (double i : array) {
//            System.out.print(i + ",");
//        }
//    }


        //找出数组中元素的数值最大的下标和对应的数值
//    public static void main(String[] args) {
//
//
//        int[] arr = {4, 5, 6, 7, 8, 1, 2};//定义一个数组存放指定元素
//        int a = 0;
//        int sum = arr[0];//假设第一个元素是最大值
//        //for循环遍历数组中元素，每次循环跟数组索引为0的元素比较大小
//        for (int i = 0; i < arr.length; i++) {
//            if (sum < arr[i]) {//数组中的元素跟sum比较，比sum大就把它赋值给sum作为新的比较值
//                sum = arr[i];
//                a = i;
//            }
//        }
//        System.out.println(sum);//输出数组中的最大值
//        System.out.println(a);
//    }


        //找出数组中指定元素的下标
        String[] ary = new String[]{"asd", "sdf", "ffd ", "rgrh"};//你所百定义的数组
        int k = 0;//定义变量保度存指定元素问答的下标
        for (
                int i = 0;
                i < ary.length; i++) {
            if (ary[i].equals("ffd "))//ffd 为你指定的元素
            {
                k = i;
                System.out.println(k);//打印出指定元素的下标
            }
        }
        if (k == 0) {
            System.out.println("您所指版定的元素不存在权");//指定元素不存在
        }
//             接口Comparable和类方法Arrays.sort()
//
//    的配合使用可以使进程按reachTime(到达时间)排序

    }

}

//网上的别人的代码
//            private static class PCB implements Comparable<PCB> {
//                String id;
//                float reachTime;
//                float needTime;
//                float startTime;
//                float finishTime;
//                char state;
//                public int compareTo( PCB b ) {
//                    if( reachTime==b.reachTime ) return 0;
//                    if( reachTime<b.reachTime ) return -1;
//                    return 1;
//                }
//            }
//            public static void main( String[] args ) {
//                Scanner sc = new Scanner( System.in );
//
//                System.out.print( "请输入进程数:" );
//                int num = sc.nextInt();
//                PCB[] arr = new PCB[num];
//                System.out.println( "请依次输入进程ID,进程到达时间,进程运行时间:" );
//                for( int i = 0; i < num; i++ ) {
//                    arr[i] = new PCB();
//                    arr[i].id = sc.next();
//                    arr[i].reachTime = sc.nextFloat();
//                    arr[i].needTime = sc.nextFloat();
//                    arr[i].state = 'R';
//                }
//                Arrays.sort(arr); // 使进程按reachTime(到达时间)排序
//
////              for(int i=0;i<num;i++){
////                System.out.println(arr[i].reachTime+" ");}
//
//                float lastTime=arr[0].reachTime;
//
//                for( int i=0; i<num; i++ ) {
//                    // 找到下一个将要执行的进程
//                    int p = i;
//                    if( arr[p].reachTime<lastTime )   arr[p].startTime = lastTime;
//                    else arr[p].startTime = arr[p].reachTime;
//                    arr[p].finishTime = arr[p].startTime + arr[p].needTime;
//                    arr[p].state = 'F';
//
//                    lastTime = arr[p].finishTime;  // 更新lastTime
//                }
//
//                float sum1=0.0f, sum2=0.0f;
//                System.out.println( "\n进程  到达时间  运行时间  开始时间  完成时间  周转时间  带权周转时间" );
//                for( PCB jcb : arr ) {
//                    System.out.format( "%4s  %8.2f  %8.2f  ", jcb.id, jcb.reachTime, jcb.needTime );
//                    System.out.format( "%8.2f  %8.2f  ", jcb.startTime, jcb.finishTime );
//                    System.out.format( "%8.2f  ", jcb.finishTime-jcb.reachTime );
//                    System.out.format( "%12.2f\n", (jcb.finishTime-jcb.reachTime)/jcb.needTime );
//                    sum1 += jcb.finishTime-jcb.reachTime;
//                    sum2 += (jcb.finishTime-jcb.reachTime)/jcb.needTime;
//                }
//                System.out.format( "平均周转时间: %.3f\n", (sum1/num) );
//                System.out.format( "平均带权周转时间: %.3f", (sum2/num) );
//            }
//        }



