package ProcessDispachter;

import java.util.Formatter;
import java.util.Scanner;

public class Banker1 {
    int ThreadNum;
    int Kinds;
    Scanner scanner = new Scanner(System.in);

    int available[];
    int max[][];
    int need[][];
    int allocation[][];


    public void getInitialData() {
//        static int available[]=new int[3];         //资源数
//        static int max[][]=new int[5][3];          //最大需求
//        static int allocation[][]=new int[5][3];   //分配
//        static int need[][]=new int[5][3];         //需求
//        static int request[]=new int[3];
        System.out.println("请输入线程总数和资源总种类数");
        ThreadNum = scanner.nextInt();
        Kinds = scanner.nextInt();
        System.out.println("你的线程总数:" + ThreadNum);
        System.out.println("你的资源总种类数目:" + Kinds);
        System.out.println("==============================");


        available = new int[Kinds];
        max = new int[ThreadNum][Kinds];
        need = new int[ThreadNum][Kinds];
        allocation = new int[ThreadNum][Kinds];

        //得到系统内给类资源的可用数目

        System.out.println("输入系统内各类资源的可用数目:");
        for (int i = 0; i < Kinds; i++) {
            available[i] = scanner.nextInt();
        }

        System.out.println("==============================");
        //各个线程所需要的最大资源数目


        System.out.println("输入各个线程所需要的最大资源总数:");
        for (int i = 0; i < ThreadNum; i++) {
            String gavin = "输入线程 %d 的各 %d 类最大需要资源数目:" + "\r\n";
            System.out.printf(gavin, i, Kinds);
            for (int j = 0; j < Kinds; j++) {
                max[i][j] = scanner.nextInt();
            }
        }

        //各个线程已经分配的资源数目
        System.out.println("==============================");
        System.out.println("输入各个线程的已经分配的各类资源数目:");

        for (int i = 0; i < ThreadNum; i++) {
            String gavin = "输入线程 %d 的各 %d 类已分配资源数目:\r\n";
            System.out.printf(gavin, i, Kinds);
            for (int j = 0; j < Kinds; j++) {
                allocation[i][j] = scanner.nextInt();
            }
        }


        //各个线程还需要的资源的数目
        System.out.println("==============================");
        System.out.println("输出各个线程还需要的各类资源的数目:");
        for (int i = 0; i < ThreadNum; i++) {
//            Formatter formatter = new Formatter(System.out);
//            formatter.format("输入线程 %d 的各类资源数目"+i);
            String gavin = "输入线程 %d 的各 %d 类还需要资源数目:\r\n";
            System.out.printf(gavin, i, Kinds);
            for (int j = 0; j < Kinds; j++) {
                need[i][j] = max[i][j] - allocation[i][j];
                System.out.println(need[i][j]);
            }
        }
    }

    public void AllocateSource() {
        int circle = 0;
        int count = 0;
        int[] S=new int[3];//安全序列
        boolean satisfy[] = new boolean[ThreadNum];

        while (count < ThreadNum) {
            for (int i = 0; i < ThreadNum&&satisfy[i]==false; i++) {
                for (int j = 0; j < Kinds; j++) {
                    if (need[i][j] > available[j]) {
//                        System.out.printf("线程 %d 目前无法满足\r\n", i);
//                        first_unmet[i] = true;
                        break;
                    }

                    if (j == Kinds - 1 && need[i][j] <= available[j]) {
//                    System.out.printf("线程 %d 已经得到满足并释放资源\r\n"+i);
                        System.out.println("已经能满足线程:" + i);
                        for (int m = 0; m < Kinds; m++) {
                            available[m] = available[m] + max[i][m];
                        }
                        satisfy[i]=true;
                        S[count]=i;
                        count++;
                    }
                }
            }
            circle++;

            if(count==ThreadNum){//判断是否满足所有进程需要
                System.out.print("此时存在一个安全序列：");
                for (int i = 0; i<ThreadNum;i++){//输出安全序列
                    System.out.print("P"+S[i]+" ");
                }
                System.out.println("故当前可分配！");
                break;
            }
            if(count<circle){//判断完成进程数是否小于循环圈数

                System.out.println("当前系统处于不安全状态，故不存在安全序列。");
                break;
            }
        }


    }


    public static void main(String[] args) {
        Banker1 banker1 = new Banker1();
        banker1.getInitialData();
        banker1.AllocateSource();


    }
}
