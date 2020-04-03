public class Paixu {


    public static void main(String[] args) {
        int[] b = {22, 25, 55, 663, 51, 99};
        getSecondMax(b);

    }

    public static int getSecondMax(int[] a) {
        int Max = a[1];
        int SecondMax = a[0];
//        int Max=a[0]>a[1]?a[0]:a[1];
//        int  SecondMax=a[0]<a[1]?a[0]:a[1];
//        int Max;
//        int SecondMax;//这样子会爆出Second未初始化的异常

        for (int i = 2; i <= a.length - 1; i++) {
            if (a[i] > a[1]) Max = a[i];
            else if (a[i] > a[0]) SecondMax = a[i];
//           if (a[i]>Max)   Max=a[i];
//            else if(a[i]>SecondMax) SecondMax=a[i];
        }

        System.out.println(SecondMax);
        return SecondMax;

    }
}
