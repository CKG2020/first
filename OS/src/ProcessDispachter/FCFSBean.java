package ProcessDispachter;


import java.io.BufferedReader;
import java.io.IOException;

import java.io.InputStreamReader;


public class FCFSBean {
    private int process_num;
    private double arival_time[];
    private double start_time[];
    private double service_time[];
    private double complete_time[];
    double[] b = arival_time;

    public int getProcess_num() {
        return process_num;
    }

    public void setProcess_num(int process_num) {
        this.process_num = process_num;
    }

    public double[] getArival_time() {
        System.out.println("输出各个进程到达时间:");
        for (double i : arival_time) {
            System.out.println(i);
        }

        return arival_time;
    }


    public void setArival_time() throws IOException {
        System.out.println("输入各个进程达到时间:");
        this.arival_time = new double[this.getProcess_num()];
        for (int i = 0; i < this.getProcess_num(); i++) {
            BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
            String str1 = buf.readLine();
            double a = Double.parseDouble(str1);
            this.b = arival_time;
            this.arival_time[i] = a;
        }

    }

    public double[] getStart_time() {

        System.out.println("输出各个进程开始时间:");
        for (double i : start_time) {
            System.out.println(i);
        }
        return start_time;
    }

    public void setStart_time() throws IOException {
        int procnum = this.getProcess_num();
        this.start_time = new double[procnum];
        this.complete_time = new double[procnum];
        int[] sorted = new int[procnum];


        double temp;
        for (int i = 0; i < procnum; i++) {
            for (int j = 0; j < procnum - 1 - i; j++) {
                if (arival_time[j] < arival_time[j + 1]) {

                    temp = arival_time[j];

                    arival_time[j] = arival_time[j + 1];

                    arival_time[j + 1] = temp;

                }
            }
        }

        System.out.println("=====================");


        for (int i = 0; i < procnum; i++) {
            for (int j = 0; j < procnum; j++) {
                if (arival_time[i] == b[j]) {
                    double lastTime = arival_time[j];
                    if (i == 0) {
                        start_time[j] = arival_time[j];
                        complete_time[j] = start_time[j] + service_time[j];
                        lastTime = complete_time[j];
                    } else if (b[j] > lastTime) {
                        start_time[j] = arival_time[j];
                        complete_time[j] = start_time[j] + service_time[j];
                        lastTime = complete_time[j];
                    } else {
                        start_time[j] = lastTime;
                        complete_time[j] = start_time[j] + service_time[j];
                        lastTime = complete_time[j];
                    }
                }
            }

//            for (int i = 0; i < procnum; i++) {
//                System.out.println(sorted[i] + "  ");
//            }
//            start_time[sorted[0]] = arival_time[sorted[0]];
//            complete_time[sorted[0]] = start_time[sorted[0]] + service_time[sorted[0]];
//
//
//            for (int m = 1; m < procnum; m++) {
//
//                if (start_time[sorted[i]] >= complete_time[sorted[i - 1]]) {
//                    start_time[sorted[i]] = arival_time[sorted[i]];
//                    complete_time[sorted[i]] = start_time[sorted[i]] + service_time[sorted[i]];
//                } else {
//                    start_time[sorted[i]] = complete_time[i - 1];
//                    complete_time[sorted[i]] = start_time[sorted[i]] + service_time[sorted[i]];
//
//                }
//            }

        }
    }

    public double[] getService_time() {
        System.out.println("输出各个进程服务时间:");
        for (double i : service_time) {
            System.out.println(i);
        }
        return service_time;
    }

    public void setService_time() throws IOException {
        this.service_time = new double[this.getProcess_num()];
        System.out.println("输入各个进程服务时间:");
        for (int i = 0; i < this.getProcess_num(); i++) {
            BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
            String str1 = buf.readLine();
            double a = Double.parseDouble(str1);
            this.service_time[i] = a;
        }


    }

    public double[] getComplete_time() {
        System.out.println("输出各个进程周转时间:");
        for (double i : complete_time) {
            System.out.println(i);
        }
        return complete_time;
    }

}