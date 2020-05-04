import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
//            通常我们遍历子串或者子序列有三种遍历方式
//
//            以某个节点为开头的所有子序列: 如 [a]，[a, b]，[ a, b, c] ... 再从以 b 为开头的子序列开始遍历 [b] [b, c]。
//            根据子序列的长度为标杆，如先遍历出子序列长度为 1 的子序列，在遍历出长度为 2 的 等等。
//            以子序列的结束节点为基准，先遍历出以某个节点为结束的所有子序列，因为每个节点都可能会是子序列的结束节点，因此要遍历下整个序列，如: 以 b 为结束点的所有子序列: [a , b] [b] 以 c 为结束点的所有子序列: [a, b, c] [b, c] [ c ]。
//
//求出最大子序和
public class Class53 {


//
//    for(int i=0;i<n;i++){
//        int m=1;
//        for(int j=i+1;j<n;j++){
//            if(s[i]!=s[j]){
//                m++;
//            }
//            else break;
//        }
//        arr[i]=m;
//    }
//    for(int i=0;i<n;i++){
//        for(int j=i+1;j<n;j++){ //当j=0时，为从大到小的排序或者把n[i]<n[j]
//            if(arr[i]>arr[j]){
//                int tmp;
//                tmp=arr[i];
//                arr[i]=arr[j];
//                arr[j]=tmp;
//            }
//        }
//    }
//    printf("请输出最大的结果：");
//    printf(" %d ",arr[n-1]);//空格符号直接在%d内打出
//}

//    public int maxSubArray(int[] nums) {
//
//        int max = 0;
//        int total = nums.length;
//        ArrayList<Integer> minus = new ArrayList<>();
//        ArrayList<Integer> temp_num = new ArrayList<>();
//        int j = 0;
//
//        //找出数组nums里面所有的负数
//        for (int i = 0; i < total; i++) {
//            if (nums[i] < 0) {
//                minus.add(i);
//            }
//        }
//        //打印出负数的下标
//        System.out.println("xxxxxxx");
//        Iterator iter = minus.iterator();
//        while (iter.hasNext()) {
//            int value = (Integer) iter.next();
//            System.out.println(value);
//        }
//
//        int minus_size = minus.size();
//
//        int q = 0;
//
//        for (int m = 0; m < minus_size; m++) {
//
//            int sum = 0;
//            for (int n = q; n < minus.get(m); n++) {
//                sum = sum + nums[n];
//
//            }
//            q = minus.get(m);
//
//            temp_num.add(sum);
//
//        }
//        //打印出临时的和
//        System.out.println("xxxxxxxxx");
//        Integer value = null;
//
//
//        for (Integer integ : temp_num) {
//            value = integ;
//            System.out.print(value + " ");
//        }
//
//
//
//        System.out.println();
//        max = Collections.max(temp_num);
//        System.out.println(max);
//
//
//        return max;
//
//
//    }
//

          //动态规划
    //
    // 但是动态规划为了找到不同子序列之间的递推关系，恰恰是以子序列的结束点为基准的，

    //这种方法太不好想了
//    public int maxSubArray(int[] nums) {
//
//        int len = nums.length;
//
//        if (len == 0) {
//
//            return 0;
//        }
//
//
//        int[] dp = new int[len];
//
//        dp[0] = nums[0];
//
//        for (int i = 1; i < len; i++) {
//
//            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
//
//        }
//
//
//        // 最后这一步，是求一个全局的最优值
//        int res = dp[0];
//
//        for (int i = 1; i < len; i++) {
//
//            res = Math.max(res, dp[i]);
//        }
//        return res;
//
//    }



                       //贪心法
    public int maxSubArray(int []nums) {
        int ans=nums[0];
        int sum=0;
        for (int num:nums){
            if (sum>0){
                sum+=num;
            }
            else
            {
                sum=num;
            }
            ans=Math.max(ans,sum);
        }

        return ans;
    }


    public static void main(String[] args) {
        int nums[] = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        Class53 class53 = new Class53();
        System.out.println(class53.maxSubArray(nums));

    }

}
//    public int  maxSubArray(int[] nums) {
//
//                                                                max = 0;
//
//          int sum = 0;
//          for (int i = 0; i < nums.length; i++) {
//            if (sum > 0) {
//                sum = sum+nums[i];
//            }
//            if (sum <=0) {
//
//                sum = nums[i];
//
//            }
//            if (sum > max) {
//                max = sum;
//            }
//
//        }
//        return max;
//    }
//
        //






