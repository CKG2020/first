package ProcessDispachter;

import java.util.Scanner;

public class DynamicAllocate {
    int partition_num;
    int origin_address[];
    int capacity[];
    int firsthand[];
    int Thread_Num;
    int need[];
    int mark = -1;
    Scanner scanner = new Scanner(System.in);

    public void InitialData() {
        //确定内存分区表
        System.out.println("输入分区总数:");

        partition_num = scanner.nextInt();
        System.out.println("输入各个分区的起始地址:");
        origin_address = new int[partition_num];
        capacity = new int[partition_num];
         firsthand = new int[partition_num];
        //获取每个分区的起始地址
        for (int i = 0; i < partition_num; i++) {
            origin_address[i] = scanner.nextInt();
        }
        //获取每个分区的大小
        System.out.println("输入各个分区的大小:");
        for (int j = 0; j < partition_num; j++) {
            capacity[j] = scanner.nextInt();
            firsthand[j]=capacity[j];
        }
        //输出每个分区的起始地址和大小
        for (int m = 0; m < partition_num; m++) {
            System.out.printf("%d分区的起始地址为%d,大小为%d\r\n", m, origin_address[m], capacity[m]);
        }
    }


    //初始化进程请求
    public void RequireService() {
        System.out.println("请输入线程总数:");
        Thread_Num = scanner.nextInt();
        need = new int[Thread_Num];
        System.out.println("输入各个线程需要分配的空间大小:");
        for (int i = 0; i < Thread_Num; i++) {
//              System.out.printf("输入进程%d所需要分配的空间为");
            need[i] = scanner.nextInt();
        }


    }

    //对容量进行排序
    //从小到大
    public void index1() {
        int temp;
        for (int i = 0; i < partition_num; i++) {
            for (int j = 0; j < partition_num - 1 - i; j++) {
                if (capacity[j] > capacity[j + 1]) {

                    temp = capacity[j];

                    capacity[j] = capacity[j + 1];

                    capacity[j + 1] = temp;

                }
            }
        }
    }

    public void index2() {
        int temp;
        for (int i = 0; i < partition_num; i++) {
            for (int j = 0; j < partition_num - 1 - i; j++) {
                if (capacity[j] < capacity[j + 1]) {
                    temp = capacity[j];

                    capacity[j] = capacity[j + 1];

                    capacity[j + 1] = temp;

                }
            }
        }
    }


    //选择动态分配的四种算法
    public void ChooseAlgorithm() {
        System.out.println("请输入你要选择的算法的序号(1,2,3,4可供选择):");
        switch (scanner.nextInt()) {
            case 1:
                System.out.println("首次适应算法");

                for (int i = 0; i < Thread_Num; i++) {
                    for (int j = 0; j < partition_num; j++) {
                        if (need[i] < capacity[j]) {
                            System.out.printf("线程%d被分到了%d分区\r\n", i, j);
                            capacity[j] = capacity[j] - need[i];
                            break;
                        }

                        if (j == partition_num - 1 && need[i] > capacity[partition_num - 1]) {
                            System.out.printf("线程%d无法获得分区\r\n", i);
                        }
                    }
                }

                break;
//问题:如果第一个线程就被分到了最后一个分区 那下一个线程来的时候改放在哪里呢
            case 2:
                System.out.println("循环首次适应算法");
//                boolean[] t = new boolean[Thread_Num];
                for (int i = 0; i < Thread_Num; i++) {
                    for (int j = mark + 1; j < partition_num; j++) {
                        if (need[i] <= capacity[j]) {

                            System.out.printf("线程%d被分到了%d分区\r\n", i, j);
                            capacity[j] = capacity[j] - need[i];
                            mark = j;
                            break;
                        }
                        if (j == partition_num - 1 && need[i] > capacity[partition_num - 1]) {
                            System.out.printf("线程%d无法获得分区\r\n", i);
                        }
                    }
                }
                break;

            case 3:
                System.out.println("最佳适应算法");
                index1();

                for (int i = 0; i < Thread_Num; i++) {
                    for (int j = 0; j < partition_num; j++) {
                        if (need[i] <= capacity[j]) {
                            int q=-1;
                            do {
                                q++;
                            }
                            while(capacity[j]!=firsthand[q]);
                            firsthand[q]=firsthand[q]-need[i];
                            System.out.printf("线程%d被分到了%d分区\r\n", i, q);
                            capacity[j] = capacity[j] - need[i];
                            index1();

                            break;
                        }
                        if (j == partition_num - 1 && need[i] > capacity[partition_num - 1]) {
                            System.out.printf("线程%d无法获得分区\r\n", i);
                        }
                    }
                }


                break;
            case 4:
                System.out.println("最坏适应算法");
                index2();
                for (int i = 0; i < Thread_Num; i++) {
                    for (int j = 0; j < partition_num; j++) {
                        if (need[i] <=capacity[j]) {
                            int q=-1;
                            do {
                                q++;
                            }
                            while(capacity[j]!=firsthand[q]);
                            firsthand[q]=firsthand[q]-need[i];
                            System.out.printf("线程%d被分到了%d分区\r\n", i, q);
                            capacity[j] = capacity[j] - need[i];
                            index2();
                            break;
                        }
                        if (j == partition_num - 1 && need[i] > capacity[partition_num - 1]) {
                            System.out.printf("线程%d无法获得分区\r\n", i);
                        }
                    }
                }


    break;
            default:
                System.out.println("你所选择的数据不合法");


        }


    }


    public static void main(String[] args) {
        DynamicAllocate dynamicAllocate = new DynamicAllocate();
        dynamicAllocate.InitialData();
        dynamicAllocate.RequireService();
        dynamicAllocate.ChooseAlgorithm();
    }


}
