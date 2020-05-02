package ProcessDispachter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SJF {
    private int process_num;
    private double arival_time[];
    private double start_time[];
    private double service_time[];
    private double complete_time[];
    private double b[];

    public int getProcess_num() {
        return process_num;
    }

    public void setProcess_num() throws IOException {
        System.out.println("请输入线程总数:");
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        String str1 = buf.readLine();
        int a = Integer.parseInt(str1);
        this.process_num = a;
    }


    public double[] getArival_time() throws IOException {
        for (double i : arival_time) {
            System.out.println(i);
        }

        return arival_time;
    }


    public void setArival_time() throws IOException {
        System.out.println("请输入各个进程的到达时间:");
        int process_num = this.getProcess_num();
        this.arival_time = new double[process_num];
        for (int i = 0; i < process_num; i++) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String s = bufferedReader.readLine();
            this.arival_time[i] = Integer.parseInt(s);

        }
    }


    public double[] getService_time() {

        for (double i : service_time) {

            System.out.println(i);
        }
        return service_time;
    }


    public void setService_time() throws IOException {
        System.out.println("请输入各个进程需要的运行时间:");
        int process_num = this.getProcess_num();
        this.service_time = new double[process_num];
        this.b = new double[process_num];
        for (int i = 0; i < process_num; i++) {

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String s = bufferedReader.readLine();
            int i1 = Integer.parseInt(s);
            this.service_time[i] = i1;
            this.b[i] = i1;

        }

    }


    public double[] getStart_time() {
        System.out.println("请输出各个线程的开始时间:");
       for (double i: start_time){
           System.out.println(i);
       }

        return start_time;
    }

    public void setStart_time() {
        int process_num = this.getProcess_num();
        this.start_time = new double[process_num];
        this.complete_time=new double[process_num];
        double temp;
        //对服务时间排序
        for (int i = 0; i < process_num; i++) {
            for (int j = 0; j < process_num - i - 1; j++) {
                if (service_time[j] > service_time[j + 1]) {
                    temp = service_time[j + 1];
                    service_time[j + 1] = service_time[j];
                    service_time[j] = temp;
                }

            }
        }

        for(int i=0;i<process_num;i++){
            System.out.println(service_time[i]);

        }
        for (int i=0;i<process_num;i++){
            System.out.println(b[i]);
        }

        //找出最先到达的线程号
        double FirstArival = arival_time[0];


        int first = 0;

        for (int i = 1; i < process_num; i++) {
            if (FirstArival > arival_time[i]) {
                FirstArival = arival_time[i];
                first = i;
            }
        }
        System.out.println("第一个到达的线程为线程:" + first);

         start_time[first]=arival_time[first];
         complete_time[first]=start_time[first]+b[first];
        double lastTime = complete_time[first];


        for (int i = 0; i < process_num; i++) {
            for (int j = 0; j < process_num; j++) {

                if (service_time[i] == b[j] && j!=first) {
                    if (lastTime>arival_time[j]){
                        start_time[j]=lastTime;
                        complete_time[j]=start_time[j]+b[j];
                        lastTime=complete_time[j];
                    }
                    else {

                        start_time[j] = arival_time[j];
                        complete_time[j] = start_time[j] + b[j];
                        lastTime = complete_time[j];

                    }
                }
            }
        }


    }


    public double[] getComplete_time() {
        System.out.println("输出各个线程完成的时间:");
        for (double i:complete_time){
            System.out.println(i);
        }
        return complete_time;
    }

    public void setComplete_time(double[] complete_time) {
        this.complete_time = complete_time;
    }

    public static void main(String[] args) throws IOException {
        SJF sjf = new SJF();
        sjf.setProcess_num();
        sjf.setArival_time();
        sjf.setService_time();
        sjf.setStart_time();
        sjf.getStart_time();
        sjf.getComplete_time();


    }
}
