package 常见题目;

import java.util.Date;

/**
 * @author W.Wen
 * @version : V1.0
 * @className: SubArrayMaxSum
 * @description: 给定一个数组，求子数组的最大累加和 (两个变量搞定)
 * @date 2021-10-21
 */
public class SubArrayMaxSum {
    public static int getMaxSum(int[] arr){
        if(arr.length==0){
            return 0;
        }
        int cur=0;
        int max=Integer.MIN_VALUE;
        for (int i : arr) {
            cur+=i;
            max=Math.max(max,cur);
            cur= Math.max(cur, 0);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr={-1,-3,-5,-1,-2,-5};
        System.out.println(getMaxSum(arr));
    }
}
